package uniandes.edu.co.proyecto.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraProveedorPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="id_proveedor",referencedColumnName = "nit")
    private Proveedor id_proveedor;

    @ManyToOne
    @JoinColumn(name="id_producto",referencedColumnName = "codigoBarras")
    private Producto id_producto;
    
    public InfoExtraProveedorPK(Proveedor id_proveedor, Producto id_producto) {
        super();
        this.id_proveedor = id_proveedor;
        this.id_producto = id_producto;
    }

    public Proveedor getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Proveedor id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }
    




}
