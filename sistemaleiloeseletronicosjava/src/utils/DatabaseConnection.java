package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Caminho absoluto relativo ao projeto
    private static final String URL = "jdbc:sqlite:./db/auction.db"; // Mesmo nível que a pasta src

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Conexão com SQLite estabelecida.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco: " + e.getMessage());
        }
        return conn;
    }
}
