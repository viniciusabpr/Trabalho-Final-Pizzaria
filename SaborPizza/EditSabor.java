package SaborPizza;

import SaborPizza.*;
import FormaPizza.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditSabor {
    CategoriaSabor categoriaSelecionada = null;

    public EditSabor(Forma forma) {
        // Cria a tela
        JFrame editSabor = new JFrame("Editar sabores das pizzas");
        editSabor.setSize(700, 400);
        editSabor.setLayout(new BorderLayout());

        // Cria os botões para selecionar a categoria
        JButton botaoPremium = new JButton("Premium");
        JButton botaoEspecial = new JButton("Especial");
        JButton botaoSimples = new JButton("Simples");

        // Cria o campo para inserir o nome do sabor
        JLabel label1 = new JLabel("Insira o sabor da pizza (+ para adicionar o sabor, - para excluir)");
        JTextField campoSabor = new JTextField();

        // Botões para adicionar e excluir sabor
        JButton botaoAd = new JButton("+");
        JButton botaoEx = new JButton("-");

        // Cria o painel para o campo de sabor e botões
        JPanel saborPanel = new JPanel();
        saborPanel.setLayout(new GridLayout(3, 3, 100, 5));
        saborPanel.add(botaoPremium);
        saborPanel.add(botaoEspecial);
        saborPanel.add(botaoSimples);
        saborPanel.add(label1);
        saborPanel.add(campoSabor);
        saborPanel.add(botaoAd);
        saborPanel.add(botaoEx);

        // Cria o painel onde serão exibidos os sabores já cadastrados para essa forma, caso existam
        JPanel saboresExistentes = new JPanel();
        saboresExistentes.setLayout(new FlowLayout(1, 650, 30));
        boolean semSabor = true;

        ArrayList<Sabor> saboresDisponiveis = forma.getSabores();
        for (Sabor sabor : saboresDisponiveis) {
            if (sabor != null) {
                JLabel label2 = new JLabel("Sabor: " + sabor.getNome());
                saboresExistentes.add(label2);
                semSabor = false;
            }
        }

        if (semSabor) {
            JLabel labelSemSabor = new JLabel("Ainda não há sabores disponíveis para essa pizza!");
            saboresExistentes.add(labelSemSabor);
        }

        // Cria o painel do botão de voltar
        JPanel voltarTela = new JPanel();
        voltarTela.setLayout(new FlowLayout());

        JButton voltar = new JButton("Voltar");
        voltarTela.add(voltar);

        // Listeners dos botões de categoria
        botaoPremium.addActionListener(e -> {
            categoriaSelecionada = CategoriaSabor.PREMIUM;
            botaoPremium.setBackground(Color.GREEN);  // Muda a cor para verde
            botaoEspecial.setBackground(null); 
            botaoSimples.setBackground(null); 
        });

        botaoEspecial.addActionListener(e -> {
            categoriaSelecionada = CategoriaSabor.ESPECIAL;
            botaoEspecial.setBackground(Color.GREEN); // Muda a cor para verde
            botaoPremium.setBackground(null); 
            botaoSimples.setBackground(null); 
        });

        botaoSimples.addActionListener(e -> {
            categoriaSelecionada = CategoriaSabor.SIMPLES;
            botaoSimples.setBackground(Color.GREEN); // Muda a cor para verde
            botaoPremium.setBackground(null); 
            botaoEspecial.setBackground(null); 
        });

        // Listener do botão de adicionar sabor
        botaoAd.addActionListener(e -> {
            String nomeSabor = campoSabor.getText();

            // Verifica se a categoria foi selecionada
            if (categoriaSelecionada == null) {
                JOptionPane.showMessageDialog(editSabor, "Por favor, selecione uma categoria para o sabor!");
                return;
            }

            // Cria o objeto Sabor com o nome e categoria selecionados
            Sabor sabor = new Sabor(nomeSabor, categoriaSelecionada);

            try {
                forma.adicionaSabor(sabor);
                JLabel labelDeuBoa = new JLabel("Sabor cadastrado com sucesso!");
                saboresExistentes.add(labelDeuBoa);
                editSabor.revalidate();
                editSabor.repaint();
            } catch (IllegalArgumentException i) {
                JLabel labelErro = new JLabel("A pizza já possui o número máximo de sabores cadastrados. "
                        + "Por favor, exclua um antes de adicionar outro!");
                saboresExistentes.add(labelErro);
                editSabor.revalidate();
                editSabor.repaint();
            }
        });

        // Listener do botão de excluir sabor
        botaoEx.addActionListener(e -> {
            String nomeSabor = campoSabor.getText();

            // Cria o objeto Sabor com o nome e categoria selecionados
            Sabor sabor = new Sabor(nomeSabor, categoriaSelecionada);

            try {
                forma.apagarSabor(sabor);
                JLabel labelDeuBoa2 = new JLabel("Sabor excluído com sucesso!");
                saboresExistentes.add(labelDeuBoa2);
                editSabor.revalidate();
                editSabor.repaint();
            }  catch (ArrayIndexOutOfBoundsException a) {
                JLabel labelErro2 = new JLabel("Ainda não há pizzas cadastradas.");
                saboresExistentes.add(labelErro2);
                editSabor.revalidate();
                editSabor.repaint();
            }
        });

        // Listener do botão de voltar
        voltar.addActionListener(e -> {
            editSabor.dispose();
        });

        // Adiciona os elementos na tela e deixa ela visível
        editSabor.add(saborPanel, BorderLayout.NORTH);
        editSabor.add(saboresExistentes, BorderLayout.CENTER);
        editSabor.add(voltarTela, BorderLayout.SOUTH);

        editSabor.setVisible(true);
    }

}
