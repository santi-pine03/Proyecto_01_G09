package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.repositorio.RecepcionProductoRepository;
import uniandes.edu.co.proyecto.servicios.RecepcionProductoServicio;

@RestController
public class RecepcionProductoController {

    private static final Logger logger = LoggerFactory.getLogger(RecepcionProductoController.class);

    @Autowired
    private RecepcionProductoRepository RPRepository;
    
    @Autowired
    private RecepcionProductoServicio RPServicio;

    @PostMapping("/recepcionproductos/new/{id_orden}/{id_bodega}/save")
    public ResponseEntity<?> guardarRecepcionProducto(@PathVariable("id_orden") Integer id_orden, @PathVariable("id_bodega") Integer id_bodega){

        try{
            Map<String, Object> Respuesta = RPServicio.Registar_Ingreso_Productos_Bodega(id_orden, id_bodega);
            List<Map<String, String>> responseList = new ArrayList<>();
            Collection<String[]> detalle = (Collection<String[]>) Respuesta.get("detalle");
            OrdenCompra orden = (OrdenCompra) Respuesta.get("encabezado");
            Map<String, String> encabezado = new HashMap<>();
            encabezado.put("Fecha Ingreso", orden.getFechaEntrega().toString());
            encabezado.put("Sucursal", orden.getId_sucursal().getNombre());
            encabezado.put("Bodega", id_bodega.toString());
            encabezado.put("Proveedor", orden.getNit_proveedor().getNombre());
            responseList.add(encabezado);
            for (String[] ocupa : detalle) {
            Map<String, String> response = new HashMap<>();
            response.put("id_producto", ocupa[1]);
            response.put("cantidad", ocupa[2]);
            response.put("precioUnitario", ocupa[3]);
            responseList.add(response);
        }
            return ResponseEntity.ok(responseList);
        }
        catch (Exception e){
            logger.error("Error al crear el Ingreso de productos a bodega: ", e);
            return new ResponseEntity<>("Error al crear el Ingreso de productos a bodega", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping("/recepcionproductos/serializable/{id_sucursal}/{id_bodega}")
    public Map<String, Object> mostrarDocSerializable(@PathVariable("id_sucursal") Integer id_sucursal, @PathVariable("id_bodega") Integer id_bodega){
        return RPServicio.darRegistros(id_sucursal, id_bodega);
    }
    @GetMapping("/recepcionproductos/read/{id_sucursal}/{id_bodega}")
    public Map<String, Object> mostrarDocRead(@PathVariable("id_sucursal") Integer id_sucursal, @PathVariable("id_bodega") Integer id_bodega){
        return RPServicio.darRegistross(id_sucursal, id_bodega);
    }
}