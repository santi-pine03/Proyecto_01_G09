package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor {
    @Id
    private Integer nit;
    private String nombre;
    private String direccion;
    private Integer  telefonoContacto;
    private String nombreContacto;

    public Proveedor()
    {;}
    public Integer getNit() {
        return nit;
    }
    public void setNit(Integer nit) {
        this.nit = nit;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Integer getTelefonoContacto() {
        return telefonoContacto;
    }
    public void setTelefonoContacto(Integer telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    public String getNombreContacto() {
        return nombreContacto;
    }
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    public Proveedor(String nombre, String direccion, String nombreContacto,Integer telefonoContacto){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.nombreContacto= nombreContacto;
    }
    


}
