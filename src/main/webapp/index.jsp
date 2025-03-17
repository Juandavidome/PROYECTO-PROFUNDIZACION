<%-- 
    Document   : index
    Created on : 17/02/2025, 6:26:47 p. m.
    Author     : juand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagina</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header class="header">
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
        <div class="header-content container">
            <div class="header-img">
                <img src="images/principal2.png" alt="">
            </div>
            <div class="header-txt">
                <h1>Ofertas Especiales</h1>
                <p>Estrena los mejores moviles</p>
                <a href="#" class="btn-1">Información</a>
            </div>
        </div>
    </header>
    <div class="header-txt-2">
        <h1>CELULARES MAS VENDIDOS</h1>
        <p>Celulares con mejor valoracion de clientes en el mercado.</p>
    </div>
    <section class="ofert container">
        <div class="ofert-1">
            <div class="ofert-img">
                <img src="images/iphone16_2.png">
            </div>
            <div class="ofert-txt">
                <h3>Iphone 16</h3>
                <a href="producto1.jsp" class="btn-2">Información</a>
            </div>
        </div>
        <div class="ofert-1">
            <div class="ofert-img">
                <img src="images/iphone_13.png" alt="">
            </div>
            <div class="ofert-txt">
                <h3>Iphone 13</h3>
                <a href="producto2.jsp" class="btn-2">Información</a>
            </div>
        </div>
        <div class="ofert-1">
            <div class="ofert-img">
                <img src="images/iphone16.png" alt="">
            </div>
            <div class="ofert-txt">
                <h3>Iphone 16 pro max</h3>
                <a href="producto3.jsp" class="btn-2">Información</a>
            </div>
        </div>
    </section>
    <main class="products container" id="lista-1">
        <h2>Productos</h2>
       
        <div class="menu-container">
            <input type="checkbox" id="nav-toggle">
            <label for="nav-toggle" class="nav-label">
                <img src="images/menu.png" class="nav-icon" aria-label="menu">
            </label>
            <nav class="navigation-bar">
                <ul class="nav-list">
                    <li><a href="#" class="nav-link">Inicio</a></li>
                    <li><a href="#" class="nav-link">Servicios</a></li>
                    <li><a href="#" class="nav-link">Productos</a></li>
                    <li><a href="#" class="nav-link">Contacto</a></li>
                </ul>
            </nav>
            <select class="select-order">
                <option>Precio más bajo</option>
                <option>Precio más alto</option>
                <option>Por opiniones</option>
                <option>Por descuento</option>
            </select>
        </div>
            
     
        <br>
        <br>
        <br>
        <div class="product-content">
            <div class="product">
                <a href="producto1.html">
                <img src="images/iphone16.png" alt="">
                </a>
                <div class="product-txt">
                    <h3>Iphone 16 PRO MAX</h3>
                    <p>Calidad Premium</p>
                    <p class="precioo">$5.300.000 COP</p>
                    <a href="#" class="agregar-carrito btn-2" data-id="1">Agregar al Carrito</a>
                </div>
            </div>
            <div class="product">
                <img src="images/iphone16_2.png" alt="">
                <div class="product-txt">
                    <h3>Iphone 16</h3>
                    <p>Calidad Premium</p>
                    <p class="precioo">$4.300.000 COP</p>
                    <a href="#" class="agregar-carrito btn-2" data-id="2">Agregar al Carrito</a>
                </div>
            </div>
            <div class="product">
                <img src="images/iphone_14.png" alt="">
                <div class="product-txt">
                    <h3>Iphone 14</h3>
                    <p>Calidad Premium</p>
                    <p class="precioo">$2.800.000 COP</p>
                    <a href="#" class="agregar-carrito btn-2" data-id="3">Agregar al Carrito</a>
                </div>
            </div>
            <div class="product">
                <img src="images/iphone_13.png" alt="">
                <div class="product-txt">
                    <h3>Iphone 13</h3>
                    <p>Calidad Premium</p>
                    <p class="precioo">$2.100.000 COP</p>
                    <a href="#" class="agregar-carrito btn-2" data-id="4">Agregar al Carrito</a>
                </div>
            </div>
            <div class="product">
                <img src="images/iphone_12.png" alt="">
                <div class="product-txt">
                    <h3>Iphone 12</h3>
                    <p>Calidad Premium</p>
                    <p class="precioo">$1.800.000 COP</p>
                    <a href="#" class="agregar-carrito btn-2" data-id="5">Agregar al Carrito</a>
                </div>
            </div>
            <div class="product">
                <img src="images/iphone_12_pro.png" alt="">
                <div class="product-txt">
                    <h3>Iphone 12 Pro Max</h3>
                    <p>Calidad Premium</p>
                    <p class="precioo">$2.300.000 COP</p>
                    <a href="#" class="agregar-carrito btn-2" data-id="6">Agregar al Carrito</a>
                </div>
            </div>
        </div>
    </main>
    <!-- 
    <section class="icons container">
        <div class="icon-1">
            <div class="icon-img">
                <img src="images/i1.svg" alt="">
            </div>
            <div class="icon-txt">
                <h3>Lorem, ipsum dolor sit amet consectetur adipisicing elit.</h3>
                <p>
                    asdasdasdasdasdas
                </p>
            </div>
        </div>
        <div class="icon-1">
            <div class="icon-img">
                <img src="images/i2.svg" alt="">
            </div>
            <div class="icon-txt">
                <h3>Lorem, ipsum dolor sit amet consectetur adipisicing elit.</h3>
                <p>
                    asdasdasdasdasdas
                </p>
            </div>
        </div>
        <div class="icon-1">
            <div class="icon-img">
                <img src="images/i3.svg" alt="">
            </div>
            <div class="icon-txt">
                <h3>Lorem, ipsum dolor sit amet consectetur adipisicing elit.</h3>
                <p>
                    asdasdasdasdasdas
                </p>
            </div>
        </div>
    </section>
    <section class="blog container">
        <div class="blog-1">
            <img src="images/b1.jpg" alt="">
            <h3>Blog 1</h3>
            <p>
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Ratione in veniam odio, nemo cum ad sequi eius quos natus ducimus error quibusdam soluta voluptatem vero amet est praesentium itaque nobis.
            </p>
        </div>
        <div class="blog-1">
            <img src="images/b2.jpg" alt="">
            <h3>Blog 2</h3>
            <p>
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Ratione in veniam odio, nemo cum ad sequi eius quos natus ducimus error quibusdam soluta voluptatem vero amet est praesentium itaque nobis.
            </p>
        </div>
        <div class="blog-1">
            <img src="images/b3.jpg" alt="">
            <h3>Blog 3</h3>
            <p>
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Ratione in veniam odio, nemo cum ad sequi eius quos natus ducimus error quibusdam soluta voluptatem vero amet est praesentium itaque nobis.
            </p>
        </div>
    </section>
    -->
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