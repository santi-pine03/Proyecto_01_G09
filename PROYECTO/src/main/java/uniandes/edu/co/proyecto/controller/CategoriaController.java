package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public Collection<Categoria> categorias(){
        return categoriaRepository.darCategorias();
    }
    @GetMapping("/categorias/consulta")
    public ResponseEntity<?> categoriaConsultaCodigo(@RequestParam(required = false) Integer codigo, @RequestParam(required = false) String nombre){
        try{
            if(codigo != null){
            Categoria categoria = categoriaRepository.darCategoriaPorCodigo(codigo);
            return ResponseEntity.ok(categoria);
            }
            else if(nombre != null){
                Categoria categoria = categoriaRepository.darCategoriaPorNombre(nombre);
            return ResponseEntity.ok(categoria);
            }else return ResponseEntity.ok(categoriaRepository.darCategorias());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @PostMapping("/categorias/new/save")
    public ResponseEntity<String> categoriaGuardar(@RequestBody Categoria categoria){

        try{
            categoriaRepository.insertarCategoria(categoria.getNombre(),categoria.getDescripcion(),categoria.getCaracteristicasAlmacenamiento());
            return new ResponseEntity<>("Categoria creada existosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al crear la Categoria", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    
}
