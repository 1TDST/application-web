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
			//Criando a instru��o SQL
			sql = "SELECT * FROM TBL_CLIENTE ORDER BY ID_CLI";
			
			//Criando a conex�o
			ps = con.prepareStatement(sql);
			
			//Recebendo os dados no ResultSet
			rs = ps.executeQuery();
			
			//Criando a lista para receber os objetos.
			lista = new ArrayList<Cliente>();
			
			//Construindo a estrutura para ler o ResultSet
			while (rs.next()) {
				//contruir o objeto cliente a cada nova itera��o.
				cli = new Cliente();
				
				//Populando o cliente com os dados do ResultSet
				cli.setId(Integer.parseInt(rs.getNString("id_cli")));
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
		String sql = null;
		Cliente cli  = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//Criando a instru��o SQL
			sql = "SELECT * FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			//Criando a conex�o
			ps = con.prepareStatement(sql);
		
			//Passando o par�metro para a instru��o SQL.
			ps.setInt(1, idCli);
			
			//Recebendo os dados no ResultSet
			rs = ps.executeQuery();
			
			//Construindo a estrutura para ler o ResultSet
			while (rs.next()) {
				//contruir o objeto cliente a cada nova itera��o.
				cli = new Cliente();
				
				//Populando o cliente com os dados do ResultSet
				cli.setId(Integer.parseInt(rs.getNString("id_cli")));
				cli.setNome(rs.getNString("nome_cli"));
				cli.setSobrenome(rs.getNString("sobrenome_cli"));
				cli.setDataNasc(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getNString("data_nasc_cli")));
				cli.setGenero(rs.getNString("genero_cli").charAt(0));
				cli.setTelefone(rs.getNString("tel_cli"));
				
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
		return cli;
	}
	
	public int insert(Cliente cli){
		
		//CRIANDO A INSTRU��O SQL
		String sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";

		try {
			//Criando a conex�o
			PreparedStatement ps = con.prepareStatement(sql);
			
			//POPULANDO A CONEX�O COM O OBJETO
			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getSobrenome());
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
			ps.setString(4, String.valueOf(cli.getGenero()));
			ps.setString(5, cli.getTelefone());
			
			//Gerando o retorno para avalia��o
			int status = ps.executeUpdate();
			
			return status;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int update(Cliente cli){
		String sql = null;
		PreparedStatement ps = null;
		int status = 0;
		
		try {
		//CRIANDO A INSTRU��O SQL
		sql = "UPDATE TBL_CLIENTE SET NOME_CLI = ?,SOBRENOME_CLI = ?,DATA_NASC_CLI = TO_DATE(?,'yyyy-MM-dd'),"
				+ "GENERO_CLI = ?,TEL_CLI = ? WHERE ID_CLI = ?";
		
		//Criando a conex�o
		ps = con.prepareStatement(sql);
		 
		//POPULANDO A CONEX�O COM O OBJETO
		ps.setString(1, cli.getNome());
		ps.setString(2, cli.getSobrenome());
		ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
		ps.setString(4, String.valueOf(cli.getGenero()));
		ps.setString(5, cli.getTelefone());
		ps.setInt(6, cli.getId());
		
		//Gerando o retorno para avalia��o
		status = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		}
		
		return status;
	}

	public int delete(int idCli){
		String sql = null;
		PreparedStatement ps = null;
		int status = 0;
		
		try {
			//Instru��o SQL
			sql = "DELETE FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			//Criando a conex�o
			ps = con.prepareStatement(sql);
			
			//Populando instru��o SQL com o par�metro
			ps.setInt(1, idCli);
			
			//Recuperando o status da opera��o
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

}
