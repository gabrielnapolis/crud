package com.imob.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/bd_produto_web"; 
	private static final String USER = "postgres";
	private static final String PASSWORD = "123";
	
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.err.println("------------------------------");
			System.err.println("Erro na conexao");
			e.printStackTrace();
		}
		return null;
	}

}

