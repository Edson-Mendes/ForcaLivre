package com.ifrs.lpoo.forcalivre.model;

/**
 * Representa uma Aula da Força Livre.
 */
public class Aula extends Identificador {

  private String nome;
  private String descricao;

  public Aula(Long id, String nome, String descricao) {
    // TODO: Adicionar validações
    super(id);
    this.nome = nome;
    this.descricao = descricao;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  @Override
  public String toString() {
    return "Aula{" +
           "id=" + this.getId() +
           ", nome='" + nome + '\'' +
           ", descricao='" + descricao + '\'' +
           '}';
  }
}
