package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Perecedero")
public class ProductoPerecedero extends Producto{

    private Date fechaVencimiento;

    public ProductoPerecedero(String nombre, Integer precioUnitarioVenta, String presentacio,Integer cantidadPresentacion, 
                                Integer unidadMedia, Date fechaExpiracion, Date fechaVencimiento, EspecificacionesEmpacado id_expecificacionesEmpacado, Categoria id_categoria){
        super(nombre, precioUnitarioVenta, presentacio, cantidadPresentacion, unidadMedia, fechaExpiracion, id_expecificacionesEmpacado, id_categoria);
        this.fechaVencimiento = fechaVencimiento;
    }

    public ProductoPerecedero(){;}

    
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    
}
