package PedidoPizza;

import javax.swing.*;
import java.awt.*;
import SaborPizza.*;

public class EscolheTipoSabor{
    public EscolheTipoSabor(){
        //Cria a tela
        JFrame escolheTipoSabor = new JFrame("Escolha o tipo do sabor");
        escolheTipoSabor.setLayout(new BorderLayout());
        escolheTipoSabor.setSize(400, 400);
        
        JLabel label1 = new JLabel("Escolha o tipo do sabor: ");
        
        //Cria os botões com os tipos de sabor
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        JButton botaoPremium = new JButton("PREMIUM");
        JButton botaoEspecial = new JButton("ESPECIAL");
        JButton botaoSimples = new JButton("SIMPLES");
        JButton botaoVoltar = new JButton("Voltar");
        
        buttonPanel.add(botaoPremium);
        buttonPanel.add(botaoEspecial);
        buttonPanel.add(botaoSimples);
        
        escolheTipoSabor.add(label1, BorderLayout.NORTH);
        escolheTipoSabor.add(buttonPanel, BorderLayout.CENTER);
        escolheTipoSabor.add(botaoVoltar, BorderLayout.SOUTH);
        
        //Listeners
        botaoPremium.addActionListener(e -> {
            CategoriaSabor categoriaSelecionada = null;
            categoriaSelecionada = CategoriaSabor.PREMIUM;
            new TelaPedidoPizza(categoriaSelecionada);
            escolheTipoSabor.dispose();
        });
        
        botaoEspecial.addActionListener(e -> {
            CategoriaSabor categoriaSelecionada = null;
            categoriaSelecionada = CategoriaSabor.ESPECIAL;
            new TelaPedidoPizza(categoriaSelecionada);
            escolheTipoSabor.dispose();
        });
        
        botaoSimples.addActionListener(e -> {
            CategoriaSabor categoriaSelecionada = null;
            categoriaSelecionada = CategoriaSabor.SIMPLES;
            new TelaPedidoPizza(categoriaSelecionada);
            escolheTipoSabor.dispose();
        });
        
        botaoVoltar.addActionListener(e -> {
            escolheTipoSabor.dispose();
        });
        
        escolheTipoSabor.setVisible(true);
    }
}
