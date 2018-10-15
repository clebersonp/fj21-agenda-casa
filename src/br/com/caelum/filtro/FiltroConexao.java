package br.com.caelum.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import br.com.caelum.dao.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

  // abriremos a conexao com o banco para cada requisicao

  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain chain) throws IOException, ServletException {

    try {
      // Cria uma conexao com o banco
      final Connection connection = new ConnectionFactory().getConnection();

      // pendurando a conexao com o banco na requisicao
      request.setAttribute("connection", connection);

      // passa a chamada para o proximo a processar
      chain.doFilter(request, response);

      // na volta da requisicao fecha a conexao
      connection.close();
    } catch (final SQLException e) {
      throw new ServletException(e);
    }

  }

  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {}

  @Override
  public void destroy() {}
}
