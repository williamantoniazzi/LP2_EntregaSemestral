package controller;

import model.Produto;
import utils.DatabaseConnection;

import java.sql.*;

public class ProdutoController {

    // Método para inserir produto associado a um leilão
    public void inserirProduto(Produto produto) {
        String sql = "INSERT INTO produtos (nome, descricao, valor_inicial, id_leilao) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getValorInicial());
            pstmt.setInt(4, produto.getIdLeilao());  // Vinculando o produto ao leilão

            pstmt.executeUpdate();
            System.out.println("Produto inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    // Método para desassociar produto de um leilão
    public void desassociarProduto(int idProduto) {
        String sql = "UPDATE produtos SET id_leilao = NULL WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idProduto);
            pstmt.executeUpdate();
            System.out.println("Produto desassociado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao desassociar produto: " + e.getMessage());
        }
    }

    // Método para associar produto a um outro leilão
    public void associarProdutoAOutroLeilao(int idProduto, int novoLeilaoId) {
        String sql = "UPDATE produtos SET id_leilao = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, novoLeilaoId);
            pstmt.setInt(2, idProduto);
            pstmt.executeUpdate();
            System.out.println("Produto associado a outro leilão com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao associar produto a outro leilão: " + e.getMessage());
        }
    }
}
