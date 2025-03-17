/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVO;

/**
 *
 * @author juand
 */
public class DetalleCarritoVO {
     private String id, carritoId, productoId, cantidad;
     
     public DetalleCarritoVO ()
     {}

    public DetalleCarritoVO(String id, String carritoId, String productoId, String cantidad) {
        this.id = id;
        this.carritoId = carritoId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(String carritoId) {
        this.carritoId = carritoId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
     
     
}
