<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						<li class="user-login-small"><a href="#" class ="col-xs-6"><c:set var="provLog" scope="session" value="${proveedorLogeado}"></c:set>
							Bienvenido <c:out value="${provLog.nombre}"></c:out></a></li>
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
				    <!-- <li class="add-publicity"><a href="#">A&ntilde;adir Publicidad</a></li> -->
				    <c:url value="/ProveedorCatalogo" var="miCuentaP">
		 				<c:param name="cuenta" value="cuenta"/>
					</c:url>
				    <li class="my-account"><a href="${miCuentaP}">Mi Cuenta</a></li>
				    <c:url value="/ProveedorCatalogo" var="misSuscripciones">
		 				<c:param name="suscripcion" value="suscripcion"/>
					</c:url>
					<li class="suscripcion"><a href="${misSuscripciones}">Suscripciones</a></li>
				    <c:url value="/ProveedorCatalogo" var="misAvisos">
		 				<c:param name="avisos" value="avisos"/>
					</c:url>
					<li class="aviso"><a href="${misAvisos}">Avisos de Stock</a></li>
					<c:url value="/ProveedorCatalogo" var="misFacturas">
		 				<c:param name="factura" value="factura"/>
					</c:url>
					<li class="facturacion"><a href="${misFacturas}">Facturaci&oacute;n</a></li>
					<c:url value="/ProveedorCatalogo" var="logOut">
		 				<c:param name="salir" value="salir"/>
					</c:url>
					<li class="logout"><a href="${logOut}">Salir</a></li>	
		        </ul>
		    </div>

		    <div id="cabecera" class="hidden-sm hidden-xs">
			    <div class="row">
				    <div class="col-xs-4 backgroundred"><div class="client-ref">
				        <span style="display: block;">
	  						<c:set var="provLog" scope="session" value="${proveedorLogeado}"></c:set>
							Bienvenido <c:out value="${provLog.nombre}"></c:out>
	    				</span>
					</div> </div>
					<div class="col-xs-4" id="page-title">
					<c:url value="/ProveedorCatalogo" var="misProduc">
		 				<c:param name="evento" value="todos"/>
					</c:url>
						<h1><a href="${misProduc}">Talaver&aacute;mica</a></h1>
						<span>Al m&aacute;s puro estilo Romano</span>
					</div>
					<div class="col-xs-4 backgroundred"><div class="contact-ref">
	  					<a href="#">
	  					  	<span style="display: block;">
	        					Visitar la p&aacute;gina web de Clientes
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
				    <!-- <li class="add-publicity"><a href="#">A&ntilde;adir Publicidad</a></li> -->
				    <c:url value="/ProveedorCatalogo" var="miCuenP">
		 				<c:param name="cuenta" value="cuenta"/>
					</c:url>
				    <li class="my-account"><a href="${miCuenP}]">Mi Cuenta</a></li>
				    <c:url value="/ProveedorCatalogo" var="misSusc">
		 				<c:param name="suscripcion" value="suscripcion"/>
					</c:url>
					<li class="suscripcion"><a href="${misSusc}">Suscripciones</a></li>
				    <c:url value="/ProveedorCatalogo" var="misAvis">
		 				<c:param name="avisos" value="avisos"/>
					</c:url>
					<li class="aviso"><a href="${misAvis}">Avisos de Stock</a></li>
					<c:url value="/ProveedorCatalogo" var="misFact">
		 				<c:param name="factura" value="factura"/>
					</c:url>
					<li class="facturacion"><a href="${misFact}">Facturaci&oacute;n</a></li>
					<c:url value="/ProveedorCatalogo" var="logOu">
		 				<c:param name="salir" value="salir"/>
					</c:url>
					<li class="logout"><a href="${logOu}">Salir</a></li>	
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
				<c:set var="provLog" scope="session" value="${proveedorLogeado}"></c:set>
				<h1 id="registroC">Avisos de stock bajo</h1>
				<p>A continuaci&oacute;n se muestra el nombre, el stock actual y el umbral de stock m&iacute;nimo de los productos cuyo stock est&aacute; por debajo del deseado.</p>
				<c:set var="HayAviso" scope="session" value="${hayAvisos}"></c:set>
				<c:choose>
					<c:when test="${HayAviso}">
						<c:set var="listaAviso" scope="session" value="${listaAvisos}"></c:set>
						<div class="row">
							<div class="col-xs-4">
								<b>NOMBRE PRODUCTO</b>
							</div>
							<div class="col-xs-4">
								<b>UMBRAL M&Iacute;NIMO</b>
							</div>
							<div class="col-xs-4">
								<b>STOCK ACTUAL</b>
							</div>
						</div>
						<c:forEach items="${listaAviso}" var="productoAviso">
							<div class="row">
								<div class="col-xs-4">
									<c:out value="${productoAviso.nombre}"></c:out>
								</div>
								<div class="col-xs-4">
									<c:out value="${productoAviso.umbralStock}"></c:out>
								</div>
								<div class="col-xs-4">
									<c:out value="${productoAviso.stock}"></c:out>
								</div>
							</div>
						</c:forEach>
						<br>
						<div id="botones">
							<c:url value="/ProveedorCatalogo" var="volverCatalogo">
				 				<c:param name="evento" value="todos"/>
							</c:url>
							<a class="btn btn-primary" id="miCatalogo" href="${volverCatalogo}">Volver a mi cat&aacute;logo</a>
						</div>
					</c:when>
					<c:otherwise>
						<p>No hay productos con stock bajo.</p>
					</c:otherwise>
				</c:choose>	
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
