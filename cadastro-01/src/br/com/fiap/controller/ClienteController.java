package br.com.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(
		description = "Controle de acesso e fluxo de informações.", 
		urlPatterns = { 
				"/cliente", 
				"/listar"
		})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Cliente> lista = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        
        if(lista == null) {
        //Implementando a lista com um ArrayList do tipo Cliente
        	lista = new ArrayList<Cliente>();
        	
        	//Criando uma estância de Cliente
        	Cliente cli = new Cliente();
        	//Populando o cliente com os dados.
        	cli.setNome("Alexandre");
        	cli.setSobrenome("Carlos");
        	cli.setDataNasc("1975-12-21");
        	cli.setGenero('m');
        	cli.setTelefone("(11) 98745-2135");
        	//Adicionando na lista
        	lista.add(cli);
        	
        	//ADICIONANDO UM NOVO REGISTRO.
        	//Criando uma estância de Cliente
        	cli = new Cliente();
        	//Populando o cliente com os dados.
        	cli.setNome("Julia");
        	cli.setSobrenome("Scarpato");
        	cli.setDataNasc("1982-04-05");
        	cli.setGenero('f');
        	cli.setTelefone("(48) 97852-4578");
        	//Adicionando na lista
        	lista.add(cli);
        	
        	//ADICIONANDO UM NOVO REGISTRO.
        	//Criando uma estância de Cliente
        	cli = new Cliente();
        	//Populando o cliente com os dados.
        	cli.setNome("Roberto");
        	cli.setSobrenome("Carlos");
        	cli.setDataNasc("1941-01-10");
        	cli.setGenero('m');
        	cli.setTelefone("(12) 97745-2356");
        	//Adicionando na lista
        	lista.add(cli);

        }
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//RECEPÇÃO DOS DADOS DO REQUEST - INÍCIO
		
		//Criar uma estância de cliente
		Cliente cli = new Cliente();
		
		//cliente?txtNm=Joaozinho&txtSnm=Couve&txtDtNasc=1980-12-24&txtGen=m

		//BO  = Business Object
		//DAO = Data Access Object
		
		//Popular o cliente com os dados do request utilizando o método
		// getPararmeter(NomeDoCampo)
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		//Adicionando na lista.
		lista.add(cli);
		
		//RECEPÇÃO DOS DADOS DO REQUEST - FIM
		
		//Adicionando a lista em um atributo no request
		// utilizando o método setAttribute(nomeAtributo, Objeto)

		request.setAttribute("listaCli", lista);
		
		//ENCAMINHAMENTO DO REQUEST/RESPONSE - INÍCIO
		
		//Criar o dispatcher através da interface RequestDispatcher
		// e passa para ela a URI/URL de destino.
		RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
		
		//Agora utilizando o método forward nós passamos
		// o request e o response finalmente.
		rd.forward(request, response);
		
		//Realizando o Encaminhamento de forma direta.
		//request.getRequestDispatcher("lista.jsp").forward(request, response);
				
		//ENCAMINHAMENTO DO REQUEST/RESPONSE - FIM
		
	
		
		
	}

}







