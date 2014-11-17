<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<h2>Historial de Compras</h2>

<c:choose>
	<c:when test="${panelFactura}">
		<!-- Lista de Facturas -->
		<c:if test="${listaFacturas!=null}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID Factura</th>
						<th>Productos</th>
						<th>Fecha</th>
						<th>Precio Total</th>
						<th class="text-center">Opciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaFacturas}" var="factura">
						<tr>
							<td><c:out value="${factura.id}"></c:out></td>
							<td><c:out value="${factura.numProductos()}"></c:out></td>
							<td><c:out value="${cliente.fecha}"></c:out></td>
							<td><c:out value="${cliente.precio}"></c:out></td>
							<td class="text-center"><a class="btn btn-danger btn-xs"
								title="Ver Detalles de Factura"
								href="XXXXXX?action=detalleFactura&id=${factura.id}"> <span
									class="glyphicon glyphicon-trash"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</c:if>


		<!-- Detalles de Factura -->
		<c:if test="${detalleFactura!=null}">

		</c:if>
	</c:when>
	<c:otherwise>
		<h3>No hay historial de Compras</h3>
	</c:otherwise>
</c:choose>
</html>