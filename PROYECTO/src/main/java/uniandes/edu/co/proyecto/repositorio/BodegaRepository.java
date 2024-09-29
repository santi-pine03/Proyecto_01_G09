package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

    @Query(value = "SELECT * FROM BODEGA", nativeQuery=true)
    Collection<Bodega> darBodegas();

    @Query(value = "SELECT * FROM Bodegas WHERE id = :id", nativeQuery=true)
    Bodega darBodega(@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Bodegas (id,nombre,tamaniom2,id_sucursal) VALUES(idBodegas.nextval, :nombre, :tamaniom2, :id_sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre")String nombre, @Param("tamaniom2")Integer tamaniom2, @Param("id_sucursal")Sucursal id_sucursal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Bodegas WHERE id = :id", nativeQuery=true)
    void eliminarBodega(@Param("id")Integer id);


}
