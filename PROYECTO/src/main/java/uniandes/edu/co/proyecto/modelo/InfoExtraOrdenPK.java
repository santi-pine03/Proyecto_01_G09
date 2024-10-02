package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraOrdenPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_orde",referencedColumnName = "id")
    private OrdenCompra id_orden;

    @ManyToOne
    @JoinColumn(name="id_producto",referencedColumnName = "codBarras")
    private Producto id_producto;

    public InfoExtraOrdenPK(OrdenCompra id_orden, Producto id_producto) {
        super();
        this.id_orden = id_orden;
        this.id_producto = id_producto;
    }
    public OrdenCompra getId_orden() {
        return id_orden;
    }

    public void setId_orden(OrdenCompra id_orden) {
        this.id_orden = id_orden;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    
    
}
