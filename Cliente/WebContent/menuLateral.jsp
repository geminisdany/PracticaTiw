<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<c:set var="cliVal" scope="session" value="${clienteValidado}"></c:set>
<!--Menu Top -para tablets, moviles y pantallas pequeñas -->
	<div class="responsive-navigation visible-sm visible-xs">
		<div class="logo-small row">
			<a href="index.jsp" class="col-xs-12">Talaverámica</a>
		</div>
		<div class="user-menu-small row">
			<ul>
				<li class="user-register-small"><a href="registro" class="col-xs-6">Registrarse</a></li>
				<li class="user-login-small"><a data-toggle="modal" data-target="#modalLogin" href="#Iniciar-Sesion" class="col-xs-6">Entrar</a></li>
			</ul>
		</div>
		<div class="cesta-compra-small row">
			<a href="gestionCompra.jsp" class="col-xs-12">Cesta de la compra <img
				src="images/carritoCompra.png" alt="Carrito Compra" width="27"
				height="27"></a>
		</div>
		<a href="#" class="menu-toggle-btn menu-small"> <i
			class="fa fa-bars fa-2x"></i>
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
	<!-- *******fin pantallas pequeñas***** -->
	
	
	
	<!--Menu lateral, para pantallas grandes-->
	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo">
			<h2><a href="index.jsp" rel="nofollow"> Talaverámica</a> </h2><span>Al más puro
				estilo Romano</span>
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
		<c:if test="${cliVal!=null}">
			<div class="navbar-footer">
			<h2>Bienvenido <c:out value="${cliVal}"></c:out></h2>
			</div>
		</c:if>
		
	</div>
	<!-- ****fin pantallas grandes*** -->

</html>