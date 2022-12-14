package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		// connectionFactory encapsula a conexao do banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		// criar um statement que devolve uma lista em boolean
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		ResultSet rst = stm.getResultSet();

		// la?o para visualiza??o
		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println("\n" + id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}

		// fechar conex?o
		connection.close();
		System.out.println("Conex?o fechada.");
	}

}
