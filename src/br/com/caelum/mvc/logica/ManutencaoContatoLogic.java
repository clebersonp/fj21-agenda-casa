package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class ManutencaoContatoLogic implements Logica {

  @Override
  public String executa(final HttpServletRequest req, final HttpServletResponse res)
      throws Exception {

    final String idString = req.getParameter("id");
    final Long id = (idString != null) && (idString != "") ? Long.parseLong(idString) : null;
    final String nome = req.getParameter("nome");
    final String email = req.getParameter("email");
    final String endereco = req.getParameter("endereco");
    final String dataNascimentoString = req.getParameter("dataNascimento");
    Date dataNascimento = null;

    if ((dataNascimentoString != null) & (dataNascimentoString != "")) {
      try {
        dataNascimento = this.recuperarData(dataNascimentoString);
      } catch (final ParseException e) {
        throw new ServletException(
            "Erro ao converter a data de nascimento. Digite no formato: dd/MM/yyyy", e);
      }
    }

    final Contato contato = new Contato(nome, email, endereco, dataNascimento);
    contato.setId(id);

    // recupera a conexao na requisicao configurado no filtro
    final Connection connection = (Connection) req.getAttribute("connection");

    final ContatoDao dao = new ContatoDao(connection);

    if (id == null) {
      dao.adiciona(contato);
    } else {
      dao.altera(contato);
    }

    return "mvc?logica=ListaContatosLogic";
  }

  private Date recuperarData(final String dataNascimento) throws ParseException {
    final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    return format.parse(dataNascimento);
  }

}
