package br.univille.entity;

import java.util.ArrayList;

public class Cliente {
    private long id; 
    private String nome;
    private String endereco;

    private Cidade cidade;
    private ArrayList pokemons = new ArrayList();

    public Cliente(String nome){
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + "]";
    }


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}

    public Cidade getCidade() {return cidade;}
    public void setCidade(Cidade cidade) {this.cidade = cidade;}

    public ArrayList getPokemons() {return pokemons;}
    public void setPokemons(ArrayList pokemons) {this.pokemons = pokemons;}

    
}
