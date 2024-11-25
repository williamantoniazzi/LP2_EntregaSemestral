package utils;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createTables() {
        String produtosTable = "CREATE TABLE IF NOT EXISTS produtos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        		"nome TEXT NOT NULL," +
                "descricao TEXT," +
                "valor_inicial DOUBLE NOT NULL," +
                "leilao_id INTEGER," +
                "FOREIGN KEY (leilao_id) REFERENCES leiloes (id)" +
                ");";
                
        String lancesTable = "CREATE TABLE IF NOT EXISTS lances (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "produto_id INTEGER NOT NULL," +
                "usuario TEXT NOT NULL," +
                "valor REAL NOT NULL," +
                "FOREIGN KEY (produto_id) REFERENCES produtos (id)" +
                ");";
        
        String leiloesTable = "CREATE TABLE IF NOT EXISTS leiloes (" + 
        		"id INTEGER PRIMARY KEY AUTOINCREMENT," + 
        		"data_ocorrencia DATE NOT NULL," +
        		"data_visita DATE NOT NULL," +
        		"local TEXT NOT NULL," +
        		"endereco TEXT NOT NULL," +
        		"cidade TEXT NOT NULL," +
        		"estado TEXT NOT NULL," +
        		"descricao TEXT," +
        		"status TEXT NOT NULL" +
        		");";
        
		String veiculosTable = "CREATE TABLE IF NOT EXISTS veiculos (" + 
        		"id INTEGER PRIMARY KEY AUTOINCREMENT," + 
        		"nome TEXT NOT NULL," +
        		"descricao TEXT NOT NULL," +
        		"valor_inicial REAL NOT NULL," +
        		"categoria TEXT NOT NULL," +
        		"ano INTEGER NOT NULL," +
        		"leilao_id INTEGER NOT NULL," +
                "FOREIGN KEY (leilao_id) REFERENCES leiloes (id)" +
                ");";
		
		String dispositivosTable = "CREATE TABLE IF NOT EXISTS dispositivos (" + 
        		"id INTEGER PRIMARY KEY AUTOINCREMENT," +
				"descricao TEXT," +
				"marca TEXT NOT NULL," +
				"modelo TEXT NOT NULL," +
				"categoria TEXT NOT NULL," +
				"valor_inicial DOUBLE NOT NULL," +
				"ano INTEGER NOT NULL" +
        		");";
		
		String clientesTable = "CREATE TABLE IF NOT EXISTS clientes (" +
			    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
			    "nome TEXT NOT NULL," +
			    "email TEXT NOT NULL UNIQUE," +
			    "telefone TEXT," +
			    "endereco TEXT," +
			    "senha TEXT NOT NULL" +  //Para autenticação futura
			");";
		
        String instituicaoFinanceiraTable = "CREATE TABLE IF NOT EXISTS instituicoes_financeiras (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        		"nome TEXT NOT NULL," +
                "cnpj TEXT NOT NULL UNIQUE," +
				"endereco TEXT" +
				");";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(produtosTable);
            stmt.execute(lancesTable);
            stmt.execute(leiloesTable);
            stmt.execute(veiculosTable);
            stmt.execute(dispositivosTable);
            stmt.execute(clientesTable);
            stmt.execute(instituicaoFinanceiraTable);
            System.out.println("Tabelas criadas com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

