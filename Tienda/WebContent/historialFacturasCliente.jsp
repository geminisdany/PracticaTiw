<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<h2>Historial de Compras</h2>

<c:choose>
	<c:when test="${panelHistorial}">
		<!-- Lista de Facturas -->
		<c:if test="${listaFacturas!=null}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID Factura</th>
						<th>Pedidos</th>
						<th>Fecha</th>
						<th>Hora</th>
						<th>Precio Total</th>
						<th class="text-center">Opciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaFacturas}" var="factura">
						<tr>
							<td><c:out value="${factura.id}"></c:out></td>
							<td><c:out value="${factura.pedidos.size()}"></c:out></td>
							<td><c:out value="${factura.fecha}"></c:out></td>
							<td><c:out value="${factura.hora}"></c:out></td>
							<td><c:out value="${factura.importe}"></c:out></td>
							<td class="text-center"><a class="btn btn-danger btn-xs"
								title="Ver Detalles de Factura"
								href="registro?action=detalleFactura&id=${factura.id}"> <span
									class="glyphicon glyphicon-trash"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</c:if>


		<!-- Detalles de Factura -->
		<c:if test="${factura!=null}">
				<jsp:include page="datosFactura.jsp"></jsp:include>
		</c:if>
		
	</c:when>
	<c:otherwise>
		<h3>No hay historial de Compras</h3>
	</c:otherwise>
</c:choose>
</html>