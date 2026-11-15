package com.ifrs.lpoo.forcalivre.model;

import java.time.LocalDate;

/**
 * Representa um aluno da Força Livre.
 */
public class Aluno extends Identificador {

  private final String cpf;
  private String nome;
  private LocalDate dataNascimento;
  private Plano plano;

  public Aluno(Long id, String cpf, String nome, LocalDate dataNascimento, Plano plano) {
    // TODO: Adicionar validações dos parâmetros.
    super(id);
    this.cpf = cpf;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.plano = plano;
  }

  public String getCpf() {
    return cpf;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public Plano getPlano() {
    return plano;
  }

  @Override
  public String toString() {
    return "Aluno{" +
           "id=" + this.getId() +
           ", cpf='" + cpf + '\'' +
           ", nome='" + nome + '\'' +
           ", dataNascimento='" + dataNascimento + '\'' +
           ", plano=" + plano.getNome() +
           '}';
  }
}
