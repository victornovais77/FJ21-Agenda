package br.com.caelum.servlet;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/salvaContato")
public class SalvarContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {

			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String endereco = request.getParameter("endereco");
			String dataNascimento = request.getParameter("dataNascimento");

			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatador.parse(dataNascimento);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(calendar);

			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);

			PrintWriter pw = response.getWriter();
			
			pw.println("<html><body><h1>");
			pw.println("Contato: " + contato.getNome() + " salvo com sucesso!");
			pw.println("</h1></body></html>");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

}
