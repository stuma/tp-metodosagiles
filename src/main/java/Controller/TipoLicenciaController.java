package Controller;

import Model.TipoLicencia;

import Repository.TipoLicenciaRepository;
import Repository.TitularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

// Fuente https://bezkoder.com/spring-boot-jpa-crud-rest-api/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class TipoLicenciaController {


    @Autowired
    TipoLicenciaRepository tipoLicenciaRepository;


    public TipoLicenciaController() {
    }


//MODELO

    //todo
    @GetMapping("/tipolicencias")
    public ResponseEntity<List<TipoLicencia>> getAlltipoLicencias(@RequestParam(required = false) String title) {
        try {
            List<TipoLicencia> tipoLicencias = new ArrayList<TipoLicencia>();

            if (title == null)
                tipoLicenciaRepository.findAll().forEach(tipoLicencias::add);


            if (tipoLicencias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tipoLicencias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/tipolicencias/{id}")
    public ResponseEntity<TipoLicencia> gettipoLicenciaById(@PathVariable("id") long id) {

    }

    @PostMapping("/tipolicencias")
    public ResponseEntity<TipoLicencia> createtipoLicencia(@RequestBody TipoLicencia tipoLicencia) {

    }

    @PutMapping("/tipolicencias/{id}")
    public ResponseEntity<TipoLicencia> updatetipoLicencia(@PathVariable("id") long id, @RequestBody TipoLicencia tipoLicencia) {

    }

    @DeleteMapping("/tipolicencias/{id}")
    public ResponseEntity<HttpStatus> deletetipoLicencia(@PathVariable("id") long id) {

    }

    @DeleteMapping("/tipolicencias")
    public ResponseEntity<HttpStatus> deleteAlltipoLicencias() {

    }

    @GetMapping("/tipolicencias/published")
    public ResponseEntity<List<TipoLicencia>> findByPublished() {

    }


}
