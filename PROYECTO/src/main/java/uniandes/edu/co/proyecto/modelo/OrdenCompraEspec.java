package uniandes.edu.co.proyecto.modelo;
import java.util.List;

public class OrdenCompraEspec {
    private OrdenCompraHelper encabezadOrdenCompra;
    private List<InfoExtraOrdenHelper> detalle;

    

    public OrdenCompraHelper getEncabezadOrdenCompra() {
        return encabezadOrdenCompra;
    }

    public void setEncabezadOrdenCompra(OrdenCompraHelper encabezadOrdenCompra) {
        this.encabezadOrdenCompra = encabezadOrdenCompra;
    }

    public List<InfoExtraOrdenHelper> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<InfoExtraOrdenHelper> detalle) {
        this.detalle = detalle;
    }
    
}
