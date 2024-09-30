package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;

public interface OrdenCompraRepository  extends JpaRepository<OrdenCompra, Integer>  {

    @Query(value = "SELECT * FROM OrdenCompras", nativeQuery = true)
    Collection<OrdenCompra> darOrdenesCompra();
     
    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenCompras SET fechaCreacion = :fechaCreacion, estado = 'anulada', fechaEntrega = :fechaEntrega, id_sucursal = :id_sucursal, id_proveedor = :id_proveedor WHERE id = :id AND estado = 'vigente'", nativeQuery = true)
    void actualizarOrdenCompra(
        @Param("id") Integer id,
        @Param("fechaCreacion") Date fechaCreacion,
        @Param("fechaEntrega") Date fechaEntrega,
        @Param("id_proveedor") Integer id_proveedor,
        @Param("id_sucursal") Integer id_sucursal);

}






