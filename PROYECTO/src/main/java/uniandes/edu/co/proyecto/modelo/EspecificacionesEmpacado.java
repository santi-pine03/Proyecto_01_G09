package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EspecificacionesEmpacado")
public class EspecificacionesEmpacado {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer volumen;
    private Integer pesoGR;

    public EspecificacionesEmpacado()
    {;}

    public EspecificacionesEmpacado( Integer volumen,Integer peso) {
        this.volumen = volumen;
        this.pesoGR = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public Integer getPeso() {
        return pesoGR;
    }

    public void setPeso(Integer peso) {
        this.pesoGR = peso;
    }
    



}
