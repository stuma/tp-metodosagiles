package utn.metodosagiles.dao.clases;
import org.springframework.stereotype.Repository;
import utn.metodosagiles.dao.interfaces.LicenciaDaoInterface;
import utn.metodosagiles.model.Licencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//clase repository que implementa los metodos de una interfaz para el acceso de datos del sistema
@Repository("LicenciaDao")
public class LicenciaDao implements LicenciaDaoInterface {

    private static List<Licencia> DB = new ArrayList<>();

    //genera un id y llama al metodo insertLicencia para su guardado en db
    @Override
    public int insert(String id, Licencia licencia) {
        DB.add(new Licencia(id));
        return 1;
    }

    //guarda una licencia en db
    @Override
    public Integer insertLicencia(Licencia licencia) {
        return 0;
    }

    //obtiene todas las licencias de la db
    @Override
    public List<Licencia> getAllLicencias() {
        return DB;
    }

    //elimina una licencia de la db
    @Override
    public Integer deleteLicencia(String id) {
        Optional<Licencia> licencia = getLicencia(id);
        if (licencia.isEmpty()) {
            return 0;
        }
        DB.remove(licencia.get());
        return 1;
    }

    //actualiza una licencia de la db
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

    //obtiene una licencia de la db segun id
    @Override
    public Optional<Licencia> getLicencia(String id) {
        return DB.stream()
                .filter(licencia -> licencia.getId().equals(id))
                .findFirst();
    }
}
