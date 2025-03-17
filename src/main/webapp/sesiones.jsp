<%-- 
    Document   : sesiones
    Created on : 12/03/2025, 9:45:49 p. m.
    Author     : juand
--%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%
        HttpSession buscarSesion = (HttpSession) request.getSession();
        if (buscarSesion.getAttribute("datosUsuario") != null)
        {
            
            UsuarioVO usuVO = (UsuarioVO) buscarSesion.getAttribute("datosUsuario");
            
        }
        else 
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        %>         
    </head>
    <body>
        <%      
            response.setHeader("Pragma","No-cache");
            response.setHeader("Cache-control","no-cache,no-store,must-revalidate"); 
            if(buscarSesion.getAttribute("datosUsuario") == null)
            {
                response.sendRedirect("index.jsp");
                
            }
    %>
    </body>
</html>
