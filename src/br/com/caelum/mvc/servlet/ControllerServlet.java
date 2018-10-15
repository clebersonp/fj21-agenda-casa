package br.com.caelum.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

  private static final String PACKAGE_MVC = "br.com.caelum.mvc.logica.";
  private static final long serialVersionUID = 1L;

  @SuppressWarnings("unchecked")
  @Override
  protected void service(final HttpServletRequest req, final HttpServletResponse resp)
      throws ServletException, IOException {

    final String parametro = req.getParameter("logica");
    final String nomeDaClasse = PACKAGE_MVC.concat(parametro);

    try {
      final Class<Logica> classe = (Class<Logica>) Class.forName(nomeDaClasse);

      final Logica logica = classe.newInstance();
      final String pagina = logica.executa(req, resp);

      req.getRequestDispatcher(pagina).forward(req, resp);

    } catch (final Exception e) {
      throw new ServletException("A lógica de negócios causou uma exceção.", e);
    }

  }
}
