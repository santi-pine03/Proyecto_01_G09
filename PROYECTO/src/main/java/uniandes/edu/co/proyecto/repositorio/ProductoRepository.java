package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query(value = "SELECT productos.*, categorias.nombre, categorias.descripcion, categorias.caracteristicasAlmacenamiento FROM productos INNER JOIN categorias ON productos.id_Categoria = categorias.codigo WHERE productos.codBarras=:codBarras", nativeQuery= true)
    Object[] darProductoId(@Param("codBarras") Integer codBarras);

    @Query(value = "SELECT productos.*, categorias.nombre, categorias.descripcion, categorias.caracteristicasAlmacenamiento FROM productos INNER JOIN categorias ON productos.id_Categoria = categorias.codigo WHERE productos.nombre=:nombre", nativeQuery= true)
    Object[] darProductoNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos(codBarras,nombre,precioUnitarioVenta,presentacion,cantidadPresentacio,unidadMedia,fechaExpiracion, id_expecificacionesempacado, id_categoria) VALUES(codBarras.nextval, :nombre, :precioUnitarioVenta, :presentacion,:cantidadPresentacio, :unidadMedia, :fechaExpiracion, :id_expecificacionesEmpacado, :id_categoria)", nativeQuery=true)
    void insertarProducto(@Param("nombre")String nombre,@Param("precioUnitarioVenta")Integer precioUnitarioVenta,@Param("presentacion")String presentacion, @Param("cantidadPresentacio")Integer cantidadPresentacio, @Param("unidadMedia")Integer unidadMedia,  @Param("fechaExpiracion")Date fechaExpiracion , @Param("id_expecificacionesEmpacado")Integer id_expecificacionesEmpacado, @Param("id_categoria")Integer id_categoria);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre=:nombre, precioUnitarioVenta=:precioUnitarioVenta,presentacion=:presentacion,cantidadPresentacio=:cantidadPresentacio,unidadMedia=:unidadMedia,fechaExpiracion=:fechaExpiracion,id_expecificacionesEmpacado=:id_expecificacionesEmpacado,id_categoria=:id_categoria WHERE codBarras=:codBarras" , nativeQuery=true)
    void actualizarProducto(@Param("codBarras")Integer codBarras,@Param("nombre")String nombre,@Param("precioUnitarioVenta")Integer precioUnitarioVenta,@Param("presentacion")String presentacion, @Param("cantidadPresentacio")Integer cantidadPresentacio, @Param("unidadMedia")Integer unidadMedia,  @Param("fechaExpiracion")Date fechaExpiracion , @Param("id_expecificacionesEmpacado")Integer id_expecificacionesEmpacado, @Param("id_categoria")Integer id_categoria);

    
    @Query("SELECT p FROM Producto p WHERE p.precioUnitarioVenta > :precio_in AND p.precioUnitarioVenta < :precio_ma")
    Collection<Producto> productoPrecio(@Param("precio_in") Integer precio_in, @Param("precio_ma") Integer precio_ma);
    

    @Query(value= "SELECT * FROM productos WHERE productos.fechaExpiracion <= :fechaMenor",nativeQuery=true)
    Collection<Producto> productofechaMenor (@Param("fechaMenor")Date fechaMenor) ;

    @Query(value= "SELECT * FROM productos WHERE productos.fechaExpiracion >= :fechaMayor",nativeQuery=true)
    Collection<Producto> productofechaMayor (@Param("fechaMayor")Date fechaMayor) ;

    @Query(value= "SELECT productos.* FROM productos INNER JOIN infoExtraBodegas ON productos.codBarras = infoExtraBodegas.id_producto INNER JOIN bodegas ON bodegas.id = infoExtraBodegas.id_bodega  WHERE bodegas.id_sucursal =:id_sucursal",nativeQuery=true)
    Collection<Producto> productoSucursal(@Param("id_sucursal")Integer id_sucursal) ;

    @Query(value= "SELECT * FROM productos WHERE productos.id_categoria=:id_categoria ",nativeQuery=true)
    Collection<Producto> productoCategoria (@Param("id_categoria")Integer id_categoria) ;
    
    @Query(value= "SELECT p.codBarras AS id_producto, p.nombre AS nombre_producto, b.nombre AS nombre_bodega, s.nombre AS nombre_sucursal,pr.nombre AS nombre_proveedor, ib.totalExistencias AS cantidad_actual FROM Productos p INNER JOIN InfoExtraBodegas ib ON p.codBarras = ib.id_producto INNER JOIN Bodegas b ON ib.id_bodega = b.id INNER JOIN Sucursales s ON b.id_sucursal = s.id LEFT JOIN InfoExtraProveedores iep ON p.codBarras = iep.id_producto LEFT JOIN Proveedores pr ON iep.id_proveedor = pr.nit WHERE ib.totalExistencias < ib.nivelMinimoReorden ORDER BY p.nombre, b.nombre, s.nombre, pr.nombre",nativeQuery=true)
    Collection<Object[]> productoNecesitaOrden () ;

    //Revisar
    @Query(value= " SELECT * FROM  ordenCompras",nativeQuery=true)
    Collection<Object[]> productoNecesitaOrdenes () ;

}
