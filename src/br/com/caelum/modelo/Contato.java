package br.com.caelum.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contato {

  private Long id;
  private String nome;
  private String email;
  private String endereco;
  private Date dataNascimento;

  public Contato() {}

  public Contato(final String nome, final String email, final String endereco,
      final Date dataNascimento) {
    this.nome = nome;
    this.email = email;
    this.endereco = endereco;
    this.dataNascimento = dataNascimento;
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

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(final String endereco) {
    this.endereco = endereco;
  }

  public Date getDataNascimento() {
    return this.dataNascimento;
  }

  public void setDataNascimento(final Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getDataNascimentoFormatada() {
    return this.dataNascimento != null
        ? new SimpleDateFormat("dd/MM/yyyy").format(this.dataNascimento)
        : null;
  }

  @Override
  public String toString() {
    return "Contato [id=" + this.id + ", nome=" + this.nome + ", email=" + this.email
        + ", endereco=" + this.endereco + ", dataNascimento="
        + new SimpleDateFormat("dd/MM/yyyy").format(this.dataNascimento) + "]";
  }
}
