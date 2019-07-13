package daos;

import models.Praetor;

import java.util.List;
import java.util.Set;

public interface PraetorDao {
    Praetor getPraetorById(Integer id);
    List<Praetor> getAllPraetors();
    Boolean insertPraetor(Praetor praetor);
    boolean updatePraetor(Praetor praetor);
    boolean deletePraetorById(Integer id);
}
