package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletController
 */
@WebServlet( urlPatterns={"/validacao","/logout"})
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperando a Sessão do usuário
		HttpSession session = request.getSession();
		
		if(session.isNew()) {
			//Determinando o Timeout da Sessão
			session.setMaxInactiveInterval(10);
			System.out.println("IS NEW!!");
			//Guardar o ID da sessão em um atributo da própria
			session.setAttribute("id", session.getId());
			
		}
		
		response.sendRedirect("index.jsp?id="+session.getId());
		
		
	}
	


	
}



//	//Teste de Request
//		System.out.println("Olá Mundo!");
//		
//		/***
//		 * Bloco de Processamento
//		 */
//			String nomeUsuario  = "";
//			String senhaUsuario = "";
//			
//			//Receber os atributos do Form que estao no
//			// request e armazenar nas variáveis.
//			nomeUsuario = request.getParameter("txt-user");
//			senhaUsuario = request.getParameter("txt-pass");
//			
//			//Imprimindo os dados que chegaram do request!
//			System.out.println("Nome  do usuário : " + nomeUsuario);
//			System.out.println("Senha do usuário : " + senhaUsuario);
//			
//		/***
//		 * Bloco de Processamento
//		 */
//
//			//Criando um redirecionamento utilizando o response
//			//utilize o método sendRedirect(caminho ou URI de destino)
//			response.sendRedirect("login.html");
