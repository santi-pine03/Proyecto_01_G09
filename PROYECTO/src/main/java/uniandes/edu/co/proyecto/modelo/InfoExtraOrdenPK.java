package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraOrdenPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_ordencompra",referencedColumnName = "id")
    private OrdenCompra id_ordencompra;

    @ManyToOne
    @JoinColumn(name="id_producto",referencedColumnName = "codBarras")
    private Producto id_producto;

    public InfoExtraOrdenPK(OrdenCompra id_ordencompra, Producto id_producto) {
        super();
        this.id_ordencompra = id_ordencompra;
        this.id_producto = id_producto;
    }
    public OrdenCompra getId_orden() {
        return id_ordencompra;
    }

    public void setId_orden(OrdenCompra id_ordencompra) {
        this.id_ordencompra = id_ordencompra;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    
    
}
