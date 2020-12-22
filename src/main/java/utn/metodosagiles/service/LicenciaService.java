package utn.metodosagiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utn.metodosagiles.dao.interfaces.LicenciaDaoInterface;
import utn.metodosagiles.dao.interfaces.TitularDaoInterface;
import utn.metodosagiles.model.Licencia;
import utn.metodosagiles.model.Titular;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//clase de servicio para las licencias con la logica de negocios
@Service
public class LicenciaService {
    //variables singleton para la persistencia de datos
    private final LicenciaDaoInterface licenciaDaoInterface;
    private final TitularDaoInterface titularDaoInterface;

    //inyeccion del repositorio para la persistencia de datos
    @Autowired
    public LicenciaService(@Qualifier("LicenciaDao") LicenciaDaoInterface licenciaDaoInterface, TitularDaoInterface titularDaoInterface) {
        this.licenciaDaoInterface = licenciaDaoInterface;
        this.titularDaoInterface = titularDaoInterface;
    }

    //metodo para el alta de una licencia e imprimir licencia en caso de que la bandera booleana lo indique
    public Integer addLicencia(Licencia licencia, boolean imprimir) throws Exception {
        long aux = titularDaoInterface.getAllTitulares().stream().filter(titular -> titular.equals(licencia.getTitular())).count();
        if (aux == 0) {
            throw new Exception("No existe titular");
        }

        String tipo = toString(licencia.getTipoLicencia());
        int edad = calcularEdad(licencia.getTitular().getFechaNacimiento());

        if (tipo.equals("A") || tipo.equals("B") || tipo.equals("F") || tipo.equals("G")) {
            if (edad < 21 || edad > 65) {
                throw new Exception("El titular no posee la edad correspondiente para el tipo de licencia seleccionado.");
            } else {
                if (!this.checkLicenciaPrevia(licencia.getTitular())) {
                    throw new Exception("El titular no posee licencia previa.");
                }
            }
        }
        if (imprimir) {
            licencia.setPendiente(false);
            this.imprimir(licencia);
        }
        licencia.setPendiente(true);
        return licenciaDaoInterface.insertLicencia(licencia);
    }

    //Metodo para retornar todas las licencias expiradas.
    public List<Licencia> licenciasExpiradas() {
        return licenciaDaoInterface.getAllLicencias()
                .stream()
                .filter(licencia ->
                        licencia
                                .getFechaVencimiento()
                                .isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    //Metodo para obtener un listado de todas las licencias
    public List<Licencia> getAllLicencias() {
        return licenciaDaoInterface.getAllLicencias();
    }

    //Metodo para obtener una licencia segun id
    public Optional<Licencia> getLicencia(String id) {
        return licenciaDaoInterface.getLicencia(id);
    }

    //Metodo para eliminar una licencia segun id
    public Integer deleteLicencia(String id) {
        return licenciaDaoInterface.deleteLicencia(id);
    }

    //Metodo apra actualizar una licencia segun id
    public Integer updateLicencia(String id, Licencia licencia) {
        return licenciaDaoInterface.updateLicencia(id, licencia);
    }

    /**
     * Calcula la fecha de vigencia de una licencia.
     */
    public LocalDate calcularVigencia(LocalDate fechaNacimiento, boolean licenciaPrev ) throws Exception {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento,ahora);
        int  anios = periodo.getYears();
        int diasHastaCumple = Math.abs((int) ChronoUnit.DAYS.between(LocalDate.now(),fechaNacimiento.plusYears(anios)));
        boolean lic = true;
        if(diasHastaCumple < 45){ throw new Exception("proximidad menor a 45 dias");   }
        int vigencia=0;
        if(anios<21){
            if(licenciaPrev){vigencia=3;}
            vigencia=1;
        }
        else{
            if(anios <=46){vigencia=5;}
            else{
                if(anios<=60){vigencia=4;}
                else{
                    if(anios<=70){vigencia=3;}
                    else{vigencia=1;
                    }
                }
            }
        }

        int auxAnioVigencia=  ahora.getYear() + vigencia;
        return fechaNacimiento.plusYears(auxAnioVigencia);
    }

    /**
     * Calcula el costo de una licencia en base a su categoría y su vigencia
     */
    public Float calcularCostoLicencia(String categoria, Integer vigencia) throws Exception {

        float calculoCosto = 0;
        switch (categoria) {
            case "A":
            case "B":
                return getCosto("B", vigencia) + getCostoAdmin();
            case "C":
                return getCosto("C", vigencia) + getCostoAdmin();
            case "E":
                return getCosto("E", vigencia) + getCostoAdmin();
            case "G":
                return getCosto("G", vigencia) + getCostoAdmin();
        }
        return 0F;
    }

    //Metodo que verifica si el titular posee una licencia previa.
    public boolean checkLicenciaPrevia(Titular t) {
        if (this.getAllLicencias().stream().filter(licencia -> licencia.getTitular().equals(t)).count() != 0) {
            return true;
        } else return false;

    }

    //Metodo que calcula la edad del titular de la licencia
    public Integer calcularEdad(LocalDate fechaNac) {
        Period periodo = Period.between(fechaNac, LocalDate.now());
        return periodo.getYears();
    }

    //Metodo que retorna el costo administrativo
    private Float getCostoAdmin() {
        return 0f;
    }

    //Metodo que retorna el costo de renovacion de una licencia
    private Float getCosto(String b, int vigencia) {
        return 0f;
    }

    //Metodo que imprime la licencia en pdf
    private int imprimir(Licencia licencia) {
        return 1;
    }

}

