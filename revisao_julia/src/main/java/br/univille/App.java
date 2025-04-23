package br.univille;
import java.util.Arrays;
import br.univille.entity.Cidade;
import br.univille.entity.Pessoa;
import br.univille.entity.Pokemon;
@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //Instância
        Cidade jlle = new Cidade();
        jlle.setNome("Joinville");
        jlle.setEstado("Santa Catarina");
        Pokemon jigglypuff = new Pokemon("Jigglypuff");
        Pokemon pikachu = new Pokemon("Pikachu");
        Pessoa zezinho = new Pessoa();
        zezinho.setNome("Zezinho");
        zezinho.setCidade(jlle);
        zezinho.getListaPokemon().add(jigglypuff);
        zezinho.getListaPokemon().add(pikachu);
        for(Pokemon umPokemon: zezinho.getListaPokemon()) {
            System.out.println(umPokemon);
        }
        zezinho.getListaPokemon().stream().forEach(System.out::println);
        System.out.println(zezinho);
    }
}