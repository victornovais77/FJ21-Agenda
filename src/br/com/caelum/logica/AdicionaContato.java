package br.com.caelum.logica;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.logica.Logica;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class AdicionaContato implements Logica {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
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
			
			return "contato-cadastrado.jsp";

		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}


	}

}
