package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.dao.exception.DAOException;
import br.com.caelum.modelo.Contato;


public class ContatoDao {

  private final Connection connection;

  public ContatoDao(final Connection connection) {
    this.connection = connection;
  }

  public void adiciona(final Contato contato) {
    final String sql = new StringBuilder().append("insert into contatos ")
        .append("(nome,email,endereco,data_nascimento) ").append("values (?,?,?,?)").toString();

    // prepara statement para inserção e usa o auto-closable - try with resources
    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // seta os valores
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, new Date(contato.getDataNascimento().getTime()));

      // executa
      stmt.execute();

    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public List<Contato> getLista() {
    final String sql = new StringBuilder("select * from contatos order by nome").toString();
    // .append("where lower(nome) like 'c%'").toString();

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      final List<Contato> contatos = new ArrayList<>();

      final ResultSet rs = stmt.executeQuery();

      while (rs.next()) {

        // criando o objeto contato
        final Contato contato = new Contato();
        contato.setId(rs.getLong("id"));
        contato.setNome(rs.getString("nome"));
        contato.setEmail(rs.getString("email"));
        contato.setEndereco(rs.getString("endereco"));
        contato.setDataNascimento(rs.getDate("data_nascimento"));

        contatos.add(contato);
      }

      rs.close();
      return contatos;
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public Contato getContato(final Long id) {
    final String sql =
        new StringBuilder("select * from contatos ").append("where id = ?").toString();

    Contato contato = null;
    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // seta valor
      stmt.setLong(1, id);

      final ResultSet rs = stmt.executeQuery();

      if (rs.next()) {

        // criando o objeto contato
        contato = new Contato();
        contato.setId(rs.getLong("id"));
        contato.setNome(rs.getString("nome"));
        contato.setEmail(rs.getString("email"));
        contato.setEndereco(rs.getString("endereco"));
        contato.setDataNascimento(rs.getDate("data_nascimento"));
      }

      rs.close();
      return contato;
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public Contato getContato(final String email) {
    final String sql =
        new StringBuilder("select * from contatos ").append("where email = ?").toString();

    Contato contato = null;
    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // seta valor
      stmt.setString(1, email);

      final ResultSet rs = stmt.executeQuery();

      if (rs.next()) {

        // criando o objeto contato
        contato = new Contato();
        contato.setId(rs.getLong("id"));
        contato.setNome(rs.getString("nome"));
        contato.setEmail(rs.getString("email"));
        contato.setEndereco(rs.getString("endereco"));
        contato.setDataNascimento(rs.getDate("data_nascimento"));
      }

      rs.close();
      return contato;
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public Contato altera(final Contato contato) {
    final String sql =
        new StringBuilder("update contatos set nome=?, email=?, endereco=?, data_nascimento=? ")
            .append("where id=?").toString();

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // setar os valores
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, new Date(contato.getDataNascimento().getTime()));
      stmt.setLong(5, contato.getId());

      stmt.execute();

      final int updateCount = stmt.getUpdateCount();

      if (updateCount > 0) {
        return contato;
      }
      return null;
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public void remove(final Contato contato) {
    final String sql = new StringBuilder("delete from contatos where id=?").toString();

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // setar os valores
      stmt.setLong(1, contato.getId());
      stmt.execute();
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }
}
