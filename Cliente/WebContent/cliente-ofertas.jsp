<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". -->
	<div id="main-content">
		<div class="blank-space"></div>
		<div class="container-fluid">

			<div id="ofertas" class="section-content">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title">
							<h2>Ofertas</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="member-item">
							<div class="member-thumb">
								<img src="images/taza1.jpg" alt="Tazas gatos">
								<div class="overlay">
									<a data-toggle="modal tooltip"
											data-placement="left" title="Comprar Producto"
											href="ServletCarrito?item=3"><button class="btn btn-default" id="3" name="3" data-target="#miCompra${Pedido.IdP}" >
								Comprar
							</button></a>
								</div>
							</div>
							<div class="member-content">
								<h4>Tazas de gatos de distintos tamaños</h4>
								<p>35,95 €</p>
							</div>
						</div>
					</div>
					<!-- /.col-md-4 -->
					<div class="col-md-4">
						<div class="member-item">
							<div class="member-thumb">
								<img src="images/elefantes1.jpg" alt="Elefantes adorno">
								<div class="overlay">
									<ul class="social-member">
										<li><a href="gestionCompra.jsp" class="fa"><img
												src="images/carritoCompra.png" alt="Carrito de la Compra"></a></li>
									</ul>
								</div>
							</div>
							<div class="member-content">
								<h4>Elefantes decoracion</h4>
								<p>18,99 €</p>
							</div>
						</div>
					</div>
					<!-- /.col-md-4 -->
					<div class="col-md-4">
						<div class="member-item">
							<div class="member-thumb">
								<img src="images/macetero1.jpg" alt="Macetero cerdo">
								<div class="overlay">
									<ul class="social-member">
										<li><a href="gestionCompra.jsp" class="fa"><img
												src="images/carritoCompra.png" alt="Carrito de la Compra"></a></li>
									</ul>
								</div>
							</div>
							<div class="member-content">
								<h4>Cerdito macetero</h4>
								<p>19,99 €</p>
							</div>
						</div>
					</div>
					<!-- /.col-md-4 -->
				</div>
				<!-- /.row -->
			</div>
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- FIN del div de "main-content"-->


</html>