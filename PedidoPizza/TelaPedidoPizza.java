package PedidoPizza;

import SaborPizza.*;
import FormaPizza.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPedidoPizza{
    public TelaPedidoPizza(CategoriaSabor categoria){
        
        //Define o formato, nome e operação de fechamento da tela
        JFrame tela = new JFrame("Cardapio das pizzas");
        tela.setSize(300, 300);
        tela.setLayout(new BorderLayout());
        
        //Painel de informação
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        JLabel labelTop = new JLabel("Escolha o tipo de pizza que deseja: ");
        topPanel.add(labelTop);
        
        //Define o layout dos botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        JButton botaoTriangulo = new JButton("Triangular");
        JButton botaoQuadrado = new JButton("Quadrada");
        JButton botaoCirculo = new JButton("Circular");
        
        buttonPanel.add(botaoTriangulo);
        buttonPanel.add(botaoQuadrado);
        buttonPanel.add(botaoCirculo);
        
        //Adiciona os elementos na tela
        tela.add(topPanel, BorderLayout.NORTH);
        tela.add(buttonPanel, BorderLayout.CENTER);
        
        //Listeners dos botões
        botaoTriangulo.addActionListener(e ->{
            Forma forma = new Triangulo();
            new EscolheSabor(forma, categoria);
            tela.dispose();
        });
        
        botaoQuadrado.addActionListener(e ->{
            Forma forma = new Triangulo();
            new EscolheSabor(forma, categoria);
            tela.dispose();
        });
        
        botaoCirculo.addActionListener(e ->{
            Forma forma = new Circunferencia();
            new EscolheSabor(forma, categoria);
            tela.dispose();
        });
        
        tela.setVisible(true);
    }
}