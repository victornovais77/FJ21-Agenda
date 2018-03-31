package br.com.caelum.servlet;

import java.io.*;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MostraHoraServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body><h1>");

		Calendar calendar = Calendar.getInstance();
		
		pw.println(calendar.getTime());

		pw.println("</h1></body></html>");
		
		
	}
}
