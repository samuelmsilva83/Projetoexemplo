package samuelmoreirasilva.app.barberhair.com.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import samuelmoreirasilva.app.barberhair.com.config.ConfiguracaoFirebase;

public class Usuario implements Serializable {

    private String id;
    private String nome;
    private String email;
    private String celular;
    private String senha;
    private String tipo;

    private String fotoPerfil;
    private String sexo;
    private String dataNascimento;
    private String cpf;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String endereco;
    private int numero;
    private String complemento;
    private String fotoDocRgCpfFrente;
    private String fotoDocRgCpfVerso;
    private String fotoDocCnh;
    private int raioAtendimento;
    private ArrayList<Servico> listaServicos;

    private String latitude;
    private String longitude;

    public Usuario() {

    }

    public void salvar() {

        DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();
        DatabaseReference usuarios = firebaseRef.child("usuarios").child(getId());

        usuarios.setValue(this);
    }

    public ArrayList<Servico> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(ArrayList<Servico> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public int getRaioAtendimento() {
        return raioAtendimento;
    }

    public void setRaioAtendimento(int raioAtendimento) {
        this.raioAtendimento = raioAtendimento;
    }

    public String getFotoDocRgCpfFrente() {
        return fotoDocRgCpfFrente;
    }

    public void setFotoDocRgCpfFrente(String fotoDocRgCpfFrente) {
        this.fotoDocRgCpfFrente = fotoDocRgCpfFrente;
    }

    public String getFotoDocRgCpfVerso() {
        return fotoDocRgCpfVerso;
    }

    public void setFotoDocRgCpfVerso(String fotoDocRgCpfVerso) {
        this.fotoDocRgCpfVerso = fotoDocRgCpfVerso;
    }

    public String getFotoDocCnh() {
        return fotoDocCnh;
    }

    public void setFotoDocCnh(String fotoDocCnh) {
        this.fotoDocCnh = fotoDocCnh;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }






}

