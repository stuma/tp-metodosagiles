package utn.metodosagiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.metodosagiles.model.Licencia;
import utn.metodosagiles.service.LicenciaService;

import java.util.List;

//metodo controller encargado de generar los endpoints y llamar a la capa de servicios para el manejo del sistema
@RequestMapping("api/licencias")
@RestController
public class LicenciaController {
    //instancia del servicio -- singleton
    private final LicenciaService licenciaService;

    //inyeccion del servicio al controller
    @Autowired
    public LicenciaController(LicenciaService licenciaService){
        this.licenciaService = licenciaService;
    }

    //endpoint para realizar el alta de una licencia
    @PostMapping
    public void addLicencia(@RequestBody Licencia licencia){
        licenciaService.addLicencia(licencia);
    }

    //endpoint para obtener todas las licencias
    @GetMapping
    public List<Licencia> getAllLicencias() {
        return licenciaService.getAllLicencias();
    }

    //endpoint para obtener una licencia segun id
    @GetMapping(path = {"id"})
    public Licencia getLicencia(@PathVariable("id") String id){
        return licenciaService.getLicencia(id)
                .orElse(null);
    }

    //endpoint para el borrado logico de una licencia
    @DeleteMapping(path = {"id"})
    public void deleteLicencia(@PathVariable("id") String id){
        licenciaService.deleteLicencia(id);
    }

    //endpoint para actualizar una licencia
    @PutMapping(path = {"id"})
    public void updateLicencia(@PathVariable("id") String id, Licencia licencia){
        licenciaService.updateLicencia(id, licencia);
    }
}
