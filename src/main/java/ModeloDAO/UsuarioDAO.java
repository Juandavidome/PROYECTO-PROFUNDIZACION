/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;
import util.Crud;

/**
 *
 * @author juand
 */
public class UsuarioDAO extends ConexionBd implements Crud{
    ConexionBd conec = new ConexionBd();
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    private String id= "", nombre= "", email= "", contraseña= "", telefono= "", cedula = "", rol = "";
    
    public UsuarioDAO(UsuarioVO usuVO){
        super();
        try {
            
            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            id = usuVO.getId();
            nombre = usuVO.getNombre();
            email = usuVO.getEmail();
            contraseña = usuVO.getContraseña();
            telefono = usuVO.getTelefono();
            cedula = usuVO.getId();
            rol = usuVO.getRol();
            
        } catch (Exception e) {
          Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            
        }
        
    }
    @Override
    public boolean agregarRegistro() {
     try {
            sql="INSERT INTO usuarios (nombre, email, contraseña, telefono, id, rol)values(?, ?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            puente.setString(2, email);
            puente.setString(3, contraseña);
            puente.setString(4, telefono);
            puente.setString(5, cedula);
            puente.setString(6, rol);
            puente.executeUpdate();
            operacion = true;
            
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, "Error al agregar registro: ", e);


        } finally{
            try {
                 this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, "Error al agregar registro: ", e);
            }
           
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
         try {
            sql="UPDATE usuarios SET nombre = ?,email = ?, contraseña = ?,telefono = ?, fecha_registro = ? where id = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            puente.setString(2, email);
            puente.setString(3, contraseña);
            puente.setString(4, telefono);
            puente.setString(6,id);
            puente.executeUpdate();
            operacion = true;
            
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);

        } finally{
            try {
                 this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);

            }
           
        }
        return operacion;
    }
    public UsuarioVO consultarPorCedula(String id){
        UsuarioVO usuVO = null;
        
        try {
            conexion = this.obtenerConexion();
            sql= "select * from usuarios where id = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1,id);
            mensajero=puente.executeQuery();
            while(mensajero.next())
            {
             usuVO = new UsuarioVO(id, mensajero.getString(2),mensajero.getString(3), mensajero.getString(4), 
                        mensajero.getString(5), mensajero.getString(6));
            }       

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return usuVO;
    }
    public boolean eliminarRegistro() 
    {    
         try 
         {
             UsuarioVO usuVO= new UsuarioVO();
            conexion = this.obtenerConexion();
            sql = "DELETE usuarios WHERE id = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.executeUpdate();
         }
        catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try {
                 this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
    public boolean actualizarRegistroCliente() {
         try {
            sql="UPDATE usuarios SET nombre = ?, email = ?,contraseña = ?,telefono = ?,fecha_registro = sysdate WHERE id = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            puente.setString(2, email);
            puente.setString(3, contraseña);
            puente.setString(4, telefono);
            puente.setString(6,id);
            puente.executeUpdate();
            operacion = true;
            
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);

        } finally{
            try {
                 this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);

            }
           
        }
        return operacion;
    }
     public ArrayList<UsuarioVO> listar(){
        
        ArrayList<UsuarioVO> lista = new ArrayList<>();
            
        try {
            conexion = this.obtenerConexion();
            sql= "SELECT * FROM usuarios;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while(mensajero.next())
            {
             UsuarioVO usuVO= new UsuarioVO(mensajero.getString(1), mensajero.getString(2),mensajero.getString(3), mensajero.getString(4), 
                        mensajero.getString(5), mensajero.getString(6));
            lista.add(usuVO);
           }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return lista;
    }
}
  