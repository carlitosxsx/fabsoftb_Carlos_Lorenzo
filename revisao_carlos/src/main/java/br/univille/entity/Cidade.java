package br.univille.entity;

public class Cidade {
    private long id;
    private String nome;
    private String estado;

    public Cidade(long id, String nome, String estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
