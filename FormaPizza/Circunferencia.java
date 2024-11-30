package FormaPizza;

//Area = PI * raio^2

public class Circunferencia extends Forma {
    private double raio;
    private String[] sabores = new String[2];
    private String sabor;
    
    public Circunferencia(double raio){
        if (raio < 7 || raio > 23){
            throw new IllegalArgumentException("Valor invalido para o raio!");
        }
        this.raio = raio;
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
        return Math.PI *(Math.pow(raio, 2));
    }
    
    @Override
    public double calculaLado(double area){
        if (area < 0){
            throw new IllegalArgumentException("A area nao pode ser negativa!");
        }
        return Math.sqrt(area / Math.PI);
    }
    
    @Override
    public boolean adicionaSabor(String sabor){
        for (int i = 0; i<sabores.length; i++){
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
