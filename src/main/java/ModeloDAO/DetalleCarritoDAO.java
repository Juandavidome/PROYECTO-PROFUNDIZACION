/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.CarritoVO;
import ModeloVO.DetalleCarritoVO;
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
public class DetalleCarritoDAO extends ConexionBd{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    private String id="", carrito_id="", producto_id="", cantidad = "";
    public DetalleCarritoDAO() {
    }
    public DetalleCarritoDAO(DetalleCarritoVO decaVO)
     {
        super();
        try 
        {
            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            id=decaVO.getId();
            carrito_id = decaVO.getCarritoId();
            producto_id = decaVO.getProductoId();
            cantidad = decaVO.getCantidad();
        } 
        catch (Exception e) 
        {
          Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e); 
        }
     }
    public boolean agregarRegistro() {
        try 
        {
            sql="INSERT INTO detalles_carrito (id, carrito_id, producto_id, cantidad) VALUES (?, ?, ?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.setString(2, carrito_id);
            puente.setString(3, producto_id);
            puente.setString(4, cantidad);
            puente.executeUpdate();
            operacion = true;
        }
        catch (Exception e)
        {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e);
        } 
        finally
        {
            try 
            {
                this.cerrarConexion();
            }
            catch (Exception e) 
            {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
    public boolean actualizarRegistro()
    {
       try
       {
            sql="UPDATE detalles_carrito SET carrito_id = ?, producto_id = ?, cantidad = ? WHERE id = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(4, id);
            puente.setString(1, carrito_id);
            puente.setString(2, producto_id);
            puente.setString(3, cantidad);
            puente.executeUpdate();
            operacion = true;
            
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e);

        } finally{
            try {
                 this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
     public boolean eliminarRegistro() 
    {
        try 
         {
            conexion = this.obtenerConexion();
            sql = "DELETE detalles_carrito WHERE id = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.executeUpdate();
         }
        catch (Exception e) 
        {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try {
                 this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
}
