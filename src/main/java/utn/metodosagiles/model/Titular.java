package utn.metodosagiles.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Titular {

    //atributos de la entidad
    private String id;
    private Integer dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String direccion;
    private Boolean donante;
    private String factorRh;

    /**
     * constructor que deserializa y serializa la informacion de la entidad desde un formato json
     */
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

    //constructor
    public Titular() {
    }

    //constructor
    public Titular(String id) {
    }

    //sobreescritura de metodo to string
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

    /**
     *Getters y Setters
     */
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
