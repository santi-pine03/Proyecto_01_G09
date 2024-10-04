package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;


@RestController
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping("/productos/new/save")    
    public ResponseEntity<String> guardarProducto( @RequestBody Producto producto){

        try {
            productoRepository.insertarProducto(producto.getNombre(), producto.getPrecioUnitarioVenta(), producto.getPresentacion(), producto.getCantidadPresentacio(), producto.getUnidadMedia(), producto.getFechaExpiracion(), producto.getid_expecificacionesEmpacado().getId(), producto.getId_categoria().getCodigo()) ;
            return ResponseEntity.ok("Producto guardado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al guardar el producto" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/productos/{codBarras}/edit/save")    
    public ResponseEntity<String> editarProducto( @PathVariable("codBarras") Integer codBarras,@RequestBody Producto producto){
        try {
            productoRepository.actualizarProducto(codBarras,producto.getNombre(), producto.getPrecioUnitarioVenta(), producto.getPresentacion(), producto.getCantidadPresentacio(), producto.getUnidadMedia(), producto.getFechaExpiracion(), producto.getid_expecificacionesEmpacado().getId(), producto.getId_categoria().getCodigo()) ;
            return ResponseEntity.ok("Producto actualizado exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/consulta/codBarras")
    public ResponseEntity<?> darProductoId(@RequestParam Integer codBarras) {
        try {
            Object[] producto = productoRepository.darProductoId(codBarras);
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al consultar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/productos/consulta/nombre")
    public ResponseEntity<?> darProductoNombre(@RequestParam String nombre) {
        try {
            Object[] producto = productoRepository.darProductoNombre(nombre);
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al consultar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/consulta")
    public ResponseEntity<?> consultarProductos(
            @RequestParam(required = false) Integer precio_in,
            @RequestParam(required = false) Integer precio_ma,
            @RequestParam(required = false) Integer fechaMenor,
            @RequestParam(required = false) Integer fechaMayor,
            @RequestParam(required = false) Integer id_sucursal,
            @RequestParam(required = false) Integer id_categoria) {
        
        Collection<Producto> productos;

        try {
            // Inicializa una lista para almacenar los productos que cumplen las condiciones
            productos = new ArrayList<>();

            // Verifica y aplica cada criterio de búsqueda
            if (precio_in != null && precio_ma != null) {
                productos.addAll(productoRepository.productoPrecio(precio_in, precio_ma));
            }

            if (fechaMenor != null) {
                productos.addAll(productoRepository.productofechaMenor(fechaMenor));
            }

            if (fechaMayor != null) {
                productos.addAll(productoRepository.productofechaMayor(fechaMayor));
            }

            if (id_sucursal != null) {
                productos.addAll(productoRepository.productoSucursal(id_sucursal));
            }
             if (id_categoria != null) {
                productos.addAll(productoRepository.productoCategoria(id_categoria));
            }

            // Eliminar duplicados, si es necesario
            //productos = productos.stream().distinct().collect(Collectors.toList());

            if (productos.isEmpty()) {
                return new ResponseEntity<>("No se encontraron productos que cumplan con los criterios", HttpStatus.NOT_FOUND);
            }

            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al consultar los productos"+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }












}
