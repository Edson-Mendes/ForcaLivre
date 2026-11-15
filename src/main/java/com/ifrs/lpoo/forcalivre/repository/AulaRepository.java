package com.ifrs.lpoo.forcalivre.repository;

import com.ifrs.lpoo.forcalivre.model.Aula;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reponsável pela consulta e persistência de Aulas.
 */
public class AulaRepository {

  private static final String ID = "ID";
  private static final String NOME = "NOME";
  private static final String DESCRICAO = "DESCRICAO";
  private static final String[] HEADERS = {ID, NOME, DESCRICAO};
  private static final String DELIMITER = ";";

  /**
   * Busca todos as aulas da Força Livre no arquivo aulas.csv.
   */
  // TODO: Refatorar
  public List<Aula> buscarTodos() {
    try {
      Reader in = new FileReader("persistencia/aulas.csv");

      CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
          .setHeader(HEADERS)
          .setDelimiter(DELIMITER)
          .setSkipHeaderRecord(true)
          .build();

      Iterable<CSVRecord> records = csvFormat.parse(in);
      List<Aula> aulas = new ArrayList<>();
      for (CSVRecord registro : records) {
        long id = Long.parseLong(registro.get(ID));
        Aula aula = new Aula(id, registro.get(NOME), registro.get(DESCRICAO));
        aulas.add(aula);
      }

      return aulas;
    } catch (Exception e) {
      System.err.println("Algo deu errado! " + e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
  }

}
