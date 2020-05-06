package samuelmoreirasilva.app.barberhair.com.activity;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import samuelmoreirasilva.app.barberhair.com.Helper.RecyclerItemClickListener;
import samuelmoreirasilva.app.barberhair.com.R;
import samuelmoreirasilva.app.barberhair.com.adapter.ServicosAdapter;
import samuelmoreirasilva.app.barberhair.com.model.Servico;
import samuelmoreirasilva.app.barberhair.com.model.Usuario;

public class MeusServicosActivity extends AppCompatActivity {

    private Usuario usuario;
    private ArrayList<Servico> listaServicos = new ArrayList<>();
    private RecyclerView recyclerServico;
    private TextView textSemCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_servicos);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Meus Serviços2");
        setSupportActionBar(toolbar);

        recyclerServico = findViewById(R.id.recyclerListaServicos);
        textSemCadastro = findViewById(R.id.textSemCadastro);

        //Bundle dados = getIntent().getExtras();
        //usuario = (Usuario) dados.getSerializable("usuario");

        //if(usuario.getListaServicos() == null) {
            //Teste
        Servico servico = new Servico("1", "Corte", "2", 96.31, 56);
        listaServicos.add(servico);

        servico = new Servico("2", "Penteado", "2", 150.29, 40);
        listaServicos.add(servico);

        servico = new Servico("2", "Penteado", "2", 150.29, 41);
        listaServicos.add(servico);

        servico = new Servico("2", "Penteado", "2", 150.29, 42);
        listaServicos.add(servico);

        servico = new Servico("2", "Penteado", "2", 150.29, 43);
        listaServicos.add(servico);



            //textSemCadastro.setVisibility(View.VISIBLE);
            //recyclerServico.setVisibility(View.INVISIBLE);
        //}else{
            //listaServicos = usuario.getListaServicos();
        //}

        ConfiguraRecyclerServico();

    }

    private void ConfiguraRecyclerServico() {

        //Configurar Adapter
        final ServicosAdapter adapter = new ServicosAdapter(listaServicos);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerServico.setLayoutManager(layoutManager);
        recyclerServico.setHasFixedSize(true);
        recyclerServico.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerServico.setAdapter(adapter);

        //Evento de Click
        recyclerServico.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerServico,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Long teste = adapter.getItemId(position);
                                //trataClickItem(Integer.valueOf(teste.toString()), position);


                                trataClickItem(view.getId(), position);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Long teste = adapter.getItemId(position);
                                trataClickItem(Integer.valueOf(teste.toString()), position);
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    private void trataClickItem(int id, int position) {

        Log.d("teste", "id=" + id);
        switch (id){
            case R.id.imageDeletar:
            case R.id.layoutDeletar:
                AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
                dialog.setMessage("Deseja realmente deletar esse serviço?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "Deletando iItem",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "Nao faz nada",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.create();
                dialog.show();

                break;
            case R.id.txtTempo:
            case R.id.txtValor:
            case R.id.textDescServico:
            case R.id.textTempoMedio:
            case R.id.textValorCabec:
            case R.id.layoutTempoMedio:
            case R.id.layoutValorCabec:
                Toast.makeText(getApplicationContext(), "Clicou alterar", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), "Erro no Click", Toast.LENGTH_SHORT).show();
                break;
        }



    }

    public void abreTelaMeusHorarios(View view){

        usuario.setListaServicos( listaServicos);

        //Intent intent  = new Intent(this, MeusHorariosActivity.class);
        //intent.putExtra("usuario", usuario);
        //startActivity(intent);

    }

     @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_adicionar, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.adicionar){

            //   Intent intent  = new Intent(this, SelecionaCategoriaServicoActivity.class);
            //intent.putExtra("usuario", usuario);
            //startActivity(intent);

        }

        return true;
    }

}
