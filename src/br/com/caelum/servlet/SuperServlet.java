package br.com.caelum.servlet;

import br.com.caelum.logica.Logica;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/super")
public class SuperServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {
			String logica = request.getParameter("logica");
			logica = "br.com.caelum.logica." + logica;
			
			Class clazz = Class.forName(logica);
			Logica acao = (Logica) clazz.newInstance();
			String pagina = acao.executa(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}


	}


}


