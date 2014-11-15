<!DOCTYPE html>
<html>
<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". -->
	<div id="main-content">
	<div class="blank-space"></div>
	
	<!-- Barra de navegacion -->
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<h3>Seccion de Cliente</h3>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="active">
						<a href="#">Modificar Datos <span class="sr-only">(current)</span></a>
					</li>
					<li>
						<a href="#">Cambiar Contraseña</a>
					</li>
					
					<li>
						<a href="#">Historial de Compras</a>
					</li>
					<li>
						<a href="#">Suscripciones</a>
					</li>
					
				</ul>
				
				
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- Fin barra de navegacion -->
	
	
	<jsp:include page="registroCliente.jsp"></jsp:include>
	
	
</div>
	
</html>