<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<h2>Suscripciones</h2>
<c:choose>
	<c:when test="${haySuscripciones}">
		<jsp:include page="catalogo.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<h2>No hay Suscripiones</h2>
		<h4>No te has suscrito a ningun producto, pasa por nuestro
			catagolo</h4>
	</c:otherwise>
</c:choose>

</html>