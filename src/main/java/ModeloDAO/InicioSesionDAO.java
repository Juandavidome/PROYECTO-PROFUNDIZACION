/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.InicioSesionVO;
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
public class InicioSesionDAO extends ConexionBd implements Crud{
    ConexionBd conec = new ConexionBd();
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    private String id="",contraseña="";
    
    

    public InicioSesionDAO(InicioSesionVO iniVO){
        super();
        try {
            
            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            id = iniVO.getId();
            contraseña = iniVO.getContraseña();
           
            
        } catch (Exception e) {
          Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            
        }
        
    }

       public boolean iniciarSesion(String usuario,String clave)
    {
        try {
            conexion = this.obtenerConexion();
            sql="select id, contraseña from usuarios where id=? and contraseña=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if(mensajero.next())
            {
                operacion=true;
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
        return operacion;
    }
           


    @Override
    public boolean agregarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
