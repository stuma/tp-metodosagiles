package Controller;

import Model.Licencia;
import Repository.LicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
//@RestController
//@RequestMapping("/api")


public class LicenciaController {

    @Autowired
    LicenciaRepository licenciaRepository;


    public LicenciaController() {
    }

    @GetMapping("/licencias")
    public ResponseEntity<List<Licencia>> getAllLicencias() {

        try {
            List<Licencia> licencias = new ArrayList<Licencia>();


            licenciaRepository.findAll().forEach(licencias::add);


            if (licencias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(licencias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/licencias/{id}")
    public ResponseEntity<Licencia> getLicenciaById(@PathVariable("id") long id) {

        Optional<Licencia> licenciaData = licenciaRepository.findById(id);

        if (licenciaData.isPresent()) {
            return new ResponseEntity<>(licenciaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/licencias")
    public ResponseEntity<Licencia> createLicencia(@RequestBody Licencia licencia) {

        try {
            Licencia auxLicencia = licenciaRepository
                    .save(licencia);             //todo nose xq en la guia crea una instancia nueva entera con los mismo valores, en esta pruebo darle save a la misma entidad que me llega
            return new ResponseEntity<>(auxLicencia, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PutMapping("/licencias/{id}")
    public ResponseEntity<Licencia> updateLicencia(@PathVariable("id") long id, @RequestBody Licencia licencia) {

        Optional<Licencia> licenciaData = licenciaRepository.findById(id);

        if (licenciaData.isPresent()) {
            Licencia auxLicencia = licenciaData.get();

            auxLicencia.setTitular(licencia.getTitular());
            auxLicencia.setFechaEmision(licencia.getFechaEmision());
            auxLicencia.setFechaVencimiento(licencia.getFechaVencimiento());
            auxLicencia.setNumeroCopias(licencia.getNumeroCopias());
            auxLicencia.setObservaciones(licencia.getObservaciones());
            auxLicencia.setPendiente(licencia.getPendiente());
            auxLicencia.setTipoLicencia(licencia.getTipoLicencia());

            return new ResponseEntity<>(licenciaRepository.save(auxLicencia), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/licencias/{id}")
    public ResponseEntity<HttpStatus> deleteLicencia(@PathVariable("id") long id) {


        try {
            licenciaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/licencias")
    public ResponseEntity<HttpStatus> deleteAllLicencias() {


        try {
            licenciaRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

