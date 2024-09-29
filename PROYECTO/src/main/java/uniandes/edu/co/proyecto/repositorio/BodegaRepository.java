package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

    @Query(value = "SELECT * FROM Bodegas", nativeQuery=true)
    Collection<Bodega> darBodegas();

    @Query(value = "SELECT * FROM Bodegas WHERE id = :id", nativeQuery=true)
    Bodega darBodega(@Param("id")int id);

}
