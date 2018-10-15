package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  private static final String URL_MYSQL = "jdbc:mysql://localhost/fj21?useSSL=false";
  private static final String USER = "root";
  private static final String PASSWORD = USER;

  public Connection getConnection() {
    try {

      Class.forName("com.mysql.jdbc.Driver");

      return DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
    } catch (final SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
