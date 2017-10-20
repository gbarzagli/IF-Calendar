package dao;

import java.util.List;
import model.Teste;

/**
 * TesteDAO
 */
public interface TesteDAO {

    void insert(Teste value);
    List<Teste> all();
    
}