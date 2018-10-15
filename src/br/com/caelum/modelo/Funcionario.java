package br.com.caelum.modelo;

public class Funcionario {

  private Long id;
  private String nome;
  private String usuario;
  private String senha;

  public Funcionario() {
    super();
  }

  public Funcionario(final Long id, final String nome, final String usuario, final String senha) {
    this.id = id;
    this.nome = nome;
    this.usuario = usuario;
    this.senha = senha;
  }

  public Funcionario(final String nome, final String usuario, final String senha) {
    this(null, nome, usuario, senha);
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public String getUsuario() {
    return this.usuario;
  }

  public void setUsuario(final String usuario) {
    this.usuario = usuario;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(final String senha) {
    this.senha = senha;
  }

  @Override
  public String toString() {
    return "Funcionario [id=" + this.id + ", nome=" + this.nome + ", usuario=" + this.usuario
        + ", senha=" + this.senha + "]";
  }
}
