<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
		<hr />
		<div class="col-md-5 mytema">
			<div class="hidden-xs hidden-sm logo text-center">
				<h1><a href="index.jsp">Administración Talaverámica</a></h1> <span>Control de clientes,productos y proveedores</span>
			</div>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-4">
					<form class="form-signin well well-sm" action="Login" method="post" role="form">
					<h3>Iniciar Sesion</h3>
						<div class="input-group form-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
							<input id="email" name="email" type="email" class="form-control" placeholder="Correo" required autofocus> 
						</div>
						
						
						<div class="input-group form-group ">
							<span class="input-group-addon">**</span>
							<input id="password" name="password" type="password" class="form-control" placeholder="Contraseña" required>
						</div>
					
						
						<c:if test='${errorLogin}'>
							<div class="alert-danger alert-dismissible" role="alert">
							  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
							  <small>Correo o Contraseña incorrecta</small>
							</div>	
						</c:if>
						<button class="btn btn-md btn-primary btn-block" type="submit">Ingresar</button>
					</form>
		</div>

</html>