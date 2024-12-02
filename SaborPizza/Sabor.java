package SaborPizza;

public class Sabor{
    private String nome;
    private CategoriaSabor categoria;
    
    public Sabor(String nome, CategoriaSabor categoria){
        this.nome = nome;
        this.categoria = categoria;
    }
    
    public String getNome(){
        return nome;
    }
    
    public CategoriaSabor getCategoria(){
        return categoria;
    }
}
