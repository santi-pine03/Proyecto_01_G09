package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ciudad")

public class CiudadEntity {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)

    Integer codigo; 
    String nombre;

    public CiudadEntity(Integer codigo, String nombre){
        this.codigo = codigo; 
        this.nombre = nombre; 
    }
// metodos get
    public CiudadEntity()
    {;}

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
// metodos set
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
