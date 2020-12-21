package utn.metodosagiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.metodosagiles.model.Titular;
import utn.metodosagiles.service.TitularService;

import java.util.List;

//clase controller que genera los endpoints del manejo de titular
@RequestMapping("api/titulares")
@RestController
public class TitularController {
    //instancia singleton de del service de titular
    private final TitularService titularService;

    //inyeccion de dependencias del service de titular
    @Autowired
    public TitularController(TitularService titularService){
        this.titularService = titularService;
    }

    //endpoint para el alta de titular
    @PostMapping
    public void addTitular(@RequestBody Titular titular){
        titularService.addTitular(titular);
    }

    //endpoint para obtener todos los titulares
    @GetMapping
    public List<Titular> getAllTitulares() {
        return titularService.getAllTitulares();
    }

    //endpoint para obtener un titular por id
    @GetMapping(path = {"id"})
    public Titular getTitular(@PathVariable("id") String id){
        return titularService.getTitular(id)
                .orElse(null);
    }

    //endpoint para eliminar un titular
    @DeleteMapping(path = {"id"})
    public void deleteTitular(@PathVariable("id") String id){
        titularService.deleteTitular(id);
    }

    //endpoint para actualizar un titular
    @PutMapping(path = {"id"})
    public void updateTitular(@PathVariable("id") String id, Titular titular){
        titularService.updateTitular(id, titular);
    }
}
