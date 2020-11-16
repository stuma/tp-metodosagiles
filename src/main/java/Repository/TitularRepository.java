package Repository;

import java.util.List;

import Model.Titular;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TitularRepository extends JpaRepository<Titular, Long> {

    List<Titular> findByDni(boolean dni);
    List<Titular> findByNombre(String nombre);

}









