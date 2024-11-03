package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.RecepcionProducto;

public interface RecepcionProductoRepository extends JpaRepository<RecepcionProducto,Integer>{

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO RECEPCIONPRODUCTOS (id,fecharecepcion,id_bodega,id_ordencompra) VALUES(idRecepcion.nextval, :fecharecepcion, :id_bodega, :id_orden)", nativeQuery = true)
    void insertarBodega(@Param("fecharecepcion") Date fecharecepcion, @Param("id_orden")Integer id_orden, @Param("id_bodega")Integer id_bodega);

    
}
