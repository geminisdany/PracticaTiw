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

<c:set var="factura" scope="request" value="${factura}"/>
<c:choose >
<c:when test="${factura==null}">
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
			
	<form onSubmit="return validar(this)" action="ServletF"
						method="post" class="form-horizontal">
			<div class="container-fluid" id="formularioRegistroC">
				<h3>
					<a href="index.jsp">Home</a><span> ></span> <a
						href="gestionCompra.jsp">1. Su Carrito</a><span> ></span> <a>2.
						Identificación</a><span> > <a href="gestionCompra3.jsp">3.
							Envío/Pago</a></span> <span> > 4. Fin</span>
				</h3>
				<h2>Datos de envío y facturación:</h2>
				<h3>Direccion de envío</h3>
				<div class="container-fluid"">
					<p>
						Bienvenido a la página de registro de envío. Por favor, rellene
						los siguientes campos. Los campos con <span class="red">*</span>
						son obligatorios.
					</p>
	
						<div class="row">
							<div class="form-group col-xs-5" id="columnas62">
								<label for="nombreC">Nombre de usuario <span class="red">*
								</span><span class="glyphicon glyphicon-user" title="Usuario"></span></label> <input
									type="text" class="form-control" id="nombreC" name="nombreC"
									placeholder="Nombre">
							</div>
							<div class="form-group col-xs-2"></div>
							<div class="form-group col-xs-5">
								<label for="dniC">DNI <span class="red">* </span><span
									title="Dni"></span></label> <input type="text" class="form-control"
									id="dni" name="dni"
									placeholder="Ej DNI 88888888">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-xs-5">
								<div class="control-group">
									<label class="control-label" for="addressesCountry2">País
										<span class="red">* </span>
									</label>
									<div class="controls">
										<select name="pais" id="addressesCountry2"
											class="form-control" data-unique="newbilling">
											<option value=""></option>
											<option value="Spain">España</option>
											<option value="Portugal">Portugal</option>
											<option value="Francia">Francia</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group col-xs-2"></div>
							<div class="form-group col-xs-5">
								<label for="provinciaC">Provincia <span class="red">*</span></label>
								<input type="text" class="form-control" id="provincia"
									name="provincia" placeholder="Provincia">
							</div>
						</div>							
						<div class="row">
							<div class="form-group col-xs-5">
								<label for="CiudadC">Ciudad <span class="red">*</span><span
									title="Ciudad"></span></label> <input type="text" class="form-control"
									id="ciudad" name="ciudad" placeholder="Ciudad">
							</div>
							
							<div class="form-group col-xs-2"></div>
							<div class="form-group col-xs-5">
								<label for="direccionC">Dirección <span class="red">*
								</span><span title="direccion"></span></label> <input type="text"
									class="form-control" id="direccion" name="direccion"
									placeholder="Dirección">
							</div>
							
						</div>

						<div class="row">
							<div class="form-group col-xs-5">
								<label for="cpC">Código postal <span class="red">*</span></label>
								<input type="text" class="form-control" id="cp" name="cp"
									maxlength="5" placeholder="Código postal">
							</div>
							<div class="form-group col-xs-2"></div>
							<div class="form-group col-xs-5">
								<label for="telefonoC">Teléfono del usuario <span
									class="red">* </span> <span
									class="glyphicon glyphicon-phone-alt" title="Teléfono"></span></label>
								<input type="text" class="form-control" id="telefonoC"
									name="phoneC" maxlength="9" placeholder="Teléfono de 9 dígitos">
							</div>
						</div>			
					
						
				</div>
				<h2>Forma de pago:</h2>
				<h3>Seleccione la forma de pago:</h3>
				<div id="opcionePago">
					<div class="pago">
						<input type="radio" name="opcion1" value="Tarjeta">
						Tarjeta
					</div>
					<div class="pago">
						<input type="radio" name="opcion1" value="Paypal"> Paypal
					</div>
					<div class="pago">
						<input type="radio" name="opcion1" value="Transferencia">
						Tranferencia
					</div>
				</div>
				<h2>Forma de envío y plazo de entrega</h2>
				<div class="row">
					<div class="form-group col-xs-5">
						<h3>Forma de envío:</h3>
						<div id="opcioneenvío">
							<div class="pago">
								<input type="radio" name="opcion2" value="Correo">
								Correo
							</div>
							<div class="pago">
								<input type="radio" name="opcion2" value="Seur"> Seur
							</div>
							<div class="pago">
								<input type="radio" name="opcion2" value="Tourline">
								Tourline Express
							</div>
						</div>
					</div>
					<div class="form-group col-xs-5">
						<h3>Plazo de entrega:</h3>
						<div id="opcioneentrega">
							<div class="pago">
								<input type="radio" name="opcion3" value="24"> 24h (7€)
							</div>
							<div class="pago">
								<input type="radio" name="opcion3" value="48"> 48h (5€)
							</div>
							<div class="pago">
								<input type="radio" name="opcion3" value="72"> 72h (3€)
							</div>
						</div>
					</div>
				</div>
				<br></br>
				<div id="botones">
					<a href="gestionCompra.jsp"><button type="button"
							class="btn btn-default" id="atras">
							Atras <span></span>
						</button></a>
						<button id="submit" type="submit" class="btn btn-default" id="continuar" name="submit" >
								Continuar <span></span>
							</button>
						
				</div>

			</div>
		</form>
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
</c:when>
				<c:otherwise>
				<jsp:include page="gestionCompra4.jsp"></jsp:include>
				</c:otherwise>
				</c:choose>
</body>
</html>

