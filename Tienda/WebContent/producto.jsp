<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

	<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". --> 
	<div id="main-content">
		<div class="blank-space"></div>
		
		<div class="container-fluid">
			<div id="ofertas" class="section-content">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title">
							<h2>Producto</h2>
						</div>
					</div>
				</div>
				<div class="row" id="productoEstiloCliente">
					<div class="col-md-4">
						<div class="member-item">
							<div class="member-thumb">
								<img src="${producto.urlImagen}" alt="girl 1">
							</div>
							<div class="member-content">
								<h4>${producto.nombre}</h4>
								<p>${producto.precio}</p>
							</div>
						</div>
					</div> <!-- /.col-md-4 -->
					<div class="col-md-8">
						<div class="member-item">
							<div class="member-thumb" id="datosProductoCliente">
								<p class="formatoCamposProducto">Descripcion: ${producto.descripcion}</p>
								<p class="formatoCamposProducto">Stock: ${producto.stock}</p>
								<p class="formatoCamposProducto">Proveedor:${producto.proveedor.nombre}</p>
							</div>
		
								<form  action="cart"   class="form-inline" role="form" method="get">
								  <div class="form-group ">
								    <label class="formatoCamposProducto control-label " >Cantidad</label>
								    <input type="number" class="form-control" name="cantidad" value="1">
								    <input type="text" name="action" value="modificar" hidden/>
								    <input type="text" name="id" value="${producto.id}" hidden/> 
								  </div>
								  <div class="row blank-space"></div>
								  <div class="form-group">
									  <button class="btn btn-success" data-toggle="modal tooltip" type="submit"
												data-placement="left" title="Agregar al carrito">Comprar
									  </button>
									  
									  <c:choose>
									  <c:when test="${productoSuscrito}">
									  		<a class="btn btn-warning" data-toggle="modal tooltip"
											data-placement="left" title="Suscribirse al producto"
											href="suscribirse?action=borrar&id=${producto.id}">Anular Suscripcion</a>
									  </c:when>
									  <c:otherwise>
									  		<a class="btn btn-warning" data-toggle="modal tooltip"
											data-placement="left" title="Suscribirse al producto"
											href="suscribirse?action=guardar&id=${producto.id}">Suscribirse</a>
									  </c:otherwise>
									  </c:choose>
									 
									  <a class="btn btn-danger" data-toggle="modal tooltip"
											data-placement="left" title="Agregar al carrito"
											href="catalogo">Cancelar</a>
									  
								  </div>
								  
								</form>
								<c:if test="${mensajeValidarse}">
									<div class="alert alert-warning alert-dismissible" role="alert">
								  		<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
								  		<strong>Warning!</strong> Antes de Suscribirte debes inciar sesion. Haz clic en ENTRAR o REGISTRARSE
									</div>
								</c:if>
								
							</div>
							
						</div>
					</div> <!-- /.col-md-4 -->
				</div> <!-- /.row -->
			</div> <!-- /#about -->
		</div> <!-- /.container-fluid -->

	<!-- FIN del div de "main-content"-->

</html>