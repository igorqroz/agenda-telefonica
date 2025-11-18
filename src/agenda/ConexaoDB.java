package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:mysql://localhost:3306/agenda_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConexao() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Testando conexão...");

        if (getConexao() != null) {
            System.out.println("CONEXÃO COM SUCESSO!");
        } else {
            System.out.println("FALHA NA CONEXÃO.");
        }
    }
}
