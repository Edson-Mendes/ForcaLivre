package com.ifrs.lpoo.forcalivre.model;

import java.math.BigDecimal;

/**
 * Representa um plano pago da Força Livre.
 */
public class Plano extends Identificador {

  private final String nome;
  private final BigDecimal preco;

  public Plano(Long id, String nome, BigDecimal preco) {
    super(id);
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  @Override
  public String toString() {
    return "Plano{" +
           "id=" + this.getId() + '\'' +
           ", nome='" + nome + '\'' +
           ", preco=" + preco +
           '}';
  }

}
