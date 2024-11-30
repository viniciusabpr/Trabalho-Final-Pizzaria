package SaborPizza;

import FormaPizza.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditSabor{
    public EditSabor(Forma forma){
        //Cria a tela
        JFrame editSabor = new JFrame("Editar sabores das pizzas");
        editSabor.setSize(700, 400);
        editSabor.setLayout(new BorderLayout());
        
        //Cria o painel onde ficarão o campo para colocar o sabor e os botões de adicionar ou excluir sabor
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new GridLayout(2, 2, 10, 5));
        
        //Cria os botões e o campo
        JLabel label1 = new JLabel("Insira o sabor da pizza (+ para adicionar o sabor, - para excluir)");
        JTextField campoSabor = new JTextField();
        JButton botaoAd = new JButton("+");
        JButton botaoEx = new JButton("-");
        
        editPanel.add(label1);
        editPanel.add(campoSabor);
        editPanel.add(botaoAd);
        editPanel.add(botaoEx);
        
        //Cria o painel onde serão exibidos os sabores já cadastrados para essa forma, caso existam
        JPanel saboresExistentes = new JPanel();
        saboresExistentes.setLayout(new FlowLayout(1, 650, 30));
        boolean semSabor = true;
        
        String [] saboresDisponiveis = forma.getSabores();
        for (String sabor : saboresDisponiveis) {
            if (sabor != null){
                JLabel label2 = new JLabel("sabor: " + sabor);
                saboresExistentes.add(label2);
                semSabor = false;
            }
        }
        
        if (semSabor){
            JLabel labelSemSabor = new JLabel("Ainda nao ha sabores disponiveis para essa pizza!");
            saboresExistentes.add(labelSemSabor);
        }
        
        //Cria o painel do botão de voltar
        JPanel voltarTela = new JPanel();
        voltarTela.setLayout(new FlowLayout());
        
        JButton voltar = new JButton("Voltar");
        
        voltarTela.add(voltar);
        
        //Listeners
        
        //Listener do botão de adicionar sabor
        botaoAd.addActionListener(e -> {
            String sabor = campoSabor.getText();
            
            try{
                forma.adicionaSabor(sabor);
                JLabel labelDeuBoa = new JLabel("Sabor cadastrado com sucesso!");
                saboresExistentes.add(labelDeuBoa);
                editSabor.revalidate();
                editSabor.repaint();
            }catch(IllegalArgumentException i){
                JLabel labelErro = new JLabel("A pizza ja possui o numero maximo de sabores cadastrados, "
                        + "por favor, exclua um antes depor adicionar outro!");
                saboresExistentes.add(labelErro);
                editSabor.revalidate();
                editSabor.repaint();
            }
        });
        
        //Listener do botão de excluir sabor
        botaoEx.addActionListener(e -> {
           String sabor = campoSabor.getText();
           
           try{
               forma.apagarSabor(sabor);
               JLabel labelDeuBoa2 = new JLabel("Sabor excluido com sucesso1");
               saboresExistentes.add(labelDeuBoa2);
                editSabor.revalidate();
                editSabor.repaint();
           }catch(IllegalArgumentException i){
               JLabel labelErro2; labelErro2 = new JLabel("O sabor da pizza nao foi encontrado.");
           }catch(ArrayIndexOutOfBoundsException a){
               JLabel labelErro2; labelErro2 = new JLabel("Ainda nao ha pizzas cadastradas.");
               saboresExistentes.add(labelErro2);
                editSabor.revalidate();
                editSabor.repaint();
           }
        });
        
        voltar.addActionListener(e -> {
            editSabor.dispose();
        });
        
        //Adiciona os elementos na tela e deixa ela visível
        
        editSabor.add(editPanel, BorderLayout.NORTH);
        editSabor.add(saboresExistentes, BorderLayout.CENTER);
        editSabor.add(voltarTela, BorderLayout.SOUTH);
        
        editSabor.setVisible(true);
    }
}
