package utn.metodosagiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utn.metodosagiles.dao.interfaces.TitularDaoInterface;
import utn.metodosagiles.model.Titular;

import java.util.List;
import java.util.Optional;

@Service
public class TitularService {
    private final TitularDaoInterface titularDaoInterface;

    @Autowired
    public TitularService(@Qualifier("TitularDao") TitularDaoInterface titularDaoInterface) {
        this.titularDaoInterface = titularDaoInterface;
    }

    public Integer addTitular(Titular licencia){
        return titularDaoInterface.insertTitular(licencia);
    }

    public List<Titular> getAllTitulares() {
        return titularDaoInterface.getAllTitulares();
    }

    public Optional<Titular> getTitular(String id){
        return titularDaoInterface.getTitular(id);
    }

    public Integer deleteTitular(String id){
        return titularDaoInterface.deleteTitular(id);
    }

    public Integer updateTitular(String id, Titular licencia){
        return titularDaoInterface.updateTitular(id, licencia);
    }
}
