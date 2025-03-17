/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import ModeloDAO.ProductoDAO;
import ModeloVO.ProductoVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juand
 */
@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet{
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        //1.recibir datos vistas 
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precio = request.getParameter("precio");
        String stock = request.getParameter("stock");
        String imagen = request.getParameter("imagen");
        String categoria = request.getParameter("categoria");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        ProductoVO proVO = new ProductoVO(id, nombre, descripcion, precio, stock, imagen, categoria);
 
        ProductoDAO proDAO = new ProductoDAO(proVO);

        
        switch(opcion)
        {
            case 1:
                if(proDAO.agregarRegistro())
                {
                    request.setAttribute("mensajeExito", "Producto registrado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "Producto no registrado correctamente");
                }
                request.getRequestDispatcher("RegistrarProducto.jsp").forward(request, response);
            break;
            case 2:
                if(proDAO.actualizarRegistro())
                {
                    request.setAttribute("mensajeExito", "Producto actualizado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "Producto no actualizado correctamente");   
                }
                request.getRequestDispatcher("ActualizarProducto.jsp").forward(request, response);
            break;
            case 3:
                proVO = proDAO.consultarPorId(id);
                if (proVO != null){
                 request.setAttribute("¡El producto encontrado!", proVO);
                 request.getRequestDispatcher("ActualizarProducto.jsp").forward(request, response);
                }else{
                request.setAttribute("mensajeError", "El producto no ha sido encontrado!");
                request.getRequestDispatcher("ConsultarProducto.jsp").forward(request, response);
                }
                break;
            case 4:
                if(proDAO.eliminarRegistro())
                {
                    request.setAttribute("mensajeExito", "Producto no inactivado correctamente");
                    request.getRequestDispatcher("ConsultarProducto.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mensajeError", "Producto inactivado correctamente");
                    request.getRequestDispatcher("ConsultarProducto.jsp").forward(request, response);
                }
            break;
              case 5:
                proVO = proDAO.consultarPorId(id);
                if (proVO != null){
                 request.setAttribute("¡El producto encontrado!", proVO);
                 request.getRequestDispatcher("RealizarDetallePedido.jsp").forward(request, response);
                }else{
                request.setAttribute("mensajeError", "¡El producto no ha sido encontrado!");
                request.getRequestDispatcher("ConsultarProductoPedido.jsp").forward(request, response);
                }
                break;
        } 
    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
