package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Sucursales")

public class Sucursal {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer Id;
    private String nombre; 
    private Integer tamanioM2; 
    private String direccion;
    private Integer telefono;
    
    @ManyToOne
    @JoinColumn(name = "id_ciudad", referencedColumnName = "codigo")
    private Ciudad id_ciudad; 

    public Sucursal(Integer Id,String nombre, Integer tamanioM2, String direccion, Integer telefono, Ciudad id_ciudad){
        this.Id = Id;
        this.nombre = nombre;
        this.tamanioM2= tamanioM2;
        this.direccion = direccion;
        this.telefono = telefono;
        
    }
    //metodos get
    public Sucursal()
    {;}
    public Integer getId() {
        return Id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId_ciudad(Ciudad id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    public Integer getTamanioM2() {
        return tamanioM2;
    }
    public String getDireccion() {
        return direccion;
    }
    public Integer getTelefono() {
        return telefono;
    }
    public Ciudad getId_ciudad(){
        return id_ciudad;
    }


    //metodos set
    public void setId(Integer id) {
        this.Id = id;
    }
    public void setTamanioM2(Integer tamanioM2) {
        this.tamanioM2 = tamanioM2;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
}
