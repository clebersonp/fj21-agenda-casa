package br.com.caelum.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {


  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain chain) throws IOException, ServletException {

    final long tempoInicial = System.currentTimeMillis();

    chain.doFilter(request, response);

    final long tempoFinal = System.currentTimeMillis();
    final String uri = ((HttpServletRequest) request).getRequestURI();
    final String parametro = ((HttpServletRequest) request).getParameter("logica");

    System.out.println("Tempo da requisição de " + uri + "?logica=" + parametro + " demorou (ms): "
        + (tempoFinal - tempoInicial));
  }

  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {}

  @Override
  public void destroy() {}
}
