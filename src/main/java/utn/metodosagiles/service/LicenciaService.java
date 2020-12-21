package utn.metodosagiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utn.metodosagiles.dao.interfaces.LicenciaDaoInterface;
import utn.metodosagiles.model.Licencia;
import utn.metodosagiles.model.Titular;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LicenciaService {

    private final LicenciaDaoInterface licenciaDaoInterface;



    @Autowired
    public LicenciaService(@Qualifier("LicenciaDao") LicenciaDaoInterface licenciaDaoInterface) {
        this.licenciaDaoInterface = licenciaDaoInterface;
    }

    public Integer addLicencia(Licencia licencia){
        return licenciaDaoInterface.insertLicencia(licencia);
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
     * @param licencia: unalicencia
     * @return costo total de emitir la licencia.
     */
    public LocalDate calcularVigencia(Licencia licencia) throws Exception {


        LocalDate fechaNac = licencia.getTitular().getFechaNacimiento();
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        Integer años = periodo.getYears();

        Integer diasHastaCumple = Math.abs((int) ChronoUnit.DAYS.between(ahora,fechaNac.plusYears(años)));

        boolean checkLicPrev= checkLicenciaPrevia(licencia.getTitular());
        boolean lic = true;
        if(diasHastaCumple < 45){ throw new Exception("falta poco para fecha nac");   }
        int vigencia=0;
        if(años<21){
            if(checkLicPrev){vigencia=3;}
            vigencia=1;
        }
        else{
            if(años <=46){vigencia=5;}
            else{
                if(años<=60){vigencia=4;}
                else{
                    if(años<=70){vigencia=3;}
                    else{vigencia=1;
                    }
                }
            }
        }

        int auxAñoVigencia=  ahora.getYear() + vigencia;
        return fechaNac.plusYears(auxAñoVigencia);


    }

    /**
     * Funciona con una llamaba a la bd que tienen los datos requeridos para calcular el costo.
     * @param categoria: tipo de licencia [A|B|C|E|G].
     * @param licencia: unalicencia
     * @return costo total de emitir la licencia.
     */public Float calcularCostoLicencia(String categoria,Licencia licencia) throws Exception {

        int vigencia=calcularVigencia(licencia).getYear();
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




    private Float getCostoAdmin() {
        return 0f;
    }

    private Float getCosto(String b, int vigencia) {
        return 0f;
    }
}
