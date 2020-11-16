package Repository;

import java.util.List;

import Model.Licencia;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LicenciaRepository extends JpaRepository<Licencia, Long> {

    List<Licencia> findById(Integer id);
    List<Licencia> findByTitular(String titular);

}