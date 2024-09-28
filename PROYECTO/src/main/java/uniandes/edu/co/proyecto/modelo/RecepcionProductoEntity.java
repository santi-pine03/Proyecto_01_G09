package uniandes.edu.co.proyecto.modelo;

import java.text.DateFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RecepcionProducto")

public class RecepcionProductoEntity {
   @Id 
   @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id; 
    private DateFormat fechaRecepcion;

    public RecepcionProductoEntity(Integer id, DateFormat fechaRecepcion){
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
    }

    public RecepcionProductoEntity()
    {;}

    // metodos get 
    public Integer getId() {
        return id;
    }

    public DateFormat getFechaRecepcion() {
        return fechaRecepcion;
    }

    // metodo set 
    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaRecepcion(DateFormat fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    

}
