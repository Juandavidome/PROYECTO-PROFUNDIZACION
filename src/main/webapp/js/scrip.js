/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const carrito = document.getElementById('carrito');
const elementos1 = document.getElementById('lista-1');
const lista = document.querySelector('#lista-carrito tbody');
const vaciarCarritoBtn = document.getElementById('vaciar');

cargarEventListeners();

function cargarEventListeners() {
    elementos1.addEventListener('click', comprarElemento);
    carrito.addEventListener('click', eliminarElemento);
    vaciarCarritoBtn.addEventListener('click', vaciarCarrito);

    document.addEventListener('DOMContentLoaded', leerLocalStorage);
}

function comprarElemento(e) {
    e.preventDefault();
    if (e.target.classList.contains('agregar-carrito')) {
        const elemento = e.target.parentElement.parentElement;
        leerDatosElemento(elemento);
    }
}

function leerDatosElemento(elemento) {
    const infoElemento = {
        imagen: elemento.querySelector('img').src,
        titulo: elemento.querySelector('h3').textContent,
        precio: elemento.querySelector('.precioo').textContent, // Clase corregida
        id: elemento.querySelector('a').getAttribute('data-id')
    };
    insertarCarrito(infoElemento);
}

function insertarCarrito(elemento) {
    const row = document.createElement('tr');
    row.innerHTML = `
    <td>
        <img src="${elemento.imagen}" width="100">
    </td>
    <td>
        ${elemento.titulo}
    </td>
    <td>
        ${elemento.precio}
    </td>
    <td>
        <a href='#' class='borrar' data-id="${elemento.id}">X</a>
    </td>
    `;
    lista.appendChild(row);
    guardarElementoLocalStorage(elemento);
}

function eliminarElemento(e) {
    e.preventDefault();
    let elemento, elementoId;
    if (e.target.classList.contains('borrar')) {
        e.target.parentElement.parentElement.remove();
        elemento = e.target.parentElement.parentElement;
        elementoId = elemento.querySelector('a').getAttribute('data-id');
        eliminarElementoLocalStorage(elementoId);
    }
}

function vaciarCarrito() {
    while (lista.firstChild) {
        lista.removeChild(lista.firstChild);
    }
    localStorage.clear();
}

function guardarElementoLocalStorage(elemento) {
    let elementos = obtenerElementosLocalStorage();
    elementos.push(elemento);
    localStorage.setItem('elementos', JSON.stringify(elementos));
}

function obtenerElementosLocalStorage() {
    let elementos;
    if (localStorage.getItem('elementos') === null) {
        elementos = [];
    } else {
        elementos = JSON.parse(localStorage.getItem('elementos'));
    }
    return elementos;
}

function leerLocalStorage() {
    let elementos = obtenerElementosLocalStorage();
    elementos.forEach(function(elemento) {
        const row = document.createElement('tr');
        row.innerHTML = `
        <td>
            <img src="${elemento.imagen}" width="100">
        </td>
        <td>
            ${elemento.titulo}
        </td>
        <td>
            ${elemento.precio}
        </td>
        <td>
            <a href='#' class='borrar' data-id="${elemento.id}">X</a>
        </td>
        `;
        lista.appendChild(row);
    });
}

function eliminarElementoLocalStorage(id) {
    let elementos = obtenerElementosLocalStorage();
    elementos = elementos.filter(elemento => elemento.id !== id);
    localStorage.setItem('elementos', JSON.stringify(elementos));
}

document.addEventListener("DOMContentLoaded", function () {
    const carrusel = document.querySelector(".carrusel-container");
    document.querySelector(".izquierda").addEventListener("click", () => {
        carrusel.scrollBy({ left: -300, behavior: "smooth" });
    });
    document.querySelector(".derecha").addEventListener("click", () => {
        carrusel.scrollBy({ left: 300, behavior: "smooth" });
    });
});


