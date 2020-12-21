package utn.metodosagiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utn.metodosagiles.dao.interfaces.LicenciaDaoInterface;
import utn.metodosagiles.model.Licencia;

import java.util.List;
import java.util.Optional;

@Service
public class LicenciaService {

    private final LicenciaDaoInterface licenciaDaoInterface;

    @Autowired
    public LicenciaService(@Qualifier("LicenciaDao") LicenciaDaoInterface licenciaDaoInterface) {
        this.licenciaDaoInterface = licenciaDaoInterface;
    }

    public Integer addLicencia(Licencia licencia){
        return licenciaDaoInterface.insertLicencia(licencia);
    }

    public List<Licencia> getAllLicencias() {
        return licenciaDaoInterface.getAllLicencias();
    }

    public Optional<Licencia> getLicencia(String id){
        return licenciaDaoInterface.getLicencia(id);
    }

    public Integer deleteLicencia(String id){
        return licenciaDaoInterface.deleteLicencia(id);
    }

    public Integer updateLicencia(String id, Licencia licencia){
        return licenciaDaoInterface.updateLicencia(id, licencia);
    }
}
