<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<body>
	<div id="main-content">
		<div id="templatemo">
			
			<div class="container-fluid" id="formularioRegistroC">
				<h3>
					<a href="index.jsp">Home</a><span> ></span> <a href="gestionCompra.jsp">1.
						Su Carrito</a><span> ></span> <a>2. Identificación</a><span> >
						<a href="registrarFactura.jsp">3. Envío/Pago</a>
					</span> <span> > </span><a href="gestionCompra4.jsp">4. Fin</a>
				</h3>
				<h2>Contenido de la compra:</h2>
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
						<tr>
							<td>jarron</td>
							<td>2€</td>
							<td>1</td>
							<td>2€</td>
						</tr>
						<tr>
							<td>fuente</td>
							<td>100€</td>
							<td>2</td>
							<td>200€</td>
						</tr>
						<tr>
							<td>Vasija</td>
							<td>33€</td>
							<td>3</td>
							<td>99€</td>
						</tr>
						<tr>
							<td>Total</td>
							<td></td>
							<td>6</td>
							<td>301€</td>
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
							<h4>Ciudad: <c:out value="${factura.direccion.ciudad}"></c:out></h4>
							<h4>Direccion: <c:out value="${factura.direccion.direccion}"></c:out></h4>
							<h4>pais: <c:out value="${factura.direccion.pais}"></c:out></h4>
							<h4>provincia: <c:out value="${factura.direccion.provincia}"></c:out></h4>
							<h4>Codigo postal: <c:out value="${factura.direccion.cp}"></c:out></h4>
					
						</div>
					</div>
				</div>
				<br></br>
			
					
		
				<br></br>
				<div class="form-group col-xs-12">
				<div id="botones">
					<a href="registrarFactura.jsp"><button type="button"
							class="btn btn-default" id="atras">
							Atras <span></span>				
						</button ></a> <a href="#"
						data-toggle="modal" data-target="#basicModal"><button
							class="btn btn-default">
								Finalizar Compra <span></span>
							</button></a> 
				</div>
				</div>
			
			</div>
		</div>
		
	</div>
</body>
</html>
