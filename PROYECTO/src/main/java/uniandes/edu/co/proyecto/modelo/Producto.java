package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "clazz_", discriminatorType = DiscriminatorType.STRING)

public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer codBarras;
    private String nombre;
    private Integer precioUnitarioVenta;
    private String presentacion;
    private Integer cantidadPresentacio;
    private Integer unidadMedia;
    @JsonFormat(pattern ="dd-MMM-yyyy")
    private Date fechaExpiracion;
    @ManyToOne
    @JoinColumn(name="id_expecificacionesEmpacado",referencedColumnName ="id")
    private EspecificacionesEmpacado id_expecificacionesEmpacado;
    @ManyToOne
    @JoinColumn(name="id_categoria",referencedColumnName ="codigo")
    private Categoria id_categoria;
    public Producto()
    {;}

    public Producto(String nombre, Integer precioUnitarioVenta, String presentacion,Integer cantidadPresentacio, Integer unidadMedia, Date fechaExpiracion, 
    EspecificacionesEmpacado id_expecificacionesEmpacado, Categoria id_categoria ) {
        this.nombre = nombre;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.presentacion= presentacion;
        this.cantidadPresentacio= cantidadPresentacio;
        this.unidadMedia= unidadMedia;
        this.fechaExpiracion= fechaExpiracion;
        this.id_expecificacionesEmpacado = id_expecificacionesEmpacado;
        this.id_categoria = id_categoria;

    }

    public Integer getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(Integer codBarras) {
        this.codBarras = codBarras;
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

    public Integer getCantidadPresentacio() {
        return cantidadPresentacio;
    }

    public void setCantidadPresentacio(Integer cantidadPresentacio) {
        this.cantidadPresentacio = cantidadPresentacio;
    }

    public Integer getUnidadMedia() {
        return unidadMedia;
    }

    public void setUnidadMedida(Integer unidadMedia) {
        this.unidadMedia = unidadMedia;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public EspecificacionesEmpacado getid_expecificacionesEmpacado() {
        return id_expecificacionesEmpacado;
    }

    public void setid_expecificacionesEmpacado(EspecificacionesEmpacado id_expecificacionesEmpacado) {
        this.id_expecificacionesEmpacado = id_expecificacionesEmpacado;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

}
