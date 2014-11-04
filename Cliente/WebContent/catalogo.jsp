<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<c:choose>
		<c:when test="${tipoCatalogo==null}">
				<jsp:include page="cliente-ofertas.jsp"></jsp:include>			
		</c:when>
		<c:otherwise>	
				<jsp:include page="catalogoTipos.jsp"></jsp:include>				
		</c:otherwise>	
				</c:choose>	

</html>