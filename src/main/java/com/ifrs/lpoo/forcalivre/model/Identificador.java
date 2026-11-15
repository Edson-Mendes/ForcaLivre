package com.ifrs.lpoo.forcalivre.model;

/**
 * Representa o identificador único.
 */
public abstract class Identificador {

  private final Long id;

  public Identificador(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }
}
