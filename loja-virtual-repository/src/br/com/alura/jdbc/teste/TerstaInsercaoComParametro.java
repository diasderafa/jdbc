package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.ConnectionFactory;

public class TerstaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		// conex�o com MYSQL
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try (Connection connection = connectionFactory.recuperarConexao()) {
			// assumir o controle
			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);) {
				// statement para retorno com generated keys com parametros (nao interferindo no
				// comando sql)

				// set nos atributos, com posi��o e nome da vari�vel
				adicionarVariavel("SmartTV", "45 Polegadas", stm);
				adicionarVariavel("R�dio", "R�dio de Bateria", stm);
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		if (nome.equals("R�dio")) {
			throw new RuntimeException("N�o foi poss�vel adicionar o produto");
		}
		stm.execute();

		// resultado das generated kets realizadas acima
		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O ID criado foi: " + id);
			}
		}
	}
}