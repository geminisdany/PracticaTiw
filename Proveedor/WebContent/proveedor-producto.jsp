<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title> TalaverÃ¡mica</title><link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
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
			


			<div class="container-fluid">
				<div id="product" class="section-content">
					<div class="row">
						<div class="col-md-12">
							<div class="section-title">
								<h2>Producto</h2>
							</div>
						</div>
					</div>
					<div class="row" id="productoEstiloCliente">
					<c:set var="mostrarProducto" scope="session" value="${productoID}"></c:set>
						<div class="col-md-4">
							<div class="member-item">
								<div class="member-thumb">
									<img src="${productoID.urlImagen}" alt="${productoID.nombre}">
								</div>
								<div class="member-content">
									<h4><c:out value="${productoID.nombre}"></c:out></h4>
								</div>
							</div>
						</div> <!-- /.col-md-4 -->
						<div class="col-md-8">
							<div class="member-item">
								<div class="member-thumb" id="datosProductoCliente">
									<p class="formatoCamposProducto">Precio m&aacute;ximo: <c:out value="${productoID.pre_max}"></c:out></p>
									<p class="formatoCamposProducto">Precio m&iacute;nimo: <c:out value="${productoID.pre_min}"></c:out></p>
									<p class="formatoCamposProducto">Categor&iacute;a: <c:out value="${productoID.tipo}"></c:out></p>
									<p class="formatoCamposProducto">Cantidad: <c:out value="${productoID.stock}"></c:out></p>
									<p class="formatoCamposProducto">Descripci&oacute;n: <c:out value="${productoID.descripcion}"></c:out></p>
								</div>
								<div class="load-more">
									<c:url value="/ProveedorCatalogo" var="gestionProducto">
						 				<c:param name="modificar" value="${productoID.idp}"/>
									</c:url>
									<a href="${gestionProducto}" class="largeButton portfolioBgColor">Editar Producto</a>
								</div>
							</div>
						</div> 
					</div> 
				</div> 
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


</body>
</html>
