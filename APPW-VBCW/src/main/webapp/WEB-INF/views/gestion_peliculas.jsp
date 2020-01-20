
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Gestión de Películas - Cine Wolke</title>
    
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
                    <img class="brand-img" src="<c:url value='img/cine-wolke.svg' /> " alt="">
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
                        <a class="nav-link active" href="<c:url value="/gestion_peliculas" />">Peliculas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/gestion_proyecciones" />">Proyecciones</a>
                    </li>
                    <a class="nav-link btn-inverso rounded ml-md-4" href="#">Cerrar Sesión</a>
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
        <h1 class="mt-5">Gestión de Películas</h1>
        <div class="row">
            <div class="col-12">
                <div class="formulario-main bg-blanco-border rounded px-4 py-4">
                    <a href='<c:url value="/gestion_peliculas" />' class="btn btn-inverso btn-inline mb-3">Nuevo registro</a>
                    <hr class="mt-2">
                    
                    <!-- Formulario -->
                    <form:form  method="post" modelAttribute="pelicula" enctype="multipart/form-data"  class="needs-validation">                    
                    
                        <div class="form-row justify-content-between">
                            <div class="col-md-6 mb-3">
                                <label >Id</label>
                                <form:input type="text" path="id" class="form-control" readonly="true"  />
                            </div>
                            
                            <div class="col-md-6 mb-3">
                                <label>Título</label>
                                <form:input type="text" class="form-control" path="titulo"
                                    placeholder="Título de la película" />
                                <form:errors path="titulo" cssClass="form-text text-danger" />
                            </div>
                            
                            <div class="col-md-6 mb-3">
                                <label>Descripción</label>
                                <form:textarea class="form-control" path="descripcion"
                                 placeholder="Breve Sinopsis"  />
                                <form:errors path="descripcion" cssClass="form-text text-danger" />
                            </div>
                            
                            <div class="col-md-6 mb-3">
                                <label for="file">Subir Imagen:</label>
                                <div class="custom-file">
                                    <input type="file" name="file" class="custom-file-input" id="customFile"/>
                                    <form:input path="imagenUri" type="hidden" id="imagenUri"/>
                                    <label class="custom-file-label" data-browse="Exáminar" for="customFile">${pelicula.imagenUri}</label>
                                </div>
                                <form:errors path="imagenUri" cssClass="form-text text-danger" />
                            </div>
                            <div class="col-md-6 mb-3">
                                <label >Censura</label>
                                <form:select class="custom-select" path="censura" >
                                    <form:option value="">Selecciona una opción</form:option>
									<form:option value="+14">+14</form:option>
									<form:option value="+18">+18</form:option>
									<form:option value="APT">APT</form:option>
                                </form:select>
                                <form:errors path="censura"  cssClass="form-text text-danger"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Género</label>
                                <form:select class="custom-select" path="genero" >
                                    <form:option value="">Selecciona una opción</form:option>
									<form:option value="Acción">Acción</form:option>
									<form:option value="Comedia">Comedia</form:option>
									<form:option value="Terror">Terror</form:option>
									<form:option value="Ciencia Ficción">Ciencia Ficción</form:option>
                                </form:select>
                                <form:errors path="genero" cssClass="form-text text-danger" />
                            </div>
                            <div class="col-md-6 mb-3">
                                <label >Duración en minutos</label>
                                <form:input type="number" class="form-control" path="duracion" min="15" max="999" 
                                    placeholder="000"  />
                                <form:errors path="duracion" cssClass="form-text text-danger" />
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Estado</label>
                                <form:select class="custom-select" path="estado" >
									<form:option value="1">Disponible</form:option>
									<form:option value="0">No Disponible</form:option>
                                </form:select>
                                <form:errors path="estado" cssClass="form-text text-danger" />
                            </div>
                            <div class="col-md-6 offset-6">
                                <button class="btn btn-principal btn-block" type="submit">Guardar</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>

            <div class="col-12">
                <hr>
                <div class="tabla-main bg-blanco-border rounded px-4 py-4 mb-4">
                    <h2 class="mt-2">Peliculas</h2>
                    <!-- Listado -->
                    <table class="table table-bordered table-hover table-responsive-lg">
                        <thead class="bg-principal">
                            <tr>
                                <th>Id</th>
                                <th>Título</th>
                                <th width=250>Descripción</th>
                                <th>Imagen</th>
                                <th>Censura</th>
                                <th>Género</th>
                                <th>Duración</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
	                        <c:forEach items="${Peliculas}" var="card">                        
	                        	<tr>
	                        		<td>${card.id}</td>
	                        		<td>${card.titulo}</td>
	                        		<td>${card.descripcion}</td>
	                        		<td>
	                        			<img src="${card.imagenUri}" width="100px" />
	                        		</td>
	                        		<td>${card.censura}</td>
	                        		<td>${card.genero}</td>
	                        		<td>${card.duracion} min</td>
	                        		<td>
		                        		<c:if test="${card.estado}">
		                        			Disponible
		                        		</c:if>
		                        		<c:if test="${!card.estado}">
		                        			No Disponible
		                        		</c:if>	                        		
	                        		</td>
	                        		<td>
	                        			<a class="link-text" href='<c:url value="/gestion_peliculas?id=${card.id}" />'>Editar </a>
	                        			<span class="px-2 px-md-3">|</span>
										<a class="link-text" href='<c:url value="/eliminar_pelicula/${card.id}"/>' onclick="return confirm('¿Estás seguro de eliminar?')" >Eliminar</a>
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
        
        <script type="text/javascript">
        	let fileInput = document.querySelector('#customFile');
        	let imagenUriValue = document.querySelector('#imagenUri');
        	fileInput.addEventListener('change', e => {
        		let fileLabel = document.querySelector('.custom-file-label');
        	    let fileName = e.target.value.replace(/^.*\\/, "");
        	    fileLabel.innerHTML = "uploads/" + fileName;
        	    imagenUriValue.value = "uploads/" + fileName;
        	});
        </script>
</body>


</html>