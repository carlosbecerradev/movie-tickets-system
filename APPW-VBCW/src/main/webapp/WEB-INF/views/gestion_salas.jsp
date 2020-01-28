
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

    <title>Gestionar Salas - Cine Wolke</title>
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
                        <a class="nav-link" href='<c:url value="/reportes" />'>Reportes </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href='<c:url value="/gestion_tarifas" />'>Tarifas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href='<c:url value="/gestion_salas" />'>Salas</a>
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
        <h1 class="mt-5">Gestión de Salas</h1>
        <div class="row">
            <div class="col-12">
                <div class="formulario-main bg-blanco-border rounded px-4 py-4">
                    <a href='<c:url value="/gestion_salas" />' class="btn btn-inverso btn-inline mb-3" type="submit">Nuevo registro</a>
                    <hr class="mt-2">
                    <!-- Formulario -->
                    <form:form  method="post" modelAttribute="sala"  class="needs-validation">
                        <div class="form-row justify-content-between">
                            <div class="col-md-6 mb-3">
                                <label>Id</label>
                                <form:input path="id" type="text" readonly="true" class="form-control" />
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Nombre</label>
                                <form:input path="nombre" type="text" class="form-control" placeholder="Sala #"   maxlength="8"  />
                                <form:errors path="nombre"  cssClass="form-text text-danger"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Estado</label>
                                <form:select class="custom-select" path="estado" >
									<form:option value="1">Disponible</form:option>
									<form:option value="0">No Disponible</form:option>
                                </form:select>
                                <form:errors path="estado" cssClass="form-text text-danger" />
                            </div>
                            <div class="col-md-6 offset-6 offset-md-0">
                            	<label class="d-none d-md-block">&nbsp;</label>	
                                <button class="btn btn-principal btn-block" type="submit">Guardar</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>

            <div class="col-12">
                <hr>	
                <div class="tabla-main bg-blanco-border rounded px-4 py-4 mb-4">
                    <h2 class="mt-2">Salas</h2>
                    <table class="table table-bordered table-hover">
                    <!-- Listado -->
                        <thead class="bg-principal">
                            <tr>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${Salas}" var="card">                        
	                        	<tr>
	                        		<td>${card.id}</td>
	                        		<td>${card.nombre}</td>
	                        		<td>
		                        	<c:if test="${card.estado}">
			                        		Disponible
			                        	</c:if>
			                        	<c:if test="${!card.estado}">
			                        		No Disponible
			                        	</c:if>	                        		
		                        	</td>
	                        		<td>
	                        			<a class="link-text" href='<c:url value="/gestion_salas?id=${card.id}" />'>Editar </a>
	                        			<span class="px-2 px-md-3">|</span>
										<a class="link-text" href='<c:url value="/eliminar_sala/${card.id}"/>' onclick="return confirm('¿Estás seguro de eliminar?')" >Eliminar</a>
	                        		</td>
	                        	</tr>                        	
	                        </c:forEach>

                        </tbody>
                    </table>
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