/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import ModeloDAO.DetalleCarritoDAO;
import ModeloVO.DetalleCarritoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juand
 */
@WebServlet(name = "DetalleCarritoControlador", urlPatterns = {"/DetalleCarritoControlador"})
public class DetalleCarritoControlador extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
        //1.recibir datos vistas 
        String id = request.getParameter("id");
        String carritoId = request.getParameter("carritoId");
        String productoId = request.getParameter("productoId");
        String cantidad = request.getParameter("cantidad");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        DetalleCarritoVO deCaVO = new DetalleCarritoVO(id, carritoId, productoId, cantidad);
 
        DetalleCarritoDAO deCaDAO = new DetalleCarritoDAO(deCaVO);

        
        switch(opcion)
        {
            case 1:
                if(deCaDAO.agregarRegistro())
                {
                    request.setAttribute("mensajeExito", "Detalle carrito registrado correctamente");
                    request.getRequestDispatcher("ConsultarProductoPedido.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mensajeError", "Detalle carrito no registrado correctamente");
                }
                request.getRequestDispatcher("RealizarPedido.jsp").forward(request, response);
            break;
            case 2:
                if(deCaDAO.actualizarRegistro())
                {
                    request.setAttribute("mensajeExito", "Detalle carrito actualizado correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "Detalle carrito no actualizado correctamente");   
                }
                request.getRequestDispatcher("ActualizarPedido.jsp").forward(request, response);
            break;
    }

        }
    }
}
