package br.com.caelum.logica;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import java.util.List;
import javax.servlet.http.*;

public class ListaContatos implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		req.setAttribute("listaContatos", contatos);
		
		return "lista-contatos.jsp";

	}
}
