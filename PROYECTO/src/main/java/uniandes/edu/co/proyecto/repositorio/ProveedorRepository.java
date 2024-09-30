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
    @Query(value = "INSERT INTO Proveedores (nit,nombre,direccion,nombreContacto,telefonoContacto) VALUES(nitproveedores.nextval, :nombre, :direccion, :nombreContacto, :telefonoContacto)", nativeQuery=true)
    void insertarProveedor(@Param("nombre")String nombre,@Param("direccion")String direccion,@Param("nombreContacto")String nombreContacto, @Param("telefonoContacto")Integer telefonoContacto );

    @Modifying
    @Transactional
    @Query(value = "UPDATE Proveedores SET nombre= :nombre,direccion=:direccion,nombreContacto=:nombreContacto,telefonoContacto=:telefonoContacto WHERE id=:id", nativeQuery=true)
    void actualizarProveedor(@Param("id")Integer id,@Param("nombre")String nombre,@Param("direccion")String direccion,@Param("nombreContacto")String nombreContacto, @Param("telefonoContacto")Integer telefonoContacto );
    
}
