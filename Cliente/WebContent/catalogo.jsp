<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<div id="main-content">
		<div class="blank-space"></div>
		<div class="container-fluid">
		   
		   <div id="${tipoCatalogo}s" class="section-content">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title">
							<h2>${tipoCatalogo}</h2>
						</div>
					</div>
				</div>
				<div class="row">
				
				<c:forEach items="${listaProducto}" var="producto" >
					<div class="col-md-4">
						<div class="member-item">
							<div class="member-thumb">
								<img src="${producto.urlImagen}" alt="${producto.nombre}">
								<div class="overlay">
									<a data-toggle="modal tooltip"
											data-placement="left" title="Comprar Producto"
											href="ServletCarrito?item=${producto.idp}"><button class="btn btn-default" id="3" name="3" data-target="#miCompra${Pedido.IdP}" >
								Comprar
							</button></a>
								</div>
							</div>
							<div class="member-content">
								<h4>${producto.nombre}</h4>
								<p>${producto.pre_max} €</p>
							</div>
						</div>
					</div>
					 </c:forEach>
					<!-- /.col-md-4 -->
				</div>
				<!-- /.row -->
			</div>
		  
			
		</div>
		<!-- /.container-fluid -->
		</div>

</html>