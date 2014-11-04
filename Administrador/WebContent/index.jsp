
<!-- para activar preview ::::: sudo apt-get install libwebkitgtk-1.0-0 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link href="style/css/bootstrap.css" rel="stylesheet">
<link href="style/css/cssPersonalizado.css" rel="stylesheet">

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scriptPersonalizado.js"></script>
<title>Administración KiwiSoft</title>
</head>
<body>
	<c:set var="AdmValidado" scope="session" value="${adminValidado}"></c:set>
	<div class="mytema"><hr/></div>
	<div class="container">
			
			<div class="header">
				<c:choose>
					<c:when test="${AdmValidado}">
						<jsp:include page="InCabeceraLogIn.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="InCabeceraLogOut.jsp"></jsp:include>
					</c:otherwise>	
				</c:choose>			
			</div><!--Fin de cabecera-->
			
			<div class="row">
				<div class="col-md-12">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs nav-justified" role="tablist">
					  <li <c:if test='${panelCliente}'>class="active"</c:if> > <a href="<c:if test='${!AdmValidado}'>#</c:if>gestionClientes" role="tab" >Clientes</a></li>
					  <li <c:if test='${panelProveedor}'>class="active"</c:if> > <a href="<c:if test='${!AdmValidado}'>#</c:if>gestionProveedores" role="tab">Proveedores</a></li>
					  <li <c:if test='${panelProducto}'>class="active"</c:if> ><a href="<c:if test='${!AdmValidado}'>#</c:if>gestionProductos" role="tab" >Productos</a></li>
					  <li><a href="#otros" role="tab" data-toggle="tab">Settings</a></li>
					</ul>
					
					<c:if test="${AdmValidado}">
						<jsp:include page="InCuerpo.jsp"></jsp:include>
					</c:if>
				</div>
				
			</div>
				
	</div>							
	<!-- Pie de pagina -->
		<jsp:include page="InPiePagina.jsp"></jsp:include>
	<!-- Fin Pie de Pagina -->
</body>
</html>