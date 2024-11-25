package controller;

import model.Leilao;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeilaoController {

    // Método para inserir um leilão
    public void inserirLeilao(Leilao leilao) {
        String sql = "INSERT INTO leiloes (data_ocorrencia, data_visita, local, endereco, cidade, estado, descricao, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, new java.sql.Date(leilao.getDataOcorrencia().getTime()));
            pstmt.setDate(2, new java.sql.Date(leilao.getDataVisita().getTime()));
            pstmt.setString(3, leilao.getLocal());
            pstmt.setString(4, leilao.getEndereco());
            pstmt.setString(5, leilao.getCidade());
            pstmt.setString(6, leilao.getEstado());
            pstmt.setString(7, leilao.getDescricao());
            pstmt.setString(8, leilao.getStatus());

            pstmt.executeUpdate();
            System.out.println("Leilão inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir leilão: " + e.getMessage());
        }
    }

    // Método para listar todos os leilões
    public List<Leilao> listarLeiloes() {
        List<Leilao> lista = new ArrayList<>();
        String sql = "SELECT * FROM leiloes";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Leilao leilao = new Leilao(
                        rs.getDate("data_ocorrencia"),
                        rs.getDate("data_visita"),
                        rs.getString("local"),
                        rs.getString("endereco"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("descricao"),
                        rs.getString("status")
                );
                leilao.setId(rs.getInt("id"));
                lista.add(leilao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar leilões: " + e.getMessage());
        }
        return lista;
    }

    // Método para atualizar um leilão
    public void atualizarLeilao(Leilao leilao) {
        String sql = "UPDATE leiloes SET data_ocorrencia = ?, data_visita = ?, local = ?, endereco = ?, cidade = ?, estado = ?, descricao = ?, status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, new java.sql.Date(leilao.getDataOcorrencia().getTime()));
            pstmt.setDate(2, new java.sql.Date(leilao.getDataVisita().getTime()));
            pstmt.setString(3, leilao.getLocal());
            pstmt.setString(4, leilao.getEndereco());
            pstmt.setString(5, leilao.getCidade());
            pstmt.setString(6, leilao.getEstado());
            pstmt.setString(7, leilao.getDescricao());
            pstmt.setString(8, leilao.getStatus());
            pstmt.setInt(9, leilao.getId());

            pstmt.executeUpdate();
            System.out.println("Leilão atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar leilão: " + e.getMessage());
        }
    }

    // Método para deletar um leilão
    public void deletarLeilao(int id) {
        String sql = "DELETE FROM leiloes WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Leilão deletado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar leilão: " + e.getMessage());
        }
    }
}
