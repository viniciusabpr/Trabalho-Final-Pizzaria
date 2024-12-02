package FormaPizza;

import java.util.ArrayList;
import SaborPizza.*;

public abstract class Forma {
    
    public abstract boolean adicionaSabor(Sabor sabor);
    
    public abstract void apagarSabor(Sabor sabor);
    
    public abstract ArrayList<Sabor> getSabores();
    
    public abstract boolean setSabor(Sabor sabor);
    
    public abstract Sabor[] getSabor();
    
    public abstract double calculaArea(double lado);

    public abstract double calculaLado(double area);
}
