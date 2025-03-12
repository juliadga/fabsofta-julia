package br.univille;
public class Pessoa {
    //atributo (variável)
    private String nome;
    // construtor - mesmo nome da classe, não tem retorno
    public Pessoa(String nome) {
        this.nome = nome;
    }
    // polimorfismo
    public Pessoa() {
        
    }
    //método
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    } 
    // overwrite
    public String ToString() {
        return getNome();
    }  
}