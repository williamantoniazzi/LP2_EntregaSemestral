package controller;

import model.Dispositivo;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DispositivoController {

    // Método para inserir um dispositivo
    public void inserirDispositivo(Dispositivo dispositivo) {
        String sql = "INSERT INTO produtos (descricao, marca, modelo, categoria, valor_inicial, ano, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dispositivo.getDescricao());
            pstmt.setString(2, dispositivo.getMarca());
            pstmt.setString(3, dispositivo.getModelo());
            pstmt.setString(4, dispositivo.getCategoria());
            pstmt.setDouble(5, dispositivo.getValorInicial());
            pstmt.setInt(6, dispositivo.getAno());
            pstmt.setString(7, "Dispositivo");

            pstmt.executeUpdate();
            System.out.println("Dispositivo inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dispositivo: " + e.getMessage());
        }
    }

    // Método para listar todos os dispositivos
    public List<Dispositivo> listarDispositivos() {
        List<Dispositivo> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE tipo = 'Dispositivo'";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dispositivo dispositivo = new Dispositivo(
                        rs.getString("descricao"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("categoria"),
                        rs.getDouble("valor_inicial"),
                        rs.getInt("ano")
                );
                dispositivo.setId(rs.getInt("id"));
                lista.add(dispositivo);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar dispositivos: " + e.getMessage());
        }
        return lista;
    }

    // Método para atualizar um dispositivo
    public void atualizarDispositivo(Dispositivo dispositivo) {
        String sql = "UPDATE produtos SET descricao = ?, marca = ?, modelo = ?, categoria = ?, valor_inicial = ?, ano = ? WHERE id = ? AND tipo = 'Dispositivo'";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dispositivo.getDescricao());
            pstmt.setString(2, dispositivo.getMarca());
            pstmt.setString(3, dispositivo.getModelo());
            pstmt.setString(4, dispositivo.getCategoria());
            pstmt.setDouble(5, dispositivo.getValorInicial());
            pstmt.setInt(6, dispositivo.getAno());
            pstmt.setInt(7, dispositivo.getId());

            pstmt.executeUpdate();
            System.out.println("Dispositivo atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dispositivo: " + e.getMessage());
        }
    }

    // Método para deletar um dispositivo
    public void deletarDispositivo(int id) {
        String sql = "DELETE FROM produtos WHERE id = ? AND tipo = 'Dispositivo'";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Dispositivo deletado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar dispositivo: " + e.getMessage());
        }
    }
}

