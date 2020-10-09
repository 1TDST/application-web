package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bo.ClienteBO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(urlPatterns = { "/cadastro", "/clientes", "/listar", "/excluir", "/update" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getRequestURI()) {

		case "/cadastro-01/cadastro":
			inserirCliente(request, response);
			break;
		
		case "/cadastro-01/clientes":
			 exibirClientes(request, response);
			break;
			
		case "/cadastro-01/listar":
			 exibirClientes(request, response, Integer.parseInt(request.getParameter("id-cli")));
			break;
	
		case "/cadastro-01/update":
			 atualizaCliente(request, response);
			break;

		case "/cadastro-01/excluir":
			 apagarCliente(request, response, Integer.parseInt(request.getParameter("id-cli")));
			break;

		default:
			response.sendRedirect("index.jsp");
		}
		

	}

	public void apagarCliente(HttpServletRequest request, HttpServletResponse response, int idCli) throws IOException {
		
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		
		//Recuperando o status da opera��o
		int status = cb.removeCliente(idCli);
		
		//Valida��o do cliente
		if(status > 0) {
			// Realizando envio de par�metros por redirecionamento
			// Obs:Estes devem recuperados atraves do escopo do PARAM
			// EX. param.nomeDoParametro
			response.sendRedirect("index.jsp?status=ok&msgStatus=Os dados foram EXCLUIDOS com SUCESSO!");
		}else {
			// Realizando envio de par�metros por redirecionamento
			// Obs:Estes devem recuperados atraves do escopo do PARAM
			// EX. param.nomeDoParametro
			response.sendRedirect("index.jsp?status=err&msgStatus=Ocorreu um erro na EXCLUSAO dos dados!");
		}
	}

	//ATUALIZA CLIENTE	
	public void atualizaCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		
		// RECEP��O DOS DADOS DO REQUEST DA P�GINA ATUAZLIZA.JSP
		// Criar uma est�ncia de cliente
		Cliente cli = new Cliente();
		
		// Popular o cliente com os dados do request utilizando o m�todo
		// getPararmeter(NomeDoCampo)
		cli.setId(Integer.parseInt(request.getParameter("txtIdCli")));
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		//Recuperando o status da opera��o
		int status = cb.atualizacaoCadastral(cli);
		
		//Valida��o do cliente
		if(status > 0) {
			// Realizando envio de par�metros por redirecionamento
			// Obs:Estes devem recuperados atraves do escopo do PARAM
			// EX. param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Os dados foram ATUALIZADOS com SUCESSO!");
		}else {
			// Realizando envio de par�metros por redirecionamento
			// Obs:Estes devem recuperados atraves do escopo do PARAM
			// EX. param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro na ATUALIZACAO dos dados!");
		}
	}

	//LISTAR CLIENTE BY ID	
	private void exibirClientes(HttpServletRequest request, HttpServletResponse response, int idCli) throws ServletException, IOException {
		
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		
		//Criar um cliente
		Cliente cli = cb.listarClientes(idCli);
		
		//Validando o cliente
		if(cli != null) {
			//Criando um atributo no request e adicionando o cliente para
			//ser encaminhado para a p�gina atualiza.jsp
			request.setAttribute("objCli", cli);
			
			//Realizando o encaminhamento
			request.getRequestDispatcher("./WEB-INF/atualiza.jsp").forward(request, response);
		}else {
			//Realizando o Redirecionamento
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro no processamento de atualiza��o do Cliente.");
		}

		
	}

	//LISTAR TODOS OS CLIENTES
	private void exibirClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		
		//Criar uma lista para armazenar o resultado da consulta.
		List<Cliente> lista = cb.listarClientes();
		
		//Validando a lista
		if(lista != null) {
			//Criando um atributo no request e adicionar a lista de clientes para
			//ser encaminhado para a p�gina lista.jsp
			request.setAttribute("listaCliente", lista);
			
			//Realizando o encaminhamento
			request.getRequestDispatcher("./WEB-INF/lista.jsp").forward(request, response);
		}else {
			//Realizando o Redirecionamento
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro no processamento da lista de Clientes.");
		}
	}

	//INSERIR CLIENTE
	public void inserirCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RECEP��O DOS DADOS DO REQUEST - IN�CIO
		// Criar uma est�ncia de cliente
		Cliente cli = new Cliente();

		// Popular o cliente com os dados do request utilizando o m�todo
		// getPararmeter(NomeDoCampo)
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));

		// Instanciar a classe BO e chamar o m�todo cadastrar
		// passando o objeto e recebendo o resultado que poder ser 1 pra OK e 0 para
		// ERRO.
		ClienteBO cb = new ClienteBO();

		int status = cb.cadastroCliente(cli);

		// Realizando a verifica��o do status da grava��o e retornando
		// uma mensagem para o usu�rio.
		if (status == 1) {
			// Criando uma mensagem de Sucesso para o usu�rio
			// Utilizando o atributo do request.
			// request.setAttribute("msgStatus", "Os dados foram gravados com SUCESSO!");

			// Realizando envio de par�metros por redirecionamento
			// Obs:Estes devem recuperados atraves do escopo do PARAM
			// EX. param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Os dados foram gravados com SUCESSO!");

		} else {
			// Criando uma mensagem de Erro caso ocorra algum problema.
			// Utilizando o atributo do request.
			// request.setAttribute("msgStatus", "Ocorreu um erro!");

			// Realizando envio de par�metros por redirecionamento
			// Obs:Estes devem recuperados atraves do escopo do PARAM
			// EX. param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro no cadastro do Cliente!");
		}

		// Realizando o ENCAMINHAMENTO!!!
		// request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}














