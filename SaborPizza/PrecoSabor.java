package SaborPizza;

import javax.swing.*;
import java.awt.*;

public class PrecoSabor{
    public static void main(String[] args){
        //Cria a tela
        JFrame precoSabor = new JFrame ("Alterar preco dos sabores");
        precoSabor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        precoSabor.setLayout(new BorderLayout());
        precoSabor.setSize(400, 400);
        
        //Cria o painel da label
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new FlowLayout(1,0,0));
        
        JLabel label1 = new JLabel ("Escolha o tipo de pizza que deseja alterar o preco (Por CM)");
        painelLabel.add(label1);
       
       //Cria o painel dos botões
       JPanel buttonPanel = new JPanel();
       buttonPanel.setLayout(null);
       
       //Cria os botões
       JButton botao1 = new JButton("Premium");
       JButton botao2 = new JButton("Especial");
       JButton botao3 = new JButton("Simples");
       
       botao1.setBounds(130, 50, 150, 40);
       botao2.setBounds(130, 110, 150, 40);
       botao3.setBounds(130, 180, 150, 40);
       
       buttonPanel.add(botao1);
       buttonPanel.add(botao2);
       buttonPanel.add(botao3);
       
       //Listeners
       
       botao1.addActionListener(e -> {
           double preco = Double.parseDouble(JOptionPane.showInputDialog("Qual o novo preco?"));
       });
       
       botao2.addActionListener(e -> {
           double preco = Double.parseDouble(JOptionPane.showInputDialog("Qual o novo preco?"));
       });
       
       botao3.addActionListener(e -> {
           double preco = Double.parseDouble(JOptionPane.showInputDialog("Qual o novo preco?"));
       });
       
       precoSabor.add(painelLabel, BorderLayout.NORTH);
       precoSabor.add(buttonPanel, BorderLayout.CENTER);
       
       precoSabor.setVisible(true);
    }
}
