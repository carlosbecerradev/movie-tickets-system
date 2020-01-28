<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Pagar Boleto!</title>
    <link rel="stylesheet" href="css/variables.css">
    <link rel="stylesheet" href="css/encabezados.css">
    <link rel="stylesheet" href="css/navegacion.css">
    <link rel="stylesheet" href="css/tabla.css">
    <link rel="stylesheet" href="css/pago.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,700|Roboto:400,500&display=swap"
rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light bg-blanco">
        <div class="container h-100 d-flex justify-content-between align-items-center">
            <a class="navbar-brand" href='<c:url value="/cartelera" />'>
                <div class="brand">
                    <img class="brand-img" src="img/cine-wolke.svg" alt="">
                    <span class="brand-text ml-2">cine wolke</span>
                </div>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse bg-blanco" id="navbarNav">
                <ul class="navbar-nav bg-blanco ml-md-auto text-center p-3 p-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" href='<c:url value="/cartelera" />' >Cartelera</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href='<c:url value="/cartelera#tarifa"/>' >Tarifa</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    <div class="container pb-2">
        <h1 class="mt-5 pb-2">Pago de Boleto</h1>
        <div class="row">
        
            <div class="col-12 col-md-3">
                <div class="proyeccion-img text-center">
                    <img width="100%" class="m-auto"
                        src="${proyeccion.pelicula.imagenUri}"
                        alt="">
                </div>
            </div>
            <div class="col-12 col-md-5">
                <div class="bg-blanco-border bordered p-3">
                    <div class="proyeccion-content">
                        <h2 class="proyeccion-titulo">${proyeccion.pelicula.titulo} (${proyeccion.calidad}) (${proyeccion.idioma})</h2>
	                        <p class="proyeccion-fecha"><b>Fecha: </b>${proyeccion.fecha}</p>
	                        <p class="proyeccion-hora"><b>Hora: </b>${proyeccion.hora}</p>
	                        <p class="proyeccion-hora"><b>Sala: </b>${proyeccion.sala.nombre}</p>
	                        <p class="proyeccion-censura"><b>Censura: </b>${proyeccion.pelicula.censura}</p>
	                        <p class="proyeccion-genero"><b>Género: </b>${proyeccion.pelicula.genero.nombre}</p>
	                        <p class="proyeccion-duracion"><b>Duración: </b>${proyeccion.pelicula.duracion} min</p>
                        <p class="proyeccion-butacas"><b>N° Butacas: </b>${numeroButacas}</p>
                    </div>
                    <div class="butacas">
                        <p class="proyeccion-butaca"><b>Butacas:</b>
                        	<c:forEach items="${butacasSeleccionadas}" var="card" >
	                            <span class="lugar ml-2">${card.butaca.fila}-${card.butaca.columna}</span>
	                            <span class="ml-2 text-principal">|</span>
                            </c:forEach>
                        </p>
                    </div>
                </div>
            </div>
            
            <div class="col-12 col-md-4">
                <div class="pagar  my-4 my-md-0">
                    <div class="monto-final">
                        <h2 class="pago">Monto Final:</h2>
                        <span class="pago-precio ml-3">${montoFinal}</span>
                    </div>
                    <form:form method="post" >
                    <div class="container-fluid mt-3">
	                      <div class="row justify-content-between">
	                          <button class=" col-6 col-md-12 col-lg-6 btn btn-principal mb-md-2 mb-lg-0">Pagar en Paypal</button>
	                          <a href='<c:url value="/cancelar_compra" />' class=" col-5 col-md-12 col-lg-5 btn btn-cancel">Cancelar</a>                        
	                      </div>      
                    </div>                  
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
crossorigin="anonymous"></script>    
    
</body>
</html>