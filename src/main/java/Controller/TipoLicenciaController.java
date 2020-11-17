package Controller;

import Model.TipoLicencia;
import Repository.TipoLicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<TipoLicencia>> getAlltipoLicencias() {
        try {
            List<TipoLicencia> tipoLicencias = new ArrayList<TipoLicencia>();


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

        Optional<TipoLicencia> tipoLicenciaData = tipoLicenciaRepository.findById(id);

        if (tipoLicenciaData.isPresent()) {
            return new ResponseEntity<>(tipoLicenciaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/tipolicencias")
    public ResponseEntity<TipoLicencia> createtipoLicencia(@RequestBody TipoLicencia tipoLicencia) {
        try {
            TipoLicencia auxTipoLicencia = tipoLicenciaRepository
                    .save(new TipoLicencia(tipoLicencia.getValor()));
            return new ResponseEntity<>(auxTipoLicencia, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/tipolicencias/{id}")
    public ResponseEntity<TipoLicencia> updatetipoLicencia(@PathVariable("id") long id, @RequestBody TipoLicencia tipoLicencia) {

        Optional<TipoLicencia> tipoLicenciaData = tipoLicenciaRepository.findById(id);

        if (tipoLicenciaData.isPresent()) {
            TipoLicencia auxTipoLicencia = tipoLicenciaData.get();
            auxTipoLicencia.setValor(tipoLicencia.getValor());


            return new ResponseEntity<>(tipoLicenciaRepository.save(auxTipoLicencia), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/tipolicencias/{id}")
    public ResponseEntity<HttpStatus> deletetipoLicencia(@PathVariable("id") long id) {
        try {
            tipoLicenciaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/tipolicencias")
    public ResponseEntity<HttpStatus> deleteAlltipoLicencias() {
        try {
            tipoLicenciaRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
