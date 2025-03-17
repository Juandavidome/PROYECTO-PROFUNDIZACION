<%-- 
    Document   : iniciarSesion
    Created on : 14/03/2025, 10:02:16 p. m.
    Author     : juand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IniciarSesion</title>
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
         <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
        <main>
        <div class="container">
          <div class="row">
            <form align="center" method="post" action="UsuarioControlador" class="needs-validation" novalidate>
                 <h2 align="center">Iniciar Sesion</h2>

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
                    
                       <div class="button1" > 
                <input type="button" value="MostrarContraseña" onclick="mostrarContrasena()" class="btn btn-outline-dark">
                       </div>
                    
            </div>
                </div>
                <div class="button" align="center"> 
                <input type="submit" value="Iniciar Sesion" >
                <input type="hidden" name="opcion" value="4">
                    <%
                        if (request.getAttribute("mensajeError") != null) {%>
                    ${mensajeError}

                    <%} else {%>
                    ${mensajeExito}
                    <%}%>
                </div>
         </form>  
        </div>
        </main>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
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
    <script src="js/scrip.js"></script>
    </body>
</html>
