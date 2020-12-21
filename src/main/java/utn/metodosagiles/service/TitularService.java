package utn.metodosagiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utn.metodosagiles.dao.interfaces.TitularDaoInterface;
import utn.metodosagiles.model.Titular;

import java.util.List;
import java.util.Optional;

//clase de servicios que implementan el abm y logica de negocios para los titulares
@Service
public class TitularService {
    //variable singleton para acceder a la capa de datos
    private final TitularDaoInterface titularDaoInterface;

    //inyeccion de dependencia de interfaz para la persistencia de datos
    @Autowired
    public TitularService(@Qualifier("TitularDao") TitularDaoInterface titularDaoInterface) {
        this.titularDaoInterface = titularDaoInterface;
    }

    //metodo para el alta de un titular
    public Integer addTitular(Titular licencia){
        return titularDaoInterface.insertTitular(licencia);
    }

    //metodo para listar todos los titulares
    public List<Titular> getAllTitulares() {
        return titularDaoInterface.getAllTitulares();
    }

    //metodo para obtener un titular por id
    public Optional<Titular> getTitular(String id){
        return titularDaoInterface.getTitular(id);
    }

    //metodo para eliminar un titular por id
    public Integer deleteTitular(String id){
        return titularDaoInterface.deleteTitular(id);
    }

    //metodo para actualizar un titular por id
    public Integer updateTitular(String id, Titular licencia){
        return titularDaoInterface.updateTitular(id, licencia);
    }
}
