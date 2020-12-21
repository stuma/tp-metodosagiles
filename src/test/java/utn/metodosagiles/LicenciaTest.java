package utn.metodosagiles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import utn.metodosagiles.model.Licencia;
import utn.metodosagiles.service.LicenciaService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LicenciaTest {


    @Autowired LicenciaService licenciaService;

    @Test
    void testcalcularVigencia() {
Licencia licencia
        LocalDate fechaNac= LocalDate.of(1996,11,6);




    }

    @Test
    void testCalcularCostoLicencia() throws Exception { //Licencia clase B 5 años
        Licencia licencia =  new Licencia();
        licencia.setFechaEmision( LocalDate.now().plusMonths(2));
        licencia.setFechaVencimiento( licencia.getFechaEmision().plusYears(5));
        float resultado =  licenciaService.calcularCostoLicencia("B",licencia);
        assertEquals(48, resultado);


    }
}
