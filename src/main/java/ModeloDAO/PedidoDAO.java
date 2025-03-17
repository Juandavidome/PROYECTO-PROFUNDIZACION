/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.PedidoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;

/**
 *
 * @author juand
 */
public class PedidoDAO extends ConexionBd{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    private String id="", usuario_id="", fecha="", estado="", total="";
    
    public PedidoDAO() {
    }
    
     public PedidoDAO(PedidoVO peVO)
     {
        super();
        try 
        {
            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            id = peVO.getId();
            usuario_id = peVO.getUsuarioId();
            fecha = peVO.getFecha();
            estado = peVO.getEstado();
            total= peVO.getEstado();
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
            sql="INSERT INTO pedidos (id, usuario_id, fecha, estado, total) VALUES (?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.setString(2, usuario_id);
            puente.setString(3, fecha);
            puente.setString(4, estado);
            puente.setString(5, total);
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
    public boolean actualizarRegistro()
    {
       try
       {
            sql="UPDATE pedidos SET usuario_id = ?, fecha = ?,estado = ?,total = ? WHERE id = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(5, id);
            puente.setString(1, usuario_id);
            puente.setString(2, fecha);
            puente.setString(3, estado);
            puente.setString(4, total);
            puente.executeUpdate();
            operacion = true;
            
        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);

        } finally{
            try {
                 this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
    public ArrayList<PedidoVO> listar(){
        
        ArrayList<PedidoVO> lista = new ArrayList<>();
            
        try {
            conexion = this.obtenerConexion();
            sql= "select * from tblpedido";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while(mensajero.next())
            {
             PedidoVO peVO= new PedidoVO(mensajero.getString(1), mensajero.getString(2),mensajero.getString(3), mensajero.getString(4),mensajero.getString(5));
            lista.add(peVO);
           }
        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return lista;
    }
    
}
