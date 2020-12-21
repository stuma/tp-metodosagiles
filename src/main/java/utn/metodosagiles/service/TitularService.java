package utn.metodosagiles.service;

import utn.metodosagiles.dao.clases.TitularDao;
import utn.metodosagiles.model.Licencia;
import utn.metodosagiles.model.Titular;

import java.time.LocalDate;
import java.util.List;

public class TitularService {

    public void altaTitular(int id, int nrodoc, String apellido, String nombre, LocalDate fechaNac, String dirección,
                            String clase, List<Licencia> licenciaList, boolean donante){

        TitularDao titularDao= new TitularDao();


        Titular titular = new Titular();
        titular.setApellido(apellido);
        titular.setDireccion(dirección);
        titular.setNombre(nombre);
        titular.setFechaNacimiento(fechaNac);
        titular.setDni(nrodoc);
        titular.setDonante(donante);

        try {
            titularDao.saveTitular(titular); //Enviado a la db para ser guardado
        }catch (Exception e){e.printStackTrace();}






    }




}