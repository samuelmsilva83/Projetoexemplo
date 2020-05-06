package samuelmoreirasilva.app.barberhair.com.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import samuelmoreirasilva.app.barberhair.com.Helper.Permissoes;
import samuelmoreirasilva.app.barberhair.com.Helper.UsuarioFirebase;
import samuelmoreirasilva.app.barberhair.com.R;
import samuelmoreirasilva.app.barberhair.com.config.ConfiguracaoFirebase;
import samuelmoreirasilva.app.barberhair.com.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;
    private String[] permissoes = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        //Validar Permissões
        Permissoes.validarPermissoes(permissoes, this,1);

        autenticacao = ConfiguracaoFirebase.getFirebaseAuth();
        autenticacao.signOut();
    }

    public void abreTelaCadastro(View view){
        //startActivity(new Intent(this, MeusServicosActivity.class));
        startActivity(new Intent(this, MeusServicosActivity.class));
        //startActivity(new Intent(this, CadastroTesteActivity.class));
    }

    public void abreTelaLogin(View view){
        startActivity(new Intent(this, MeusServicosActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        //verificar como ir pra tela direto quando estiver logado
        //UsuarioFirebase.redirecionaUsuarioLogado(MainActivity.this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for(int permissaoResultado : grantResults){
            if(permissaoResultado == PackageManager.PERMISSION_DENIED){
                alertavalidacaoPermissao();
            }
        }
    }

    private void alertavalidacaoPermissao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para utilizar o app é necessário aceitar as permissões!");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
