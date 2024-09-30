package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;

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
            bodegaRepository.insertarBodega(bodega.getNombre(),bodega.getTamaniom2(),bodega.getId_sucursal());
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
    public ResponseEntity<Collection<Collection<Object>>> obtenerPorcentajeOcupacion(@RequestBody List<Producto> productos) {
        try {

        List<Integer> codBarras = new ArrayList<>();

        for (Producto producto : productos) {
            codBarras.add(producto.getCodigoBarras());
        }
        System.out.println(codBarras);                              
        Collection<Collection<Object>> ocupacion = bodegaRepository.darPorcentajeOcupacionBodega(codBarras);
        System.out.println(codBarras);
        return ResponseEntity.ok(ocupacion);
    } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/BODEGAS/inventario")
    public ResponseEntity<Collection<Collection<Object>>> obtenerInventarioProductosBodega(@RequestBody Bodega bodega){
        try{
            Integer id_bodega = bodega.getId();
            System.out.println(id_bodega); 
            Collection<Collection<Object>> inventario = bodegaRepository.darInventarioProductosBodega(id_bodega);
            return ResponseEntity.ok(inventario);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
