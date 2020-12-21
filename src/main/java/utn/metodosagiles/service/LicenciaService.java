package utn.metodosagiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utn.metodosagiles.dao.interfaces.LicenciaDaoInterface;
import utn.metodosagiles.model.Licencia;

import java.util.List;
import java.util.Optional;

//clase de servicio para las licencias con la logica de negocios
@Service
public class LicenciaService {

    //variable singleton para la persistencia de datos
    private final LicenciaDaoInterface licenciaDaoInterface;

    //inyeccion del repositorio para la persistencia de datos
    @Autowired
    public LicenciaService(@Qualifier("LicenciaDao") LicenciaDaoInterface licenciaDaoInterface) {
        this.licenciaDaoInterface = licenciaDaoInterface;
    }

    //metodo para el alta de una licencia
    public Integer addLicencia(Licencia licencia){
        return licenciaDaoInterface.insertLicencia(licencia);
    }

    //metodo para obtener todas las licencias
    public List<Licencia> getAllLicencias() {
        return licenciaDaoInterface.getAllLicencias();
    }

    //metodo para obtener una licencia por id
    public Optional<Licencia> getLicencia(String id){
        return licenciaDaoInterface.getLicencia(id);
    }

    //metodo para borrar una licencia segun id
    public Integer deleteLicencia(String id){
        return licenciaDaoInterface.deleteLicencia(id);
    }

    //metodo para actualizar los datos de una licencia
    public Integer updateLicencia(String id, Licencia licencia){
        return licenciaDaoInterface.updateLicencia(id, licencia);
    }
}
