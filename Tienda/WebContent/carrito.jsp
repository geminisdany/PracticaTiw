<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<br></br>
<div  id="main-content">
	<div class="blank-space"></div>
	<div class="container-fluid">
	<h3>
		<a href="index.jsp">Home</a><span> ></span> <a
			href="#">1. Su Carrito</a><span> > 2.
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
									<td><c:out value="${pedido.producto.id}"></c:out></td>
									<td><c:out value="${pedido.producto.nombre}"></c:out></td>
									<td><c:out value="${pedido.cantidad}"></c:out></td>
									<td><c:out value="${pedido.precio}"></c:out></td>
									<td class="text-center">
									<a class="btn btn-info btn-xs"
										data-toggle="modal tooltip" data-placement="left"
										title="Modificar Pedido"
										href="catalogo?action=mostrarProducto&id=${pedido.producto.id}"><span
											class="glyphicon glyphicon-pencil"></span></a>
											
									<a class="btn btn-danger btn-xs"
										data-toggle="modal tooltip" data-placement="left"
										title="Eliminar Pedido"
										href="cart?action=borrar&idp=${pedido.producto.id}"><span
											class="glyphicon glyphicon-trash"></span></a>
											
									
									
									</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		
		</div >
			
		<div class="col-md-12">
			<div class="col-md-2 col-md-offset-9">
				<div class="col-md-6 col-xs-6"><h3>Total:</h3></div>
				<div class="col-md-6 col-xs-6"><h3>${total}€</h3></div>
			</div>
		</div>
	
	<div id="botones">
		<a href="cart?action=vaciar"><button type="button" class="btn btn-default" id="vc">
				Vaciar carrito <span></span>
			</button></a> <a href="catalogo"><span><button type="button"
					class="btn btn-default" id="seguirC">
					Seguir Comprando <span></span>
				</button></span></a> <a href="cart?action=formPedido"><button type="button"
				class="btn btn-default" id="CPF">
				Realizar pedido <span></span>
			</button></a>
	</div>
	</c:if>
	</div>
	<div class="blank-space"></div>
</div>

</html>