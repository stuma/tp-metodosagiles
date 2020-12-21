package utn.metodosagiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.metodosagiles.model.Licencia;
import utn.metodosagiles.service.LicenciaService;

import java.util.List;

@RequestMapping("api/licencias")
@RestController
public class LicenciaController {
    private final LicenciaService licenciaService;

    @Autowired
    public LicenciaController(LicenciaService licenciaService){
        this.licenciaService = licenciaService;
    }

    @PostMapping
    public void addLicencia(@RequestBody Licencia licencia){
        licenciaService.addLicencia(licencia);
    }

    @GetMapping
    public List<Licencia> getAllLicencias() {
        return licenciaService.getAllLicencias();
    }

    @GetMapping(path = {"id"})
    public Licencia getLicencia(@PathVariable("id") String id){
        return licenciaService.getLicencia(id)
                .orElse(null);
    }

    @DeleteMapping(path = {"id"})
    public void deleteLicencia(@PathVariable("id") String id){
        licenciaService.deleteLicencia(id);
    }

    @PutMapping(path = {"id"})
    public void updateLicencia(@PathVariable("id") String id, Licencia licencia){
        licenciaService.updateLicencia(id, licencia);
    }
}
