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

import uniandes.edu.co.proyecto.modelo.Bodega;
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

}
