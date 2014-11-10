<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Talaverámica</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<meta name="keywords" content="Web de compra/venta de ceramica online" />
<meta name="description" content="Web de compra/venta de productos de ceramica online" />
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1">

<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/personal_misc.css">
<link rel="stylesheet" href="css/personal_cliente.css">

<!-- JavaScripts -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.singlePageNav.js"></script>
<script src="js/jquery.flexslider.js"></script>
<script src="js/custom.js"></script>
<script src="js/jquery.flexslider.js"></script>


</head>

<body>
	<!-- Menu Lateral -->
		<jsp:include page="menuLateral.jsp"></jsp:include>
	<!-- Fin de Menu Lateral -->
	
	
	<!-- Cabecera -->
		<jsp:include page="cabecera.jsp"></jsp:include>
	<!-- Fin de Cabecera -->
	
	<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". -->
				<c:choose>
					<c:when test="${action!=null}">
						
						<c:if test="${action=='registroCliente'}">
						<jsp:include page="registroCliente.jsp"></jsp:include>	
						</c:if>
						
						<c:if test="${action=='mostrarDatos'}">
						<jsp:include page="datosCliente.jsp"></jsp:include>	
						</c:if>
						
						<c:if test="${action=='catalogo'}">
						<jsp:include page="catalogo.jsp"></jsp:include>	
						</c:if>
						
						<c:if test="${action=='mostrarProducto'}">
							<jsp:include page="producto.jsp"></jsp:include>	
						</c:if>
						
						<c:if test="${action=='mostrarCarrito'}">
							<jsp:include page="carrito.jsp"></jsp:include>	
						</c:if>
						<c:if test="${action=='formPedido'}">
							<jsp:include page="registrarFactura.jsp"></jsp:include>	
						</c:if>
						
						<c:if test="${action=='datosFactura'}">
							<jsp:include page="datosFactura.jsp"></jsp:include>	
						</c:if>
						
					</c:when>
					<c:otherwise>
						<jsp:include page="presentacion.jsp"></jsp:include>					
					</c:otherwise>	
				</c:choose>	
	
	<!-- FIN del div de "main-content"--->



	<!-- Pie de Pagina -->
		<jsp:include page="piePagina.jsp"></jsp:include>
	<!-- Fin de Pie de Pagina  -->
		
	
</body>
</html>