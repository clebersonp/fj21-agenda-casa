package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class ListaContatosLogic implements Logica {

  @Override
  public String executa(final HttpServletRequest req, final HttpServletResponse res)
      throws Exception {

    // recupera a conexao na requisicao configurado no filtro, aqui temos uma injeção de dependencia
    final Connection connection = (Connection) req.getAttribute("connection");

    // temos uma inversao de controle, pois estamos passando a instancia da conexao para o dao
    final List<Contato> contatos = new ContatoDao(connection).getLista();

    // setando a lista de contatos no parametro do request
    req.setAttribute("contatos", contatos);

    return "/WEB-INF/jsp/lista-contatos.jsp";
  }
}
