<%-- 
    Document   : registrarUsuario
    Created on : 15/03/2025, 7:12:28 p. m.
    Author     : juand
--%>
<%@page import="ModeloVO.RolVO"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="util.ConexionBd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <header>
        <div class="menu container">
            <a href="#" class="logo">Logo</a>
            <input type="checkbox" id="menu">
            <label for="menu">
                <img src="images/menu.png" class="menu-icono" aria-label="menu">
            </label>
            <nav class="navbar">
                <ul>
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="#">Productos</a></li>
                    <li><a href="iniciarSesion.jsp">Iniciar Sesion</a></li>
                    <li><a href="registrarUsuario.jsp">Registrar Usuario</a></li>
                </ul>
            </nav>
            <div>
                <ul>
                    <li class="submenu">
                       <img src="images/car.svg" id="img-carrito" aria-label="carrito">
                       <div id="carrito">
                        <table id="lista-carrito">
                            <thead>
                                <tr>
                                    <th>Imagen</th>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                        <a href="#" id="vaciar" class="btn-2">Vaciar Carrito</a>
                       </div>
                    </li>
                </ul>
            </div>
        </div>
         </header>
         <div class="container">
            <form  class="row g-3 needs-validation" novalidate align="center" method="post" action="UsuarioControlador">
                <br>
                <br>
                <br>
                <br>
                <br>
                <h2 align="center">Registrarse</h2>
                <p>Crea tu cuenta solo tomara un minuto</p>
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6" >
                            <input type="text" class="form-control" name="nombre" placeholder="Nombre" required>
                            <div class="invalid-feedback">
                                Ingrese su nombre
                            </div>

                        </div>
                    </div>
                </div>
                <div class="form-group" >
                    <input type="number" class="form-control" name="telefono" placeholder="Telefono" required>
                    <div class="invalid-feedback">
                        Ingrese su número telefonico
                    </div>

                </div>

                <div class="form-group" >
                    <input type="email" class="form-control" name="email" placeholder="Correo Electronico" required>
                    <div class="invalid-feedback">
                        Ingrese su correo electronico
                    </div>

                </div>
                <div class="form-group" >
                    <input type="number" class="form-control" name="id" placeholder="Cedula" required>
                    <div class="invalid-feedback">
                        Ingrese su cedula
                    </div>

                </div>
                <div class="form-group">
                    <input type="password" id="password" class="form-control" name="contra" placeholder="Contraseña" required>
                    <div class="invalid-feedback">
                        Ingrese una contraseña
                    </div><br>

                    <div class="button1">
                        <input type="button" value="MostrarContraseña" onclick="mostrarContrasena()" class="btn btn-outline-dark">
                    </div>
                </div>
                <select name="rol"  class="form-select" aria-label="Default select example">
                        <option>Seleccione un Rol...</option>
                        <%
                            RolDAO rolDAO = new RolDAO();
                            for (RolVO rolVO : rolDAO.listar()) {
                        %>
                        <option value="<%=rolVO.getRolId()%>"><%=rolVO.getRolTipo()%></option>
                        <%}%>
                    </select>
                      <div class="invalid-feedback">
                        Ingrese una un rol
                    </div>
                    <br>
                    <br>
                    <div class="button"> 
                <input type="submit" value="Registrar" >
              
                <input type="hidden" name="opcion" value="1">
                <%
                    if (request.getAttribute("mensajeError") != null) {%>
                    ${mensajeError}

                    <%} else {%>
                    ${mensajeExito}
                    <%}%>
                    </div>
                    </div>
            </form>
                    <footer class="footer">
        <div class="footer-content container">
            <div class="link">
                <h3>CONTACTO Bogota-Colombia</h3>
                <ul>
                    <li><a href="#">Cra 30 Numero 30A-231</a></li>
                    <li><a href="#">Bogota-Colombia</a></li>
                    <li><a href="#">Numero: +57 3044127844</a></li>
                    <li><a href="#">Persona a contactar: <br> Juan David Ome</a></li>
                </ul>
            </div>
            <div class="link">
                <h3>CONTACTO Medellin-Colombia</h3>
                <ul>
                    <li><a href="#">Calle 51 No. 45 - 57</a></li>
                    <li><a href="#">Medellin-Colombia</a></li>
                    <li><a href="#">Numero: +57 4-4447110</a></li>
                    <li><a href="#">Persona a contactar: <br> Juan David Ome</a></li>
                </ul>
            </div>
        </div>
    </footer>
                    <script>
                        function mostrarContrasena() {
    var passwordInput = document.getElementById("password");
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
    } else {
        passwordInput.type = "password";
    }
}
                    </script>
    </body>
</html>
