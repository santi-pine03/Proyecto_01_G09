package uniandes.edu.co.proyecto.controller;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.InfoExtraOrdenHelper;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.modelo.OrdenCompraEspec;
import uniandes.edu.co.proyecto.modelo.OrdenCompraHelper;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
public class OrdenCompraController {
    @Autowired
    private OrdenCompraRepository ordenRepository;

    @Autowired
    private ProductoRepository productoRepository;
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
     public ResponseEntity<String> crearOrdenCompra(@RequestBody OrdenCompraEspec ordenCompraEspec){
         OrdenCompraHelper encabezado = ordenCompraEspec.getEncabezadOrdenCompra();
         List <InfoExtraOrdenHelper> detalle = ordenCompraEspec.getDetalle();    

         try {
            Date fecha = new Date(encabezado.getFecha_entrega().getTime());
            System.out.println(fecha);
            ordenRepository.crearOrdenCompra(fecha , LocalDate.now() ,encabezado.getNit_proveedor(), encabezado.getId_sucusal());
            Integer ordenCompraId = ordenRepository.getUltimaOrdenId2();
            System.out.println(ordenCompraId);
            
                for (int i = 0; i < detalle.size(); i++) {
                    InfoExtraOrdenHelper objeto = detalle.get(i);
                    ordenRepository.agregarDetalleOrden(ordenCompraId, objeto.getCodBarras() , objeto.getCantidad(), objeto.getCostoUnitario());
                }
            
                    return ResponseEntity.ok("Orden de compra creada exitosamente.");
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la orden de compra.");
                }
            }
    }

