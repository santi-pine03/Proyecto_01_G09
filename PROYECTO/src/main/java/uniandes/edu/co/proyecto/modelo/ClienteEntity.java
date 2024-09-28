package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Cliente")


public class ClienteEntity {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)

    private String cedula; 
    private String nombre; 


    public ClienteEntity(String cedula, String nombre){
        this.cedula = cedula; 
        this.nombre = nombre; 
    }

    public ClienteEntity()
    {;}

    // metodos get 
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }
    // metodos set
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
