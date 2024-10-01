package uniandes.edu.co.proyecto.controller;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SucursalController {
 @Autowired
    private SucursalRepository sucursalRepository;

    @PostMapping("/sucursales/new/save")
    public ResponseEntity<String> sucursalGuardar( @RequestBody Sucursal sucursal){
        try{
            sucursalRepository.crearSucursal(sucursal.getId(), sucursal.getTamanioM2(), sucursal.getDireccion(), sucursal.getTelefono(), sucursal.getId_ciudad());
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al crear la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    @GetMapping("/sucursal/consulta/producto")
    public ResponseEntity<?> darScurusalesProductoDisponible(@RequestParam Integer producto_id, @RequestParam String nombre) {
        try {
             List<Sucursal> sucursales = sucursalRepository.findSucursalesConProductoDisponible(producto_id, nombre);
            if (sucursales != null) {
                return ResponseEntity.ok(sucursales);
            } else {
                return new ResponseEntity<>("Sucursales con producto dado no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al consultar el producto en la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
