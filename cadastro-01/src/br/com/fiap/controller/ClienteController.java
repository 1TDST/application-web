package br.com.fiap.controller;

import java.io.IOException;

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
@WebServlet("/cliente")
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch (request.getRequestURI()) {
		case "/cadastro-01/cliente": inserirCliente(request,response);
			break;
		default:
			response.sendRedirect("index.jsp");
		}
		
	}

	
	public void inserirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RECEPÇÃO DOS DADOS DO REQUEST - INÍCIO
		//Criar uma estância de cliente
		Cliente cli = new Cliente();
		
		//Popular o cliente com os dados do request utilizando o método
		// getPararmeter(NomeDoCampo)
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		//Instanciar a classe BO e chamar o método cadastrar
		// passando o objeto e recebendo o resultado que poder ser 1 pra OK e 0 para ERRO.
		ClienteBO cb = new ClienteBO();
		
		int status = cb.cadastroCliente(cli);
		
		//Realizando a verificação do status da gravação e retornando
		// uma mensagem para o usuário.
		if(status == 1) {
			//Criando uma mensagem de Sucesso para o usuário
			//Utilizando o atributo do request.
			//request.setAttribute("msgStatus", "Os dados foram gravados com SUCESSO!");

			//Realizando envio de parâmetros por redirecionamento
			//Obs:Estes devem recuperados atraves do escopo do PARAM
			//EX. param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Os dados foram gravados com SUCESSO!");
			
		}else {
			//Criando uma mensagem de Erro caso ocorra algum problema.
			//Utilizando o atributo do request.
			//request.setAttribute("msgStatus", "Ocorreu um erro!");
			
			//Realizando envio de parâmetros por redirecionamento
			//Obs:Estes devem recuperados atraves do escopo do PARAM
			//EX. param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro!");
		}
		
		//Realizando o ENCAMINHAMENTO!!!
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
}
