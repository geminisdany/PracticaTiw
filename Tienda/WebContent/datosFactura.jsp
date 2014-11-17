<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
		<div id="main-content">
		<div id="templatemo">
			
			<div class="container-fluid" id="formularioRegistroC">
				<h3>
					<a href="index.jsp">Home</a><span> ></span> <a href="gestionCompra.jsp">1.
						Su Carrito</a><span> ></span> <a>2. Identificación</a><span> >
						<a href="registrarFactura.jsp">3. Envío/Pago</a>
					</span> <span> > </span><a href="gestionCompra4.jsp">4. Resumen</a>
				</h3>
				<h2>Su compra se ha realizado con Exito.</h2>
				<h3>Contenido de la compra:</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Artículo</th>
							<th>Precio</th>
							<th>Unidad</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaPedidos}" var="pedido" >
						<tr>
							<td>${pedido.producto.nombre}</td>
							<td>${pedido.producto.precio}€</td>
							<td>${pedido.cantidad}</td>
							<td>${pedido.precio}€</td>
						</tr>
						</c:forEach>
						<tr>
						<td>TOTAL DE FACTURA</td>
						<td></td>
						<td></td>
						<td>${factura.importe}€</td>
						</tr>
					</tbody>
				</table>
				<h2>Datos de envío y facturación:</h2>
				<div class="form-group col-xs-7">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Datos del cliente</h3>
						</div>
						<div class="panel-body">

							<h4>Nombre: <c:out value="${cliente.nombre}"></c:out></h4>
							<h4>Telefono: <c:out value="${cliente.telefono}"></c:out></h4>
							<h4>Forma de Pago: <c:out value="${factura.tipoPago}"></c:out></h4>
							
							<h5>Direccion: <c:out value="${factura.direccion.direccion}"></c:out></h5>
							<h5>Ciudad: <c:out value="${factura.direccion.ciudad}"></c:out></h5>
							<h5>provincia: <c:out value="${factura.direccion.provincia}"></c:out></h5>
							<h5>pais: <c:out value="${factura.direccion.pais}"></c:out></h5>	
							<h5>Codigo postal: <c:out value="${factura.direccion.cp}"></c:out></h5>
					
						</div>
					</div>
				</div>
				<br></br>
			
					
		
				<br></br>
				<div class="form-group col-xs-12">
				<div id="botones">
					<a class="btn btn-default" href="catalogo">
						Seguir Comprando 
					</a> 
				</div>
				</div>
			
			</div>
		</div>
		
	</div>
</html>
