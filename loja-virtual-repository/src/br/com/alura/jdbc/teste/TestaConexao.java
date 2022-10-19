package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		// abrir conex�o
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");
		System.out.println("Conex�o realizada.");

		// fechar conex�o
		connection.close();
		System.out.println("Conex�o fechada.");
	}

}
