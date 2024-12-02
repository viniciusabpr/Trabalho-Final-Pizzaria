package PedidoPizza;

//Janela para escolher o tamanho e os sabores de pizza

import SaborPizza.*;
import FormaPizza.Forma;
import SaborPizza.Sabor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EscolheSabor{
    public EscolheSabor(Forma forma, CategoriaSabor categoria){
        
        //Define a área da nova janela
        JFrame escolherSabor = new JFrame("Escolher o sabor");
        escolherSabor.setSize(500, 350);
        escolherSabor.setLayout(new BorderLayout());
        
        //Define a área onde ficarão os campos para setar tamanho da pizza
        JPanel tamanhoPanel = new JPanel();
        tamanhoPanel.setLayout(new GridLayout(2, 2,5, 5));
        JLabel label1 = new JLabel("Defina o tamanho do lado da pizza:");
        JTextField campo1 = new JTextField(10);
        JLabel label2 = new JLabel ("Defina a area da pizza: ");
        JTextField campo2 = new JTextField(10);
        
        tamanhoPanel.add(label1);
        tamanhoPanel.add(campo1);
        tamanhoPanel.add(label2);
        tamanhoPanel.add(campo2);
        
        //Define a área para escolha dos sabores
        JPanel saborPanel = new JPanel();
        saborPanel.setLayout(new FlowLayout());
        
        //Cria os botões para serem inseridos caso existam sabores
        
        ArrayList<Sabor> saboresDisponiveis = forma.getSabores(); 
        JButton[] botoesSabores = new JButton[saboresDisponiveis.size()];
        boolean semSabor = true;

        for (int i = 0; i < saboresDisponiveis.size(); i++) {
            int indice = i; 
            botoesSabores[i] = new JButton(saboresDisponiveis.get(i).getNome()); 

            if (saboresDisponiveis != null){
                // Adiciona o listener ao botão
                botoesSabores[i].addActionListener(e -> {
                    forma.setSabor(saboresDisponiveis.get(indice)); 
                    for (int j = 0; j < botoesSabores.length; j++) {
                        if (j == indice) {
                            botoesSabores[j].setBackground(Color.GREEN); 
                       } else {
                            botoesSabores[j].setBackground(null);
                        }
                    }
                });
            
                saborPanel.add(botoesSabores[i]);
                semSabor = false;
            }
        }
        
        //Se não houverem sabores, será mostrado esse texto
        if (semSabor){
            JLabel semSabores = new JLabel ("Nao ha sabores disponeis para esse tipo de pizza");
            saborPanel.add(semSabores);
        }
        
        //Define a área para confirmação dos sabores
        JPanel confirmacaoPanel = new JPanel();
        confirmacaoPanel.setLayout(new FlowLayout());
        
        JButton botaoConfirmacao = new JButton("Confirmar");
        JButton botaoVoltar = new JButton("Voltar");
        
        confirmacaoPanel.add(botaoVoltar);
        confirmacaoPanel.add(botaoConfirmacao);
        
        //Adiciona os paineis à tela
        escolherSabor.add(tamanhoPanel, BorderLayout.NORTH);
        escolherSabor.add(saborPanel, BorderLayout.CENTER);
        escolherSabor.add(confirmacaoPanel, BorderLayout.SOUTH);
        
        //Listeners
        
        //Converte para área direto quando colocado o valor do lado
        campo1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                try{
                    double valorLado = Double.parseDouble(campo1.getText());
                    double area = forma.calculaArea(valorLado);
                    campo2.setText(String.format("%.2f", area));
                }catch(NumberFormatException n){
                    System.out.println("Por favor, insira um valor valido");
                }
            }
        });
        
        //Converte o valor inserido da área para o lado
        campo2.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                try{
                    double valorArea = Double.parseDouble(campo2.getText());
                    double lado = forma.calculaLado(valorArea);
                    campo1.setText(String.format("%.2f", lado));
                }catch(NumberFormatException n){
                    System.out.println("Por favor, insira um valor valido");
                }
            }
        });
        
        //Volta para tela de escolher formato
        botaoVoltar.addActionListener(e -> {
            escolherSabor.dispose();
        });
        
        escolherSabor.setVisible(true);
        
        }
        
   }
