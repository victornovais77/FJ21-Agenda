package br.com.caelum.logica;

import javax.servlet.http.*;

public interface Logica {
	
	public String executa(HttpServletRequest request, HttpServletResponse response);
	
}
