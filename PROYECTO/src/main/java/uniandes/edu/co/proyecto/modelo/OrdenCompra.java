package uniandes.edu.co.proyecto.modelo;
import java.text.DateFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="OrdenCompras")

public class OrdenCompra {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    @SuppressWarnings("unused")
    private DateFormat fechaCreacion;
    private String estado;
    private DateFormat fechaEntrega;

    public OrdenCompra(Integer id, DateFormat fechaCreacion, String estado, DateFormat fechaEntrega){
        this.id = id; 
        this.fechaCreacion = fechaCreacion;
        this.estado =estado;
        this.fechaEntrega = fechaEntrega;
    }
    //Metedos get
    public OrdenCompra()
    {;}
    public Integer getId() {
        return id;
    }

    public DateFormat getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public DateFormat getFechaEntrega() {
        return fechaEntrega;
    }

    public void setId(Integer id) {
        this.id = id;
    }
// Metedos set
    public void setFechaCreacion(DateFormat fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaEntrega(DateFormat fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id")
    private Ciudad id_ciudad; 

    @ManyToOne
    @JoinColumn(name = "nit_proveedor", referencedColumnName = "nit")
    private Proveedor nit_proveedor;

}
