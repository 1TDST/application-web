package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fiap.bean.Cliente;
import br.com.fiap.connection.ConnectionFactory;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Connection con = new ConnectionFactory().DBConnectionManager();
		
		List<Cliente> lista = new Teste().select(con);
		
		for(Cliente cli : lista) {
			
			System.out.println("Nome do cliente : " + cli.getNome());
			System.out.println("Telefone : " + cli.getTelefone());
		}
		
	}
	
	
	public List<Cliente> select(Connection con){
		
		String sql = null;
		Cliente cli  = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Cliente> lista = null;
		
		try {
			//Criando a instrução SQL
			sql = "SELECT * FROM TBL_CLIENTE ORDER BY ID_CLI";
			
			//Criando a conexão
			ps = con.prepareStatement(sql);
			
			//Recebendo os dados no ResultSet
			rs = ps.executeQuery();
			
			//Criando a lista para receber os objetos.
			lista = new ArrayList<Cliente>();
			
			//Construindo a estrutura para ler o ResultSet
			while (rs.next()) {
				//contruir o objeto cliente a cada nova iteração.
				cli = new Cliente();
				
				//Populando o cliente com os dados do ResultSet
				cli.setNome(rs.getNString("nome_cli"));
				cli.setSobrenome(rs.getNString("sobrenome_cli"));
				cli.setDataNasc(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getNString("data_nasc_cli")));
				cli.setGenero(rs.getNString("genero_cli").charAt(0));
				cli.setTelefone(rs.getNString("tel_cli"));
				
				//Adicionando na lista
				lista.add(cli);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	

	
	
}
