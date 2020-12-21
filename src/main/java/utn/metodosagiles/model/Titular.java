package utn.metodosagiles.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

//@Entity
//@Table(name = "titular")
public class Titular {

//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

//    @Column
    private Integer dni;

//    @Column
    private String nombre;

//    @Column
    private String apellido;

//    @Column
    private LocalDate fechaNacimiento;

//    @Column
    private String direccion;

//    @Column
    private Boolean donante;

//    @Column
    private String factorRh;

    public Titular(@JsonProperty("id") String id,
                    @JsonProperty("dni") Integer dni,
                    @JsonProperty("nombre") String nombre,
                    @JsonProperty("apellido") String apellido,
                    @JsonProperty("direccion") String direccion,
                    @JsonProperty("donante") Boolean donante,
                    @JsonProperty("factorRh") String factorRh
                    ) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.donante = donante;
        this.factorRh = factorRh;
    }

    public Titular() {
    }

    public Titular(String id) {
    }

    @Override
    public String toString() {
        return "Licencia{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", donante='" + donante + '\'' +
                ", factorRh='" + factorRh + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getDonante() {
        return donante;
    }

    public void setDonante(Boolean donante) {
        this.donante = donante;
    }

    public String getFactorRh() {
        return factorRh;
    }

    public void setFactorRh(String factorRh) {
        this.factorRh = factorRh;
    }
}
