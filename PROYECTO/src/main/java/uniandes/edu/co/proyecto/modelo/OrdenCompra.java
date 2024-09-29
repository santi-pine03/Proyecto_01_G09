package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="ordenCompra")

public class OrdenCompra {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id; 
    private Date fechaCreacion;
    private String estado;
    private Date fechaEntrega;
    @ManyToOne
    @JoinColumn(name="id_sucursal",referencedColumnName = "id")
    private Sucursal id_sucursal;
    @ManyToOne
    @JoinColumn(name="id_proveedor",referencedColumnName = "nit")
    private Proveedor id_proveedor;

    public OrdenCompra () 
    {;}
    public OrdenCompra(Date fecha1, String estado, Date fecha2, Proveedor proveedor,Sucursal sucursal ){
        this.fechaCreacion = fecha1;
        this.estado= estado;
        this.fechaEntrega= fecha2;
        this.id_proveedor = proveedor;
        this.id_sucursal = sucursal;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    

}








