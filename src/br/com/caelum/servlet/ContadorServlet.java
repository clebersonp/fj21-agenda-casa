package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class ContadorServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private int contador = 0;

  @Override
  protected void service(final HttpServletRequest req, final HttpServletResponse resp)
      throws ServletException, IOException {

    // a cada requisição incrementa no contador
    this.contador++;

    final PrintWriter out = resp.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>Exemplo de contador</title>");
    out.println("</head>");
    out.println("<body>");
    out.println(
        "<p>Como a servlet terá uma única instância para todas as requisições, não eh uma boa ideia compartilhar variáveis como todos os clientes."
            + " Será criada uma nova thread para cada requisição consumir a única instância da servlet.</p>");
    out.println("<h4>Agora o contador eh: " + this.contador + " </h4>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  public void init(final ServletConfig config) throws ServletException {
    super.init(config);
    System.out.println("Servlet iniciada!");
  }

  @Override
  public void destroy() {
    super.destroy();
    System.out.println("Servlet destruida");
  }

}
