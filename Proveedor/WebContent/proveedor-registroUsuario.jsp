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
						<li class="user-login-small"><a href="#" class ="col-xs-6">Contacto</a></li>
					</ul>
				</div> 
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
					<c:url value="/SesionProveedor" var="volverLogin">
		 				<c:param name="evento" value="login"/>
					</c:url>
						<h1><a href="${volverLogin}">Talaver&aacute;mica</a></h1>
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
			


			<div class="container-fluid" id="formularioRegistroC">
				<h1 id="registroC">Registro de Proveedores</h1>
				<p>Bienvenido a la p&aacute;gina de registro de Talaver&aacute;mica. Por favor, rellene los siguientes campos.</p>
				<form action="RegistroUsuario" class="form-horizontal" role="form" method="post" onsubmit="return pwdIguales()">
					<div class="row">
					  <div class="form-group col-sm-5" id="columnas62">
						<label for="nombre">Nombre del Proveedor<span class="red">*</span><span class="glyphicon glyphicon-user" title="Usuario"></span></label>
						<input type="text" class="form-control" id="nombre" name="nombre"
							   placeholder="Nombre">
					  </div>
					  <div class="form-group col-sm-2"></div>
					  <div class="form-group col-sm-5" id="columnas6o2">
						<label for="cif">CIF del proveedor<span class="red">*</span></label>
						<input type="text" class="form-control" id="cif" name="cif"
							   placeholder="CIF">
					  </div>
					</div>
					<br>					
					<div class="row">
					  <div class="form-group col-sm-5">
						<label for="email">Email del proveedor<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Email"></span></label>
						<input type="email" class="form-control" id="email" name="email"
								   placeholder="Email">
					  </div>
					  <div class="form-group col-sm-2"></div>
					  <div class="form-group col-sm-5">
						<label for="tlf">Tel&eacute;fono del proveedor <span class="red">*</span><span class="glyphicon glyphicon-phone-alt" title="Tel&eacute;fono"></span></label>
						<input type="text" class="form-control" id="tlf" name="tlf"
							   placeholder="Tel&eacute;fono">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-sm-5">
						<label for="contras">Contrase&ntilde;a del proveedor<span class="red">*</span><span class="glyphicon glyphicon-lock" title="Contrase&ntilde;a"></span></label>
						<input type="password" class="form-control" id="contras" name="contras"
							   placeholder="*************">
					  </div>
					  <div class="form-group col-sm-2"></div>
					  <div class="form-group col-sm-5">
						<label for="pwd2P">Confirmar contrase&ntilde;a <span class="red">*</span></label>
						<input type="password" class="form-control" id="pwd2P" name="pwd2P"
							   placeholder="*************">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-sm-6">
						<label for="direccion">Direcci&oacute;n<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Direcci&oacute;n"></span></label>
						<input type="text" class="form-control" id="direccion" name="direccion"
							   placeholder="C/calle n&uacute;mero escalera piso puerta">
					  </div>
					  <div class="form-group col-sm-1"></div>
					  <div class="form-group col-sm-5">
						<label for="ciudad">Localidad<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Localidad"></span></label>
						<input type="text" class="form-control" id="ciudad" name="ciudad"
							   placeholder="Localidad">
					  </div>
					</div>
					<br>
					<div class="row"> 
					  <div class="form-group col-sm-2">
						<label for="cp"> CP <span class="red">*</span></label>
						<input type="text" class="form-control" id="cp" name="cp"
								placeholder="28054" maxlength="5">
					  </div>
					  <div class="form-group col-sm-1"></div>
					  <div class="form-group col-sm-4">
						<label for=provincia>Provincia<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Provincia"></span></label>
						<input type="text" class="form-control" id="provincia" name="provincia"
							   placeholder="Provincia">
					  </div>
					  <div class="form-group col-sm-1"></div>
					  <div class="form-group col-sm-4">
						<label for="pais">Pa&iacute;s<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Pa&iacute;s"></span></label>
						<input type="text" class="form-control" id="pais" name="pais"
							   placeholder="Pa&iacute;s">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-sm-5">
						<label for="web">Web del proveedor<span class="red">*</span><span class="glyphicon glyphicon-globe" title="Web"></span></label>
						<input type="url" class="form-control" id="web" name="web"
							   placeholder="http://www.pagina-proveedor.extension">
					  </div>
					  <div class="form-group col-sm-7"></div>
					</div>
				  <br>				  
				  <div class="checkbox">
					<label>
					  <input type="checkbox"> Deseo recibir correos con novedades y ofertas de Talaver&aacute;mica
					</label>
				  </div>
				  <br>
				  <div id="botones">
					<button type="submit" class="btn btn-default validadorForm" id="enviar">Enviar <span class="glyphicon glyphicon-ok"></span></button>
					<c:url value="/RegistroUsuario" var="cancelarOp"></c:url>
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
	<script type="text/javascript" src="js/registroProveedores.js"></script>


</body>
</html>
