package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.ProveedorRepository;

@RestController
public class ProveedorController {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @PostMapping("/proveedores/new/save")    
    public ResponseEntity<String> guardarProveedor( @RequestBody Proveedor proveedor){
        try {
            proveedorRepository.insertarProveedor(proveedor.getNombre(), proveedor.getDireccion(), proveedor.getNombreContacto(), proveedor.getTelefonoContacto());
            return ResponseEntity.ok("Proveedor guardado exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/proveedores/{id}/edit/save")    
    public ResponseEntity<String> proveedorEditGuardar(@PathVariable("id") Integer id, @RequestBody Proveedor proveedor){
        try {
            proveedorRepository.actualizarProveedor(id, proveedor.getNombre(), proveedor.getDireccion(), proveedor.getNombreContacto(), proveedor.getTelefonoContacto() );
            return ResponseEntity.ok("Proveedor actualizado exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar el proveedor ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
