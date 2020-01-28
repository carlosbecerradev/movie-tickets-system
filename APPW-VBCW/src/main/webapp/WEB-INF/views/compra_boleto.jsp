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

    <title>Comprando Boleto - Cine Wolke</title>
    <link rel="stylesheet" href="css/variables.css">
    <link rel="stylesheet" href="css/encabezados.css">
    <link rel="stylesheet" href="css/navegacion.css">
    <link rel="stylesheet" href="css/tabla.css">
    <link rel="stylesheet" href="css/venta-boleto.css">
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
                </ul>
            </div>
        </div>
    </nav>
	
	<!-- Mensajes -->
    <c:if test="${error != null}">
    	<div class="alert alert-danger text-center">${error}</div>
    </c:if>
    
    <div class="container ">
        <h1 class="mt-5">Compra de Boleto</h1>
        <!-- form start -->
        <form:form method="post" modelAttribute="cliente"   class="needs-validation">
	        <div class="row justify-content-between align-items center">
	            <div class="col-12 col-md-6 col-lg-3 my-4">
	            	
	                <div class="proyeccion-card sticky-top bg-gris">
	                    <div class="proyeccion-img text-center">
	                        <img width="100%"
	                            src="${proyeccion.pelicula.imagenUri}"
	                            alt="">
	                    </div>
	
	                    <div class="proyeccion-content p-4">
	                        <h2 class="proyeccion-titulo">${proyeccion.pelicula.titulo} (${proyeccion.calidad}) (${proyeccion.idioma})</h2>
	                        <p class="proyeccion-fecha"><b>Fecha: </b>${proyeccion.fecha}</p>
	                        <p class="proyeccion-hora"><b>Hora: </b>${proyeccion.hora}</p>
	                        <p class="proyeccion-hora"><b>Sala: </b>${proyeccion.sala.nombre}</p>
	                        <p class="proyeccion-censura"><b>Censura: </b>${proyeccion.pelicula.censura}</p>
	                        <p class="proyeccion-genero"><b>Género: </b>${proyeccion.pelicula.genero.nombre}</p>
	                        <p class="proyeccion-duracion"><b>Duración: </b>${proyeccion.pelicula.duracion} min</p>
	                    </div>
	                </div>
	                
	            </div>
	            
	            <div class="col-12 col-md-6 col-lg-9 my-4">
	                <div class="asientos-tarifa bg-blanco-border p-4">
	                    <h2 class="mb-4">Seleccione la cantidad de asientos</h2>
	                    <div class="tabla-main">
	                        <table id="tabla_cantidad" class="table table-bordered table-hover table-responsive-sm">
	                            <thead class="bg-principal">
	                                <tr>
	                                    <th>Tipo</th>
	                                    <th>Precio (S/)</th>
	                                    <th>Cantidad</th>
	                                    <th>Importe (S/)</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            <c:forEach items="${tarifas}" var="tar">
	                                <tr>
	                                    <td>${tar.tipo_cliente}</td>
	                                    <td>${tar.precio}</td>
	                                    <td id="inputCantidad">
	                                    	<input type="hidden" name="id_tarifa" value="${tar.id}" />
	                                        <input id="input_cantidad" name="cantidad" style="width:50px;" type="number" value="0" min="0" />
	                                    </td>
	                                    <td>0</td>
	                                </tr>
	                             </c:forEach>                              
	                            </tbody>
	                        </table>
	                        <div>
	                            Monto a pagar: <span style="font-size: 2rem;" class="ml-3 text-success">S/ <span id="monto_total">0</span></span>
							</div>
	                    </div>
	                </div>
	                <hr>
	                <div class="formulario-cliente bg-blanco-border p-4">
	                    <h2 class="mb-4">Datos del Cliente</h2>
	                        <div class="form-row">
	                        
	                            <div class="form-group col-md-6">
	                                <label>Nombres</label>
	                                <form:input path="nombres" type="text" class="form-control" placeholder="Fulanito" maxlength="50"  />
	                                <form:errors path="nombres" cssClass="form-text text-danger" />
	                            </div>
	                            <div class="form-group col-md-6">
	                                <label>Apellidos</label>
	                                <form:input path="apellidos" type="text" class="form-control" placeholder="Melganito" maxlength="50" />
	                                <form:errors path="apellidos" cssClass="form-text text-danger" />
	                            </div>
	                            <div class="form-group col-md-6">
	                                <label>DNI</label>
	                                <form:input path="dni" type="text" class="form-control" placeholder="71522111" pattern="[0-9]{8}" maxlength="8" />
	                                <form:errors path="dni" cssClass="form-text text-danger" />
	                            </div>
	                            <div class="form-group col-md-6">
	                                <label>Correo</label>
	                                <form:input path="correo" type="email" class="form-control" placeholder="example@gmail.com" maxlength="60" />
	                                <form:errors path="correo" cssClass="form-text text-danger" />
	                            </div>
	                        </div>
	                </div>
	                <hr>
	                <div class="seleccion-butacas bg-blanco-border p-4">
	                    <h2 class="mb-4">Selección de Butacas</h2>
	                    <div class="grid-sala my-4">
	                        
	                        <div class="block-butacas py-3">
	                        	<div class="pantalla text-center ml-auto mr-auto"></div>
  
		                        <c:forEach items="${reservasByProyeccion}" var="card">
		                        	<c:if test="${card.estado == false}">
		                                <div id="butaca" class="grid-sala-colunm">
		                                    <input type="checkbox" name="id_reserva_butaca" value="${card.id}" placeholder="${card.butaca.fila}-${card.butaca.columna}"  autocomplete="off" />
		                                </div>
	                        		</c:if>
	                        		<c:if test="${card.estado == true}">
	                        			<div class="grid-sala-colunm bg-dark"><input id="reservado" type="checkbox"/></div>
	                        		</c:if>
		                        </c:forEach>
		                        
	                        </div>
	                        
	                    </div>
	                    <div class="container">
	                        <div class="butacas-estado row justify-content-center align-items-center">
	                            <div class="col-12 col-sm-4">
	                                <div class="d-flex align-items-center justify-content-center">
	                                    <div class="grid-sala-colunm"></div>
	                                    <span>Disponible</span>
	                                </div>
	                            </div>
	                            <div class="col-12 col-sm-4">
	                                <div class="d-flex align-items-center justify-content-center">
	                                    <div class="grid-sala-colunm active"></div>
	                                    <span>Seleccionado</span>
	                                </div>
	                            </div>
	                            <div class="col-12 col-sm-4">
	                                <div class="d-flex align-items-center justify-content-center">
	                                    <div class="grid-sala-colunm bg-dark"></div>
	                                    <span>No disponible</span>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <hr>
	                <div class="container">
	                    <div class="row">
	                        <div class="col-6">
	                            <a href='<c:url value="/cartelera" />' class="btn btn-cancel btn-block">Cancelar</a>
	                        </div>
	                        <div class="col-6">
	                            <button class="btn btn-principal btn-block">Confirmar</button>
	                        </div>
	                    </div>
	                </div>                
	
	            </div>
	        </div>
	        <!-- form end -->
    	</form:form>
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
	
        // Obtengo el elemento tabla y el elemento monto_total a traves de su id=""
        let tabla = document.getElementById('tabla_cantidad');
        let monto_span = document.getElementById('monto_total');     
        // Obtengo todos los input cantidad
        let inputsCantidades = [...document.querySelectorAll('#input_cantidad')];

        for (let i = 0; i < inputsCantidades.length; i++) {
            inputsCantidades[i].addEventListener('click', e => {
                // Declaro variables
                let monto_pagar = 0, importe = 0;
                // Calculo el importe
                importe = parseFloat(tabla.rows[i + 1].cells[1].innerText) * e.target.value;
                
                // Muestro el la celda importe el importe
                tabla.rows[i + 1].cells[3].innerHTML = importe;
                // Sumo los valores que estan en los campos importe
                for (let j = 1; j < tabla.rows.length; j++) {
                    monto_pagar = monto_pagar + parseFloat(tabla.rows[j].cells[3].innerText);                   
                }
                // Muestro el monto a pagar
                monto_span.innerHTML = monto_pagar;
            });
        }
   
         
        // chapo todas las butacas
        let butacas_checkbox  = [...document.querySelectorAll('#butaca input')];
        // console.log(butacas_checkbox);


            let validarSeleccion = 0; 
            butacas_checkbox.forEach(e => { 
                e.addEventListener('click', ev => {
                    /* variables para igualar cantidad en tarifas con butacas seleccionada*/
                    let validarCantidadButacas = 0; 

                    for(let i=0; i < tabla.rows.length - 1; i++)    {
                        validarCantidadButacas = validarCantidadButacas + parseInt(tabla.rows[i + 1].cells[2].childNodes[3].value);
                    }
                    
                        if (ev.target.checked) {
                            if(validarSeleccion < validarCantidadButacas) {
                                validarSeleccion = validarSeleccion + 1;
                                e.parentNode.classList.add("active"); 
                            } else {
                                ev.target.checked = false;
                            }
                        } else {
                            validarSeleccion = validarSeleccion - 1;
                            e.parentNode.classList.remove("active"); 
                        }                    
                    
                    console.log(validarCantidadButacas);
                    console.log(validarSeleccion);
                });
            });
        

        


    </script>

</body>
</html>