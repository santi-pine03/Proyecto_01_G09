package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class ProductoPerecedero extends Producto{

    private Date fechaVencimiento;

    public ProductoPerecedero(String nombre, Integer precioUnitarioVenta, String presentacion,Integer cantidadPresentacion, 
                                Integer unidadMedida, Date fechaExpiracion, Date fechaVencimiento){
        super(nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion);
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
