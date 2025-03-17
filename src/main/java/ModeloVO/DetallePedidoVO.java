/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVO;

/**
 *
 * @author juand
 */
public class DetallePedidoVO {
    private String id, pedidoId, ProductoId, cantidad, precio;
    
    public DetallePedidoVO() {
    }

    public DetallePedidoVO(String id, String pedidoId, String ProductoId, String cantidad, String precio) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.ProductoId = ProductoId;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getProductoId() {
        return ProductoId;
    }

    public void setProductoId(String ProductoId) {
        this.ProductoId = ProductoId;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    
}
