package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

    public interface RespuestaPorcentajeOcupacionBodega {

        Double getINDICE_OCUPACION();
        Integer getID_PRODUCTO();
    }
    public interface RespuestaInventarioProductosBodega {

        Integer getID_PRODUCTO();
        Integer getCANTIDAD_ACTUAL();
        Integer getCANTIDAD_MINIMA();
        Integer getCOSTO_PROMEDIO();
    }

    @Query(value = "SELECT * FROM BODEGAS", nativeQuery=true)
    Collection<Bodega> darBodegas();

    @Query(value = "SELECT * FROM BODEGAS WHERE id = :id", nativeQuery=true)
    Bodega darBodega(@Param("id")Integer id);

    //RF3
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO BODEGAS (id,nombre,tamaniom2,id_sucursal) VALUES(idBodegas.nextval, :nombre, :tamaniom2, :id_sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre")String nombre, @Param("tamaniom2")Integer tamaniom2, @Param("id_sucursal")Integer id_sucursal);

    //RF3
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM BODEGAS WHERE id = :id", nativeQuery=true)
    void eliminarBodega(@Param("id")Integer id);

    //RFC1
    @Query(value = "SELECT infob.id_producto AS ID_PRODUCTO, (infob.totalExistencias / infob.capacidadAlmacenamiento) AS INDICE_OCUPACION " +
    "FROM InfoExtraBodegas infob " +
    "WHERE infob.id_producto IN :codBarras", nativeQuery = true)
    Collection<RespuestaPorcentajeOcupacionBodega> darPorcentajeOcupacionBodega(@Param("codBarras") List<Integer> codBarras);


    //RFC3
    @Query(value = "SELECT infob.id_producto AS ID_PRODUCTO, infob.totalExistencias AS CANTIDAD_ACTUAL, infob.nivelMinimoReorden AS CANTIDAD_MINIMA, infob.costoPromedio AS COSTO_PROMEDIO " +
    "FROM InfoExtraBodegas infob " +//INNER JOIN Productos pro ON infob.id_producto = pro.codBarras " +
    "WHERE infob.id_bodega = :id_bodega", nativeQuery = true)
    Collection<RespuestaInventarioProductosBodega> darInventarioProductosBodega(@Param("id_bodega") Integer id_bodega);

    //Se actualiza la cantidad de existencias y costo promedio para el RF10
    @Modifying
    @Transactional
    @Query(value = "UPDATE InfoExtraBodegas" +
    "SET costopromedio = (((costopromedio * totalexistencias) + (:nuevo_precio * :nuevas_unidades)) / (totalexistencias + :nuevas_unidades))" + 
    "totalexistencias = totalexistencias + :nuevas_unidades"+
    "WHERE id_producto = :id_producto", nativeQuery=true)
    void actualizarCostoPromedioYCantExistencias(@Param("nuevo_precio") Integer nuevo_precio, @Param("nuevas_unidades") Integer nuevas_unidades,@Param("id_producto") Integer id_producto);


}
