<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<c:choose>
	<c:when test="${hayFacturas}">
		<!-- Lista de Facturas -->
		<c:if test="${listaFacturas!=null}">
			<h2>Historial de Compras</h2>
			<form action="registro" method="get" class="form-inline" role="form">
				<div class="form-group">
					<input type="text" name="action" value="buscarFacturasByFecha"
						hidden> <input type="text" class="form-control"
						id="datepicker" name="fecha" placeholder="dd/mm/yyyy">
				</div>
				<button type="submit" class=" btn btn-default">Buscar por
					Fecha</button>
				<a href="registro?action=ordenarByFecha" class="btn btn-default">Ordenar
					por fecha</a>
			</form>

			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID Factura</th>
						<th>Pedidos</th>
						<th>Fecha (day/month/year/)</th>
						<th>Precio Total</th>
						<th class="text-center">Beneficios</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaFacturas}" var="factura">
						<tr>
							<td><c:out value="${factura.id}"></c:out></td>
							<td><c:out value="${factura.pedidos.size()}"></c:out></td>
							<td><c:out value="${factura.fechaUsuario()}"></c:out></td>
							<td><c:out value="${factura.importe}"></c:out></td>
							<td class="text-center">     </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</c:if>

	</c:when>
	<c:otherwise>

		<h3>No hay historial de Compras</h3>
	</c:otherwise>
</c:choose>



</html>