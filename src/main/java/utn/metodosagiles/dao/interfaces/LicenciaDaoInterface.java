package utn.metodosagiles.dao.interfaces;
import utn.metodosagiles.model.Licencia;
import java.util.List;
import java.util.Optional;
import java.util.Random;

//interfaz con los metodos de persistencia de datos
public interface LicenciaDaoInterface {
    //añade una licencia a la db - metodo auxiliar
    int insert(String id, Licencia licencia);

    //añade una licencia a la bd
    default Integer insertLicencia(Licencia licencia){
        Random rd = new Random();
        String id = Integer.toString(rd.nextInt());
        return insert(id, licencia);
    }

    //retorna un listado de todas las licencias
    List<Licencia> getAllLicencias();

    //elimina una licencia de la bd
    Integer deleteLicencia(String id);

    //actualiza los datos de una licencia en la bd
    Integer updateLicencia(String id, Licencia licencia);

    //obtiene una licencia de la bd segun id
    Optional<Licencia> getLicencia(String id);
}
