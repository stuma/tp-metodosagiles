package Services;
import Model.Licencia;
import Service.TitularService;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LicenciaService {

    public LicenciaService() {
    }

    public LocalDate calcularVigencia(Licencia licencia){



        LocalDate fechaNac = licencia.getTitular().getFechaNacimiento();
        LocalDate ahora = LocalDate.now();

        //Math.abs((int) ChronoUnit.YEARS.between(fechaNac,ahora);

        Period periodo = Period.between(fechaNac, ahora);
        Integer años = periodo.getYears();

        Integer diasHastaCumple = Math.abs((int) ChronoUnit.DAYS.between(ahora,fechaNac.plusYears(años)));

        boolean checkLicPrev= titularService.checkLicenciaPrevia(licencia.getTitular());
        boolean lic = true;
        if(diasHastaCumple < 45){ //ERROR
            }
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
    public Float CalcularCosto(){
        return 0f;
    }


    public Float calcularCostoLicencia(String categoria,Licencia licencia){
        switch(licencia.getTipoLicencia().getValor()){
            case "A": calcularVigencia(licencia);
            case "B": calcularVigencia(licencia);
            case "C": calcularVigencia(licencia);
            case "D": calcularVigencia(licencia);
            case "E": calcularVigencia(licencia);
            case "F": calcularVigencia(licencia);



        }
        return 0F;
    }

}
