package uniandes.edu.co.proyecto.modelo;

import java.text.DateFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Venta")


public class VentaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private DateFormat fecha; 

    public VentaEntity(Integer id, DateFormat fecha){
        this.id = id;
        this.fecha = fecha;
    }

    public VentaEntity()
    {;}
// metodos get
    public Integer getId() {
        return id;
    }

    public DateFormat getFecha() {
        return fecha;
    }

// metodos set 
    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(DateFormat fecha) {
        this.fecha = fecha;
    }

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id")
    private SucursalEntity id_sucursal ;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private ClienteEntity id_cliente; 
}
