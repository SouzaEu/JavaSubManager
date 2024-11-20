package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    // Configuração do banco de dados
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String SERVER = "oracle.fiap.com.br";
    private static final String PORT = "1521";
    private static final String USER = "RM556972";
    private static final String PASSWORD = "180606";
    private static final String SID = "ORCL";
    private static final String URL = "jdbc:oracle:thin:@" + SERVER + ":" + PORT + ":" + SID;

    public static Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            } finally {
                connection = null;
            }
        }
    }
}

