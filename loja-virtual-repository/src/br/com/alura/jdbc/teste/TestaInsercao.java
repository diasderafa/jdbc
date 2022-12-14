package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		// conex?o com MYSQL
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		// statement para retorno com generated keys
		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('GELADEIRA', 'GELADEIRA AZUL')", Statement.RETURN_GENERATED_KEYS);
		
		// resultado das generated kets realizadas acima
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);			
		}
		
	}

}
