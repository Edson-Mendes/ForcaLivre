package com.ifrs.lpoo.forcalivre.repository;

import com.ifrs.lpoo.forcalivre.model.Plano;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Reponsável pela consulta e persistência de Planos.
 */
public class PlanoRepository {

  private static final String[] HEADERS = {"ID", "NOME", "PRECO"};
  private static final String DELIMITER = ";";
  private static final String PRECO = "PRECO";
  private static final String ID = "ID";
  private static final String NOME = "NOME";

  /**
   * Busca todos os planos da Força Livre no arquivo planos.csv.
   */
  // TODO: Refatorar
  public List<Plano> buscarTodos() {
    try {
      Reader in = new FileReader("persistencia/planos.csv");

      CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
          .setHeader(HEADERS)
          .setDelimiter(DELIMITER)
          .setSkipHeaderRecord(true)
          .build();

      Iterable<CSVRecord> records = csvFormat.parse(in);
      List<Plano> planos = new ArrayList<>();
      for (CSVRecord record : records) {
        long id = Long.parseLong(record.get(ID));
        BigDecimal preco = new BigDecimal(record.get(PRECO));
        Plano plano = new Plano(id, record.get(NOME), preco);

        planos.add(plano);
      }

      return planos;
    } catch (Exception e) {
      System.err.println("Algo deu errado! " + e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
  }

}
