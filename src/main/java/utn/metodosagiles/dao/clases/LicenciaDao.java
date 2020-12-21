package utn.metodosagiles.dao.clases;

import org.springframework.stereotype.Repository;
import utn.metodosagiles.dao.interfaces.LicenciaDaoInterface;
import utn.metodosagiles.model.Licencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("LicenciaDao")
public class LicenciaDao implements LicenciaDaoInterface {

    private static List<Licencia> DB = new ArrayList<>();

    @Override
    public int insert(String id, Licencia licencia) {
        DB.add(new Licencia(id));
        return 1;
    }

    @Override
    public Integer insertLicencia(Licencia licencia) {
        return 0;
    }

    @Override
    public List<Licencia> getAllLicencias() {
        return DB;
    }

    @Override
    public Integer deleteLicencia(String id) {
        Optional<Licencia> licencia = getLicencia(id);
        if (licencia.isEmpty()) {
            return 0;
        }
        DB.remove(licencia.get());
        return 1;
    }

    @Override
    public Integer updateLicencia(String id, Licencia licencia) {
        return getLicencia(id).map(
                l -> {
                    Integer indexLicencia = DB.indexOf(l);
                    if (indexLicencia >= 0) {
                        DB.set(indexLicencia, licencia);
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }

    //TODO
    @Override
    public Optional<Licencia> getLicencia(String id) {
        return DB.stream()
                .filter(licencia -> licencia.getId().equals(id))
                .findFirst();
    }
}
