package com.ifrs.lpoo.forcalivre.repository;

import com.ifrs.lpoo.forcalivre.model.Aluno;
import com.ifrs.lpoo.forcalivre.model.Plano;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Reponsável pela consulta e persistência de Alunos.
 */
public class AlunoRepository {

  private static final String ID = "ID";
  private static final String NOME = "NOME";
  private static final String CPF = "CPF";
  private static final String DATA_NASCIMENTO = "DATA_NASCIMENTO";
  private static final String PLANO_ID = "PLANO_ID";
  private static final String[] HEADERS = {ID, CPF, NOME, DATA_NASCIMENTO, PLANO_ID};
  private static final String DELIMITER = ";";

  /**
   * Busca todos os alunos da Força Livre no arquivo planos.csv.
   */
  // TODO: Refatorar
  public List<Aluno> buscarTodos(PlanoRepository planoRepository) {
    try {
      Reader in = new FileReader("persistencia/alunos.csv");

      CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
          .setHeader(HEADERS)
          .setDelimiter(DELIMITER)
          .setSkipHeaderRecord(true)
          .build();

      Iterable<CSVRecord> records = csvFormat.parse(in);
      List<Aluno> alunos = new ArrayList<>();
      for (CSVRecord registro : records) {
        long id = Long.parseLong(registro.get(ID));
        LocalDate dataNascimento = LocalDate.parse(registro.get(DATA_NASCIMENTO));
        long planoId = Long.parseLong(registro.get(PLANO_ID));
        Optional<Plano> planoOptional = planoRepository.buscarTodos().stream()
            .filter(p -> p.getId().equals(planoId))
            .findFirst();

        Aluno aluno = new Aluno(id, registro.get(CPF), registro.get(NOME), dataNascimento, planoOptional.orElse(null));
        alunos.add(aluno);
      }

      return alunos;
    } catch (Exception e) {
      System.err.println("Algo deu errado! " + e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
  }

}
