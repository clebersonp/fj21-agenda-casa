package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

  @Override
  public String executa(final HttpServletRequest req, final HttpServletResponse res)
      throws Exception {

    System.out.println("Executando a lógica ...");

    System.out.println("Retornando o nome da página JSP ...");

    return "/WEB-INF/jsp/primeira-logica.jsp";
  }
}
