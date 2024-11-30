package SaborPizza;

import FormaPizza.*;
import javax.swing.*;
import java.awt.*;

public class EscolheEditPizza{
    public static void main(String[] args){
        Forma forma = new Triangulo();
        
        //Cria a tela
        JFrame cadastrarSabor = new JFrame();
        cadastrarSabor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadastrarSabor.setSize(400, 400);
        cadastrarSabor.setLayout(new BorderLayout());
        
        //Define a área do texto
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout(1, 0, 0));
        JLabel label1 = new JLabel ("Selecione o formato da pizza para adicionar o sabor: ");
        
        labelPanel.add(label1);
        
        //Define a área onde ficarão os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        JButton botao1 = new JButton ("Triangular");
        JButton botao2 = new JButton ("Quadrada");
        JButton botao3 = new JButton ("Circular");
        
        botao1.setBounds(130, 50, 150, 40);
        botao2.setBounds(130, 110, 150, 40);
        botao3.setBounds(130, 180, 150, 40);
        
        buttonPanel.add(botao1);
        buttonPanel.add(botao2);
        buttonPanel.add(botao3);
        
        //Listeners
        
        botao1.addActionListener(e -> {
            new EditSabor(forma);
        });
        
        //Adiciona os elementos à tela
        cadastrarSabor.add(labelPanel, BorderLayout.NORTH);
        cadastrarSabor.add(buttonPanel, BorderLayout.CENTER);
        
        cadastrarSabor.setVisible(true);
    }
}
