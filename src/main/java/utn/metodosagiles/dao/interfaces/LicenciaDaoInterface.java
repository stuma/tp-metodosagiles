package utn.metodosagiles.dao.interfaces;

import utn.metodosagiles.model.Licencia;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface LicenciaDaoInterface {
    int insert(String id, Licencia licencia);

    default Integer insertLicencia(Licencia licencia){
        Random rd = new Random();
        String id = Integer.toString(rd.nextInt());
        return insert(id, licencia);
    }

    List<Licencia> getAllLicencias();

    Integer deleteLicencia(String id);

    Integer updateLicencia(String id, Licencia licencia);

    Optional<Licencia> getLicencia(String id);
}
