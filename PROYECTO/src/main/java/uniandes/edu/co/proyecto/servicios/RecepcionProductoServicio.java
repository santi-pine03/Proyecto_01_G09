package uniandes.edu.co.proyecto.servicios;

import java.util.Collection;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InfoExtraOrden;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
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
    public void Registar_Ingreso_Productos_Bodega(Integer id_orden, Integer id_bodega) {
            OrdenCompra orden = OrdenRepository.darOrdenCompra(id_orden); // Obtener la orden de compra. 
            System.out.println(orden);      
            RPRepository.insertarRecepcionProducto(orden.getFechaEntrega(),orden.getId(),id_bodega);//Se crea la recepcion de producto de la Orden de Compra
            Collection<InfoExtraOrden> productosOrden = OrdenRepository.darProductosOrdenCompra(id_orden); //Se obtienen todos los productos de la Orden de Compra
            for(InfoExtraOrden IEorden : productosOrden){
                //Se actualiza la cantidad de existencias y costo promedio en la bodega de los productos de la Orden de Compra
                bodegaRepository.actualizarCostoPromedioYCantExistencias(IEorden.getCostoUnitarioCompra(), IEorden.getCantidad(), IEorden.getPk_infoOrden().getId_producto().getCodBarras(), id_bodega);
            }
            OrdenRepository.ordenCompraEntregada(id_orden);//Se actualiza la Orden de Compra como ENTREGADA
    }
}
