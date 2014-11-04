<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<c:set var="AdmValidado" scope="session" value="${adminValidado}"></c:set>
	<c:choose>
		<c:when test="${AdmValidado}">
			<c:url value="./ProveedorCatalogo" var="misProductos">
 				<c:param name="evento" value="todos"/>
			</c:url>
			<c:redirect url="${misProductos}"></c:redirect>
		</c:when>
		<c:otherwise>
			<jsp:include page="proveedor-login.jsp"></jsp:include>
		</c:otherwise>	
	</c:choose>
</body>
</html>