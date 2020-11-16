package Controller;

import Model.Titular;

import Repository.TitularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class TitularController {


    @Autowired
    TitularRepository titularRepository;


    public TitularController() {
    }

    @GetMapping("/titulares")
    public ResponseEntity<List<Titular>> getAllTitulares(@RequestParam(required = false) String title) {

    }

    @GetMapping("/titulares/{id}")
    public ResponseEntity<Titular> getTitularById(@PathVariable("id") long id) {

    }

    @PostMapping("/titulares")
    public ResponseEntity<Titular> createTitular(@RequestBody Titular tutorial) {

    }

    @PutMapping("/titulares/{id}")
    public ResponseEntity<Titular> updateTitular(@PathVariable("id") long id, @RequestBody Titular tutorial) {

    }

    @DeleteMapping("/titulares/{id}")
    public ResponseEntity<HttpStatus> deleteTitular(@PathVariable("id") long id) {

    }

    @DeleteMapping("/titulares")
    public ResponseEntity<HttpStatus> deleteAllTitulares() {

    }

    @GetMapping("/titulares/published")
    public ResponseEntity<List<Titular>> findByPublished() {

    }
}




