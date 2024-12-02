package FormaPizza;

//Area = PI * raio^2

import SaborPizza.Sabor;
import java.util.ArrayList;

public class Circunferencia extends Forma {
    private double raio;
    ArrayList<Sabor> saboresDisponiveis = new ArrayList<>();
    private Sabor[] saborEscolhido = new Sabor[2];
    
    public Circunferencia(){};
    
    public double defineLado(double raio){
        if (raio < 7 || raio > 23){
            throw new IllegalArgumentException("Valor invalido para o raio!");
        }
        return raio;
    }
    
    @Override
    public boolean setSabor(Sabor sabor){
        boolean semSabor = true;
        for (int i = 0; i < 2; i++){
            if(saborEscolhido[i] == null){
                saborEscolhido[i] = sabor;
                semSabor = false;
            }
        }
        return semSabor;
    }
    
    @Override
    public Sabor[] getSabor(){
        return saborEscolhido;
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
    public void adicionaSabor(Sabor sabor){
        saboresDisponiveis.add(sabor);
    }
    
    @Override
    public void apagarSabor(Sabor sabor){
        if (saboresDisponiveis.contains(sabor)) {
            saboresDisponiveis.remove(sabor);
        } else {
            // Caso o sabor não seja encontrado, lança uma exceção
            throw new IllegalArgumentException("O sabor especificado não foi encontrado na lista.");
        }
    }
    
    @Override
    public ArrayList<Sabor> getSabores(){
        return saboresDisponiveis;
    }
}
