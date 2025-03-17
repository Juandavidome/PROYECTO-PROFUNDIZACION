/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import ModeloDAO.DetallePedidoDAO;
import ModeloVO.DetallePedidoVO;
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
@WebServlet(name = "DetallePedidoControlador", urlPatterns = {"/DetallePedidoControlador"})
public class DetallePedidoControlador extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
        //1.recibir datos vistas 
        String id = request.getParameter("DetId");
        String pedidoId = request.getParameter("DetPrecio");
        String ProductoId = request.getParameter("DetCantidad");
        String cantidad = request.getParameter("DetPrecioTotal");
        String precio = request.getParameter("DetPedido");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        DetallePedidoVO detpeVO = new DetallePedidoVO(id, pedidoId, ProductoId, cantidad, precio);
 
        DetallePedidoDAO depeDAO = new DetallePedidoDAO(detpeVO);

        
        switch(opcion)
        {
            case 1:
                if(depeDAO.agregarRegistro())
                {
                    request.setAttribute("mensajeExito", "Detalle Del Pedido registrado correctamente");
                    request.getRequestDispatcher("ConsultarProductoPedido.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mensajeError", "Detalle Del Pedido no registrado correctamente");
                }
                request.getRequestDispatcher("RealizarPedido.jsp").forward(request, response);
            break;
        }
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
