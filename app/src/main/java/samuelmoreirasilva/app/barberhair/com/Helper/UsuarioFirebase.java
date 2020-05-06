package samuelmoreirasilva.app.barberhair.com.Helper;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import samuelmoreirasilva.app.barberhair.com.config.ConfiguracaoFirebase;
import samuelmoreirasilva.app.barberhair.com.model.Usuario;

public class UsuarioFirebase {

    public static FirebaseUser getUsuarioAtual(){

        FirebaseAuth usuario = ConfiguracaoFirebase.getFirebaseAuth();
        return usuario.getCurrentUser();

    }

    public static Usuario getDadosUsuarioLogado(){

        FirebaseUser firefebaseUser = getUsuarioAtual();

        Usuario usuario = new Usuario();
        usuario.setId(firefebaseUser.getUid());
        usuario.setEmail(firefebaseUser.getEmail());
        usuario.setNome(firefebaseUser.getDisplayName());

        return usuario;
    }

    public static boolean atualizarNomeUsuario(String nome){

        try {
            FirebaseUser user = getUsuarioAtual();

            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(nome)
                    .build();
            user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(!task.isSuccessful()){
                        Log.d("Perfil", "Erro ao atualizar nome de perfil!");
                    }
                }
            });

            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void redirecionaUsuarioLogado(final Activity activity){

        FirebaseUser user = getUsuarioAtual();
        if(user != null){

            String usuario = getIdentificadorUsuario();

            DatabaseReference usuarioRef = ConfiguracaoFirebase.getFirebaseDatabase()
                    .child("usuarios")
                    .child(usuario);

            usuarioRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Usuario usuario = dataSnapshot.getValue(Usuario.class);

                    String tipoUsuario = usuario.getTipo();
                    if(tipoUsuario.equals("C")) {
                    //    Intent i = new Intent(activity, RequisicoesActivity.class);
                      //  activity.startActivity(i);
                    }else {
                        //Intent i = new Intent(activity, ClienteActivity.class);
                        //activity.startActivity(i);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

    }

    public static String getIdentificadorUsuario(){
        return getUsuarioAtual().getUid();
    }

    public static void atualizarDadosLocalizacao(Double lat, Double lon){

        //Define nó de local do usuário
        DatabaseReference localUsuario = ConfiguracaoFirebase.getFirebaseDatabase()
                .child("local_usuario");

        GeoFire geoFire = new GeoFire(localUsuario);

        //Recupera dados do usuário logado
        Usuario usuarioLogado = UsuarioFirebase.getDadosUsuarioLogado();

        //Configura localização do usuário
        geoFire.setLocation(
                usuarioLogado.getId(),
                new GeoLocation(lat, lon),
                new GeoFire.CompletionListener() {
                    @Override
                    public void onComplete(String key, DatabaseError error) {
                        if(error != null){
                            Log.d("Erro", "Erro ao salvar local!");
                        }
                    }
                }
        );
    }

}
