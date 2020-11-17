package Controller;

import Model.Titular;
import Repository.TitularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class TitularController {


    @Autowired
    TitularRepository titularRepository;


    public TitularController() {
    }

    @GetMapping("/titulares")
    public ResponseEntity<List<Titular>> getAllTitulares() {
        try {
            List<Titular> titulares = new ArrayList<Titular>();


            titularRepository.findAll().forEach(titulares::add);


            if (titulares.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(titulares, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/titulares/{id}")
    public ResponseEntity<Titular> getTitularById(@PathVariable("id") long id) {
        Optional<Titular> titularData = titularRepository.findById(id);

        if (titularData.isPresent()) {
            return new ResponseEntity<>(titularData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/titulares")
    public ResponseEntity<Titular> createTitular(@RequestBody Titular titular) {



        try {
            Titular auxTitular = titularRepository
                    .save(titular);             //todo nose xq en la guia crea una instancia nueva entera con los mismo valores, en esta pruebo darle save a la misma entidad que me llega
            return new ResponseEntity<>(auxTitular, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
//UPDATE
    @PutMapping("/titulares/{id}")
    public ResponseEntity<Titular> updateTitular(@PathVariable("id") long id, @RequestBody Titular titular) {

        Optional<Titular> titularData = titularRepository.findById(id);

        if (titularData.isPresent()) {

            Titular auxTitular = titularData.get();

            auxTitular.setDni(titular.getDni());
            auxTitular.setNombre(titular.getNombre());
            auxTitular.setApellido(titular.getApellido());
            auxTitular.setDireccion(titular.getDireccion());
            auxTitular.setDonante(titular.getDonante());
            auxTitular.setFactorRh(titular.getFactorRh());
            auxTitular.setFechaNacimiento(titular.getFechaNacimiento());
            return new ResponseEntity<>(titularRepository.save(auxTitular), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/titulares/{id}")
    public ResponseEntity<HttpStatus> deleteTitular(@PathVariable("id") long id) {

        try {
             titularRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/titulares")
    public ResponseEntity<HttpStatus> deleteAllTitulares() {

        try {
            titularRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}




