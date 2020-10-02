package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Cliente;
import br.com.fiap.connection.ConnectionFactory;

public class ClienteDAO {
	
	private Connection con;
	
	public ClienteDAO() {
		
		//Instanciando a classe ConnectinFactory
		ConnectionFactory cf = new ConnectionFactory();
		try {
			con = cf.DBConnectionManager();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> select(){
		
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
	
	public Cliente select(int idCli){
		return null;
	}
	
	public int insert(Cliente cli){
		
		//CRIANDO A INSTRUÇÃO SQL
		String sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";

		try {
			//Criando a conexão
			PreparedStatement ps = con.prepareStatement(sql);
			
			//POPULANDO A CONEXÃO COM O OBJETO
			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getSobrenome());
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
			ps.setString(4, String.valueOf(cli.getGenero()));
			ps.setString(5, cli.getTelefone());
			
			//Gerando o retorno para avaliação
			int status = ps.executeUpdate();
			
			return status;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int update(Cliente cli){
		return 0;
	}

	public int delete(int idCli){
		return 0;
	}

}
