package com.ifrs.lpoo.forcalivre;


import com.ifrs.lpoo.forcalivre.model.Plano;
import com.ifrs.lpoo.forcalivre.repository.PlanoRepository;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    PlanoRepository planoRepository = new PlanoRepository();

    List<Plano> planos = planoRepository.buscarTodos();
    planos.forEach(System.out::println);
  }

}