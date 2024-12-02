package PedidoCliente;

import java.util.ArrayList;
import FormaPizza.*;

public class Pedido{
    private EstadoPedido estado;
    int id;
    double preco;
    ArrayList<Forma> pizzas = new ArrayList<>();
    
    public Pedido( double preco, ArrayList<Forma> pizzas){
        this.estado = estado.PREPARANDO;
        this.preco = preco;
        this.pizzas = pizzas;
        id += id;
    }
}
