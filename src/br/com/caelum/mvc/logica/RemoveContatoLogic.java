package br.com.caelum.mvc.logica;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class RemoveContatoLogic implements Logica {

  @Override
  public String executa(final HttpServletRequest req, final HttpServletResponse res)
      throws Exception {

    final Long id = Long.parseLong(req.getParameter("id"));

    final Contato contato = new Contato();
    contato.setId(id);

    // recupera a conexao na requisicao configurado no filtro
    final Connection connection = (Connection) req.getAttribute("connection");

    final ContatoDao dao = new ContatoDao(connection);
    dao.remove(contato);

    System.out.println("Excluindo contato ...");

    return "mvc?logica=ListaContatosLogic";
  }
}
