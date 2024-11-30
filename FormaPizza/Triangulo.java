package FormaPizza;

//Area = Base * altura/2

public class Triangulo extends Forma {
    private double lado;
    private String[] sabores = new String[2];
    private String sabor;
    
    public Triangulo(){};
    
    public double defineLado(double lado){
        if (lado < 20 || lado > 60){
            throw new IllegalArgumentException("Valores invalidos para os lados!");
        }
        return lado;
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
        return (lado * lado) / 2;
    }
    
    @Override
    public double calculaLado(double area){
        if (area < 0){
            throw new IllegalArgumentException("Area nao pode ser negativa!");
        }
        return Math.sqrt(area * 2);
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
                sabores[i] = null;
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
