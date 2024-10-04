package uniandes.edu.co.proyecto.controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;


@RestController
public class OrdenCompraController {
    @Autowired
    private OrdenCompraRepository ordenRespository;


    @PostMapping("/ordencompras/{id}/edit/save")    
    public ResponseEntity<String> ordeneditGuardar(@PathVariable("id") Integer id, @RequestBody OrdenCompra ordencompra) {
        try {
            ordenRespository.actualizarOrdenCompra(
                id );
            return ResponseEntity.ok("Orden de compra actualizada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/ordencompras")
    public ResponseEntity<?> necesitaOrden() {
        try {
            Collection<Object[]> productos = ordenRespository.darOrdenes();
            if (!productos.isEmpty()) {
                return ResponseEntity.ok(productos);
            } else {
                return new ResponseEntity<>("No hay orden de compras", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las ordenes de compra "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
