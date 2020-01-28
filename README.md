# venta-de-boletos-de-cine-app
1- Abrir proyecto en Spring Tool Suit 3 (STS3).
2- Ejecutar el proyecto.
3- Abrir el archivo poblar-tablas.sql en WorkBrench.
4- Ejecutar el script paso a paso.
5- Ingresar al localhost:8060/wolke/login
6- Iniciar sesión como Administrador - "admin" y "123".
7- Crear Tarifas
8- Crear salas (Al crear una sala se crearán sus butacas automaticamente).
9- Cerrar Sesion y luego iniciar sesion como marketero - "marketero" y "123".
10- Crear Pelicula.
11- Crear Proyeccion (Al crear una proyeccion se crearán automaticamente todas las reservas de las butacas automaticamente en estado 0 y sin boleto asociado).
12- Ir a localhost:8060/wolke/ o localhost:8060/wolke/cartelera (Solo se listan las proyeccion con la fecha de hoy y manaña).
13- Seleccionar una proyeccion.
14- Rellenar todos los campos en la pagina compra de boleto.
15- Presionar el boton pagar en Paypal.(No programado, solo registra el boleto al presionar ese boton).
16- Ir a localhost:8060/wolke/reportes.
17- Iniciar sesión como Administrador - "admin" y "123".
18- Consultar boletos comprados.