package com.tperfect_trip.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String url = "jdbc:mysql://localhost:3306/TPerfect_Trip";
	
	private static final String user = "root";
	private static final String password = "root";
	
	
	
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Encontrou Driver!");
			
		 
		} catch(ClassNotFoundException e) {
			System.out.println("Nao foi encontrado! Mensagem: " + e.getMessage());
		 }
		
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("Conectado com sucesso!");
		  
			return connection;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao banco! Mensagem: " + e.getMessage());
			return null;
		}
		
	}
}
