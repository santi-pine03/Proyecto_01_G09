package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductosPerecederos")
public class ProductoPerecedero extends Producto{

    private Date fechaVencimiento;

    public ProductoPerecedero(String nombre, Integer precioUnitarioVenta, String presentacion,Integer cantidadPresentacion, 
                                Integer unidadMedida, Date fechaExpiracion, Date fechaVencimiento, EspecificacionesEmpacado especificaciones, Categoria id_categoria){
        super(nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, especificaciones, id_categoria);
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
