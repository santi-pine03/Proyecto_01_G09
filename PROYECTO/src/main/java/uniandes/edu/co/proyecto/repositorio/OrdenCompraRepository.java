package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InfoExtraOrden;
import uniandes.edu.co.proyecto.modelo.InfoExtraOrdenPK;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.modelo.Sucursal;

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
        @Param("id_proveedor") Proveedor proveedor,
        @Param("id_sucursal") Sucursal sucursal);

    @Query(value = "INSERT INTO infoextraorden (idOrden, pk_infoOrden, cantidad, costoUnitarioCompra) VALUES (:idOrden,:pk_infoOrden, :idProducto, :cantidad, :costoUnitarioCompra)", nativeQuery = true)
    void agregarDetalleOrden(
        @Param("idOrden") Integer idOrden,
        @Param("pk_infoOrden") InfoExtraOrdenPK pk_infoOrden,
        @Param("cantidad") Integer cantidad,
        @Param("costoUnitarioCompra") Integer costoUnitarioCompra);
    
    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Integer getUltimaOrdenId();    

    @Query(value= " SELECT * FROM  ordenCompras WHERE id = :id_orden",nativeQuery=true)
    OrdenCompra darOrdenCompra(@Param("id_orden")Integer id);

    @Query(value= " SELECT * FROM  InfoExtraOrdenes WHERE id_ordencompra = :id_orden",nativeQuery=true)
    Collection<InfoExtraOrden> darProductosOrdenCompra(@Param("id_orden")Integer id);

    @Query(value= " UPDATE OrdenCompras SET estado = 'ENTREGADA' WHERE id = :id_orden",nativeQuery=true)
    void ordenCompraEntregada(@Param("id_orden")Integer id);

}






