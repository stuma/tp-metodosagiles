package Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;


@Entity
@Table(name = "tipo_licencia")
public class TipoLicencia implements Comparable<TipoLicencia> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String valor;

    public TipoLicencia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(TipoLicencia o) {
        return 0;
    }
}
