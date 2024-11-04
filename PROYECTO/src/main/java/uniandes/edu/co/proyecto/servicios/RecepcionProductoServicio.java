package uniandes.edu.co.proyecto.servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InfoExtraOrden;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.modelo.RecepcionProducto;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;
import uniandes.edu.co.proyecto.repositorio.RecepcionProductoRepository;

@Service
public class RecepcionProductoServicio {

    private RecepcionProductoRepository RPRepository;
    private OrdenCompraRepository OrdenRepository;
    private BodegaRepository bodegaRepository;

    public RecepcionProductoServicio(RecepcionProductoRepository RPRepository, OrdenCompraRepository OrdenRepository, BodegaRepository bodegaRepository)
    {
        this.RPRepository = RPRepository;
        this.OrdenRepository = OrdenRepository;
        this.bodegaRepository = bodegaRepository;
    }
    
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Map<String, Object> Registar_Ingreso_Productos_Bodega(Integer id_orden, Integer id_bodega) {
            Map<String, Object> response = new HashMap<>();//Mapa que tendra el encabezado y el detalle de la respuesta
            OrdenCompra orden = OrdenRepository.darOrdenCompra(id_orden); // Obtener la orden de compra. 
            System.out.println(orden);      
            RPRepository.insertarRecepcionProducto(orden.getFechaEntrega(),orden.getId(),id_bodega);//Se crea la recepcion de producto de la Orden de Compra
            Collection<Object[]> productosOrden = OrdenRepository.darProductosOrdenCompra(id_orden); //Se obtienen todos los productos de la Orden de Compra
            Collection<String[]> respuesta = new ArrayList<String[]>(); //Esto sera lo que se mostrara como respuesta
            for(Object[] IEorden : productosOrden){
                //Se actualiza la cantidad de existencias y costo promedio en la bodega de los productos de la Orden de Compra
                String nuevo = Arrays.toString(IEorden);
                String sinCorchetes = nuevo.substring(1, nuevo.length() - 1); // Eliminar los corchetes
                String[] elementos = sinCorchetes.split(", ");
                respuesta.add(elementos); // Se añaden los productos de la orden de compra a la respuesta para mostrarlos
                bodegaRepository.actualizarCostoPromedioYCantExistencias(Integer.parseInt(elementos[3]), Integer.parseInt(elementos[2]), Integer.parseInt(elementos[1]), id_bodega);
            }
            OrdenRepository.ordenCompraEntregada(id_orden);//Se actualiza la Orden de Compra como ENTREGADA
            response.put("encabezado", orden);
            response.put("detalle", respuesta);

            return response;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Map<String, Object> darRegistros(Integer id_sucursal, Integer id_bodega) throws InterruptedException{
        Map<String, Object> response = new HashMap<>();
        response.put("nombreSucursal", bodegaRepository.darBodega(id_bodega).getId_sucursal().getNombre());
        response.put("nombreBodega", bodegaRepository.darBodega(id_bodega).getNombre());
        Thread.sleep(30000);
        response.put("RecepcionProductos:", RPRepository.darDocumentos(id_bodega));


        return response;

    }
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Map<String, Object> darRegistross(Integer id_sucursal, Integer id_bodega) throws InterruptedException{
        
        Map<String, Object> response = new HashMap<>();
        response.put("nombreSucursal", bodegaRepository.darBodega(id_bodega).getId_sucursal().getNombre());
        response.put("nombreBodega", bodegaRepository.darBodega(id_bodega).getNombre());
        Thread.sleep(30000);
        response.put("RecepcionProductos:", RPRepository.darDocumentos(id_bodega));


        return response;

    }

}
