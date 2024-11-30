package FormaPizza;

//Area = lado * lado

public class Quadrado extends Forma{
    private double lado;
    private String[] sabores = new String[2];
    private String sabor;
    
    
    public Quadrado (double lado){
        if (lado < 10 || lado > 40){
            throw new IllegalArgumentException("Valor invalido para o lado!");
        }
        this.lado = lado;
    }
    
    @Override
    public void setSabor(String sabor){
        this.sabor = sabor;
    }
    
    @Override
    public String getSabor(){
        return sabor;
    }
    
    @Override
    public double calculaArea(double lado){
        return lado * lado;
    }
    
    @Override
    public double calculaLado(double area){
        if (area < 0){
            throw new IllegalArgumentException("A area nao pode ser negativa!");
        }
        return Math.sqrt(area);
    }
    
    @Override
    public boolean adicionaSabor(String sabor){
        for (int i = 0; i < sabores.length; i++){
            if (sabores[i] == null){
                sabores[i] = sabor;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean apagarSabor(String sabor){
        for (int i = 0; i <sabores.length; i++){
            if (sabor.equalsIgnoreCase(sabores[i])){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String[] getSabores(){
        return sabores;
    }
}
