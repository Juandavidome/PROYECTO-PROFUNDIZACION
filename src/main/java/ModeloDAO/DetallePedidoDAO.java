/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.DetallePedidoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;

/**
 *
 * @author juand
 */
public class DetallePedidoDAO extends ConexionBd{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    private String id="", pedido_id="", producto_id="", cantidad="", precio="";
     public DetallePedidoDAO() {
    }
     public DetallePedidoDAO(DetallePedidoVO DePeVO)
     {
        super();
        try 
        {
            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            id = DePeVO.getId();
            pedido_id = DePeVO.getPedidoId();
            producto_id = DePeVO.getProductoId();
            cantidad = DePeVO.getCantidad();
            precio= DePeVO.getPrecio();
        } 
        catch (Exception e) 
        {
          Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e); 
        }
    }
       public boolean agregarRegistro() 
    {
        try 
        {
            sql="INSERT INTO pedidos (id, pedido_id, producto_id, cantidad, precio) VALUES (?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.setString(2, pedido_id);
            puente.setString(3, producto_id);
            puente.setString(4, cantidad);
            puente.setString(5, precio);
            puente.executeUpdate();
            operacion = true;
        }
        catch (Exception e)
        {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
        } 
        finally
        {
            try 
            {
                this.cerrarConexion();
            }
            catch (Exception e) 
            {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
}
