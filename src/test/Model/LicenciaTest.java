package Model;

import Services.LicenciaService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LicenciaTest {

    @Test
    void testcalcularVigencia() {
        Licencia licencia= new Licencia();

    }

    @Test
    void testCalcularCostoLicencia(){ //Licencia clase B 5 años
    LicenciaService licenciaService= new LicenciaService();
    Licencia licencia =  new Licencia();
    licencia.setFechaEmision( LocalDate.now().plusMonths(2));
    licencia.setFechaVencimiento( licencia.getFechaEmision().plusYears(5));
    float resultado =  licenciaService.calcularCostoLicencia("B",licencia);
    assertEquals(48, resultado);
    }
}