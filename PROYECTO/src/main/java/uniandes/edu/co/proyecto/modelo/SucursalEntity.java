package uniandes.edu.co.proyecto.modelo;

import org.hibernate.annotations.ValueGenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Sucursal")

public class SucursalEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id; 
    private Integer tamanioM2; 
    private String direccion;
    private Integer telefono;


    public SucursalEntity(Integer tamanioM2, String direccion, Integer telefono){
        this.tamanioM2= tamanioM2;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    //metodos get
    public SucursalEntity()
    {;}
    public Integer getId() {
        return id;
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

    //metodos set
    public void setId(Integer id) {
        this.id = id;
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

    @ManyToOne
    @JoinColumn(name = "id_ciudad", referencedColumnName = "codigo")
    private CiudadEntity id_ciudad; 

}
