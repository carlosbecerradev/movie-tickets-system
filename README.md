# Sistema Web para la venta de boletos de un cine
Proyecto del curso de **Desarrollo de Aplicaciones AvanzadasII** con el lenguaje de programación **Java** y **Spring Framework**. *Version 1.0.0*.

## Instalación
Pasos para ejecutar correctamente este proyecto.

 1. **Clone** este repositorio o solamente descarguelo.
 2. Importar el proyecto a **Spring Tool Suite 3** o otro IDE.
 3. Descargar las dependencias necesarias con *Maven*.
 4. Abrir **MySQL Workbench 8.0 CE** y ejecutar lo siguientes scripts:
    - **poblar-tablas.sql**.
    - **constraints-tablas.sql**.
 5. Por último, ejecute el proyecto.

## Requisitos
 - Javo 8.
 - Spring Framework 4.
 - Spring Boot 2.
 - Apache Maven 3 o superior.
 - MySQL 5 o superior.

## Uso

1. Ingresar al **localhost:8060/wolke/login**.
2. Iniciar sesión como Administrador:
    - "admin" y "123".
3. Crear Tarifas
4. Crear salas (Al crear una sala se crearán sus butacas automaticamente).
5. Cerrar Sesion y luego iniciar sesion como Marketero:
    - "marketero" y "123".
6. Crear Pelicula.
7. Crear Proyeccion (Al crear una proyeccion se crearán automaticamente todas las reservas de las butacas automaticamente en estado 0 y sin boleto asociado).
8. Ir a **localhost:8060/wolke/** o **localhost:8060/wolke/cartelera** (Solo se listan las proyeccion con la fecha de hoy y manaña).
9. Seleccionar una proyeccion.
10. Rellenar todos los campos en la pagina compra de boleto.
11. Presionar el boton pagar en Paypal.
    - (No programado, solo registra el boleto al presionar ese boton).
    - (Se enviará un correo electrónico con los datos del boleto).
12. Ir a **localhost:8060/wolke/reportes**.
13. Iniciar sesión como Administrador:
    - "admin" y "123".
13. Consultar boletos comprados y generar archivo Excel.
 
