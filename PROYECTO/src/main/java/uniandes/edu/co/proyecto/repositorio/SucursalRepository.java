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
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Sucursal;


public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{


@Modifying
@Query(value = "INSERT INTO Sucursal (id, tamanioM2, direccion, telefono, id_ciudad) VALUES (:id, :tamanioM2, :direccion, :telefono, :id_ciudad)", nativeQuery = true)
void crearSucursalQuery(@Param("id") Integer id, 
                        @Param("tamanioM2") Integer tamanioM2, 
                        @Param("direccion") String direccion, 
                        @Param("telefono") String telefono, 
                        @Param("id_ciudad") Integer ciudadId);


                        
                        
                        
                        
                        
                        
}
