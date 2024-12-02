package Cliente;

//Tela para ligar o menu do cliente com as telas de editar dados de sabor e preço das pizzas

import javax.swing.*;
import java.awt.*;
import SaborPizza.*;

public class TelaIntermediariaPizza{
    public TelaIntermediariaPizza(){
        //Cria a tela
        JFrame tela = new JFrame();
        tela.setLayout(new BorderLayout());
        tela.setSize(400,400);
        
        //Cria o painel com as instruções
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        JLabel labelTop = new JLabel("Escolha o que deseja editar nas pizzas: ");
        topPanel.add(labelTop);
        
        //Cria o painel com dois botões com as opções
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(1, 200, 10));
        
        JButton botaoEditSabor =  new JButton("Editar Sabor");
        JButton botaoEditPreco = new JButton("Editar Preco");
        
        buttonPanel.add(botaoEditSabor);
        buttonPanel.add(botaoEditPreco);
        
        //Cria o botão de voltar, para sair da tela
        JButton voltar = new JButton("Voltar");
        
        tela.add(topPanel, BorderLayout.NORTH);
        tela.add(buttonPanel, BorderLayout.CENTER);
        tela.add(voltar, BorderLayout.SOUTH);
        
        //Listeners
        botaoEditSabor.addActionListener(e -> {
            new EscolheEditPizza();
        });
        
        botaoEditPreco.addActionListener(e -> {
            new PrecoSabor();
        });
        
        voltar.addActionListener(e -> {
            tela.dispose();
        });
        
        tela.setVisible(true);
    }
}