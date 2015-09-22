package org.ws.logincontrol.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ws.logincontrol.webservices.UserWs;
import org.ws.logincontrol.webservices.UserWsServiceLocator;

import com.sun.xml.registry.uddi.bindings_v2_2.GetServiceDetail;

/**
 * Servlet implementation class LoginControlServlet
 */
@WebServlet("/LoginControlServlet")
public class LoginControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultadoJSP = null;
		
		try {
			// Obt�m os valores digitados na p�gina inicial
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			// Cria objeto para localizar o web service UserWs
			UserWsServiceLocator locator = new UserWsServiceLocator();
			
			// Cria objeto do tipo UserWs, ou seja, um we service
			UserWs stub = locator.getUserWsPort();
			
			// Executa o Web Method findUser e obt�m o seu resultado
			String nome = stub.findUser(email,  senha);
			
			if (nome != null) {
				// Seta o redirecionamento para a p�gina de sucesso
				resultadoJSP = "/sucesso.jsp";
			}
			else {
				// Seta o redicionamento para a p�gina de erro
				resultadoJSP = "/erro.jsp";
			}
			
			// Cria um atributo chamado "nome" com o valor da variavel nome
			request.setAttribute("nome", nome);
			
			//Redireciona para a p�gina de resultado
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(resultadoJSP);
			dispatcher.forward(request, response);
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

}
