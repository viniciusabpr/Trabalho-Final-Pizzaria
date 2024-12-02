package SaborPizza;

import SaborPizza.*;
import FormaPizza.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditSabor {
    private CategoriaSabor categoriaSelecionada = null; // Categoria do sabor
    private final JPanel saboresExistentes; // Painel que exibe os sabores
    private final Forma forma; // Forma da pizza

public EditSabor(Forma forma) {
        this.forma = forma; // Instância da forma recebida
        JFrame editSabor = new JFrame("Editar Sabores das Pizzas");
        editSabor.setSize(700, 400);
        editSabor.setLayout(new BorderLayout());

        // Botões para selecionar a categoria
        JButton botaoPremium = new JButton("Premium");
        JButton botaoEspecial = new JButton("Especial");
        JButton botaoSimples = new JButton("Simples");

        // Campo para o nome do sabor
        JLabel label1 = new JLabel("Insira o sabor da pizza:");
        JTextField campoSabor = new JTextField();

        // Botão para adicionar sabor
        JButton botaoAd = new JButton("Adicionar");

        // Painel superior para os campos de entrada
        JPanel saborPanel = new JPanel(new GridLayout(2, 2, 10, 5));
        saborPanel.add(botaoPremium);
        saborPanel.add(botaoEspecial);
        saborPanel.add(botaoSimples);
        saborPanel.add(label1);
        saborPanel.add(campoSabor);
        saborPanel.add(botaoAd);

        // Painel para exibir os sabores existentes
        saboresExistentes = new JPanel();
        saboresExistentes.setLayout(new BoxLayout(saboresExistentes, BoxLayout.Y_AXIS));
        atualizarSabores(); // Atualiza os sabores já cadastrados

        // Painel inferior com botão Voltar
        JPanel voltarPanel = new JPanel(new FlowLayout());
        JButton voltar = new JButton("Voltar");
        voltarPanel.add(voltar);

        // Listeners para os botões de categoria
        botaoPremium.addActionListener(e -> {
            categoriaSelecionada = CategoriaSabor.PREMIUM;
            destacarBotao(botaoPremium, botaoEspecial, botaoSimples);
        });
        botaoEspecial.addActionListener(e -> {
            categoriaSelecionada = CategoriaSabor.ESPECIAL;
            destacarBotao(botaoEspecial, botaoPremium, botaoSimples);
        });
        botaoSimples.addActionListener(e -> {
            categoriaSelecionada = CategoriaSabor.SIMPLES;
            destacarBotao(botaoSimples, botaoPremium, botaoEspecial);
        });

        // Listener para adicionar sabor
        botaoAd.addActionListener(e -> {
            String nomeSabor = campoSabor.getText().trim();

            if (categoriaSelecionada == null) {
                JOptionPane.showMessageDialog(editSabor, "Por favor, selecione uma categoria!");
                return;
            }

            if (nomeSabor.isEmpty()) {
                JOptionPane.showMessageDialog(editSabor, "Por favor, insira o nome do sabor!");
                return;
            }

            try {
                Sabor novoSabor = new Sabor(nomeSabor, categoriaSelecionada);
                forma.adicionaSabor(novoSabor);
                atualizarSabores();
                JOptionPane.showMessageDialog(editSabor, "Sabor adicionado com sucesso!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(editSabor, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Listener para voltar
        voltar.addActionListener(e -> editSabor.dispose());

        // Adiciona os componentes na tela
        editSabor.add(saborPanel, BorderLayout.NORTH);
        editSabor.add(new JScrollPane(saboresExistentes), BorderLayout.CENTER);
        editSabor.add(voltarPanel, BorderLayout.SOUTH);

        editSabor.setVisible(true);
    }

    // Método para destacar o botão da categoria selecionada
    private void destacarBotao(JButton selecionado, JButton... outros) {
        selecionado.setBackground(Color.GREEN);
        for (JButton botao : outros) {
            botao.setBackground(null);
        }
    }

    // Método para atualizar os sabores no painel
    private void atualizarSabores() {
        for (Sabor sabor : forma.getSabores()) {
            JPanel saborPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labelSabor = new JLabel("Sabor: " + sabor.getNome() + " - Categoria: " + sabor.getCategoria());
            JButton botaoRemover = new JButton("Remover");

            // Listener para remover o sabor
            botaoRemover.addActionListener(e -> {
                try {
                    forma.apagarSabor(sabor);
                    atualizarSabores(); // Atualiza a exibição após remover
                    JOptionPane.showMessageDialog(null, "Sabor removido com sucesso!");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });

            saborPanel.add(labelSabor);
            saborPanel.add(botaoRemover);
            saboresExistentes.add(saborPanel);
        }

        if (forma.getSabores().isEmpty()) {
            saboresExistentes.add(new JLabel("Ainda não há sabores disponíveis para essa pizza!"));
        }

        saboresExistentes.revalidate();
        saboresExistentes.repaint();
    }
}


