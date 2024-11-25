package controller;

import model.Cliente;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    // Inserir um novo cliente
    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, email, telefone, endereco, senha) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setString(5, cliente.getSenha());

            pstmt.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    // Listar todos os clientes
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getString("senha")
                );
                cliente.setId(rs.getInt("id"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }

    // Atualizar um cliente existente
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ?, endereco = ?, senha = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setString(5, cliente.getSenha());
            pstmt.setInt(6, cliente.getId());

            pstmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // Remover um cliente pelo ID
    public void removerCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Cliente removido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }
}
