package uniandes.edu.co.proyecto.modelo;

public class InfoExtraOrdenHelper {

    Integer codBarras;
    Integer cantidad;
    Integer costoUnitario;

    
    public InfoExtraOrdenHelper(Integer codBarras, Integer cantidad, Integer costoUnitario) {
        this.codBarras = codBarras;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }
    public Integer getCodBarras() {
        return codBarras;
    }
    public void setCodBarras(Integer codBarras) {
        this.codBarras = codBarras;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Integer getCostoUnitario() {
        return costoUnitario;
    }
    public void setCostoUnitario(Integer costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    

}
