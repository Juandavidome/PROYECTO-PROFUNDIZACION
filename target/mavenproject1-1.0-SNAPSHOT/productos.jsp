<%-- 
    Document   : productos
    Created on : 15/03/2025, 8:39:37 p. m.
    Author     : juand
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="ModeloVO.ProductoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
        /* Estilos CSS */
        .container {
            background-color: #f9f9f9;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
        }

        .titlepage h2 {
            font-family: 'Arial', sans-serif;
            font-size: 2.5em;
            font-weight: bold;
            text-align: center;
            color: #333;
        }

        .titlepage p {
            font-size: 1.2em;
            text-align: center;
            color: #555;
        }

        .card-body {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
            margin: 10px;
        }

        .card-title {
            font-size: 1.5em;
            color: #333;
        }

        .card-text {
            font-size: 1.2em;
            color: #27ae60;
            font-weight: bold;
        }

        .card-img-top {
            border-radius: 5px;
            margin-bottom: 15px;
        }

        .list-group-item {
            font-size: 1em;
            color: #666;
            border: none;
            background-color: #fafafa;
        }

        a {
            display: inline-block;
            text-decoration: none;
            background-color: #ff6f61;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 1em;
            font-weight: bold;
            margin-top: 10px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #e05550;
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
                    <li><a href="#">Productos</a></li>
                </ul>
            </nav>
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
        
         <div class="container">
            <div class="row">
               <div class="col-md-10 offset-md-1">
                  <div class="titlepage">
                     <h2>TODOS LOS PRODUCTOS</h2>
                     <p>Aqui encontraras el mejor catalogo de productos del mercado.
                     </p>
                  </div>
               </div>
            </div>
         </div>
         <%
                ProductoDAO proDAO = new ProductoDAO();

                ArrayList<ProductoVO> lista = proDAO.listar();
                int salto = 0;
                for (ProductoVO p : lista) {
            %>

            
                    <img url="IMG/<%=p.getImagen()%>" class="card-img-top" alt="..." width="140" height="140">
                    <div class="card-body">
                        <h5 class="card-title"><%=p.getNombre()%></h5>
                        <p class="card-text"><%=p.getPrecio()%></p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><%=p.getDescripcion()%></li>
                        <li class="list-group-item">$.<%=p.getStock()%></li>
                    </ul>

                    <a href="anadirCarrito.jsp?id=<%= p.getId()%>">Añadir Al Carrito</a>                    
                    <br>
                    <br>
              
            <%
                salto++;
                if (salto == 2) {

            %>
            <tr> 
                <%                            salto = 0;
                        }
                    }
                %>
    </body>
</html>
