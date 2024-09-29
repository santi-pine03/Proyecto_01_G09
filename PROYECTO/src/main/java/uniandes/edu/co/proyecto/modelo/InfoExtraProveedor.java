package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="infoextraproveedor")
public class InfoExtraProveedor {
    private Integer cantidadExistencias;

    @EmbeddedId
    private InfoExtraProveedorPK pk_infoProveedor;
    

    public InfoExtraProveedor(Integer cantidadExistencias, Proveedor id_proveedor, Producto id_producto) {

        this.cantidadExistencias = cantidadExistencias;
        this.pk_infoProveedor = new InfoExtraProveedorPK(id_proveedor, id_producto);
    }

    public Integer getCantidadExistencias() {
        return cantidadExistencias;
    }

    public void setCantidadExistencias(Integer cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }

    public InfoExtraProveedorPK getPk_infoProveedor() {
        return pk_infoProveedor;
    }

    public void setPk_infoProveedor(InfoExtraProveedorPK pk_infoProveedor) {
        this.pk_infoProveedor = pk_infoProveedor;
    }
    
}
