package Controller;

import Model.Licencia;
import Repository.LicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")


public class LicenciaController {

    @Autowired
    LicenciaRepository licenciaRepository;


    public LicenciaController() {
    }

    @GetMapping("/licencias")
    public ResponseEntity<List<Licencia>> getAllLicencias(@RequestParam(required = false) String title) {

    }

    @GetMapping("/licencias/{id}")
    public ResponseEntity<Licencia> getLicenciaById(@PathVariable("id") long id) {

    }

    @PostMapping("/licencias")
    public ResponseEntity<Licencia> createLicencia(@RequestBody Licencia licencia) {

    }

    @PutMapping("/licencias/{id}")
    public ResponseEntity<Licencia> updateLicencia(@PathVariable("id") long id, @RequestBody Licencia licencia) {

    }

    @DeleteMapping("/licencias/{id}")
    public ResponseEntity<HttpStatus> deleteLicencia(@PathVariable("id") long id) {

    }

    @DeleteMapping("/licencias")
    public ResponseEntity<HttpStatus> deleteAllLicencias() {

    }

    @GetMapping("/licencias/published")
    public ResponseEntity<List<Licencia>> findByPublished() {

    }
}

