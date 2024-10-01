package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.EspecificacionesEmpacado;
import uniandes.edu.co.proyecto.repositorio.EspecificacionesEmpacadoRepository;

@RestController
public class EspecificacionesController {

    
    @Autowired
    private EspecificacionesEmpacadoRepository empacadoRepository;

    @PostMapping("/especificacionesempacado/new/save")
    public ResponseEntity<String> empacadoGuardar( @RequestBody EspecificacionesEmpacado empacado){
        try{
            empacadoRepository.crearEspecificaciones(empacado.getVolumen(), empacado.getPeso());
            return new ResponseEntity<>("Especificacion creada exitosamente", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al crear la Especificacion", HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
    
}
