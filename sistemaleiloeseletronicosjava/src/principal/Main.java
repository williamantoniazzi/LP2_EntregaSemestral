package principal;

import controller.VeiculoController;
import model.Veiculo;

import java.util.List;

public class Main {

    public static void main1(String[] args) {
        // Criando uma instância do controlador de veículos
        VeiculoController veiculoController = new VeiculoController();

        // Inserir um veículo (exemplo)
        Veiculo veiculo = new Veiculo("Fusca", "Veículo clássico", 15000.0, "Carro", 1968, 1);
        veiculoController.inserirVeiculo(veiculo);

        // Listar todos os veículos
        System.out.println("Listando veículos...");
        List<Veiculo> veiculos = veiculoController.listarVeiculos();
        for (Veiculo v : veiculos) {
            System.out.println(v.getNome() + " - " + v.getCategoria() + " - " + v.getAno());
        }

        // Atualizar um veículo (exemplo)
        if (!veiculos.isEmpty()) {
            Veiculo veiculoAtualizado = veiculos.get(0);  // Vamos pegar o primeiro veículo da lista
            veiculoAtualizado.setDescricao("Veículo em excelente estado");
            veiculoController.atualizarVeiculo(veiculoAtualizado);
            System.out.println("Veículo atualizado: " + veiculoAtualizado.getDescricao());
        }

        // Remover um veículo (exemplo)
        if (!veiculos.isEmpty()) {
            Veiculo veiculoParaRemover = veiculos.get(0);  // Remover o primeiro veículo da lista
            veiculoController.removerVeiculo(veiculoParaRemover.getId());
            System.out.println("Veículo removido: " + veiculoParaRemover.getNome());
        }
    }
}
