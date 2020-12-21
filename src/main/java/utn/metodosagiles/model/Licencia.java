package utn.metodosagiles.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Licencia {

    //atributos de la entidad
    private String id;
    private TipoLicencia tipoLicencia;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private Titular titular;
    private String observaciones;
    private Integer numeroCopias;
    private Boolean pendiente;

    //constructor que serializa y deserializa los atributos desde un formato json
    public Licencia(@JsonProperty("id") String id,
                   @JsonProperty("tipoLicencia") TipoLicencia tipoLicencia,
                    @JsonProperty("fechaEmision") LocalDate fechaEmision,
                    @JsonProperty("fechaVencimiento") LocalDate fechaVencimiento,
                    @JsonProperty("titular") Titular titular,
                   @JsonProperty("observaciones") String observaciones,
                   @JsonProperty("numeroCopias") Integer numeroCopias,
                   @JsonProperty("pendiente") Boolean pendiente) {
        this.id = id;
        this.tipoLicencia = tipoLicencia;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.titular = titular;
        this.observaciones = observaciones;
        this.numeroCopias = numeroCopias;
        this.pendiente = pendiente;
    }

    //constructor
    public Licencia(String id) {
        this.id = id;
    }

    //constructor
    public Licencia() {
    }

    //override de metodo to string
    @Override
    public String toString() {
        return "Licencia{" +
                "id=" + id +
                ", tipoLicencia='" + tipoLicencia + '\'' +
                ", fechaEmision='" + fechaEmision + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", titular='" + titular.getNombre() + " " + titular.getApellido() + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", numeroCopias='" + numeroCopias + '\'' +
                ", pendiente=" + pendiente +
                '}';
    }

    //enum de tipo de licencia
    enum TipoLicencia {
        CLASE_A, CLASE_B, CLASE_C, CLASE_D, CLASE_E, CLASE_F, CLASE_G
    }

    //getters y setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public TipoLicencia getTipoLicencia() {
        return tipoLicencia;
    }
    public void setTipoLicencia(TipoLicencia tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public Titular getTitular() {
        return titular;
    }
    public void setTitular(Titular titular) {
        this.titular = titular;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Integer getNumeroCopias() {
        return numeroCopias;
    }
    public void setNumeroCopias(Integer numeroCopias) {
        this.numeroCopias = numeroCopias;
    }
    public Boolean getPendiente() {
        return pendiente;
    }
    public void setPendiente(Boolean pendiente) {
        this.pendiente = pendiente;
    }
}

