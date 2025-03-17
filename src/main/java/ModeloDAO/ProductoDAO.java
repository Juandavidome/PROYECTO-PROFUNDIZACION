/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.ProductoVO;
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
public class ProductoDAO extends ConexionBd implements Crud{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    private String  id = "",nombre = "", descripcion = "", precio = "",stock = "",imagen = "", categoria="";
    
    public ProductoDAO() {
    }
     public ProductoDAO(ProductoVO proVO)
     {
        super();
        try 
        {
            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            id=proVO.getId();
            nombre = proVO.getNombre();
            descripcion = proVO.getDescripcion();
            precio = proVO.getPrecio();
            stock = proVO.getStock();
            imagen = proVO.getImagen();
            categoria = proVO.getCategoria();
        } 
        catch (Exception e) 
        {
          Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e); 
        }
    }

    @Override
    public boolean agregarRegistro() {
       try 
        {
            sql="INSERT INTO productos (id, nombre, descripcion, precio, stock, imagen, categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.setString(2, nombre);
            puente.setString(3, descripcion);
            puente.setString(4, precio);
            puente.setString(5, stock);
            puente.setString(6, imagen);
            puente.setString(7, categoria);
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

    @Override
    public boolean actualizarRegistro() {
        try
       {
            sql="UPDATE productos SET nombre, descripcion, precio, stock, imagen, categoria WHERE id = ?;";
            puente.setString(1, nombre);
            puente.setString(2, descripcion);
            puente.setString(3, precio);
            puente.setString(4, stock);
            puente.setString(5, imagen);
            puente.setString(6, categoria);
            puente.setString(7, id);
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
            sql = "DELETE productos WHERE id = ?;";
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
    public ProductoVO consultarPorId(String ProId){
        ProductoVO proVO = null;
        
        try {
            conexion = this.obtenerConexion();
            sql= "select * from productos where id = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1,ProId);
            mensajero=puente.executeQuery();
            while(mensajero.next())
            {
             proVO = new ProductoVO(id, mensajero.getString(2),mensajero.getString(3), mensajero.getString(4), 
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));
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
        return proVO;
    }
    public ArrayList<ProductoVO> listar(){
        
        ArrayList<ProductoVO> lista = new ArrayList<>();
            
        try {
            conexion = this.obtenerConexion();
            sql= "select * from productos";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while(mensajero.next())
            {
             ProductoVO usuVO= new ProductoVO(mensajero.getString(1), mensajero.getString(2),mensajero.getString(3), mensajero.getString(4), 
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));
            lista.add(usuVO);
           }
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return lista;
    }
}
