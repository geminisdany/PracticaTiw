<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<div id="topbar" class="hidden-xs hidden-sm">
		<!-- Cesta de la compra -->
		<div class="cesta-compra">
			<a href="gestionCompra.jsp">Cesta de la compra <img
				src="images/carritoCompra.png" alt="Carrito Compra" width="27"
				height="27"></a>
		</div>
		<!-- Fin de cesta de la compra -->
		
		<!-- Menu de Usuario de Sesion -->
			<jsp:include page="sesionCliente.jsp"></jsp:include>	
		<!-- Fin de Menu de Usuario de Sesion -->
	</div>
	
	
	
	
	
	
	<!------------------------ Ventana modal:Login -------------------------->				
					<div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="main-content">	
						<div id="login-menu">
						<div class="row">
							<div class="col-md-4">
							</div>
							<div class="col-md-4" id="login-form">
							<hr/>
								<h1 class="title " >Acceso para Clientes</h1>
								<form action="Login" method="post" role="form" >
								  <div class="form-group">
								    <label for="user" class="uppercase">Usuario</label>
								   <input type="text" class="form-control" id="user" name="user" placeholder="usuario">
								  </div>
								  <div class="form-group">
								    <label for="password" class="uppercase">Contraseña</label>
								    <input type="password" class="form-control" id="password" name="password" placeholder="**********">
								  </div>
								  <div class="row margintop">
									   <div class="col-md-6"><button type="submit" class="btn btn-block btn-primary">Entrar</button></div>
									   <div class="col-md-6"><button type="button"  data-dismiss="modal" class="btn btn-block btn-danger">Cancelar</button></div>
									</div>
								</form>
							</div>
							<div class="col-md-4"></div>
						</div>
					</div>
				</div>									
	<!------------------------ Fin ventana modal:Login -------------------------->
	
	

</html>