package SaborPizza;

public enum CategoriaSabor{
    PREMIUM(0.00), ESPECIAL(0.00), SIMPLES(0.00);
    
    private double preco;
    
    CategoriaSabor(double preco) {
        this.preco = preco;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double novoPreco) {
        if (novoPreco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero!");
        }
        this.preco = novoPreco;
    }
}