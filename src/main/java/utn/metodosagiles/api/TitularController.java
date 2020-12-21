package utn.metodosagiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.metodosagiles.model.Licencia;
import utn.metodosagiles.model.Titular;
import utn.metodosagiles.service.LicenciaService;
import utn.metodosagiles.service.TitularService;

import java.util.List;

@RequestMapping("api/titulares")
@RestController
public class TitularController {
    private final TitularService titularService;

    @Autowired
    public TitularController(TitularService titularService){
        this.titularService = titularService;
    }

    @PostMapping
    public void addTitular(@RequestBody Titular titular){
        titularService.addTitular(titular);
    }

    @GetMapping
    public List<Titular> getAllTitulares() {
        return titularService.getAllTitulares();
    }

    @GetMapping(path = {"id"})
    public Titular getLicencia(@PathVariable("id") String id){
        return titularService.getTitular(id)
                .orElse(null);
    }

    @DeleteMapping(path = {"id"})
    public void deleteTitular(@PathVariable("id") String id){
        titularService.deleteTitular(id);
    }

    @PutMapping(path = {"id"})
    public void updateTitular(@PathVariable("id") String id, Titular titular){
        titularService.updateTitular(id, titular);
    }
}
