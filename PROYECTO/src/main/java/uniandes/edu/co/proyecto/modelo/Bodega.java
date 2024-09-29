package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="BODEGA")
public class Bodega {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String nombre;
    private Integer tamaniom2;
    @ManyToOne
    @JoinColumn(name="id_sucursal",referencedColumnName = "id")
    private Sucursal id_sucursal;

    public Bodega(String nombre, Integer tamaniom2, Sucursal id_sucursal){
        this.nombre = nombre;
        this.tamaniom2 = tamaniom2;
        this.id_sucursal = id_sucursal;
    }
    public Bodega(){;}

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTamaniom2(Integer tamaniom2) {
        this.tamaniom2 = tamaniom2;
    }
    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public Integer getTamaniom2() {
        return tamaniom2;
    }
    public void setId_sucursal(Sucursal id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
    public Sucursal getId_sucursal() {
        return id_sucursal;
    } 

}
