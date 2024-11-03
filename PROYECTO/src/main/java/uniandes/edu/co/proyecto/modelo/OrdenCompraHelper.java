package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

public class OrdenCompraHelper {

    Integer nit_proveedor;
    Integer id_sucusal;
    Date fecha_entrega;

    

    public OrdenCompraHelper(Integer nit_proveedor, Integer id_sucusal, Date fecha_entrega) {
        this.nit_proveedor = nit_proveedor;
        this.id_sucusal = id_sucusal;
        this.fecha_entrega = fecha_entrega;
    }
    public Integer getNit_proveedor() {
        return nit_proveedor;
    }
    public void setNit_proveedor(Integer nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }
    public Integer getId_sucusal() {
        return id_sucusal;
    }
    public void setId_sucusal(Integer id_sucusal) {
        this.id_sucusal = id_sucusal;
    }
    public Date getFecha_entrega() {
        return fecha_entrega;
    }
    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    
}
