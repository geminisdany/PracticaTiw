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


</head>
<body>

	<!-- This one in here is responsive menu for tablet and mobiles -->
	<div class="responsive-navigation visible-sm visible-xs">
		<a href="index.jsp" class="menu-toggle-btn"> Talaverámica </a>
	</div>
	<!-- /responsive_navigation -->

	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo">
			<a href="index.jsp" rel="nofollow"><h1>Talaverámica</h1></a> <span>Al
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
				<span id="login"><a href="cliente-login.jsp">Login </a> |
					Logout</span>&nbsp;&nbsp;&nbsp;<span id="registro"><a
					href="cliente-registroUsuario.jsp">Registrarse</a></span> <span
					id="cestaCompra">Cesta de la compra <a
					href="gestionCompra.jsp"><img src="images/carritoCompra.png"
						alt="Carrito Compra" width="35px" height="35px"></a></span>
			</div>
			<div class="container-fluid" id="formularioRegistroC">
				<h3>
					<a href="index.jsp">Home</a><span> ></span> <a
						href="gestionCompra.jsp">1. Su Carrito</a><span> > 2.
						Identificación</span> <span> > 3. Envío/Pago</span> <span> > 4.
						Fin</span>
				</h3>
				<h2>Contenido del carrito de Compra</h2>
				<c:if test="${panelPedido}">
					<div class="tab-pane active" id="pedido">
						<div class="table-responsive panel panel-default">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>IDP</th>
										<th>Nombre</th>
										<th>Cantidad</th>
										<th>Precio</th>
										<th class="text-center">Opciones</th>
									</tr>
								</thead>
								<tbody>
								
						<c:forEach items="${listaPedido}" var="pedido">
							<tr>
							<c:if test="${pedido.idp==3}">
								<td><c:out value="${pedido.idp}"></c:out></td>
								<td><c:out value="${pedido.nombre}"></c:out></td>
								<td><c:out value="${pedido.cantidad}"></c:out></td>
								<td><c:out value="${pedido.precio}"></c:out></td>
								<td class="text-center">
									 <a class="btn btn-danger btn-xs" data-toggle="modal tooltip"
									data-placement="left" title="Eliminar Pedido"
									href="ServletCarrito?action=borrar&idp=${pedido.idp}"><span
										class="glyphicon glyphicon-trash"></span></a></td>
							</c:if>
							</tr>
						</c:forEach>
					
					</tbody>
				</table>
			</div>
		</div>

	</c:if>
				<div id="botones">
					<a href="#"><button type="button" class="btn btn-default"
							id="vc">
							Vaciar carrito <span></span>
						</button></a> <a href="index.jsp"><span><button type="button"
								class="btn btn-default" id="seguirC">
								Seguir Comprando <span></span>
							</button></span></a> <a href="gestionCompra2.jsp"><button type="button"
							class="btn btn-default" id="CPF">
							Realizar pedido <span></span>
						</button></a>
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
									<li><a href="#" rel="blank" class="fa fa-twitter"></a></li>
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
								Copyright © 2014 <a href="index.jsp">Talaverámica</a>
							</p>
						</div>
						<div class="col-md-6 credits">
							<p>
								Diseño: <a href="#" rel="blank">Kiwi</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>