package br.com.caelum.dao.exception;

public class DAOException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DAOException() {
    super();
  }

  public DAOException(final String message, final Throwable cause, final boolean enableSuppression,
      final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public DAOException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public DAOException(final String message) {
    super(message);
  }

  public DAOException(final Throwable cause) {
    super(cause);
  }
}
