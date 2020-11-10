package Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;



@Entity
@Table(name = "licencia")
public class Licencia implements Comparable<Licencia> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @ManyToOne()
    private TipoLicencia tipoLicencia;

    @Column
    private LocalDate fechaEmision;

    @Column
    private LocalDate fechaVencimiento;

    @Column
    @ManyToOne()
    private Titular titular;

    @Column
    private String observaciones;

    @Column
    private Integer numeroCopias;

    @Column
    private Boolean pendiente;

    public Licencia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public int compareTo(Licencia o) {
        return 0;
    }
}
