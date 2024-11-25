package controller;

import model.InstituicaoFinanceira;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstituicaoController {

    public void inserirInstituicao(InstituicaoFinanceira instituicao) {
        String sql = "INSERT INTO instituicoes_financeiras (nome, cnpj, endereco) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, instituicao.getNome());
            pstmt.setString(2, instituicao.getCnpj());
            pstmt.setString(3, instituicao.getEndereco());
            pstmt.executeUpdate();

            System.out.println("Instituição financeira inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir instituição: " + e.getMessage());
        }
    }

    public List<InstituicaoFinanceira> listarInstituicoes() {
        List<InstituicaoFinanceira> instituicoes = new ArrayList<>();
        String sql = "SELECT * FROM instituicoes_financeiras";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                InstituicaoFinanceira instituicao = new InstituicaoFinanceira(
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("endereco")
                );
                instituicao.setId(rs.getInt("id"));
                instituicoes.add(instituicao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar instituições: " + e.getMessage());
        }
        return instituicoes;
    }

    public void atualizarInstituicao(InstituicaoFinanceira instituicao) {
        String sql = "UPDATE instituicoes_financeiras SET nome = ?, cnpj = ?, endereco = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, instituicao.getNome());
            pstmt.setString(2, instituicao.getCnpj());
            pstmt.setString(3, instituicao.getEndereco());
            pstmt.setInt(4, instituicao.getId());
            pstmt.executeUpdate();

            System.out.println("Instituição financeira atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar instituição: " + e.getMessage());
        }
    }

    public void removerInstituicao(int id) {
        String sql = "DELETE FROM instituicoes_financeiras WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Instituição financeira removida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao remover instituição: " + e.getMessage());
        }
    }
}
