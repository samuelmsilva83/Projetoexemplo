package samuelmoreirasilva.app.barberhair.com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import samuelmoreirasilva.app.barberhair.com.R;
import samuelmoreirasilva.app.barberhair.com.model.Servico;

public class ServicosAdapter extends RecyclerView.Adapter<ServicosAdapter.MyViewHolder>{

    private ArrayList<Servico> listaServicos;

    public ServicosAdapter(ArrayList<Servico> lista) {
        listaServicos = lista;
    }

    @NonNull
    @Override
    public ServicosAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_servicos, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Servico servico = listaServicos.get(position);
        holder.servico.setText(servico.getDescricao());
        holder.valor.setText(Double.toString(servico.getPreco()));
        holder.tempo.setText(Integer.toString(servico.getTempo()));

    }

    @Override
    public int getItemCount() {
        return listaServicos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView servico;
        TextView tempo;
        TextView valor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            servico = itemView.findViewById(R.id.textDescServico);
            tempo = itemView.findViewById(R.id.txtTempo);
            valor = itemView.findViewById(R.id.txtValor);
        }
    }


}
