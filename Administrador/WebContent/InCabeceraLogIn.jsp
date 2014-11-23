<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<c:set var="AdmValidado" scope="session" value="${adminValidado}"></c:set>
		<hr/>
		<div class="col-md-5 mytema">		
				<div class=" hidden-xs hidden-sm logo text-center">
					<h1><a href="index.jsp">Administración Talaverámica</a></h1> <span>Control de clientes,productos y proveedores</span>
				</div>	
		</div>
		<div class="col-md-2"></div>
		<div class="well col-md-4">
			<h1>Bienvenido</h1>
			<h2><small> ${AdmValidado} </small></h2>
			
		<a class="btn btn-md btn-primary btn-block" href="Login?action=logOut">Cerrar Sesion</a>
		</div>
		<div class="col-md-12"></div>

</html> 