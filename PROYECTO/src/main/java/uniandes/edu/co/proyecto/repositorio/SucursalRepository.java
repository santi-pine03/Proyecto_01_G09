package uniandes.edu.co.proyecto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Sucursal;


public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{


@Modifying
@Query(value = "INSERT INTO Sucursal (id,nombre, tamanioM2, direccion, telefono, id_ciudad) VALUES (idSucursales.nextval, :nombre, :tamanioM2, :direccion, :telefono, :id_ciudad)", nativeQuery = true)
void crearSucursal(@Param("tamanioM2") String nombre,
                        @Param("tamanioM2") Integer tamanioM2, 
                        @Param("direccion") String direccion, 
                        @Param("telefono") Integer telefono, 
                        @Param("id_ciudad") Ciudad ciudadId);


@Query(value = "SELECT * FROM Sucursal s JOIN Bodega b ON s.id = b.id_sucursal JOIN Producto p ON b.id_producto = p.id WHERE (p.id = :productoId OR p.nombre = :productoNombre) AND b.cantidad_disponible > 0)", 
                nativeQuery = true)
                List<Sucursal> findSucursalesConProductoDisponible(@Param("productoId") Integer productoId, 
                                                                    @Param("productoNombre") String productoNombre);

                        
                        
                        
                        
                        
                        
}
