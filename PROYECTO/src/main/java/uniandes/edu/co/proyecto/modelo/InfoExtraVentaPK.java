package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraVentaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_venta",referencedColumnName = "id")
    private Venta id_venta;

    @ManyToOne
    @JoinColumn(name="id_producto",referencedColumnName = "codigoBarras")
    private Producto id_producto;

    public InfoExtraVentaPK(Venta id_venta, Producto id_producto) {
        super();
        this.id_venta = id_venta;
        this.id_producto = id_producto;
    }

    public void setId_venta(Venta id_venta) {
        this.id_venta = id_venta;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public Venta getId_venta() {
        return id_venta;
    }

    public Producto getId_producto() {
        return id_producto;
    }
    

    
}
