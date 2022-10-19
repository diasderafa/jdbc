package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		// abrir conexão
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");
		System.out.println("Conexão realizada.");

		// fechar conexão
		connection.close();
		System.out.println("Conexão fechada.");
	}

}
