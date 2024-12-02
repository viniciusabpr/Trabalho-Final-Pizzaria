package SaborPizza;

import FormaPizza.*;
import javax.swing.*;
import java.awt.*;

public class EscolheEditPizza{
    public EscolheEditPizza(){
        
        //Cria a tela
        JFrame cadastrarSabor = new JFrame();
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
        JButton botaoVoltar = new JButton("Voltar");
        
        botao1.setBounds(130, 50, 150, 40);
        botao2.setBounds(130, 110, 150, 40);
        botao3.setBounds(130, 180, 150, 40);
        
        buttonPanel.add(botao1);
        buttonPanel.add(botao2);
        buttonPanel.add(botao3);
        
        //Listeners
        
        botao1.addActionListener(e -> {
            Forma forma = new Triangulo();
            new EditSabor(forma);
        });
        
        botao2.addActionListener(e -> {
            Forma forma = new Quadrado();
            new EditSabor(forma);
        });
        
        botao3.addActionListener(e -> {
            Forma forma = new Circunferencia();
            new EditSabor(forma);
        });
        
        botaoVoltar.addActionListener(e -> {
            cadastrarSabor.dispose();
        });
        
        //Adiciona os elementos à tela
        cadastrarSabor.add(labelPanel, BorderLayout.NORTH);
        cadastrarSabor.add(buttonPanel, BorderLayout.CENTER);
        cadastrarSabor.add(botaoVoltar, BorderLayout.SOUTH);
        
        cadastrarSabor.setVisible(true);
    }
}
