package samuelmoreirasilva.app.barberhair.com.model;

import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

import samuelmoreirasilva.app.barberhair.com.config.ConfiguracaoFirebase;

public class Servico implements Serializable {

    private String id;
    private String descricao;
    private String idCategoria;
    private Double preco;
    private int tempo;

    public Servico(String id, String descricao, String idCategoria, Double preco, int tempo) {
        this.id = id;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.preco = preco;
        this.tempo = tempo;
    }


    public void salvar() {

        DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();
        DatabaseReference servicos = firebaseRef.child("servicos").child(getId());

        servicos.setValue(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
