<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<br></br>
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
					<li <c:if test="${panelDatos}"> class="active" </c:if> >
						<a href="registro?action=modificarCliente">Editar Datos <span class="sr-only">(current)</span></a>
					</li>
					<li <c:if test="${panelPass}"> class="active" </c:if>>
						<a href="registro?action=cambiarPass">Cambiar Contraseña</a>
					</li>
					
					<li <c:if test="${panelHistorial}"> class="active" </c:if>>
						<a href="registro?action=historial">Historial de Compras</a>
					</li>
					<li <c:if test="${panelSuscripcion}"> class="active" </c:if>>
						<a href="suscribirse?action=mostrarSuscripciones">Suscripciones</a>
					</li>
					
				</ul>
				
				
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- Fin barra de navegacion -->
	
	
	
	
	<c:if test="${panelDatos}"><jsp:include page="editarCliente.jsp"></jsp:include></c:if> 
	
	<c:if test='${panelPass}'> <jsp:include page="cambiarPassCliente.jsp"></jsp:include></c:if>
	
	<c:if test='${panelHistorial}'><jsp:include page="historialFacturasCliente.jsp"></jsp:include></c:if>
	
	<c:if test='${panelSuscripcion}'><jsp:include page="suscripcionesCliente.jsp"></jsp:include></c:if>

</div>
</html>