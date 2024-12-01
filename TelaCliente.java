import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaCliente extends JFrame {
    // Lista para guardar os clientes
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    // Componentes da tela
    JTextField campoNome;
    JTextField campoSobrenome;
    JTextField campoTelefone;
    JTextField campoBusca;
    JTable tabela;
    DefaultTableModel modeloTabela;

    // Construtor
    public TelaCliente() {
        // Configurar a janela
        setTitle("Cadastro de Clientes");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new BoxLayout(painelEntrada, BoxLayout.Y_AXIS));

        // Painel para os botões
        JPanel painelBotoes = new JPanel(new FlowLayout());
        // Criar os campos de texto
        campoNome = new JTextField(20);
        campoSobrenome = new JTextField(20);
        campoTelefone = new JTextField(20);
        campoBusca = new JTextField(20);

        // Criar os botões
        JButton botaoAdicionar = new JButton("Adicionar");
        JButton botaoAtualizar = new JButton("Atualizar");
        JButton botaoExcluir = new JButton("Excluir");
        JButton botaoBuscar = new JButton("Buscar");

        // Criar a tabela
        String[] colunas = {"Nome", "Sobrenome", "Telefone"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modeloTabela);

        // Adicionar componentes ao painel de entrada
        painelEntrada.add(new JLabel("Nome:"));
        painelEntrada.add(campoNome);
        painelEntrada.add(new JLabel("Sobrenome:"));
        painelEntrada.add(campoSobrenome);
        painelEntrada.add(new JLabel("Telefone:"));
        painelEntrada.add(campoTelefone);

        painelEntrada.add(new JLabel("Buscar:"));
        painelEntrada.add(campoBusca);

        // Adicionar botões ao painel de botões
        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoAtualizar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoBuscar);

        // Adicionar tabela com barra de rolagem
        JScrollPane scrollTabela = new JScrollPane(tabela);

        // Adicionar os painéis ao layout principal
        add(painelEntrada, BorderLayout.NORTH);
        add(scrollTabela, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Adicionar ação ao botão Adicionar
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarCliente();
            }
        });

        // Adicionar ação ao botão Buscar
        botaoBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarClientes();
            }
        });

        // Adicionar ação ao botão Excluir
        botaoExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirCliente();
            }
        });

        // Adicionar ação ao botão Atualizar
        botaoAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarCliente();
            }
        });
    }

    // Método para adicionar cliente
    private void adicionarCliente() {
        String nome = campoNome.getText().trim();
        String sobrenome = campoSobrenome.getText().trim();
        String telefone = campoTelefone.getText().trim();

        // Verificar campos vazios
        if (nome.isEmpty() || sobrenome.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
            return;
        }

        // Validar campos
        if (!validarNome(nome) || !validarNome(sobrenome)) {
            JOptionPane.showMessageDialog(null, "Os campos Nome e Sobrenome devem conter apenas letras e espaços!");
            return;
        }
        if (!validarTelefone(telefone)) {
            JOptionPane.showMessageDialog(null, "O campo Telefone deve conter o formato correto (apenas números)! Exemplo: 999999999 ou 9999999999");
            return;
        }

        Cliente cliente = new Cliente(nome, sobrenome, telefone);
        listaClientes.add(cliente);

        // Limpar campos
        campoNome.setText("");
        campoSobrenome.setText("");
        campoTelefone.setText("");

        // Atualizar tabela
        atualizarTabela();

        JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
    }

    // Método para buscar clientes
    private void buscarClientes() {
        String busca = campoBusca.getText().toLowerCase();

        // Limpar tabela
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        // Procurar clientes
        for (Cliente cliente : listaClientes) {
            String nome = cliente.getNome().toLowerCase();
            String sobrenome = cliente.getSobrenome().toLowerCase();
            String telefone = cliente.getTelefone();

            // Verificar se o nome, sobrenome ou telefone contém a busca
            if (nome.contains(busca) || sobrenome.contains(busca) || telefone.contains(busca)) {
                Object[] linha = {cliente.getNome(), cliente.getSobrenome(), formatarTelefone(cliente.getTelefone())};
                modeloTabela.addRow(linha);
            }
        }
    }

    // Método para excluir cliente
    private void excluirCliente() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir!");
            return;
        }

        listaClientes.remove(linha);
        atualizarTabela();
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
    }

    // Método para atualizar cliente
    private void atualizarCliente() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para atualizar!");
            return;
        }

        String nome = campoNome.getText().trim();
        String sobrenome = campoSobrenome.getText().trim();
        String telefone = campoTelefone.getText().trim();

        // Verificar campos vazios
        if (nome.isEmpty() || sobrenome.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
            return;
        }

        // Validar campos
        if (!validarNome(nome) || !validarNome(sobrenome)) {
            JOptionPane.showMessageDialog(null, "Os campos Nome e Sobrenome devem conter apenas letras e espaços!");
            return;
        }
        if (!validarTelefone(telefone)) {
            JOptionPane.showMessageDialog(null, "O campo Telefone deve conter o formato correto (apenas números)! Exemplo: 999999999 ou 9999999999");
            return;
        }

        Cliente cliente = listaClientes.get(linha);
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setTelefone(telefone);

        atualizarTabela();
        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
    }

    // Método para atualizar a tabela
    private void atualizarTabela() {
        // Limpar tabela
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        // Adicionar todos os clientes
        for (Cliente cliente : listaClientes) {
            Object[] linha = {cliente.getNome(), cliente.getSobrenome(), formatarTelefone(cliente.getTelefone())};
            modeloTabela.addRow(linha);
        }
    }

    // Método para formatar telefone para exibição
    private String formatarTelefone(String telefone) {
        // Verifica se o telefone tem 11 caracteres (para o formato (XX) XXXXX-XXXX)
        if (telefone.length() == 11) {
            return String.format("(%s) %s-%s", telefone.substring(0, 2), telefone.substring(2, 7), telefone.substring(7));
        }
        // Caso contrário, formato (XX) XXXX-XXXX
        else if (telefone.length() == 10) {
            return String.format("(%s) %s-%s", telefone.substring(0, 2), telefone.substring(2, 6), telefone.substring(6));
        }
        return telefone; // Caso o formato não seja válido, retorna como está (deve ser uma validação anterior)
    }

    // Métodos de validação
    private boolean validarNome(String texto) {
        return texto.matches("^[a-zA-ZÀ-ÿ\\s]+$"); // Permite letras, acentos e espaços
    }

    private boolean validarTelefone(String texto) {
        return texto.matches("^\\d{10,11}$"); // Permite apenas 10 ou 11 dígitos
    }

    public static void main(String[] args) {
        TelaCliente tela = new TelaCliente();
        tela.setVisible(true);
    }
}

// Classe Cliente
class Cliente {
    private String nome;
    private String sobrenome;
    private String telefone;

    public Cliente(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
