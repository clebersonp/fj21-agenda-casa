package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.dao.exception.DAOException;
import br.com.caelum.modelo.Funcionario;

public class FuncionarioDao {

  final Connection connection;

  public FuncionarioDao() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public List<Funcionario> getLista() {
    final List<Funcionario> funcionarios = new ArrayList<>();

    final String sql = "select * from funcionarios";

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      final ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        final Long id = rs.getLong("id");
        final String nome = rs.getString("nome");
        final String usuario = rs.getString("usuario");
        final String senha = rs.getString("senha");

        funcionarios.add(new Funcionario(id, nome, usuario, senha));
      }

      rs.close();
      return funcionarios;
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public Funcionario getFuncionario(final Long id) {
    Funcionario funcionario = null;

    final String sql = "select * from funcionarios where id = ?";

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // setar valores
      stmt.setLong(1, id);

      final ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        final Long idRecuperado = rs.getLong("id");
        final String nome = rs.getString("nome");
        final String usuario = rs.getString("usuario");
        final String senha = rs.getString("senha");

        funcionario = new Funcionario(idRecuperado, nome, usuario, senha);
      }
      rs.close();
      return funcionario;
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public Funcionario getFuncionario(final String usuario) {
    Funcionario funcionario = null;

    final String sql = "select * from funcionarios where usuario = ?";

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // setar valores
      stmt.setString(1, usuario);

      final ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        final Long id = rs.getLong("id");
        final String nome = rs.getString("nome");
        final String usuarioRecuperado = rs.getString("usuario");
        final String senha = rs.getString("senha");

        funcionario = new Funcionario(id, nome, usuarioRecuperado, senha);
      }

      rs.close();
      return funcionario;
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public void alterar(final Funcionario funcionario) {
    final String sql = "update funcionarios set nome = ?, usuario = ?, senha = ? where id = ?";

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // setar valores
      stmt.setString(1, funcionario.getNome());
      stmt.setString(2, funcionario.getUsuario());
      stmt.setString(3, funcionario.getSenha());
      stmt.setLong(4, funcionario.getId());

      stmt.execute();
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public void remover(final Funcionario funcionario) {
    final String sql = "delete from funcionarios where id = ?";

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // setar valores
      stmt.setLong(1, funcionario.getId());

      stmt.execute();
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public void adiciona(final Funcionario funcionario) {
    final String sql = "insert into funcionarios(nome, usuario, senha) values (?, ?, ?)";

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // setar valores
      stmt.setString(1, funcionario.getNome());
      stmt.setString(2, funcionario.getUsuario());
      stmt.setString(3, funcionario.getSenha());

      stmt.execute();
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public Funcionario login(final String usuario, final String senha) {
    Funcionario funcionario = null;
    final String sql = "select * from funcionarios where usuario = ? and senha = ?";

    try (final PreparedStatement stmt = this.connection.prepareStatement(sql)) {

      // setar valores
      stmt.setString(1, usuario);
      stmt.setString(2, senha);

      final ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        final Long id = rs.getLong("id");
        final String nome = rs.getString("nome");
        final String usuarioRecuperado = rs.getString("usuario");
        final String senhaRecuperado = rs.getString("senha");

        funcionario = new Funcionario(id, nome, usuarioRecuperado, senhaRecuperado);
      }

      rs.close();
      return funcionario;
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }
}


