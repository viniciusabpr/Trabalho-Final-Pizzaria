package PedidoPizza;

import FormaPizza.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPedido{
    public static void main(String[] args){
        
        //Define o formato, nome e operação de fechamento da tela
        JFrame tela = new JFrame("Pedidos");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(800, 600);
        tela.setLayout(new BorderLayout());
        
        //Define o layout dos botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        JButton botaoTriangulo = new JButton("Triangular");
        JButton botaoQuadrado = new JButton("Quadrada");
        JButton botaoCirculo = new JButton("Circular");
        
        buttonPanel.add(botaoTriangulo);
        buttonPanel.add(botaoQuadrado);
        buttonPanel.add(botaoCirculo);
        
        //Define área de texto para exibir as informações das pizzas
        JTextArea outPutArea = new JTextArea(15,50);
        outPutArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outPutArea);
        
        //Adiciona os elementos na tela
        tela.add(buttonPanel, BorderLayout.NORTH);
        tela.add(scrollPane, BorderLayout.CENTER);
        
        //Listeners dos botões
        botaoTriangulo.addActionListener(e ->{
            Forma forma = new Triangulo();
            new EscolheSabor(forma);
        });
        
        tela.setVisible(true);
    }
}
