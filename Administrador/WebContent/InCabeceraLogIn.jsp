<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
		<hr/>
		<div class="col-md-5 mytema">		
				<div class=" hidden-xs hidden-sm logo text-center">
					<a href="#" "><h1>Administración Talaverámica</h1></a> <span>Control de clientes,productos y proveedores</span>
				</div>	
		</div>
		<div class="col-md-2"></div>
		<div class="well col-md-4">
			<h1>Bienvenido</h1>
			<h2><small>Administrador</small></h2>
			
			<c:url value="/Login" var="cerrarSesion">
 				<c:param name="accion" value="logOut"/>
			</c:url>
		<a class="btn btn-md btn-primary btn-block" href="${cerrarSesion}">Cerrar Sesion</a>
		</div>
		<div class="col-md-12"></div>

</html> 