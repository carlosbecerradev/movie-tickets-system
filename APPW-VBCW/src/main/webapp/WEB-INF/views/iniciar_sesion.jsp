    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Ingresar al sistema!</title>
    <link rel="stylesheet" href="css/variables.css">
    <link rel="stylesheet" href="css/encabezados.css">
    <link rel="stylesheet" href="css/navegacion.css">
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
                        <a class="nav-link" href='<c:url value="/cartelera" />'>Cartelera</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

				<!-- Mensajes -->
	            <c:if test="${param.logout != null}">
	                <div class="alert alert-success text-center">
	                    Usted ha cerrado sesión!
	                </div>
	            </c:if>
	            
	            <!-- si existe error de logeo -->
	            <c:if test="${param.error != null}">
	                <div class="alert alert-danger text-center">
	                    Usuario y/o contraseña erróneos, intente nuevamente.
	                </div>
	            </c:if>
	            
	            <c:if test="${param.accesso_denegado != null}">
	                <div class="alert alert-info text-center">
	                    No tiene permiso para ingresar a esta página.
	                </div>
	            </c:if>
	            
	            <sec:authorize access="isAuthenticated()">
		            <sec:authentication var="username" 
		                                 property="principal.username"/>
					<div class="alert alert-info text-center">
	                    Hola <b>${username}</b>, usted ya inicio sesión 
					
						<sec:authorize access="hasRole('ROLE_ADMINISTRADOR')">
						    <a class="text-light px-3 py-2 btn btn-success" href="<c:url value='/reportes'/>">Redirigir</a>
						</sec:authorize>

	                    <sec:authorize access="hasRole('ROLE_MARKETERO')">
						    <a class="text-light px-3 py-2 btn btn-success" href="<c:url value='/gestion_peliculas'/>">Redirigir</a>
						</sec:authorize>
	                    
	                </div>		 
		        </sec:authorize>
	     
	            
    <div class="container ">
        <div class="row justify-content-center align-items center">
            <div class="col-12 col-md-10 col-lg-6 my-5 p-5 bg-blanco-border">
                <h1 class="mb-4 text-center">Iniciar Sesión</h1>
                <form  method="post" class="needs-validation" action="/wolke/login">
                
                <!-- token de seguridad -->
	            <input type="hidden"
	                   name="${_csrf.parameterName}"
	                   value="${_csrf.token}"/>            
	            
               		 
                    <div class="form-group">
                        <label>Nombre de usuario</label>
                        <input name="username" type="text" class="form-control"  placeholder="ingrese su usuario" />                        
                    </div>
                    
                    <div class="form-group">
                        <label>Contraseña</label>
                        <input name="contrasenia" type="password" class="form-control"  placeholder="ingrese su contraseña" />
                        
                        <small class="form-text text-muted">Si no recuerdas tu contraseña, consultar con
                            Soporte Técnico.</small>
                    </div>
                    
                    <button type="submit" class="btn btn-block btn-principal">Ingresar</button>
                </form>
                
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