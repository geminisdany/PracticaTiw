<!DOCTYPE html>
<html>
<head>
    <title> Talaver·mica</title><link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<meta name="keywords" content="Web de compra/venta de ceramica online" />
	<meta name="description" content="Web de compra/venta de productos de ceramica online" />
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1">

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/personal_misc.css">
	<link rel="stylesheet" href="css/personal_cliente.css">
</head>
<body>

	<!-- Men√∫ para tablets, m√≥viles y pantallas peque√±as -->
    <div class="responsive-navigation visible-sm visible-xs">
		<div class="logo-small row"><a href="index.jsp" class="col-xs-12">Talaver·mica</a></div>
		<div class="user-menu-small row">
			<ul>
				<li class="user-register-small"><a href="cliente-registroUsuario.jsp" class ="col-xs-6">Registrarse</a></li>
				<li class="user-login-small"><a href="gestionCompra.jsp" class ="col-xs-6">Entrar</a></li>
			</ul>
		</div> 
		<div class="cesta-compra-small row"><a href="gestionCompra.jsp" class="col-xs-12">Cesta de la compra <img src="images/carritoCompra.png" alt="Carrito Compra" width="27" height="27"></a></div>
        <a href="#" class="menu-toggle-btn menu-small">
            <i class="fa fa-bars fa-2x"></i>
        </a>       
        <ul class="responsive-menu">
           <li class="ofertas"><a href="catalogo">Ofertas</a></li>
			<li class="vasijas"><a href="catalogo?tipoCatalogo=vasija">Vasijas</a></li>
			<li class="macetas"><a href="catalogo?tipoCatalogo=maceta">Macetas</a></li>
			<li class="copas"><a href="catalogo?tipoCatalogo=copa">Copas</a></li>
			<li class="botijos"><a href="catalogo?tipoCatalogo=botijo">Botijos</a></li>
			<li class="tinajas"><a href="catalogo?tipoCatalogo=tinaja">Tinajas</a></li>
			<li class="fuentes"><a href="catalogo?tipoCatalogo=fuente">Fuentes</a></li>
        </ul>
    </div>

	<!-- Men√∫ para pantallas grandes-->    
	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo">
			<a href="index.jsp" rel="nofollow"><h1>Talaver·mica</h1></a>
			<span>Al m·s puro estilo Romano</span>
		</div> 		
		   <ul class="main-menu">
                <li class="ofertas"><a href="catalogo">Ofertas</a></li>
			<li class="vasijas"><a href="catalogo?tipoCatalogo=vasija">Vasijas</a></li>
			<li class="macetas"><a href="catalogo?tipoCatalogo=maceta">Macetas</a></li>
			<li class="copas"><a href="catalogo?tipoCatalogo=copa">Copas</a></li>
			<li class="botijos"><a href="catalogo?tipoCatalogo=botijo">Botijos</a></li>
			<li class="tinajas"><a href="catalogo?tipoCatalogo=tinaja">Tinajas</a></li>
			<li class="fuentes"><a href="catalogo?tipoCatalogo=fuente">Fuentes</a></li>
	        </ul>	    
		<div class="navbar-footer">
          	<h2>Bienvenido</h2>
        </div>
	</div>
	<div id="topbar" class="hidden-xs hidden-sm">
		<div class="cesta-compra"><a href="gestionCompra.jsp">Cesta de la compra <img src="images/carritoCompra.png" alt="Carrito Compra" width="27" height="27"></a></div>
			<div class="user-menu">
			<ul>
				<li class="user-register"><a href="cliente-registroUsuario.jsp" class ="col-xs-3">Registrarse</a></li>
				<li class="user-login"><a href="cliente-login.jsp" class ="col-xs-3">Entrar</a></li>
			</ul>
			</div> 				
    </div>

	

	<!-- CONTENIDO QUE DEBER√çA CAMBIAR: todo el div de "main-content". --> 
	<div id="main-content">
		
			<div class="container-fluid" id="formularioRegistroC">
				<h1 id="registroC">Registro de Clientes</h1>
				<p>Bienvenido a la p·gina de registro de Talaver·mica. Por favor, rellene los siguientes campos.</p>
				<form class="form-horizontal" role="form" onSubmit="return validarF()">
					<div class="row">
					  <div class="form-group col-xs-5" id="columnas62">
						<label for="nombreC">Nombre de usuario <span class="red">*</span><span class="glyphicon glyphicon-user" title="Usuario"></span></label>
						<input type="text" class="form-control" id="nombreC" name="nameC"
							   placeholder="Nombre">
					  </div>
					  <div class="form-group col-xs-2"></div>
					  <div class="form-group col-xs-5" id="columnas6o2">
						<label for="aliasC">Alias de usuario <span class="red">*</span></label>
						<input type="text" class="form-control" id="aliasC" name="aliC"
							   placeholder="Alias">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-xs-5">
						<label for="apellido1C">Primer apellido del usuario <span class="red">*</span></label>
						<input type="text" class="form-control" id="apellido1C" name="ape1C" 
							   placeholder="Apellido 1">
					  </div>
					  <div class="form-group col-xs-2"></div>
					  <div class="form-group col-xs-5">
						<label for="apellido2C">Segundo apellido del usuario <span class="red">*</span></label>
						<input type="text" class="form-control" id="apellido2C" name="ape2C"
							   placeholder="Apellido 2">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-xs-5">
						<label for="emailC">Email <span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Email"></span></label>
						<input type="email" class="form-control" id="emailC" name="hotmailC" 
								   placeholder="Email">
					  </div>
					  <div class="form-group col-xs-2"></div>
					  <div class="form-group col-xs-5">
						<label for="telefonoC">Tel&eacute;fono del usuario <span class="red">*</span><span class="glyphicon glyphicon-phone-alt" title="Telefono"></span></label>
						<input type="tel" class="form-control" id="telefonoC" name="phoneC"
							   placeholder="Telefono">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-xs-5">
						<label for="pwdC">Contrase√±a <span class="red">*</span><span class="glyphicon glyphicon-lock" title="Contrase√±a"></span></label>
						<input type="password" class="form-control" id="pwdC" name="wordC"
							   placeholder="ContraseÒa">
					  </div>
					  <div class="form-group col-xs-2"></div>
					  <div class="form-group col-xs-5">
						<label for="pwd2C">Confirmar contrase√±a <span class="red">*</span></label>
						<input type="password" class="form-control" id="pwd2C" name="word2C"
							   placeholder="ContraseÒa">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-xs-4">
						<label for="direccionC">Direcci&oacute;n <span class="red">*</span><span class="glyphicon glyphicon-lock" title="Direcci√≥n"></span></label>
						<input type="text" class="form-control" id="direccionC" name="addrC"
							   placeholder="C/calle-numero-escalera-piso-puerta">
					  </div>
					  <div class="form-group col-xs-1"></div>
					  <div class="form-group col-xs-2">
						<label for="codpostC"> C&oacute;digo postal <span class="red">*</span></label>
						<input type="text" class="form-control" id="codpostC" name="postC"
								placeholder="28054" maxlength="5">
					  </div>
					  <div class="form-group col-xs-1"></div>
					  <div class="form-group col-xs-4">
						<label for="ciupC">Ciudad, Pa&iacute;s <span class="red">*</span></label>
						<input type="text" class="form-control" id="ciupC" name="citycC"
							   placeholder="Ciudad, Pa√≠s">
					  </div>
					</div>
				  <br>
				  <div class="form-group">
					<label for="archivoC">Adjuntar un archivo <span class="glyphicon glyphicon-picture"></span></label>
					<input type="file" id="archivoC"> 
					<img id="img-destino" src="#" alt="Imagen subida">
				  </div>
				  <br>
				  <div class="checkbox">
					<label>
					  <input type="checkbox"> Deseo recibir correos con novedades y ofertas de Talaver&aacute;mica
					</label>
				  </div>
				  <br>
				  <div id="botones">
					<button type="submit" class="btn btn-default" id="enviar" class="validadorForm()" onclick="pwdIguales()">Enviar <span class="glyphicon glyphicon-ok"></span></button>
					<span><button type="reset" class="btn btn-default" id="cancelar">Cancelar <span class="glyphicon glyphicon-remove"></span></button></span>
				  </div>
				</form>
			</div>


	</div>
	<!-- FIN del div de "main-content">



	<!-- FOOTER -->	
	<div class="site-footer">
		<div class="first-footer">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="social-footer">
							<ul>
								<li><a href="#" class="fa fa-facebook"></a></li>
								<li><a href="#" class="fa fa-twitter"></a></li>
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
					<div class="col-xs-6">
						<p class="copyright">
								Copyright © 2014 <a href="#">Talaver·mica</a>
							</p>
					</div>
					<div class="col-xs-6 credits">
						<p>DiseÒo: <a href="index.jsp">Kiwi</a></p>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- JavaScripts -->
	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/jquery.singlePageNav.js"></script>
	<script src="js/jquery.flexslider.js"></script>
	<script src="js/custom.js"></script>
	<script type="text/javascript" src="js/pruebabootstrap.js"></script>
</body>
</html>