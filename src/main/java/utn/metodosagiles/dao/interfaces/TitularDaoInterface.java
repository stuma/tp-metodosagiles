package utn.metodosagiles.dao.interfaces;

import utn.metodosagiles.model.Titular;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface TitularDaoInterface {
    int insert(String id, Titular titular);

    default Integer insertTitular(Titular titular) {
        Random rd = new Random();
        String id = Integer.toString(rd.nextInt());
        return insert(id, titular);
    }

    List<Titular> getAllTitulares();

    Integer deleteTitular(String id);

    Integer updateTitular(String id, Titular titular);

    Optional<Titular> getTitular(String id);

}
