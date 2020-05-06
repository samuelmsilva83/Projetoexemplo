package samuelmoreirasilva.app.barberhair.com.model;

import java.io.Serializable;

public class Categoria implements Serializable {

    int Codigo;
    String Descricao;

    public Categoria() {

    }

    public Categoria(int codigo, String descricao) {
        Codigo = codigo;
        Descricao = descricao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }
}
