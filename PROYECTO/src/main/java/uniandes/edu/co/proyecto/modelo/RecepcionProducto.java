package uniandes.edu.co.proyecto.modelo;

import java.text.DateFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RecepcionProductos")

public class RecepcionProducto {
   @Id 
   @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id; 
    @JsonFormat(pattern ="dd-MMM-yyyy")
    private DateFormat fechaRecepcion;
    @ManyToOne
    @JoinColumn(name = "id_bodega", referencedColumnName = "id")
    private Bodega id_bodega;
    @ManyToOne
    @JoinColumn(name = "id_orden", referencedColumnName = "id")
    private OrdenCompra id_orden;

    public RecepcionProducto(Integer id, DateFormat fechaRecepcion, OrdenCompra id_orden, Bodega id_bodega){
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
        this.id_bodega= id_bodega;
        this.id_orden= id_orden;
        
    }

    public RecepcionProducto()
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



    //faltan los atributos de la clase bodega, entonces genera error
   /*  @OneToOne
    @JoinColumn(name = "id_ordenCompra", referencedColumnName = "id")
    private OrdenCompra id_OrdenCompra; 
     */

    public Bodega getId_bodega() {
        return id_bodega;
    }

    public void setId_bodega(Bodega id_bodega) {
        this.id_bodega = id_bodega;
    }

    public OrdenCompra getId_orden() {
        return id_orden;
    }

    public void setId_orden(OrdenCompra id_orden) {
        this.id_orden = id_orden;
    }

    

}
