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

    <title>Cartelera - Cine Wolke</title>
    <link rel="stylesheet" href="css/variables.css">
    <link rel="stylesheet" href="css/encabezados.css">
    <link rel="stylesheet" href="css/tabla.css">
    <link rel="stylesheet" href="css/navegacion.css">
    <link rel="stylesheet" href="css/carletera.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,700|Roboto:400,500&display=swap" rel="stylesheet">
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
    
    <!-- Mensajes -->
	    <c:if test="${success != null}">
	    	<div class="alert alert-success text-center">${success}</div>
	    </c:if>

    <main class="main-wrapper container">
        <div class="main-title mt-5">
            <h1>Cartelera</h1>
        </div>
        <!-- Cartelera -->
        <div class="cartelera ">
            <div class="carousel-grid pb-2">
            	<c:forEach var="card" items="${Peliculas}">
            	
            		<div class="item">
	                    <img src="${card.imagenUri}" alt="" class="item-img">
	                    <div class="item-content">
	                        <a href='<c:url value="/cartelera?id=${card.id}" />' class="btn-inverso px-3 py-2 rounded">Ver detalles</a>	                        
	                    </div>
	                </div>
	                
            	</c:forEach>
                
            </div>
        </div>
        
        <c:if test="${pelicula != null}">
	        <!-- Detalle de peliculas y sus proyecciones -->
	        <div class="pelicula my-5 bg-blanco-border">
	            <div class="container-fluid">
	            
	                <div class="row">
	                	
	                    <div class="col-12 col-md-4">
	                        <div class="pelicula-img py-4">                        	
	                            <img src="${pelicula.imagenUri}" alt="" width="100%">
	                        </div>
	                    </div>
	                    <!-- col -->
	                    <div class="col-12 col-md-8">
	                        <div class="pelicula-content my-3">                        
	                            <h2 class="pelicula-title">${pelicula.titulo}</h2>
	                            <h3 class=" mt-4">Sinopsis</h3>
	                            <p class="pelicula-descripcion mb-3">
	                                ${pelicula.descripcion}
	                            </p>
	                            <h3 class="pelicula-genero">Género:
	                                <span class="text ml-3 mt-4">${pelicula.genero.nombre}</span>
	                            </h3>
	                            <h3 class="pelicula-censura">Censura:
	                                <span class="text ml-3 mt-4">${pelicula.censura}</span>
	                            </h3>
	                            <h3 class="pelicula-censura">Duración:
	                                <span class="text ml-3 mt-4">${pelicula.duracion} min</span>
	                            </h3>
	                            <h3 class="pelicula-horarios">Horarios:</h3>
	                            <div class="horarios">
		                             <details class="horarios-details" open>
				                         <summary>HOY</summary>
			                             <div class="horario my-2">
	                            			<c:forEach var="proy" items="${ProyeccionesHoy}">
			                                   <a href='<c:url value="/compra_boleto?id=${proy.id}" />' class="btn btn-principal">${proy.hora}</a>		                                         
		                            	 	</c:forEach>
			                             </div>      
		                             </details>    
		                             <details class="horarios-details" open>
				                         <summary>MAÑANA</summary>
			                             <div class="horario my-2">
	                            			<c:forEach var="proy" items="${ProyeccionesManiana}">
			                                   <a href='<c:url value="/compra_boleto?id=${proy.id}" />' class="btn btn-principal">${proy.hora}</a>		                                         
		                            	 	</c:forEach>
			                             </div>      
		                             </details> 
	                            </div>
	
	                        </div>
	                        
	                    </div>
	                 <!-- col -->
	               		
	                </div>
	                <!-- row -->       
	             
	            </div>
	        </div>
        </c:if>
        <hr>
        
        <!-- Tarifa  -->
        <div id="tarifa" class="tarifa my-5">
            <h2 class=" mt-4">Tarifa</h2>
            <table class="table table-bordered table-hover table-responsive-md">
                <thead class="bg-principal">
                    <tr>
                        <th>Tipo de persona</th>
                        <th>Calidad</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                
                <tbody>
	                <c:forEach var="card" items="${Tarifas}">
	                	<tr>
	                        <td>${card.tipo_cliente}</td>
	                        <td>${card.calidad}</td>
	                        <td class="tarifa-precio">${card.precio}</td>
	                    </tr>
	                </c:forEach>                    
                </tbody>
            </table>
        </div>
    </main>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>