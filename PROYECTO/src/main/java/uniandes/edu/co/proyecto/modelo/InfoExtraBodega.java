package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="infoextrabodega")
public class InfoExtraBodega {

    private Integer totalExistencias;
    private Integer costoPromedio;
    private Integer capacidadAlmacenamiento;
    private Integer nivelMinReorden;
    @EmbeddedId
    private InfoExtraBodegaPK pk_infoBodega;
    public InfoExtraBodega(Bodega id_bodega, Producto id_producto, Integer totalExistencias,
                            Integer costoPromedio, Integer capacidadAlmacenamiento, Integer nivelMinReorden){
        this.pk_infoBodega = new InfoExtraBodegaPK(id_bodega, id_producto);
        this.totalExistencias = totalExistencias;
        this.costoPromedio = costoPromedio;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.nivelMinReorden = nivelMinReorden;
    }

    public InfoExtraBodega(){;}

    public void setTotalExistencias(Integer totalExistencias) {
        this.totalExistencias = totalExistencias;
    }

    public void setCostoPromedio(Integer costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public void setCapacidadAlmacenamiento(Integer capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public void setNivelMinReorden(Integer nivelMinReorden) {
        this.nivelMinReorden = nivelMinReorden;
    }

    public void setPk_infoBodega(InfoExtraBodegaPK pk_infoBodega) {
        this.pk_infoBodega = pk_infoBodega;
    }

    public Integer getTotalExistencias() {
        return totalExistencias;
    }

    public Integer getCostoPromedio() {
        return costoPromedio;
    }

    public Integer getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public Integer getNivelMinReorden() {
        return nivelMinReorden;
    }

    public InfoExtraBodegaPK getPk_infoBodega() {
        return pk_infoBodega;
    }

    
}
