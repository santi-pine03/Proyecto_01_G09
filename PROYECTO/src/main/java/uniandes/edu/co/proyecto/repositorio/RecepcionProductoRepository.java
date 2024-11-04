package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
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
    void insertarRecepcionProducto(@Param("fecharecepcion") Date fecharecepcion, @Param("id_orden")Integer id_orden, @Param("id_bodega")Integer id_bodega);


    @Transactional
    @Query(value = "SELECT * FROM RECEPCIONPRODUCTOS WHERE id_bodega = :id_bodega AND fechaRecepcion BETWEEN SYSDATE - 30 AND SYSDATE", nativeQuery = true)
    Collection<RecepcionProducto> darDocument(@Param("id_bodega") Integer id_bodega);
    
    @Transactional
    @Query(value = "SELECT P.*, c.nit_proveedor FROM RecepcionProductos p Inner join Ordencompras c ON p.id_ordencompra = c.id WHERE fechaRecepcion BETWEEN SYSDATE - 30 AND SYSDATE", nativeQuery = true)
    Collection<Object[]> darDocumentos(@Param("id_bodega") Integer id_bodega);

}

