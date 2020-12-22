package utn.metodosagiles.service;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utn.metodosagiles.dao.clases.LicenciaDao;
import utn.metodosagiles.dao.clases.TitularDao;
import utn.metodosagiles.dao.interfaces.LicenciaDaoInterface;
import utn.metodosagiles.dao.interfaces.TitularDaoInterface;
import utn.metodosagiles.model.Licencia;
import utn.metodosagiles.model.Titular;

import java.security.Guard;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class LicenciaService {

    private final LicenciaDaoInterface licenciaDaoInterface;


    @Autowired
    public LicenciaService(@Qualifier("LicenciaDao") LicenciaDaoInterface licenciaDaoInterface, TitularDaoInterface titularDaoInterface, TitularDao titularDao, TitularDao titularDao1, TitularService titularService, LicenciaDao licenciaDao) {
        this.licenciaDaoInterface = licenciaDaoInterface;

        this.titularDao = titularDao1;
        this.titularService = titularService;
        this.licenciaDao = licenciaDao;
    }
    final TitularDao titularDao;
    final TitularService titularService;
    final LicenciaDao licenciaDao;

    /**
     * Metodo que guarda e imprime o guarda dependiendo del paramerto booleano .
     * @param licencia .
     * @param imprimir .
     */
    public Integer addLicencia(Licencia licencia, boolean imprimir) throws Exception {

      long aux = titularDao.getAllTitulares().stream().filter(titular -> titular.equals(licencia.getTitular())).count();
      if(aux==0) {
          throw new Exception("No exixte titular");
      }
      String tipo = licencia.getTipoLicencia();

       int edad= calcularEdad(licencia.getTitular().getFechaNacimiento());
       if(tipo=="A"||tipo=="B"||tipo=="F"||tipo=="G"){
           if(edad<21 || edad>65){
               throw new Exception("No tiene la edad para ese tipo de licecnia");
           }else{
               if(!titularService.checkLicenciaPrevia(licencia.getTitular())){

                   throw new Exception("no tiene licencia previa");

               }
           }
       }
       if(imprimir){
           licencia.setPendiente(false);
           imprimir(licencia);
      }

       licencia.setPendiente(true);
      return licenciaDaoInterface.insertLicencia(licencia);
    }
Predicate p

    public List<Licencia> licenciasExpiradas(){
       return licenciaDaoInterface.getAllLicencias().stream().filter(licencia -> licencia.getFechaVencimiento().isAfter(LocalDate.now())).collect(Collectors.toList());
    }


    private void imprimir(Licencia licencia) {
    }

    public List<Licencia> getAllLicencias() {


        return licenciaDaoInterface.getAllLicencias();
    }

    public Optional<Licencia> getLicencia(String id){
        return licenciaDaoInterface.getLicencia(id);
    }

    public Integer deleteLicencia(String id){
        return licenciaDaoInterface.deleteLicencia(id);
    }

    public Integer updateLicencia(String id, Licencia licencia){
        return licenciaDaoInterface.updateLicencia(id, licencia);
    }

    /**
     * Calcula la fecha de vigencia .
     * @param fechaNacimiento
     * @param licenciaPrev
     *
     * @return costo total de emitir la licencia.
     */
    public LocalDate calcularVigencia(LocalDate fechaNacimiento, boolean licenciaPrev ) throws Exception {
       int anios = calcularEdad(fechaNacimiento);
        Integer diasHastaCumple = Math.abs((int) ChronoUnit.DAYS.between(LocalDate.now(),fechaNacimiento.plusYears(anios)));
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

        int auxAñoVigencia=  anios.getYear() + vigencia;
        return fechaNacimiento.plusYears(auxAñoVigencia);


    }

    /**
     * Funciona con una llamaba a la bd que tienen los datos requeridos para calcular el costo.
     * @param categoria: tipo de licencia [A|B|C|E|G].
     * @param vigencia: duraciond e la licencia
     * @return costo total de emitir la licencia.
     */public Float calcularCostoLicencia(String categoria, Integer vigencia) throws Exception {


        float calculoCosto=0;

        switch(categoria){
            case "A":
            case "B": return getCosto("B", vigencia) + getCostoAdmin() ;
            case "C": return getCosto("C", vigencia) + getCostoAdmin();
            case "E": return getCosto("E", vigencia) + getCostoAdmin() ;
            case "G": return getCosto("G", vigencia) +getCostoAdmin() ;
        }
        return 0F;
    }

    public boolean checkLicenciaPrevia(Titular t){

        if( this.getAllLicencias().stream().filter(licencia -> licencia.getTitular().equals(t)).count() != 0){
            return true;
        }
        else return false;

    }

     public Integer calcularEdad(LocalDate fechaNac){
         Period periodo = Period.between(fechaNac, LocalDate.now());
        return periodo.getYears();
     }

    private Float getCostoAdmin() {
        return 0f;
    }

    private Float getCosto(String b, int vigencia) {
        return 0f;
    }

    public void addLicencia(Licencia licencia) {
    }
}

