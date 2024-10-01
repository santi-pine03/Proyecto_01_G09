package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
<<<<<<< HEAD
@Table(name="infoextraventas")
=======
@Table(name="InfoExtraVentas")
>>>>>>> 3d8a95aec7fa6edaa16177aa480abbd75fab6d58
public class InfoExtraVenta {

    private Integer cantidad;
    private Integer precioUnitario;

    @EmbeddedId
    private InfoExtraVentaPK pk_infoVenta;

    public InfoExtraVenta(Producto id_producto, Venta id_venta, Integer cantidad, Integer precioUnitario) {
        this.pk_infoVenta = new InfoExtraVentaPK(id_venta,id_producto);
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    public InfoExtraVenta(){;}
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public void setPk_infoVenta(InfoExtraVentaPK pk_infoVenta) {
        this.pk_infoVenta = pk_infoVenta;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public Integer getPrecioUnitario() {
        return precioUnitario;
    }
    public InfoExtraVentaPK getPk_infoVenta() {
        return pk_infoVenta;
    }
    
}
