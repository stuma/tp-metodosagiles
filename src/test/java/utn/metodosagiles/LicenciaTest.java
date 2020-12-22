package utn.metodosagiles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import utn.metodosagiles.model.Licencia;
import utn.metodosagiles.service.LicenciaService;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LicenciaTest {


    @Autowired LicenciaService licenciaService;

    @Test
    void testcalcularVigencia() throws Exception {                        //   18 años con licencia anterior
        LocalDate fechaNac= LocalDate.of(2002,12,10);
        Date vencimiento = new GregorianCalendar(2020+5,12,10).getTime();
        LocalDate vigenciaCalculada=licenciaService.calcularVigencia(fechaNac,true);
        assertEquals(vencimiento, vigenciaCalculada );
    }
    @Test
    void testcalcularVigencia5() throws Exception { //   18 años sin licencia anterior
        LocalDate fechaNac= LocalDate.of(2001,12,10);
        Date vencimiento = new GregorianCalendar(2020+3,12,10).getTime();
        LocalDate vigenciaCalculada=licenciaService.calcularVigencia(fechaNac,false);
        assertEquals(vencimiento, vigenciaCalculada );
    }

    @Test
    void testcalcularVigencia3() throws Exception {                     //62 años
        LocalDate fechaNac= LocalDate.of(1958,12,10);
        Date vencimiento = new GregorianCalendar(2020+3,12,10).getTime();
        LocalDate vigenciaCalculada=licenciaService.calcularVigencia(fechaNac,true);
        assertEquals(vencimiento, vigenciaCalculada );
    }
    @Test
    void testcalcularVigencia2() throws Exception {                 //80 años
        LocalDate fechaNac= LocalDate.of(1940,12,10);
        Date vencimiento = new GregorianCalendar(2020+1,12,10).getTime();
        LocalDate vigenciaCalculada=licenciaService.calcularVigencia(fechaNac,true);
        assertEquals(vencimiento, vigenciaCalculada );
    }


    @Test
    void testCalcularCostoLicencia() throws Exception { //Licencia clase B 5 años
        float resultado =  licenciaService.calcularCostoLicencia("B",5);
        assertEquals(48, resultado);
    }
    @Test
    void testCalcularCostoLicencia2() throws Exception { //Licencia clase E 3 años
        float resultado =  licenciaService.calcularCostoLicencia("E",3);
        assertEquals(47, resultado);
    }
    @Test
    void testCalcularCostoLicencia3() throws Exception { //Licencia clase A 4 años
        float resultado =  licenciaService.calcularCostoLicencia("A",4);
        assertEquals(38, resultado);
    }
}
