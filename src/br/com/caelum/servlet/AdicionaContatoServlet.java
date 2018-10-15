package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(final HttpServletRequest req, final HttpServletResponse resp)
      throws ServletException, IOException {

    final PrintWriter out = resp.getWriter();

    final String nome = req.getParameter("nome");
    final String email = req.getParameter("email");
    final String endereco = req.getParameter("endereco");
    final String dataNascimento = req.getParameter("dataNascimento");
    Date dataNascimentoDate = null;
    try {
      dataNascimentoDate = this.recuperarData(dataNascimento);
    } catch (final ParseException e) {
      out.println("Erro ao converter a data de nascimento. Digite no formato: dd/MM/yyyy");
      return;
    }

    // recupera a conexao na requisicao configurado no filtro
    final Connection connection = (Connection) req.getAttribute("connection");

    final ContatoDao dao = new ContatoDao(connection);
    final Contato contato = new Contato(nome, email, endereco, dataNascimentoDate);
    dao.adiciona(contato);

    // utilizando um dispatcher para dispachar para p proxima pagina
    final RequestDispatcher rd = req.getRequestDispatcher("/paginas/contato-adicionado.jsp");
    rd.forward(req, resp);

    /*
     * Sem utilizar boas praticas out.println("<html>"); out.println("<head>");
     * out.println("<title>Contato Gravado</title>"); out.println("</head>"); out.println("<body>");
     * out.print("<h3>Contato " + contato.getNome() + " gravado com sucesso!</h3>");
     * out.println("</body>"); out.println("</html>");
     */
  }

  private Date recuperarData(final String dataNascimento) throws ParseException {
    final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    return format.parse(dataNascimento);
  }

}
