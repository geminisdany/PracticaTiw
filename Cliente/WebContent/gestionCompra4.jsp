<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Talaverámica</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<meta name="keywords" content="Web de compra/venta de ceramica online" />
<meta name="description"
	content="Web de compra/venta de productos de ceramica online" />
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/templatemo_misc.css">
<link rel="stylesheet" href="css/personal_style.css">
<link rel="stylesheet" href="css/pruebabootstrap.css">

<link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.css">

<!-- JavaScripts -->
<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/jquery.singlePageNav.js" type="text/javascript"></script>
<script src="js/jquery.flexslider.js" type="text/javascript"></script>
<script src="js/jquery.prettyPhoto.js" type="text/javascript"></script>
<script src="js/custom.js" type="text/javascript"></script>
<script type='text/javascript' src='js/logging.js'
	type="text/javascript"></script>
<script type="text/javascript" src="js/pruebabootstrap.js"
	type="text/javascript"></script>

<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/ValidacionD.js"></script>

</head>
<body>

	<!-- This one in here is responsive menu for tablet and mobiles -->
	<div class="responsive-navigation visible-sm visible-xs">
		<a href="index.jsp" class="menu-toggle-btn"> Talaverámica </a>
	</div>
	<!-- /responsive_navigation -->

	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo">
			<a href="index.jsp" rel="nofollow"> <h1>Talaverámica</h1></a> <span>Al
				más puro estilo Romano</span>
		</div>
		<!-- /.logo -->

		<div class="user-element">
			<h2>
				Bienvenido <br></br>
			</h2>
		</div>
		<!-- /.Login menu -->
	</div>
	<!-- /#main-sidebar -->

	<div id="main-content">

		<div id="templatemo">
			<div id="cabecera">
				<span id="login"><a href="cliente-login.jsp">Login </a> | Logout</span>&nbsp;&nbsp;&nbsp;<span
					id="registro"><a href="cliente-registroUsuario.jsp">Registrarse</a></span> <span
					id="cestaCompra">Cesta de la compra <a href="gestionCompra.jsp"><img
						src="images/carritoCompra.png" alt="Carrito Compra" width="35px"
						height="35px"></a></span>
			</div>
			<div class="container-fluid" id="formularioRegistroC">
				<h3>
					<a href="index.jsp">Home</a><span> ></span> <a href="gestionCompra.jsp">1.
						Su Carrito</a><span> ></span> <a>2. Identificación</a><span> >
						<a href="gestionCompra3.jsp">3. Envío/Pago</a>
					</span> <span> > </span><a href="gestionCompra4.jsp">4. Fin</a>
				</h3>
				<h2>Contenido de la compra:</h2>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Artículo</th>
							<th>Precio</th>
							<th>Unidad</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>jarron</td>
							<td>2€</td>
							<td>1</td>
							<td>2€</td>
						</tr>
						<tr>
							<td>fuente</td>
							<td>100€</td>
							<td>2</td>
							<td>200€</td>
						</tr>
						<tr>
							<td>Vasija</td>
							<td>33€</td>
							<td>3</td>
							<td>99€</td>
						</tr>
						<tr>
							<td>Total</td>
							<td></td>
							<td>6</td>
							<td>301€</td>
						</tr>
					</tbody>
				</table>
				<h2>Datos de envío y facturación:</h2>
				<div class="form-group col-xs-7">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Datos del cliente</h3>
						</div>
						<div class="panel-body">

							<h4>Nombre: <c:out value="${factura.nombreC}"></c:out></h4>
							<h4>Ciudad: <c:out value="${factura.ciudad}"></c:out></h4>
							<h4>Direccion: <c:out value="${factura.direccion}"></c:out></h4>
							<h4>pais: <c:out value="${factura.pais}"></c:out></h4>
							<h4>DNI: <c:out value="${factura.DNI}"></c:out></h4>
							<h4>provincia: <c:out value="${factura.provincia}"></c:out></h4>
							<h4>Codigo postal: <c:out value="${factura.cp}"></c:out></h4>
					
						</div>
					</div>
				</div>
				<br></br>
			
					
		
				<br></br>
				<div class="form-group col-xs-12">
				<div id="botones">
					<a href="gestionCompra3.jsp"><button type="button"
							class="btn btn-default" id="atras">
							Atras <span></span>				
						</button ></a> <a href="#"
						data-toggle="modal" data-target="#basicModal"><button
							class="btn btn-default">
								Finalizar Compra <span></span>
							</button></a> 
				</div>
				</div>
			<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
					aria-labelledby="basicModal" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">X</button>
								<h4 class="modal-title" id="myModalLabel">Estado de la compra
									</h4>
							</div>
							<div class="modal-body">
								<h3>La compra se ha hecho con exito</h3>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">Cerrar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="site-footer">
			<div class="first-footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="social-footer">
								<ul>
									<li><a href="#" class="fa fa-facebook"></a></li>
									<li><a href="#" rel="blank"
										class="fa fa-twitter"></a></li>
									<li><a href="#" class="fa fa-dribbble"></a></li>
									<li><a href="#" class="fa fa-linkedin"></a></li>
									<li><a href="#" class="fa fa-rss"></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="bottom-footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6">
							<p class="copyright">
								Copyright © 2014 <a href="#">Talaverámica</a>
							</p>
						</div>
						<div class="col-md-6 credits">
							<p>
								Diseño: <a href="#"
									rel="blank">Kiwi</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
