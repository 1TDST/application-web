package br.com.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuildAction
 */
@WebServlet("/montador")
public class BuildAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Exemplo de saída para o usuário
		//PrintWriter pw = response.getWriter();
		//pw.print("<h1>Olá Mundo</h1>");
		
		//Vamos testar a consistência das informações que chegam no request através do
		// método getParameter(passando o nome do parâmetro ou chave que é em formato de String)
		String nomeImg    = request.getParameter("uri-img");
		String caminhoImg = request.getParameter("url-img");
		String tamanhoImg = request.getParameter("wid-img");
		
		
		//Imprimindo para verificar a consistência dos dados
		System.out.println("PATH OU URL: " + caminhoImg+nomeImg);
		
		//Utilizando o request vamos criar um atribuito nele(request)
		// através do método setAttribute(passando o nomeDoAtributo,
		// e o valor do atributo em si)
		request.setAttribute("attrSrcImg", (caminhoImg+nomeImg));
		request.setAttribute("attrWidImg", (tamanhoImg));
		
		//Devemos criar um encaminhador(DISPATCHER) para levar
		// as informações para a página de destino em questão ou
		// seja index.jsp.
		// Só precisamos passar para esta interface o PATH/URL ou
		//URI de destino utilizando o request. Utilizamos o método
		// getRequestDispatcher(PATH/URL ou URI)
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		//E finalmente podemos encaminhar as informações de fato.
		// Com o dispatcher montado, nós temos que direcionar para a
		//página alvo tanto o request como o response através do método
		// forward(Request,Response)
		rd.forward(request, response);
		
	}

}






