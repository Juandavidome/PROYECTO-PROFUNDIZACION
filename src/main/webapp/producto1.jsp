<%-- 
    Document   : producto1
    Created on : 17/02/2025, 8:04:22 p. m.
    Author     : juand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de Producto</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>
    <header class="header">
        <div class="menu container">
            <a href="#" class="logo">LOGO</a>
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
            <div class="carrito-container">
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
    <main class="products container">
        <div class="producto container">
            <div class="galeria">
                <img src="images/iphone16_2.png" alt="Producto 1" class="imagen-principal">
                <div class="miniaturas">
                    <img src="images/descarga (1).jpeg" alt="Producto 1" class="miniatura">
                    <img src="images/descarga (2).jpeg" alt="Producto 2" class="miniatura">
                    <img src="images/descarga (3).jpeg" alt="Producto 3" class="miniatura">
                </div>
            </div>
            <div class="detalles">
                <h1 class="titulo-producto">Iphone 16</h1>
                <p class="precio">$4.300.000 COP</p>
                <p class="descripcion">¡Descubre el iPhone 16! Con su diseño elegante y rendimiento sin igual, este dispositivo de calidad premium ofrece una experiencia inigualable. Equipado con la última tecnología en cámaras, una pantalla impresionante y una batería de larga duración, el iPhone 16 es tu compañero ideal para cualquier aventura. ¡Llévalo hoy y eleva tu estilo de vida al máximo! 🚀📱</p>
                <button class="btn-comprar">Agregar al Carrito</button>
            </div>
        </div>
        
        <div class="comentarios container">
            <h2>Comentarios</h2>
            <textarea placeholder="Deja tu comentario del producto..." class="comentario-textarea"></textarea>
            <button class="btn-enviar">Enviar Comentario</button>
        </div>
    </main>

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
