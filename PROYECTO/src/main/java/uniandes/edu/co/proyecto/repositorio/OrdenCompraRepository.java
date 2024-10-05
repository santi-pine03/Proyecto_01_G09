package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InfoExtraOrdenPK;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;

public interface OrdenCompraRepository  extends JpaRepository<OrdenCompra, Integer>  {


     
    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenCompras SET  estado = 'anulada' WHERE id = :id AND estado = 'vigente'", nativeQuery = true)
    void actualizarOrdenCompra(
        @Param("id") Integer id);
    @Query(value= " SELECT * FROM  ordenCompras",nativeQuery=true)
    Collection<Object[]> darOrdenes () ;

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenCompra (fechaCreacion, estado, fechaEntrega, id_sucursal, id_proveedor) VALUES (CURRENT_DATE, 'vigente', :fechaEntrega, :id_sucursal, :id_proveedor)", nativeQuery = true)
    void crearOrdenCompra(
        @Param("fechaEntrega") Date fechaEntrega,
        @Param("id_proveedor") Integer id_proveedor,
        @Param("id_sucursal") Integer id_sucursal);
    @Query(value = "INSERT INTO infoextraorden (idOrde, pk_infoOrden, cantidad, costoUnitarioCompra) VALUES (:pk_infoOrden, :idProducto, :cantidad, :costoUnitarioCompra)", nativeQuery = true)
    void agregarDetalleOrden(
        @Param("idOrden") Integer idOrden,
        @Param("pk_infoOrden") InfoExtraOrdenPK pkInfoOrden,
        @Param("cantidad") Integer cantidad,
        @Param("costoUnitarioCompra") Integer costoUnitarioCompra);
    
    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Integer getUltimaOrdenId();    

}






