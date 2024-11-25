package controller;

import model.Veiculo;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoController {

    // Método para inserir veiculo no banco de dados
    public void inserirVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculos (nome, descricao, valor_inicial, categoria, ano, leilao_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, veiculo.getNome());
            pstmt.setString(2, veiculo.getDescricao());
            pstmt.setDouble(3, veiculo.getValorInicial());
            pstmt.setString(4, veiculo.getCategoria());  // Categoria do veículo (carro, moto, caminhão)
            pstmt.setInt(5, veiculo.getAno());  // Ano do veículo
            pstmt.setInt(6, veiculo.getLeilaoId());  // ID do leilão a que o veículo pertence

            pstmt.executeUpdate();
            System.out.println("Veículo inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir veículo: " + e.getMessage());
        }
    }

    // Método para listar todos os veículos
    public List<Veiculo> listarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("valor_inicial"),
                        rs.getString("categoria"),
                        rs.getInt("ano"),
                        rs.getInt("leilao_id")
                );
                veiculo.setId(rs.getInt("id"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar veículos: " + e.getMessage());
        }

        return veiculos;
    }

    // Método para atualizar informações de um veículo
    public void atualizarVeiculo(Veiculo veiculo) {
        String sql = "UPDATE veiculos SET nome = ?, descricao = ?, valor_inicial = ?, categoria = ?, ano = ?, leilao_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, veiculo.getNome());
            pstmt.setString(2, veiculo.getDescricao());
            pstmt.setDouble(3, veiculo.getValorInicial());
            pstmt.setString(4, veiculo.getCategoria());  // Categoria do veículo
            pstmt.setInt(5, veiculo.getAno());  // Ano do veículo
            pstmt.setInt(6, veiculo.getLeilaoId());  // ID do leilão associado
            pstmt.setInt(7, veiculo.getId());  // ID do veículo a ser atualizado

            pstmt.executeUpdate();
            System.out.println("Veículo atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veículo: " + e.getMessage());
        }
    }

    // Método para remover veículo
    public void removerVeiculo(int idVeiculo) {
        String sql = "DELETE FROM veiculos WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idVeiculo);
            pstmt.executeUpdate();
            System.out.println("Veículo removido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover veículo: " + e.getMessage());
        }
    }
}
