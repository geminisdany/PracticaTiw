<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<div class="container-fluid" id="formularioRegistroC">
	<h3>
		<a href="index.jsp">Home</a><span> ></span> <a
			href="gestionCompra.jsp">1. Su Carrito</a><span> > 2.
			Identificación</span> <span> > 3. Envío/Pago</span> <span> > 4. Fin</span>
	</h3>
	<h2>Contenido del carrito de Compra</h2>
	<c:if test="${panelPedido}">
		<div class="tab-pane active" id="pedido">
			<div class="table-responsive panel panel-default">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>IDP</th>
							<th>Nombre</th>
							<th>Cantidad</th>
							<th>Precio</th>
							<th class="text-center">Opciones</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${listaPedido}" var="pedido">
							<tr>
								<c:if test="${pedido.idp==3}">
									<td><c:out value="${pedido.idp}"></c:out></td>
									<td><c:out value="${pedido.nombre}"></c:out></td>
									<td><c:out value="${pedido.cantidad}"></c:out></td>
									<td><c:out value="${pedido.precio}"></c:out></td>
									<td class="text-center"><a class="btn btn-danger btn-xs"
										data-toggle="modal tooltip" data-placement="left"
										title="Eliminar Pedido"
										href="ServletCarrito?action=borrar&idp=${pedido.idp}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</c:if>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

	</c:if>
	<div id="botones">
		<a href="#"><button type="button" class="btn btn-default" id="vc">
				Vaciar carrito <span></span>
			</button></a> <a href="index.jsp"><span><button type="button"
					class="btn btn-default" id="seguirC">
					Seguir Comprando <span></span>
				</button></span></a> <a href="gestionCompra2.jsp"><button type="button"
				class="btn btn-default" id="CPF">
				Realizar pedido <span></span>
			</button></a>
	</div>
</div>


</body>
</html>