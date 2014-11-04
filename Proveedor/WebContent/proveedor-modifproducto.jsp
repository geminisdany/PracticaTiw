<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title> Talaver&aacute;mica</title><link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<meta name="keywords" content="Web de compra/venta de ceramica online" />
	<meta name="description" content="Web de compra/venta de productos de ceramica online" />
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1">

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/personal_misc.css">
	<link rel="stylesheet" href="css/personal_proveedor.css">
</head>
<body>
			<div class="responsive-navigation visible-sm visible-xs">
				<c:url value="/ProveedorCatalogo" var="misPro">
		 				<c:param name="evento" value="todos"/>
					</c:url>
				<div class="logo-small row"><a href="${misPro}" class="col-xs-12">Talaver&aacute;mica</a></div>
				<div class="user-menu-small row">
					<ul>
						<li class="user-register-small"><a href="#" class ="col-xs-6">Web Cliente</a></li>
						<li class="user-login-small"><a href="#" class ="col-xs-6">Contacto</a></li>
					</ul>
				</div> 
		        <a href="#" class="menu-toggle-btn menu-small">
		            <i class="fa fa-bars fa-2x"></i>
		        </a>       
		        <ul class="responsive-menu">
		          	<c:url value="/ProveedorCatalogo" var="anadirProd">
		 				<c:param name="aniadir" value="aniadir"/>
					</c:url>
		          	<li class="add-product"><a href="${anadirProd}">A&ntilde;adir Producto</a></li>
				    <c:url value="/ProveedorCatalogo" var="misProducto">
		 				<c:param name="evento" value="todos"/>
					</c:url>
				    <li class="my-products"><a href="${misProducto}">Mis Productos</a></li>
				    <li class="add-publicity"><a href="#">A&ntilde;adir Publicidad</a></li>
				    <c:url value="/ProveedorCatalogo" var="miCuentaP">
		 				<c:param name="cuenta" value="cuenta"/>
					</c:url>
				    <li class="my-account"><a href="${miCuentaP}">Mi Cuenta</a></li>
				    <c:url value="/ProveedorCatalogo" var="logOut">
		 				<c:param name="salir" value="salir"/>
					</c:url>
					<li class="logout"><a href="${logOut}">Salir</a></li>	
		        </ul>
		    </div>

		    <div id="cabecera" class="hidden-sm hidden-xs">
			    <div class="row">
				    <div class="col-xs-4 backgroundred"><div class="client-ref">
				        <a href="#">
	  					  	<span style="display: block;">
	        					Visitar la p&aacute;gina web de Clientes
	    					</span>
						</a>
					</div> </div>
					<div class="col-xs-4" id="page-title">
					<c:url value="/ProveedorCatalogo" var="misProduc">
		 				<c:param name="evento" value="todos"/>
					</c:url>
						<a href="${misProduc}"><h1>Talaver&aacute;mica</h1></a>
						<span>Al m&aacute;s puro estilo Romano</span>
					</div>
					<div class="col-xs-4 backgroundred"><div class="contact-ref">
				        <a href="#">
	  					  	<span style="display: block;">
	        					Contactar con Talaver&aacute;mica
	    					</span>
						</a>
					</div> </div>
				</div>
		    </div>
			
			<div id="navbar" class="hidden-sm hidden-xs">
				<ul class="main-menu">
					<c:url value="/ProveedorCatalogo" var="anadirProdu">
		 				<c:param name="aniadir" value="aniadir"/>
					</c:url>
					<li class="add-product"><a href="${anadirProdu}">A&ntilde;adir Producto</a></li>
				    <c:url value="/ProveedorCatalogo" var="misProduct">
		 				<c:param name="evento" value="todos"/>
					</c:url>
				    <li class="my-products"><a href="${misProduct}">Mis Productos</a></li>
				    <li class="add-publicity"><a href="#">A&ntilde;adir Publicidad</a></li>
				    <c:url value="/ProveedorCatalogo" var="miCuenP">
		 				<c:param name="cuenta" value="cuenta"/>
					</c:url>
				    <li class="my-account"><a href="${miCuenP}]">Mi Cuenta</a></li>
				    <c:url value="/ProveedorCatalogo" var="logOu">
		 				<c:param name="salir" value="salir"/>
					</c:url>
					<li class="logout"><a href="${logOut}">Salir</a></li>	
				</ul>
			</div>
		
		
			<div class="main-slider hidden-sm hidden-xs">
				<div class="flexslider">
					<ul class="slides">

						<li>
							<div class="slider-caption">
							</div>
							<img src="images/slideProv1.jpg" alt="Slide 1">
						</li>

						<li>
							<div class="slider-caption">
							</div>
							<img src="images/slideProv2.jpg" alt="Slide 2">
						</li>

                        <li>
							<div class="slider-caption">
							</div>
							<img src="images/slideProv3.jpg" alt="Slide 3">
						</li>

					</ul>
				</div>
			</div>




		<!--MAIN CONTENT: ELEMENTOS VARIABLES-->
		<div id="main-content">		
			


				<div class="blank-space"></div>
					<div class="container-fluid" id="formularioRegistroC">
						<h1 id="registroC">Modificaci&oacute;n de datos de producto</h1>
						<p>Bienvenido a la p&aacute;gina de modificaciones de datos de productos de Talaver&aacute;mica. Por favor, complete los siguientes campos que quiera editar.</p>
						<c:set var="modificarProducto" scope="session" value="${productoID}"></c:set>
						<form action="GestionarProducto" class="form-horizontal" role="form" method="post" onsubmit="return precios()">
							<input type="hidden" class="form-control" id="idp" name="idp"
								value="${productoID.idp}">
							<div class="row">
							  <div class="form-group col-sm-5" id="columnas62">
								<label for="nombre">Nombre<span class="red">*</span></label>
								<input type="text" class="form-control" id="nombre" name="nombre"
									   value="${productoID.nombre}">
							  </div>
							  <div class="form-group col-sm-2"></div>
							  <div class="form-group col-sm-5" id="columnas6o2">
								<label for="stock">Cantidad<span class="red">*</span></label>
								<input type="text" class="form-control" id="stock" name="stock"
									   value="${productoID.stock}">
							  </div>
							</div>
							<br>
							<div class="row">
							  <div class="form-group col-sm-3"></div>
							  <div class="form-group col-sm-8">
								<label>Categor&iacute;a<span class="red">*</span></label><br>
									<input type="radio" name="tipo" value="vasija" checked>Vasija   
									<input type="radio" name="tipo" value="maceta">Maceta
									<input type="radio" name="tipo" value="copa">Copa
									<input type="radio" name="tipo" value="botijo">Botijo
									<input type="radio" name="tipo" value="tinaja">Tinaja
									<input type="radio" name="tipo" value="fuente">Fuente
							  </div>
							  <div class="form-group col-sm-1"></div>
							</div>
							<br>
							<div class="row">
							  <div class="form-group col-sm-5">
								<label for="pre_min">Precio m&iacute;nimo<span class="red">*</span></label>
								<input type="text" class="form-control" id="pre_min" name="pre_min"
									   value="${productoID.pre_min}">&euro;
							  </div>
							  <div class="form-group col-sm-2"></div>
							  <div class="form-group col-sm-5">
								<label for="pre_max">Precio m&aacute;ximo<span class="red">*</span></label>
								<input type="text" class="form-control" id="pre_max" name="pre_max"
									   value="${productoID.pre_max}">&euro;
							  </div>
							</div>
							<div class="row">
								<div class="form-group col-sm-12">
									<label for="descripcion">Descripci&oacute;n</label>
									<input type="text" maxlength="255" class="form-control" id="descripcion" name="descripcion" value="${productoID.descripcion}">
								</div>
							</div>
							<br>
							<div class="row">
							  <div class="form-group col-sm-3"></div>
							  <div class="form-group col-sm-6">
								<label for="urlImagen">Imagen del producto<span class="glyphicon glyphicon-picture"></span></label>
								<input type="text" class="form-control" id="urlImagen" name="urlImagen" value="${productoID.urlImagen}"> 
							  </div>
							  <div class="form-group col-sm-3"></div>
							</div>
						  <br>
						  <div id="botones">
							<button type="submit" class="btn btn-default validadorForm" id="enviar" onclick="precios()">Guardar<span class="glyphicon glyphicon-ok"></span></button>
							<c:url value="/GestionarProducto" var="cancelarOp"></c:url>
							<span><a class="btn btn-default" id="cancelar" href="${cancelarOp}">Cancelar<span class="glyphicon glyphicon-remove"></span></a></span>
						  </div>
						</form>
					</div>



		</div> <!-- /#main-content -->

		
		<div class="site-footer">
			<div class="first-footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="social-footer">
								<ul>
									<li><a href="#" class="fa fa-facebook"></a></li>
									<li><a href="https://twitter.com/" class="fa fa-twitter"></a></li>
									<li><a href="#" class="fa fa-dribbble"></a></li>
									<li><a href="#" class="fa fa-linkedin"></a></li>
									<li><a href="#" class="fa fa-rss"></a></li>
								</ul>
							</div> <!-- /.social-footer -->
						</div> <!-- /.col-md-12 -->
					</div> <!-- /.row -->
				</div> <!-- /.container-fluid -->
			</div> <!-- /.first-footer -->
			<div class="bottom-footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-xs-6">
							<p class="copyright">Copyright &copy; 2014 <a href="#">Talaver&aacute;mica</a>
                            </p>
						</div> <!-- /.col-md-6 -->
						<div class="col-xs-6 credits">
							<p>Dise&ntilde;o: <a href="https://twitter.com/">Kiwi</a></p>
						</div> <!-- /.col-md-6 -->
					</div> <!-- /.row -->
				</div> <!-- /.container-fluid -->
			</div> <!-- /.bottom-footer -->
		</div> <!-- /.site-footer -->
	<!-- JavaScripts -->
	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/jquery.singlePageNav.js"></script>
	<script src="js/jquery.flexslider.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/proveedor-altamodifproducto.js"></script>
</body>
</html>
