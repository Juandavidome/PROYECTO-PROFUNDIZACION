/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.CarritoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;
import util.Crud;

/**
 *
 * @author juand
 */
public class CarritoDAO extends ConexionBd{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    private String id="", usuario_id="";
    public CarritoDAO() {
    }
     
     public CarritoDAO(CarritoVO caVO)
     {
        super();
        try 
        {
            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            id=caVO.getId();
            usuario_id = caVO.getUsuarioId();
            
        } 
        catch (Exception e) 
        {
          Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e); 
        }
    }

    public boolean agregarRegistro() {
        try 
        {
            sql="INSERT INTO carrito (id, usuario_id) VALUES (?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.setString(2, usuario_id);
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
    public boolean eliminarRegistro() 
    {
        try 
         {
            conexion = this.obtenerConexion();
            sql = "DELETE carrito WHERE id = ?;";
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
