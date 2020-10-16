package br.com.fiap.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet implementation class LinguaController
 */
@WebServlet("/change-language")
public class LinguaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LinguaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String language = request.getParameter("lingua");
		Locale locale = new Locale(language);

		Config.set(request.getSession(), Config.FMT_LOCALE,locale);
		Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE, locale);

		response.sendRedirect("index.jsp?lingua="+locale);
	}

}
