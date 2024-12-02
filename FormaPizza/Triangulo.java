package FormaPizza;

//Area = Base * altura/2

import java.util.ArrayList;
import SaborPizza.*;


public class Triangulo extends Forma {
    private double lado;
    ArrayList<Sabor> saboresDisponiveis = new ArrayList<>();
    private Sabor[] saborEscolhido = new Sabor[2];
    
    public Triangulo(){};
    
    public double defineLado(double lado){
        if (lado < 20 || lado > 60){
            throw new IllegalArgumentException("Valores invalidos para os lados!");
        }
        return lado;
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
    public boolean adicionaSabor(Sabor sabor){
        boolean saborExiste = false;
        if (saboresDisponiveis.isEmpty()) {
            saboresDisponiveis.add(sabor);
        } else {
            for (Sabor saborBusca : saboresDisponiveis){
                if (saborBusca.equals(sabor)){
                    saborExiste = true;
                }else{
                    saboresDisponiveis.add(sabor);
                }
            }
        }
        return saborExiste;
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
