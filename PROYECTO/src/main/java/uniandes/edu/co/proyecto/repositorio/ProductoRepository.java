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
    @Query(value = "SELECT productos.*, categorias.nombre, categorias.descripcion, categorias.caracteristicasAlmacenamiento FROM productos INNER JOIN categorias ON productos.id_Categoria = categorias.id WHERE productos.codBarras=:codBarras", nativeQuery= true)
    Object[] darProductoId(@Param("codBarras") Integer codBarras);

    @Query(value = "SELECT productos.*, categorias.nombre, categorias.descripcion, categorias.caracteristicasAlmacenamiento FROM productos INNER JOIN categorias ON productos.id_Categoria = categorias.id WHERE productos.nombre=:nombre", nativeQuery= true)
    Object[] darProductoNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Productos (codBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacio, unidadMedida, fechaExpiracion,id_expecificacionesEmpacado, id_categoria) VALUES(codBarras.nextval, :nombre, :precioUnitarioVenta, :presentacion, :cantidadPresentacio, :unidadMedida, :fechaExpiracion, :id_expecificacionesEmpacado, :id_categoria)", 
        nativeQuery = true)
    void insertarProductos(@Param("nombre") String nombre, 
                        @Param("precioUnitarioVenta") Integer precioUnitarioVenta, 
                        @Param("presentacion") String presentacion, 
                        @Param("cantidadPresentacio") Integer cantidadPresentacio, 
                        @Param("unidadMedida") Integer unidadMedida, 
                        @Param("fechaExpiracion") Date fechaExpiracion, 
                        @Param("id_expecificacionesEmpacado") Integer id_expecificacionesEmpacado, 
                        @Param("id_categoria") Integer id_categoria);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Productos (codBarras,nombre,precioUnitarioVenta,presentacion,cantidadPresentacio,unidadMedida, fechaExpiracion,id_expecificacionesEmpacado, id_categoria) VALUES(codBarras.nextval, :nombre, :precioUnitarioVenta, :presentacion,:cantidadPresentacio, :unidadMedida, :fechaExpiracion, :id_expecificacionesEmpacado, :id_categoria)", nativeQuery=true)
    void insertarProducto(@Param("nombre")String nombre,@Param("precioUnitarioVenta")Integer precioUnitarioVenta,@Param("presentacion")String presentacion, @Param("cantidadPresentacio")Integer cantidadPresentacio, @Param("unidadMedida")Integer unidadMedida,  @Param("fechaExpiracion")Date fechaExpiracion , @Param("id_expecificacionesEmpacado")Integer id_expecificacionesEmpacado, @Param("id_categoria")Integer id_categoria);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Productos SET codBarras=:codBarras,nombre=:nombre, precioUnitarioVenta=:precioUnitarioVenta,presentacion=:presentacion,cantidadPresentacion=:cantidadPresentacion,unidadMedida=:unidadMedida,fechaExpiracion=:fechaExpiracion,id_empacado=:id_empacado,id_categoria=:id_categoria WHERE codBarras=:codBarras" , nativeQuery=true)
    void actualizarProducto(@Param("codBarras")Integer codBarras,@Param("nombre")String nombre,@Param("precioUnitarioVenta")Integer precioUnitarioVenta,@Param("presentacion")String presentacion, @Param("cantidadPresentacion")Integer cantidadPresentacion, @Param("unidadMedida")Integer unidadMedida,  @Param("fechaExpiracion")Date fechaExpiracion , @Param("id_empacado")Integer id_empacado, @Param("id_categoria")Integer id_categoria);

    
    @Query(value= "SELECT * FROM productos WHERE productos.precio >= :precio_in AND productos.precio <= :precio_ma ",nativeQuery=true)
    Collection<Producto> productoPrecio (@Param("precio_in")Integer precio_in, @Param("precio_ma")Integer precio_ma) ;

    @Query(value= "SELECT * FROM productos WHERE productos.fechaExpiracion <= :fecha",nativeQuery=true)
    Collection<Producto> productofechaMenor (@Param("fecha")Integer fecha) ;

    @Query(value= "SELECT * FROM productos WHERE productos.fechaExpiracion >= :fecha",nativeQuery=true)
    Collection<Producto> productofechaMayor (@Param("fecha")Integer fecha) ;

    @Query(value= "SELECT productos.* FROM productos INNER JOIN infoExtraBodega ON productos.id = infoExtraBodega.idProducto INNER JOIN bodega ON bodega.id = infoExtraBodega.id_bodega  WHERE bodega.id_sucursal = :id_sucursal  ",nativeQuery=true)
    Collection<Producto> productoSucursal(@Param("id_sucursal")Integer id_sucursal) ;

    @Query(value= "SELECT * FROM productos WHERE productos.id_categoria=:id_categoria ",nativeQuery=true)
    Collection<Producto> productoCategoria (@Param("id_categoria")Integer id_categoria) ;
}
