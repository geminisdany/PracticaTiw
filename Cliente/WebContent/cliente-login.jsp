<!DOCTYPE html>
<html>
<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". action="Login"  servletn form falta implementacion--> 
	<div id="main-content">	
			<div id="login-menu">
			<div class="row">
				<div class="col-xs-4"></div>
				<div class="col-xs-4" id="login-form">
					<h1 class="title">Acceso para Clientes</h1>
					<form role="form" >
					  <div class="form-group">
					    <label for="user" class="uppercase">Usuario</label>
					   <input type="text" class="form-control" id="user" name="user" placeholder="usuario">
					  </div>
					  <div class="form-group">
					    <label for="password" class="uppercase">Contraseña</label>
					    <input type="password" class="form-control" id="password" name="password" placeholder="**********">
					  </div>
					  <div class="row margintop">
						   <div class="col-xs-6"><button type="submit" class="btn btn-block btn-primary">Entrar</button></div>
						   <div class="col-xs-6"><a href="cliente-registroUsuario.jsp"><button class="btn btn-block btn-danger">Registrarse</button></a></div>
						</div>
					</form>
				</div>
				<div class="col-xs-4"></div>
			</div>
		</div>
	</div>
	<!-- FIN del div de "main-content"-->
</html>