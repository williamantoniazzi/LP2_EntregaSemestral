package view;

import controller.ClienteController;
import controller.InstituicaoController;
import controller.VeiculoController;
import model.Cliente;
import model.InstituicaoFinanceira;
import model.Veiculo;
import utils.DatabaseSetup;

import java.util.List;
import java.util.Scanner;


public class MainView {
	
    public static void main(String[] args) {
        // Chama a criação das tabelas antes de iniciar o menu
        DatabaseSetup.createTables();

        // Inicia o menu principal
        MainView mainView = new MainView();
        mainView.exibirMenu();
    }

    private VeiculoController veiculoController;
    private ClienteController clienteController;
    private InstituicaoController instituicaoController = new InstituicaoController();
    private Scanner scanner;

    public MainView() {
        this.veiculoController = new VeiculoController();
        this.clienteController = new ClienteController();
        this.scanner = new Scanner(System.in);
    }

    // Exibe o menu e gerencia a interação com o usuário
    public void exibirMenu() {
        while (true) {
            System.out.println("----- Menu -----");
            System.out.println("1. Inserir Veículo");
            System.out.println("2. Listar Veículos");
            System.out.println("3. Atualizar Veículo");
            System.out.println("4. Remover Veículo");
            System.out.println("5. Inserir Cliente");
            System.out.println("6. Listar Clientes");
            System.out.println("7. Atualizar Cliente");
            System.out.println("8. Remover Cliente");
            System.out.println("9. Inserir Instituição Financeira");
            System.out.println("10. Listar Instituições Financeiras");
            System.out.println("11. Remover Instituições Financeiras");           
            System.out.println("12. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    inserirVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    atualizarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 5:
                    inserirCliente();
                    break;
                case 6:
                    listarClientes();
                    break;
                case 7:
                    atualizarCliente();
                    break;
                case 8:
                    removerCliente();
                    break;
                case 9:
                	inserirInstituicao();
                	break;
                case 10:
                	listarInstituicoes();
                	break;
                case 11:
                	removerInstituicao();
                	break;
                case 12:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Inserir um veículo
    private void inserirVeiculo() {
        System.out.print("Nome do Veículo: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor Inicial: ");
        double valorInicial = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("ID do Leilão: ");
        int idLeilao = scanner.nextInt();

        Veiculo veiculo = new Veiculo(nome, descricao, valorInicial, categoria, ano, idLeilao);
        veiculoController.inserirVeiculo(veiculo);
    }

    // Listar todos os veículos
    private void listarVeiculos() {
        List<Veiculo> veiculos = veiculoController.listarVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo encontrado.");
        } else {
            for (Veiculo veiculo : veiculos) {
                System.out.println("ID: " + veiculo.getId() + " | Nome: " + veiculo.getNome() + " | Categoria: " + veiculo.getCategoria() + " | Ano: " + veiculo.getAno());
            }
        }
    }

    // Atualizar um veículo
    private void atualizarVeiculo() {
        System.out.print("ID do Veículo a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nova Descrição: ");
        String descricao = scanner.nextLine();
        Veiculo veiculo = new Veiculo("", descricao, 0, "", 0, 0);
        veiculo.setId(id);
        veiculoController.atualizarVeiculo(veiculo);
    }

    // Remover um veículo
    private void removerVeiculo() {
        System.out.print("ID do Veículo a ser removido: ");
        int id = scanner.nextInt();
        veiculoController.removerVeiculo(id);
    }
    
    // Método para inserir cliente
    private void inserirCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone, endereco, senha);
        clienteController.inserirCliente(cliente);
    }

    // Método para listar clientes
    private void listarClientes() {
        List<Cliente> clientes = clienteController.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | Email: " + cliente.getEmail());
            }
        }
    }

    // Método para atualizar cliente
    private void atualizarCliente() {
        System.out.print("ID do Cliente a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Novo Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Nova Senha: ");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone, endereco, senha);
        cliente.setId(id);
        clienteController.atualizarCliente(cliente);
    }

    // Método para remover cliente
    private void removerCliente() {
        System.out.print("ID do Cliente a ser removido: ");
        int id = scanner.nextInt();
        clienteController.removerCliente(id);
    }

    private void inserirInstituicao() {
        System.out.print("Nome da Instituição: ");
        String nome = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        InstituicaoFinanceira instituicao = new InstituicaoFinanceira(nome, cnpj, endereco);
        instituicaoController.inserirInstituicao(instituicao);
    }

    // Método para listar instituições
    private void listarInstituicoes() {
        List<InstituicaoFinanceira> instituicoes = instituicaoController.listarInstituicoes();
        if (instituicoes.isEmpty()) {
            System.out.println("Nenhuma instituição encontrada.");
        } else {
            for (InstituicaoFinanceira instituicao : instituicoes) {
                System.out.println("ID: " + instituicao.getId() + " | Nome: " + instituicao.getNome() + " | CNPJ: " + instituicao.getCnpj());
            }
        }
    }
    
    // Método para remover instituição financeira
    private void removerInstituicao() {
        System.out.print("ID da Instituição a ser removido: ");
        int id = scanner.nextInt();
        instituicaoController.removerInstituicao(id);
    }

}

