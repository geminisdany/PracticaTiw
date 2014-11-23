<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<c:set var="cliVal" scope="session" value="${clienteValidado}"></c:set>
		<c:choose>
			<c:when test="${cliVal!=null}">
				<div class="user-menu">
					<ul>
					<li class="user-login"><a href="login" class="col-md-3">Salir</a></li>	
						<li class="user-register"><a href="registro?action=modificarCliente" class="col-xs-3">Mis Datos</a></li>
						<li class="user-bvd"><a  class="col-md-5">Bienvenido <c:out value="${cliVal}"></c:out></a></li>					
					</ul>
				</div>
				
			
				
			</c:when>		
			<c:otherwise>
				<div class="user-menu">
					<ul>
					
						<li class="user-register"><a href="registro?action=formulario" class="col-xs-3">Registrarse</a></li>
						<li class="user-in"><a  data-toggle="modal" data-target="#modalLogin" href="#Iniciar-Sesion" class="col-md-3">Entrar</a></li>
					</ul>
				</div>
				

				
				
			</c:otherwise>
		</c:choose>
		
		


	
	
</html>