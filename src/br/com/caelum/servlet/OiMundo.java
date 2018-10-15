package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// mapeamento de servlets via annotation ou via web.xml
@WebServlet(name = "servletOiMundo", urlPatterns = {"/oi", "/ola"})
public class OiMundo extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {

    final PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>Primeira Servlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Oi mundo servlet</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}
