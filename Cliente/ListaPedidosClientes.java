package Cliente;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import PedidoPizza.*;

public class ListaPedidosClientes{
    public ListaPedidosClientes(Cliente cliente){
        //Cria a tela
        JFrame telaPedidos = new JFrame("Pedidos do cliente");
        telaPedidos.setSize(600, 600);
        telaPedidos.setLayout(new BorderLayout());
        
        DefaultTableModel modelTabela;
        JTable tabela;
        
        //Cria a navbar da tela (Exibe o nome do cliente no topo)
        JPanel topPanel = new JPanel ();
        topPanel.setLayout(new FlowLayout());
        
        JLabel labelNome = new JLabel("Cliente: " + cliente.getNome());
        
        topPanel.add(labelNome);
        
        //Cria as tabelas principais para colocar as informações
        String[] colunas = {"ID", "N° Pizzas", "Valor total"};
        modelTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelTabela);
        
        JScrollPane scrollTabela = new JScrollPane(tabela);
        
        //Cria o painel onde ficarão os botões
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new FlowLayout());
        
        JButton bAdItem = new JButton("Adicionar Item");
        JButton edItem = new JButton ("Editar Item");
        JButton buttonVoltar = new JButton("voltar");
        
        botoesPanel.add(buttonVoltar);
        botoesPanel.add(edItem);
        botoesPanel.add(bAdItem);
        
        telaPedidos.add(topPanel, BorderLayout.NORTH);
        telaPedidos.add(scrollTabela, BorderLayout.CENTER);
        telaPedidos.add(botoesPanel, BorderLayout.SOUTH);
        
        //Listeners
        buttonVoltar.addActionListener(e ->{
            telaPedidos.dispose();
        });
        
        bAdItem.addActionListener(e ->{
            new EscolheTipoSabor();
        });
        
        telaPedidos.setVisible(true);
    }
}
