package com.ifrs.lpoo.forcalivre;


import com.ifrs.lpoo.forcalivre.model.Aluno;
import com.ifrs.lpoo.forcalivre.model.Aula;
import com.ifrs.lpoo.forcalivre.model.Plano;
import com.ifrs.lpoo.forcalivre.repository.AlunoRepository;
import com.ifrs.lpoo.forcalivre.repository.AulaRepository;
import com.ifrs.lpoo.forcalivre.repository.PlanoRepository;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    System.out.println("---- TESTE BUSCAR PLANOS ----");

    PlanoRepository planoRepository = new PlanoRepository();
    List<Plano> planos = planoRepository.buscarTodos();
    planos.forEach(System.out::println);

    System.out.println("---- TESTE BUSCAR ALUNOS ----");

    AlunoRepository alunoRepository = new AlunoRepository();
    List<Aluno> alunos = alunoRepository.buscarTodos(planoRepository);
    alunos.forEach(System.out::println);

    System.out.println("---- TESTE BUSCAR AULAS ----");
    AulaRepository aulaRepository = new AulaRepository();
    List<Aula> aulas = aulaRepository.buscarTodos();
    aulas.forEach(System.out::println);
  }

}