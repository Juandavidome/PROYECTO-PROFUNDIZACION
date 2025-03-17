<%-- 
    Document   : RegistrarProducto
    Created on : 16/03/2025, 6:48:57 p. m.
    Author     : juand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Producto</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        h2 {
            font-size: 2em;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            width: 50%;
            margin: 40px auto;
            padding: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        input {
            width: 100%;
            padding: 10px;
            font-size: 1em;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input:focus {
            outline: none;
            border-color: #27ae60;
            box-shadow: 0px 0px 5px rgba(39, 174, 96, 0.5);
        }

        .invalid-feedback {
            font-size: 0.9em;
            color: #e74c3c;
            margin-top: 5px;
        }

        .button {
            text-align: center;
        }

        .button input {
            background-color: #27ae60;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            margin: 10px;
            transition: background-color 0.3s ease;
        }

        .button input:hover {
            background-color: #219150;
        }

        .input-group {
            margin-bottom: 20px;
        }

        .input-group input[type="file"] {
            padding: 5px;
        }
    </style>
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
                </ul>
            </nav>
        </div>
         </header>
         <form method="post" action="ProductoControlador" class="row g-3 needs-validation" novalidate>
           <br>
                <h2 align="center">Registrar Producto</h2>
            
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6" >
                            <input type="number" class="form-control" name="id" placeholder="Id" required>
                            <div class="invalid-feedback">
                                Ingrese un Id
                            </div>

                        </div>
                    </div>
                </div>
                <div class="form-group" >
                    <input type="text" class="form-control" name="nombre" placeholder="Nombre" required>
                    <div class="invalid-feedback">
                        Ingrese un Nombre
                    </div>

                </div>
                <div class="form-group" >
                    <input type="text" class="form-control" name="descripcion" placeholder="Descripcion" required>
                    <div class="invalid-feedback">
                        Ingrese una Descripcion
                    </div>

                </div>
                <div class="form-group" >
                    <input type="number" class="form-control" name="precio" placeholder="Precio" required>
                    <div class="invalid-feedback">
                        Ingrese el Precio
                    </div>

                </div>

                <div class="form-group" >
                    <input type="number" class="form-control" name="stock" placeholder="Cantidad" required>
                    <div class="invalid-feedback">
                        Ingrese la Cantidad
                    </div>

                </div>

                <div class="form-group" >
                    <input type="number" class="form-control" name="categoria" placeholder="Cantidad" required>
                    <div class="invalid-feedback">
                        Ingrese la Categoria
                    </div>
                </div>
                    
                    <br>
                    
                 
                    <div class="input-group mb-4">
                        <input name="imagen" type="file" class="form-control" id="inputGroupFile03" aria-describedby="inputGroupFileAddon03" aria-label="Upload">
                    </div>
                     <div class="invalid-feedback">
                        Inserte una imagen
                    </div>
                  <div class="button" align="center"> 
                      <input type="submit" value="Registrar" >

                      <input type="hidden" name="opcion" value="1">
           
             <%
            if(request.getAttribute("mensajeError")!=null)
            {%>
            ${mensajeError}
            
            <%} else {%>
            ${mensajeExito}
            <%}%>
             </div>
            
        </form> 
    </body>
</html>
