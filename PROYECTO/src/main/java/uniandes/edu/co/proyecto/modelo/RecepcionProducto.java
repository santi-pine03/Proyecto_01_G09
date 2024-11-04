package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

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
    private Date fecharecepcion;
    @ManyToOne
    @JoinColumn(name = "id_bodega", referencedColumnName = "id")
    private Bodega id_bodega;
    @ManyToOne
    @JoinColumn(name = "id_ordencompra", referencedColumnName = "id")
    private OrdenCompra id_ordencompra;

    public RecepcionProducto(Integer id, Date fecharecepcion, OrdenCompra id_ordencompra, Bodega id_bodega){
        this.id = id;
        this.fecharecepcion = fecharecepcion;
        this.id_bodega= id_bodega;
        this.id_ordencompra= id_ordencompra;
        
    }

    public RecepcionProducto()
    {;}

    // metodos get 
    public Integer getId() {
        return id;
    }

    public Date getFechaRecepcion() {
        return fecharecepcion;
    }

    // metodo set 
    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaRecepcion(Date fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
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
        return id_ordencompra;
    }

    public void setId_orden(OrdenCompra id_ordencompra) {
        this.id_ordencompra = id_ordencompra;
    }

    

}
