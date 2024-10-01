package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")

public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer codigoBarras;
    private String nombre;
    private Integer precioUnitarioVenta;
    private String presentacion;
    private Integer cantidadPresentacio;
    private Integer unidadMedida;
    @JsonFormat(pattern = "dd-MMM-yyyy")
    private Date fechaExpiracion;
    @ManyToOne
    @JoinColumn(name="id_esfecificacionesEmpacado",referencedColumnName = "id")
    private EspecificacionesEmpacado id_expecificacionesEmpacado;
    @ManyToOne
    @JoinColumn(name="id_categoria",referencedColumnName = "codigo")
    private Categoria id_categoria;
    public Producto()
    {;}

    public Producto(String nombre, Integer precioUnitarioVenta, String presentacion,Integer cantidadPresentacion, Integer unidadMedida, Date fechaExpiracion, 
    EspecificacionesEmpacado especificaciones, Categoria id_categoria ) {
        this.nombre = nombre;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.presentacion= presentacion;
        this.cantidadPresentacio= cantidadPresentacion;
        this.unidadMedida= unidadMedida;
        this.fechaExpiracion= fechaExpiracion;
        this.id_expecificacionesEmpacado = especificaciones;
        this.id_categoria = id_categoria;

    }

    public Integer getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Integer codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Integer precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Integer getCantidadPresentacion() {
        return cantidadPresentacio;
    }

    public void setCantidadPresentacion(Integer cantidadPresentacion) {
        this.cantidadPresentacio = cantidadPresentacion;
    }

    public Integer getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Integer unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public EspecificacionesEmpacado getId_empacado() {
        return id_expecificacionesEmpacado;
    }

    public void setId_empacado(EspecificacionesEmpacado id_empacado) {
        this.id_expecificacionesEmpacado = id_empacado;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

}
