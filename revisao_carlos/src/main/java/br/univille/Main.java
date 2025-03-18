package br.univille;

import br.univille.entity.*;

public class Main {
    public static void main(String[] args) {
        
        Cidade mcp = new Cidade(0, "MACAPÁ", "AP");
        Cidade fdv = new Cidade(1, "FREDERICO W.", "RS");

        Pokemon pkm1 = new Pokemon("BUALBASSAURO");
        Pokemon pkm2 = new Pokemon("PIKACHU");
        
        Cliente c1 = new Cliente("LORENZO");
        c1.setCidade(fdv);
        c1.getPokemons().add(pkm1);
        Cliente c2 = new Cliente("CARLOS");
        c2.setCidade(mcp);
        c2.getPokemons().add(pkm2);

        // c1.setPokemons(ArrayList<new Pokemon("ATA")>);

        System.out.println(c1.toString());
        System.out.println(c2.toString());

    }
}
