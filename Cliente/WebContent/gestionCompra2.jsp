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
				<span id="login"><a href="cliente-login.jsp">Login </a> | Logout</span>&nbsp;&nbsp;&nbsp;<span
					id="registro"><a href="cliente-registroUsuario.jsp">Registrarse</a></span> <span
					id="cestaCompra">Cesta de la compra <a href="gestionCompra.jsp"><img
						src="images/carritoCompra.png" alt="Carrito Compra" width="35px"
						height="35px"></a></span>
			</div>
			<form onSubmit="return validar(this)" action="gestionCompra3.jsp"
				method="post" class="form-horizontal">
				<div class="container-fluid" id="formularioRegistroC">
					<h1 align="center">Logearse</h1>
					<div class="row">
						<div class="form-group col-xs-4"></div>
						<div class="form-group col-xs-5">
							<label for="emailC">Email <span
								class="glyphicon glyphicon-envelope" title="Email"></span></label> <input
								type="email" class="form-control" id="emailC" name="hotmailC" placeholder="Email">
						</div>
					</div>
					<div class="row">
						<div class="form-group col-xs-4"></div>
						<div class="form-group col-xs-5">
							<label for="pwdC">Contraseña <span
								class="glyphicon glyphicon-lock" title="Contraseña"></span></label> <input
								type="password" class="form-control" id="pwdC" name="wordC"
								placeholder="Contraseña">
						</div>
					</div>
					<div align="center">
						<a href="#">recordar clave</a>
					</div>
					<br></br>
					<div id="botones">
						<a href="gestionCompra.jsp"><button type="button"
								class="btn btn-default" id="atras">
								Atras <span></span>
							</button></a> <a href="cliente-registroUsuario.jsp"><button type="button"
								class="btn btn-default" id="reg">
								Registrarse <span></span>
							</button></a> <a href="gestionCompra3.jsp"><span><button
									type="button" class="btn btn-default" id="identificacion">
									Identidicarse <span></span>
								</button></span></a>
				
					</div>
					</div>
			</form>
		</div>
		<div class="nada"></div>
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
							Copyright © 2014 <a href="#">Talaverámica</a>
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