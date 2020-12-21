package utn.metodosagiles.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

//@Entity
//@Table(name = "licencia")
public class Licencia {

//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

//    @Column
//    @ManyToOne()
    private TipoLicencia tipoLicencia;

//    @Column
    private LocalDate fechaEmision;

//    @Column
    private LocalDate fechaVencimiento;

//    @Column
//    @ManyToOne()
    private Titular titular;

//    @Column
    private String observaciones;

//    @Column
    private Integer numeroCopias;

//    @Column
    private Boolean pendiente;

    private List<Licencia> listaLicencia;

    public List<Licencia> getListaLicencia() {
        return listaLicencia;
    }

    public void setListaLicencia(List<Licencia> listaLicencia) {
        this.listaLicencia = listaLicencia;
    }

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

    public Licencia(String id) {
        this.id = id;
    }

    public Licencia() {
    }

    @Override
    public String toString() {
        return "Licencia{" +
                "id=" + id +
                ", tipoLicencia='" + tipoLicencia.getNombre() + '\'' +
                ", fechaEmision='" + fechaEmision + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", titular='" + titular.getNombre() + " " + titular.getApellido() + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", numeroCopias='" + numeroCopias + '\'' +
                ", pendiente=" + pendiente +
                '}';
    }

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

