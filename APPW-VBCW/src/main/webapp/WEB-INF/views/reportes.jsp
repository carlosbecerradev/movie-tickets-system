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

    <title>Reporte de Boletos Vendidos - Cine Wolke</title>
    <link rel="stylesheet" href="css/variables.css">
    <link rel="stylesheet" href="css/encabezados.css">
    <link rel="stylesheet" href="css/navegacion.css">
    <link rel="stylesheet" href="css/tabla.css">
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
                        <a class="nav-link active" href='<c:url value="/reportes" />'>Reportes </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href='<c:url value="/gestion_tarifas" />'>Tarifas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href='<c:url value="/gestion_salas" />'>Salas</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link " href='<c:url value="/gestion_butacas" />'>Butacas</a>
                    </li>
                    <a class="nav-link btn-inverso rounded ml-md-4" href='<c:url value="/logout"/>'>
	                    	Cerrar Sesión
	                    </a>
                </ul>
            </div>
        </div>
    </nav>
    
    <!-- Mensajes -->
    <c:if test="${success != null}">
    	<div class="alert alert-success text-center">${success}</div>
    </c:if>
    
    <c:if test="${error != null}">
    	<div class="alert alert-danger text-center">${error}</div>
    </c:if>
    
    <c:if test="${warning != null}">
    	<div class="alert alert-warning text-center">${warning}</div>
    </c:if>
    
    <c:if test="${info != null}">
    	<div class="alert alert-info text-center">${info}</div>
    </c:if>
        
    <div class="container">
        <h1 class="mt-5 ">Reporte de Ventas</h1>
        <div class="row">
            <div class="col-12">
                <div class="formulario-main bg-blanco-border rounded px-4 pt-2 mb-2">
                    <form id="frm_filtro_boletos" class="needs-validation" method="get" action='<c:url value="/reportes" />'>
                        <div class="form-row justify-content-between my-4 align-items-center">

                            <div class="col-md-4 mb-3">
                                <label>Filtrar Por Película</label>
                                <select name="id_pelicula" id="selectPelicula" class="custom-select" >
                                	<option value="" >Selecciona</option>
                                	<c:forEach items="${Peliculas}" var="card">
                                		<option value="${card.id}">${card.titulo}</option>
                                	</c:forEach>
                                </select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label>Filtrar Por Fecha</label>
                                <input name="fecha" type="date" id="inputFecha" class="form-control"/>
                            </div>
                            <div class="col-md-4 mt-3">
                                <a class="btn btn-principal btn-block" href='<c:url value="/reportes_limpiar" />'>Limpiar</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-12">
                <div class="tabla-main rounded pt-4">
                    <table id="tabla_reporte" class="table table-bordered table-hove table-responsive-md">
                        <thead class="bg-principal">
                            <tr>
                                <th>Id</th>
                                <th>Cliente</th>
                                <th>Película</th>
                                <th>Calidad</th>
                                <th>Fecha</th>
                                <th>Cant. butacas</th>
                                <th>Monto Final (S/)</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${Boletos}" var="card">
                            <tr>
                                <td>${card.id}</td>
                                <td>${card.cliente.nombres} ${card.cliente.apellidos}</td>
                                <td>${card.getProyeccion().pelicula.titulo}</td>
                                <td>${card.getProyeccion().calidad}</td>
                                <td>${card.fecha}</td>
                                <td>${card.itemsReservaButaca.size()}</td>
                                <td>${card.monto_final}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row align-items-center">
		
            <div class="col-6">
                <div class="imprimir">
                    <a class="btn btn-principal" href='<c:url value="/reportes?format=xlsx" />' target="_blank" >Generar Excel</a>
                </div>
            </div>
            <div class="col-6">
                <div class="text-right">
                    <span>Recaudado: <h2 class="text-principal">S/ <span id="recaudado">0</span></h2></span>
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

	<script>
		let selectInput = document.getElementById("selectPelicula");
        let $recaudado = 0.0;
        
		console.log(selectInput);
	    selectInput.addEventListener('change', e => {        
	    	document.getElementById("frm_filtro_boletos").submit();  
	    });
	    
	    inputFecha.addEventListener('change', e => {        
	    	document.getElementById("frm_filtro_boletos").submit();  
	    });
	    
	    for(let i=0; i < tabla_reporte.rows.length - 1; i++)    {
            $recaudado = $recaudado + parseFloat(tabla_reporte.rows[i + 1].cells[6].innerText);
        }
	    
        recaudado.innerHTML = $recaudado;
	    
	    
	</script>

</body>
</html>