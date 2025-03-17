/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;
import ModeloDAO.InicioSesionDAO;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.InicioSesionVO;
import ModeloVO.RolVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juand
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //1.recibir datos vistas 
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String contraseña = request.getParameter("contra");
            String telefono = request.getParameter("telefono");
            String rol = request.getParameter("rol");
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            System.out.println("Contraseña: " + contraseña);

            UsuarioVO usuVO = new UsuarioVO(id, nombre, email, contraseña, telefono, rol);
            InicioSesionVO iniVO = new InicioSesionVO(id, contraseña);
            InicioSesionDAO iniDAO = new InicioSesionDAO(iniVO);

            UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

            switch (opcion) {
                case 1:
                    if (usuDAO.agregarRegistro()) {
                        request.setAttribute("mensajeExito", "Usuario registrado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Usuario no registrado correctamente");
                    }
                    request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                    break;
                case 2:
                    if (usuDAO.actualizarRegistro()) {
                        request.setAttribute("mensajeExito", "Usuario actualizado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Usuario no actualizado correctamente");

                    }
                    request.getRequestDispatcher("ActualizarUsu.jsp").forward(request, response);
                    break;
                case 3:
                    usuVO = usuDAO.consultarPorCedula(id);
                    if (usuVO != null) {
                        request.setAttribute("¡El usuario encontrado!", usuVO);
                        request.getRequestDispatcher("ActualizarUsu.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensajeError", "El usuario no ha sido encontrado!");
                        request.getRequestDispatcher("ConsultarUsu.jsp").forward(request, response);
                    }
                    break;
                 case 4:
                    if (
                            
                        iniDAO.iniciarSesion(id, contraseña)) {
                        HttpSession miSesion = request.getSession(true);
                        usuVO = usuDAO.consultarPorCedula(id);
                        miSesion.setAttribute("datosUsuario", usuVO);
                        String idUsuario = usuVO.getId();
                        RolDAO rolDAO = new RolDAO();
                        RolVO rolVO = new RolVO();
                        ArrayList <RolVO> listaRoles = rolDAO.Iniciar(idUsuario);
                        for(int i=0; i<listaRoles.size(); i++)
                        {
                            rolVO = listaRoles.get(i);
                            if(listaRoles.size()>1)
                            {
                                request.getRequestDispatcher("Index.jsp").forward(request, response);
                            }
                            if(rolVO.getRolId().equals("2"))
                            {
                                request.getRequestDispatcher("Administrador.jsp").forward(request, response);
                            }
                            if(rolVO.getRolId().equals("3"))
                            {
                                request.getRequestDispatcher("PersonalDeVentas.jsp").forward(request, response);
                            }
                            if(rolVO.getRolId().equals("1"))
                            {
                                request.getRequestDispatcher("productos.jsp").forward(request, response);
                            }
                        }
                    }
                    break;
                case 5:
                    if (usuDAO.agregarRegistro()) {
                        request.setAttribute("mensajeExito", "Usuario registrado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Usuario no registrado correctamente");

                    }
                    request.getRequestDispatcher("RegistrarCliente.jsp").forward(request, response);
                    break;
                case 8:
                    usuVO = usuDAO.consultarPorCedula(id);
                    if (usuVO != null) {
                        request.setAttribute("¡Cliente encontrado!", usuVO);
                        request.getRequestDispatcher("ActualizarCli.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensajeError", "Cliente no encontrado");

                    }
                    request.getRequestDispatcher("Cliente.jsp").forward(request, response);
                    break;
                case 9:
                    if (usuDAO.actualizarRegistro()) {
                        request.setAttribute("mensajeExito", "Usuario actualizado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Usuario no actualizado correctamente");

                    }
                    request.getRequestDispatcher("ActualizarCli.jsp").forward(request, response);
                    break;
                case 10:
                    if (usuDAO.actualizarRegistroCliente()) {
                        request.setAttribute("mensajeExito", "Usuario actualizado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Usuario no actualizado correctamente");

                    }
                    request.getRequestDispatcher("ActualizarCli.jsp").forward(request, response);
                    break;
                case 11:
                    usuVO = usuDAO.consultarPorCedula(id);
                    if (usuVO != null) {
                        request.setAttribute("¡Cliente encontrado!", usuVO);
                        request.getRequestDispatcher("RealizarPedido.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensajeError", "Cliente no encontrado");

                    }
                    request.getRequestDispatcher("Cliente.jsp").forward(request, response);
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String listar = "Usuario.jsp";
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
