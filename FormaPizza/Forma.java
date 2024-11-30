package FormaPizza;

public abstract class Forma {
    
    public abstract boolean adicionaSabor(String sabor);
    
    public abstract boolean apagarSabor(String sabor);
    
    public abstract String[] getSabores();
    
    public abstract void setSabor(String sabor);
    
    public abstract String getSabor();
    
    public abstract double calculaArea(double lado);

    public abstract double calculaLado(double area);
}
