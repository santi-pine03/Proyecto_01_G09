package uniandes.edu.co.proyecto.controller;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.InfoExtraOrden;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;


@RestController
public class OrdenCompraController {
    @Autowired
    private OrdenCompraRepository ordenRepository;
    /* @Autowired 
    private InfoExtraOrden infoExtraOrden;

    @Autowired 
    private OrdenCompra ordenCompra; */
    @PostMapping("/ordencompras/{id}/edit/save")    
    public ResponseEntity<String> ordeneditGuardar(@PathVariable("id") Integer id, @RequestBody OrdenCompra ordencompra) {
        try {
            ordenRepository.actualizarOrdenCompra(
                id );
            return ResponseEntity.ok("Orden de compra actualizada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/ordencompras")
    public ResponseEntity<?> necesitaOrden() {
        try {
            Collection<Object[]> productos = ordenRepository.darOrdenes();
            if (!productos.isEmpty()) {
                return ResponseEntity.ok(productos);
            } else {
                return new ResponseEntity<>("No hay orden de compras", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las ordenes de compra "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     @PostMapping("/ordenesCompra/new/save")
     public ResponseEntity<String> crearOrdenCompra(
             @RequestParam("fechaEntrega") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEntrega,
             @RequestParam("idProveedor") Proveedor idProveedor,
             @RequestParam("idSucursal") Sucursal idSucursal, 
             @RequestBody List<InfoExtraOrden> infoExtraOrden) {

                try {
                    ordenRepository.crearOrdenCompra(fechaEntrega, idProveedor, idSucursal);
                    Integer idOrden = ordenRepository.getUltimaOrdenId();
        
                    for (InfoExtraOrden detalle : infoExtraOrden) {
                        ordenRepository.agregarDetalleOrden(
                            idOrden, 
                            detalle.getPk_infoOrden(),
                            detalle.getCantidad(), 
                            detalle.getCostoUnitarioCompra());
                    } 
                   
                    return ResponseEntity.ok("Orden de compra creada exitosamente.");
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la orden de compra.");
                }
            }
    }

