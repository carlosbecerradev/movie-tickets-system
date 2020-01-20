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

    <div class="container ">
        <h1 class="mt-5">Compra de Boleto</h1>
        <div class="row justify-content-between align-items center">
            <div class="col-12 col-md-6 col-lg-3 my-4">
            	<c:forEach items="${proyeccion}" var="proy">
                <div class="proyeccion-card sticky-top bg-gris">
                    <div class="proyeccion-img text-center">
                        <img width="100%"
                            src="${proy.pelicula.imagenUri}"
                            alt="">
                    </div>

                    <div class="proyeccion-content p-4">
                        <h2 class="proyeccion-titulo">${proy.pelicula.titulo} (${proy.calidad}) (${proy.idioma})</h2>
                        <p class="proyeccion-fecha"><b>Fecha: </b>${proy.fecha}</p>
                        <p class="proyeccion-hora"><b>Hora: </b>${proy.hora}</p>
                        <p class="proyeccion-hora"><b>Sala: </b>${proy.sala.nombre}</p>
                        <p class="proyeccion-censura"><b>Censura: </b>${proy.pelicula.censura}</p>
                        <p class="proyeccion-genero"><b>Género: </b>${proy.pelicula.genero}</p>
                        <p class="proyeccion-duracion"><b>Duración: </b>${proy.pelicula.duracion} min</p>
                    </div>
                </div>
                </c:forEach>
            </div>
            
            <div class="col-12 col-md-6 col-lg-9 my-4">
            <form:form>
                <div class="asientos-tarifa bg-blanco-border p-4">
                    <h2 class="mb-4">Seleccione la cantidad de asientos</h2>
                    <div class="tabla-main">
                        <table class="table table-bordered table-hover table-responsive-sm">
                            <thead class="bg-principal">
                                <tr>
                                    <th>Tipo</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${tarifas}" var="tar">
                                <tr>
                                    <td>${tar.tipo_cliente}</td>
                                    <td>${tar.precio}</td>
                                    <td>
                                        <input style="width:50px;" type="number" value="0" min="0" />
                                    </td>
                                </tr>
                             </c:forEach>                              
                            </tbody>
                        </table>
                        <div class="text-right">
                        	<p class="bg-principal px-4 py-2 font-weight-normal">Importe: <span class="ml-4 span-soles ">0.0</span></p>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="formulario-cliente bg-blanco-border p-4">
                    <h2 class="mb-4">Datos del Cliente</h2>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputEmail4">Nombres</label>
                                <input type="email" class="form-control" id="inputEmail4" placeholder="Fulanito">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputPassword4">Apellidos</label>
                                <input type="password" class="form-control" id="inputPassword4" placeholder="Melganito">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputEmail4">DNI</label>
                                <input type="email" class="form-control" id="inputEmail4" placeholder="71522111">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputPassword4">Correo</label>
                                <input type="password" class="form-control" id="inputPassword4"
                                    placeholder="example@gmail.com">
                            </div>
                            <!-- <button type="submit" style="background: var(--azul);"
                                class="btn text-white btn-block">Confirmar</button> -->
                        </div>
                </div>
                <hr>
                <div class="seleccion-butacas bg-blanco-border p-4">
                    <h2 class="mb-4">Selección de Butacas</h2>
                    <div class="grid-sala my-4">
                        <div class="pantalla text-center"></div>
                        <div class="grid-sala-row">
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                        </div>
                        <div class="grid-sala-row">
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                        </div>
                        <div class="grid-sala-row">
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                        </div>
                        <div class="grid-sala-row">
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm active"></a>
                                <a href="" class="grid-sala-colunm active"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                        </div>
                        <div class="grid-sala-row">
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                        </div>
                        <div class="grid-sala-row">
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                        </div>
                        <div class="grid-sala-row">
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                            <div class="col-group">
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                                <a href="" class="grid-sala-colunm"></a>
                            </div>
                        </div>
                    </div>
                    <ul class="butacas-estado d-flex justify-content-around align-items-center">
                        <p>
                            <div class="grid-sala-colunm"></div> Disponible
                        </p>
                        <p>
                            <div class="grid-sala-colunm active"></div>No disponible
                        </p>
                    </ul>
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
                
                </form:form>

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