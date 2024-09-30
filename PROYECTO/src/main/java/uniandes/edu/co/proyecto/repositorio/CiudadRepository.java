package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Ciudad (codigo, nombre) VALUES (:codigo, :nombre)")
    void crearCiudad(@Param("codigo") Integer codigo,
                    @Param("nombre")String nombre);
    
    @Query(value = "SELECT * FROM <Ciudades>", nativeQuery=true)
    Collection<Ciudad>darCiudades();
}
