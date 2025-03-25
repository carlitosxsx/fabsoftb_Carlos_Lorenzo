package br.univille;

import br.univille.entity.*;

public class Main {
    public static void main(String[] args) {
        
        Cidade mcp = new Cidade(0, "MACAPÁ", "AP");

        Pokemon pkm1 = new Pokemon("BULBASSAURO");
        Pokemon pkm2 = new Pokemon("PIKACHU");
        
        Cliente c1 = new Cliente("CARLOS");
        c1.setCidade(mcp);
        c1.getPokemons().add(pkm1);
        c1.getPokemons().add(pkm2);

        for (int i = 0; i < c1.getPokemons().size(); i++) {
            var umPokemon = c1.getPokemons().get(i);
            System.out.println(umPokemon);
        }

        for (var umPokemon : c1.getPokemons()) {
            System.out.println(umPokemon);
        }

        c1.getPokemons().stream().forEach(System.out::println);

    }
}