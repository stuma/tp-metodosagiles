package utn.metodosagiles.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//import javax.persistence.*;
import java.util.UUID;

//@Entity
//@Table(name = "tipo_licencia")
public class TipoLicencia {

//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

//    @Column
    private String nombre;

    public TipoLicencia() {
    }

    public TipoLicencia(@JsonProperty("id") String id,
                        @JsonProperty("nombre") String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

    @Override
    public String toString() {
        return "Licencia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
