package br.com.caelum.mvc.logica;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class MostraContatoManutencaoLogic implements Logica {

  @Override
  public String executa(final HttpServletRequest req, final HttpServletResponse res)
      throws Exception {

    Contato contato = null;
    final String idString = req.getParameter("id");

    if ((idString != null) && (idString != "")) {
      final Long id = Long.parseLong(idString);

      // recupera a conexao na requisicao configurado no filtro
      final Connection connection = (Connection) req.getAttribute("connection");

      contato = new ContatoDao(connection).getContato(id);
    }

    req.setAttribute("contato", contato);

    return "/WEB-INF/jsp/manutencao-contato.jsp";
  }
}
