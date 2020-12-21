package utn.metodosagiles.dao.interfaces;
import utn.metodosagiles.model.Titular;
import java.util.List;
import java.util.Optional;
import java.util.Random;

//interfaz que define los metodos de persistencia de la clase Titular en la db
public interface TitularDaoInterface {
    //metodo auxiliar para guardar un titular en la db
    int insert(String id, Titular titular);

    //metodo para guardar un titular en la db
    default Integer insertTitular(Titular titular) {
        Random rd = new Random();
        String id = Integer.toString(rd.nextInt());
        return insert(id, titular);
    }

    //metodo que retorna todos los titulares de la db
    List<Titular> getAllTitulares();

    //metodo que elimina un titular de la db segun un id
    Integer deleteTitular(String id);

    //metodo que actualiza un titular segun id
    Integer updateTitular(String id, Titular titular);

    //metodo que retorna un titular dsde la bd segun id
    Optional<Titular> getTitular(String id);

}
