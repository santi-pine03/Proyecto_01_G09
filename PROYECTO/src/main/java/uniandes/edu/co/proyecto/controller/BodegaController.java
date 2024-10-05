package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository.RespuestaInventarioProductosBodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository.RespuestaPorcentajeOcupacionBodega;

@RestController
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/BODEGAS")
    public Collection<Bodega> bodegas(){

        return bodegaRepository.darBodegas();
    }

    @PostMapping("/BODEGAS/new/save")
    public ResponseEntity<String> bodegaGuardar(@RequestBody Bodega bodega){

        try{
            bodegaRepository.insertarBodega(bodega.getNombre(),bodega.getTamaniom2(),bodega.getId_sucursal().getId());
            return new ResponseEntity<>("Bodega creada existosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al crear la Bodega", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
    @GetMapping("/BODEGAS/{id}/delete")
    public ResponseEntity<String> bodegaEliminar(@PathVariable("id") Integer id){

        try{
            bodegaRepository.eliminarBodega(id);
        return new ResponseEntity<>("Bodega eliminida exitosamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al eliminar la Bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    @GetMapping("/BODEGAS/ocupacion")
    public ResponseEntity<?> obtenerPorcentajeOcupacion(@RequestBody List<Producto> productos) {
        try {

        List<Integer> codBarras = new ArrayList<>();

        for (Producto producto : productos) {
            codBarras.add(producto.getCodBarras());
        }
        System.out.println(codBarras);                              
        Collection<RespuestaPorcentajeOcupacionBodega> ocupacion = bodegaRepository.darPorcentajeOcupacionBodega(codBarras);
        List<Map<String, Object>> responseList = new ArrayList<>();
        for (RespuestaPorcentajeOcupacionBodega ocupa : ocupacion) {
            Map<String, Object> response = new HashMap<>();
            response.put("id_producto", ocupa.getID_PRODUCTO());
            response.put("IndiceOcupacion", ocupa.getINDICE_OCUPACION());
            responseList.add(response);
        }
        return ResponseEntity.ok(responseList);
    } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/BODEGAS/inventario")
    public ResponseEntity<?> obtenerInventarioProductosBodega(@RequestBody Bodega bodega){
        try{
            Integer id_bodega = bodega.getId();
            // id_sucursal = sucursal.getId();
            System.out.println(id_bodega); 
            Collection<RespuestaInventarioProductosBodega> inventario = bodegaRepository.darInventarioProductosBodega(id_bodega);
            List<Map<String, Object>> responseList = new ArrayList<>();
            for (RespuestaInventarioProductosBodega inven : inventario) {
                Map<String, Object> response = new HashMap<>();
                response.put("id_producto", inven.getID_PRODUCTO());
                response.put("cantidad_actual", inven.getCANTIDAD_ACTUAL());
                response.put("cantidad_minima", inven.getCANTIDAD_MINIMA());
                response.put("costo_promedio", inven.getCOSTO_PROMEDIO());
                responseList.add(response);
            }
            return ResponseEntity.ok(inventario);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
