package br.com.projetoa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseAccess {
	

    static String STATUS_CONEXAO;
    static String SERVER_ADDR = "31.220.55.46"; //""; //"18.231.108.89";
    static String DATABASE_NAME = "keromed";
    static String USER = "cliente";
    static String PASSWORD = "cliente";
    

    public Connection getConnection() throws DatabaseAccessException {
        String URL = "jdbc:mysql://" + SERVER_ADDR + "/" + DATABASE_NAME;
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            if (connection != null) {
				STATUS_CONEXAO = ("Conexão realizada com sucesso.");
			} else {
				STATUS_CONEXAO = ("Não foi possível realizar conexão.");
			}
			return connection;
            
            
        } catch (ClassNotFoundException e) {
			throw new DatabaseAccessException(e, "Problemas ao Carregar o Driver.");
		} catch (SQLException e) {
			throw new DatabaseAccessException("Problemas ao Conectar com o Banco: " + e);
		}
      
    }

   
    public void closeConnection(Connection connection) throws DatabaseAccessException {
        try {
			connection.close();
			STATUS_CONEXAO = "Conexão Fechada";
		} catch (SQLException e) {
			throw new DatabaseAccessException( 
					"Erro ao fechar conexão com o banco." + e.getMessage());
		} catch (NullPointerException e) {
			throw new DatabaseAccessException(e, "Não há conexões abertas.");
		}
    }

    
    public String getStatus() {
        return STATUS_CONEXAO;
    }

}
