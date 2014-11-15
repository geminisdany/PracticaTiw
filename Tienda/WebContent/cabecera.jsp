<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<c:set var="cestTotal" scope="session" value="${cestaTotal}"></c:set>
	
	<div id="topbar" class="hidden-xs hidden-sm">
		
		<!-- Cesta de la compra -->
		<div class="cesta-compra">
			<a href="cart?action=mostrarLista">Cesta de la compra <img
				src="images/carritoCompra.png" alt="Carrito Compra" width="27"
				height="27"> <c:if test="${cestTotal!=null}"><span class="badge"> <c:out value="${cestTotal}"></c:out></span></c:if></a>
		</div>
		<!-- Fin de cesta de la compra -->
		
		<!-- Menu de Usuario de Sesion -->
			<div><jsp:include page="sesionCliente.jsp"></jsp:include></div>	
		<!-- Fin de Menu de Usuario de Sesion -->
		
	
	</div>
	
	
	<!------------------------ Ventana Modal:Login -------------------------->				
					<div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="main-content">	
						<div id="login-menu">
							<div class="col-md-4 col-xs-1">
							</div>
							<div class="col-md-4 col-xs-10" id="login-form">
							<hr class="hidden-md hidden-lg"/>
							<hr class="hidden-md hidden-lg"/>
							<hr class="hidden-md hidden-lg"/>
								<h1 class="title " >Acceso para Clientes</h1>
								<form action="login" method="post" role="form" >
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
	<!------------------------ Fin ventana modal:Login -------------------------->
	
	

</html>