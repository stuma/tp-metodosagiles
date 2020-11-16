package Repository;

import Model.TipoLicencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TipoLicenciaRepository extends JpaRepository<TipoLicencia, Long> {

    List<TipoLicencia> findById(Integer Id);
    List<TipoLicencia> findByValor(String Valor);

}
