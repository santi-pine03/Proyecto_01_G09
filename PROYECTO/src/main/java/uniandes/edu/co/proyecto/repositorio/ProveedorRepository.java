package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface  ProveedorRepository extends JpaRepository<Proveedor, Integer>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Proveedores (nit,nombre,direccion,nombreContacto,telefonoContacto) VALUES(:nit, :nombre, :direccion, :nombreContacto, :telefonoContacto)", nativeQuery=true)
    void insertarProveedor(@Param("nit")Integer nit,@Param("nombre")String nombre,@Param("direccion")String direccion,@Param("nombreContacto")String nombreContacto, @Param("telefonoContacto")Integer telefonoContacto );

    @Modifying
    @Transactional
    @Query(value = "UPDATE Proveedores SET nombre= :nombre,direccion=:direccion,nombreContacto=:nombreContacto,telefonoContacto=:telefonoContacto WHERE Proveedores.nit=:nit", nativeQuery=true)
    void actualizarProveedor(@Param("nit")Integer nit,@Param("nombre")String nombre,@Param("direccion")String direccion,@Param("nombreContacto")String nombreContacto, @Param("telefonoContacto")Integer telefonoContacto );
    
}
