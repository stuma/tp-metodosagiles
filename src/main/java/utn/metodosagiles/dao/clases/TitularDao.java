package utn.metodosagiles.dao.clases;
import org.springframework.stereotype.Repository;
import utn.metodosagiles.dao.interfaces.TitularDaoInterface;
import utn.metodosagiles.model.Titular;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//clase repository para el manejo de las instancias de titulares con la base de datos
//implementa una interfaz con los metodos de persistencia a la bd
@Repository("TitularDao")
public class TitularDao implements TitularDaoInterface {
    private static List<Titular> DB = new ArrayList<>();

    //añade un titular a la bd
    @Override
    public int insert(String id, Titular titular) {
        DB.add(new Titular(id));
        return 1;
    }

    //metodo auxiliar para añadir un titular a la bd
    @Override
    public Integer insertTitular(Titular titular) {
        return 0;
    }

    //obtiene todos los titulares de la db
    @Override
    public List<Titular> getAllTitulares() {
        return DB;
    }

    //elimina un titular por id
    @Override
    public Integer deleteTitular(String id) {
        Optional<Titular> titular = getTitular(id);
        if (titular.isEmpty()) {
            return 0;
        }
        DB.remove(titular.get());
        return 1;
    }

    //actualiza un titular por id
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

    //obtiene un titular por id
    @Override
    public Optional<Titular> getTitular(String id) {
        return DB.stream()
                .filter(titular -> titular.getId().equals(id))
                .findFirst();
    }
}
