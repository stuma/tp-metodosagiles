package utn.metodosagiles.dao.clases;

import org.springframework.stereotype.Repository;
import utn.metodosagiles.dao.interfaces.TitularDaoInterface;
import utn.metodosagiles.model.Titular;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("TitularDao")
public class TitularDao implements TitularDaoInterface {
    private static List<Titular> DB = new ArrayList<>();

    @Override
    public int insert(String id, Titular titular) {
        DB.add(new Titular(id));
        return 1;
    }

    @Override
    public Integer insertTitular(Titular titular) {
        return 0;
    }

    @Override
    public List<Titular> getAllTitulares() {
        return DB;
    }

    @Override
    public Integer deleteTitular(String id) {
        Optional<Titular> titular = getTitular(id);
        if (titular.isEmpty()) {
            return 0;
        }
        DB.remove(titular.get());
        return 1;
    }

    @Override
    public Integer updateTitular(String id, Titular titular) {
        return getTitular(id).map(
                t -> {
                    Integer indexTitular = DB.indexOf(t);
                    if (indexTitular >= 0) {
                        DB.set(indexTitular, titular);
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }

    @Override
    public Optional<Titular> getTitular(String id) {
        return DB.stream()
                .filter(titular -> titular.getId().equals(id))
                .findFirst();
    }
}
