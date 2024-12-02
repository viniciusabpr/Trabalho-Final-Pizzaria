package SaborPizza;

import javax.swing.*;
import java.awt.*;

public class PrecoSabor {
    public PrecoSabor() {
        // Cria a tela
        JFrame precoSabor = new JFrame("Alterar preço dos sabores");
        precoSabor.setLayout(new BorderLayout());
        precoSabor.setSize(400, 400);

        // Cria o painel da label
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new FlowLayout(1, 0, 0));

        JLabel label1 = new JLabel("Escolha o tipo de pizza que deseja alterar o preço (Por CM)");
        painelLabel.add(label1);

        // Cria o painel dos botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);

        // Cria os botões
        JButton botao1 = new JButton("Premium");
        JButton botao2 = new JButton("Especial");
        JButton botao3 = new JButton("Simples");
        JButton botaoSair = new JButton("Voltar");

        botao1.setBounds(130, 50, 150, 40);
        botao2.setBounds(130, 110, 150, 40);
        botao3.setBounds(130, 180, 150, 40);

        buttonPanel.add(botao1);
        buttonPanel.add(botao2);
        buttonPanel.add(botao3);
        buttonPanel.add(botaoSair);

        // Listeners
        botao1.addActionListener(e -> alterarPreco(CategoriaSabor.PREMIUM));
        botao2.addActionListener(e -> alterarPreco(CategoriaSabor.ESPECIAL));
        botao3.addActionListener(e -> alterarPreco(CategoriaSabor.SIMPLES));

        precoSabor.add(painelLabel, BorderLayout.NORTH);
        precoSabor.add(buttonPanel, BorderLayout.CENTER);
        precoSabor.add(botaoSair, BorderLayout.SOUTH);
        
        botaoSair.addActionListener(e -> {
            precoSabor.dispose();
        });

        precoSabor.setVisible(true);
    }

    /**
     * Método para alterar o preço de um sabor específico.
     */
    private static void alterarPreco(CategoriaSabor categoriaSabor) {
        double precoAtual = categoriaSabor.getPreco();

        String input = JOptionPane.showInputDialog(
                null,
                "Preço atual para " + categoriaSabor.name() + ": R$ " + precoAtual + "\nInforme o novo preço:",
                "Alterar preço",
                JOptionPane.PLAIN_MESSAGE
        );

        try {
            double novoPreco = Double.parseDouble(input);
            if (novoPreco <= 0) {
                JOptionPane.showMessageDialog(null, "O preço deve ser maior que zero!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                categoriaSabor.setPreco(novoPreco);
                JOptionPane.showMessageDialog(
                        null,
                        "Preço de " + categoriaSabor.name() + " atualizado para R$ " + novoPreco,
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
