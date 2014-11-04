<!DOCTYPE html>
<html>
<head>
    <title> Talaverámica</title><link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
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

	<!-- MenÃº para tablets, mÃ³viles y pantallas pequeÃ±as -->
    <div class="responsive-navigation visible-sm visible-xs">
		<div class="logo-small row"><a href="index.jsp" class="col-xs-12">Talaverámica</a></div>
		<div class="user-menu-small row">
			<ul>
				<li class="user-register-small"><a href="cliente-registroUsuario.jsp" class ="col-xs-6">Registrarse</a></li>
				<li class="user-login-small"><a href="cliente-login.jsp" class ="col-xs-6">Entrar</a></li>
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

	<!-- MenÃº para pantallas grandes-->    
	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo">
			<a href="index.jsp" rel="nofollow"><h1>Talaverámica</h1></a>
			<span>Al más puro estilo Romano</span>
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

	

	<!-- CONTENIDO QUE DEBERÃA CAMBIAR: todo el div de "main-content". --> 
	<div id="main-content">
		
	


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
								Copyright © 2014 <a href="#">Talaverámica</a>
							</p>
					</div>
					<div class="col-xs-6 credits">
						<p>Diseño: <a href="#">Kiwi</a></p>
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