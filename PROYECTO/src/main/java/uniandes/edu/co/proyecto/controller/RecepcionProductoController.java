package uniandes.edu.co.proyecto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository.RespuestaPorcentajeOcupacionBodega;
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
            Collection<String[]> Respuesta = RPServicio.Registar_Ingreso_Productos_Bodega(id_orden, id_bodega);
            List<Map<String, String>> responseList = new ArrayList<>();
            for (String[] ocupa : Respuesta) {
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

}