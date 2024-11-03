package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="infoextraordenes")
public class InfoExtraOrden {
    private Integer cantidad;
    private Integer costoUnitarioCompra;

    @EmbeddedId
    private InfoExtraOrdenPK pk_infoOrden;
    
    public InfoExtraOrden(Integer cantidad, Integer costoUnatio,OrdenCompra id_orden, Producto id_producto) {
        this.cantidad = cantidad;
        this.costoUnitarioCompra= costoUnatio;
        this.pk_infoOrden = new InfoExtraOrdenPK(id_orden, id_producto);
    }

    public InfoExtraOrden(){;}

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCostoUnitarioCompra() {
        return costoUnitarioCompra;
    }

    public void setCostoUnitarioCompra(Integer costoUnitarioCompra) {
        this.costoUnitarioCompra = costoUnitarioCompra;
    }

    public InfoExtraOrdenPK getPk_infoOrden() {
        return pk_infoOrden;
    }

    public void setPk_infoOrden(InfoExtraOrdenPK pk_infoOrden) {
        this.pk_infoOrden = pk_infoOrden;
    }
    
}
