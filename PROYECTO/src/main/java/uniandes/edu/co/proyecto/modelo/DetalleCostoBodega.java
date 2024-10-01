package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DetalleCostosBodega")
public class DetalleCostoBodega {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer costoUnitario;
    private Integer cantExistencias;
    private InfoExtraBodegaPK fk_infoExtra;

    public DetalleCostoBodega(Bodega id_bodega, Producto id_producto, Integer costoUnitario, Integer cantExistencias) {
        this.fk_infoExtra = new InfoExtraBodegaPK(id_bodega, id_producto);
        this.costoUnitario = costoUnitario;
        this.cantExistencias = cantExistencias;
    }
    public DetalleCostoBodega(){;}
    public void setId(Integer id) {
        this.id = id;
    }
    public void setCostoUnitario(Integer costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
    public void setCantExistencias(Integer cantExistencias) {
        this.cantExistencias = cantExistencias;
    }
    
    public Integer getId() {
        return id;
    }
    public Integer getCostoUnitario() {
        return costoUnitario;
    }
    public Integer getCantExistencias() {
        return cantExistencias;
    }
    public void setFk_infoExtra(InfoExtraBodegaPK fk_infoExtra) {
        this.fk_infoExtra = fk_infoExtra;
    }
    public InfoExtraBodegaPK getFk_infoExtra() {
        return fk_infoExtra;
    }
      

}
