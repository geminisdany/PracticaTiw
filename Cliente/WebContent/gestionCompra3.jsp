<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

<c:set var="factura" scope="request" value="${factura}"/>
<c:choose >
<c:when test="${factura==null}">

	<div id="main-content">

		<div id="templatemo">
			
			
	<form onSubmit="return validar(this)" action="ServletF"
						method="post" class="form-horizontal">
			<div class="container-fluid" id="formularioRegistroC">
				<h3>
					<a href="index.jsp">Home</a><span> ></span> <a
						href="gestionCompra.jsp">1. Su Carrito</a><span> ></span> <a>2.
						Identificación</a><span> > <a href="gestionCompra3.jsp">3.
							Envío/Pago</a></span> <span> > 4. Fin</span>
				</h3>
				<h2>Datos de envío y facturación:</h2>
				<h3>Direccion de envío</h3>
				<div class="container-fluid">
					<p>
						Bienvenido a la página de registro de envío. Por favor, rellene
						los siguientes campos. Los campos con <span class="red">*</span>
						son obligatorios.
					</p>
	
						<div class="row">
							<div class="form-group col-xs-5" id="columnas62">
								<label for="nombreC">Nombre de usuario <span class="red">*
								</span><span class="glyphicon glyphicon-user" title="Usuario"></span></label> <input
									type="text" class="form-control" id="nombreC" name="nombreC"
									placeholder="Nombre">
							</div>
							<div class="form-group col-xs-2"></div>
							<div class="form-group col-xs-5">
								<label for="dniC">DNI <span class="red">* </span><span
									title="Dni"></span></label> <input type="text" class="form-control"
									id="dni" name="dni"
									placeholder="Ej DNI 88888888">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-xs-5">
								<div class="control-group">
									<label class="control-label" for="addressesCountry2">País
										<span class="red">* </span>
									</label>
									<div class="controls">
										<select name="pais" id="addressesCountry2"
											class="form-control" data-unique="newbilling">
											<option value=""></option>
											<option value="Spain">España</option>
											<option value="Portugal">Portugal</option>
											<option value="Francia">Francia</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group col-xs-2"></div>
							<div class="form-group col-xs-5">
								<label for="provinciaC">Provincia <span class="red">*</span></label>
								<input type="text" class="form-control" id="provincia"
									name="provincia" placeholder="Provincia">
							</div>
						</div>							
						<div class="row">
							<div class="form-group col-xs-5">
								<label for="CiudadC">Ciudad <span class="red">*</span><span
									title="Ciudad"></span></label> <input type="text" class="form-control"
									id="ciudad" name="ciudad" placeholder="Ciudad">
							</div>
							
							<div class="form-group col-xs-2"></div>
							<div class="form-group col-xs-5">
								<label for="direccionC">Dirección <span class="red">*
								</span><span title="direccion"></span></label> <input type="text"
									class="form-control" id="direccion" name="direccion"
									placeholder="Dirección">
							</div>
							
						</div>

						<div class="row">
							<div class="form-group col-xs-5">
								<label for="cpC">Código postal <span class="red">*</span></label>
								<input type="text" class="form-control" id="cp" name="cp"
									maxlength="5" placeholder="Código postal">
							</div>
							<div class="form-group col-xs-2"></div>
							<div class="form-group col-xs-5">
								<label for="telefonoC">Teléfono del usuario <span
									class="red">* </span> <span
									class="glyphicon glyphicon-phone-alt" title="Teléfono"></span></label>
								<input type="text" class="form-control" id="telefonoC"
									name="phoneC" maxlength="9" placeholder="Teléfono de 9 dígitos">
							</div>
						</div>			
					
						
				</div>
				<h2>Forma de pago:</h2>
				<h3>Seleccione la forma de pago:</h3>
				<div id="opcionePago">
					<div class="pago">
						<input type="radio" name="opcion1" value="Tarjeta">
						Tarjeta
					</div>
					<div class="pago">
						<input type="radio" name="opcion1" value="Paypal"> Paypal
					</div>
					<div class="pago">
						<input type="radio" name="opcion1" value="Transferencia">
						Tranferencia
					</div>
				</div>
				<h2>Forma de envío y plazo de entrega</h2>
				<div class="row">
					<div class="form-group col-xs-5">
						<h3>Forma de envío:</h3>
						<div id="opcioneenvío">
							<div class="pago">
								<input type="radio" name="opcion2" value="Correo">
								Correo
							</div>
							<div class="pago">
								<input type="radio" name="opcion2" value="Seur"> Seur
							</div>
							<div class="pago">
								<input type="radio" name="opcion2" value="Tourline">
								Tourline Express
							</div>
						</div>
					</div>
					<div class="form-group col-xs-5">
						<h3>Plazo de entrega:</h3>
						<div id="opcioneentrega">
							<div class="pago">
								<input type="radio" name="opcion3" value="24"> 24h (7€)
							</div>
							<div class="pago">
								<input type="radio" name="opcion3" value="48"> 48h (5€)
							</div>
							<div class="pago">
								<input type="radio" name="opcion3" value="72"> 72h (3€)
							</div>
						</div>
					</div>
				</div>
				<br></br>
				<div id="botones">
					<a href="gestionCompra.jsp"><button type="button"
							class="btn btn-default" id="atras">
							Atras <span></span>
						</button></a>
						<button id="submit" type="submit" class="btn btn-default" id="continuar" name="submit" >
								Continuar <span></span>
							</button>
						
				</div>

			</div>
		</form>
		</div>
		<div class="site-footer">
			<div class="first-footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="social-footer">
								<ul>
									<li><a href="#" class="fa fa-facebook"></a></li>
									<li><a href="#" rel="blank"
										class="fa fa-twitter"></a></li>
									<li><a href="#" class="fa fa-dribbble"></a></li>
									<li><a href="#" class="fa fa-linkedin"></a></li>
									<li><a href="#" class="fa fa-rss"></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</c:when>
				<c:otherwise>
				<jsp:include page="gestionCompra4.jsp"></jsp:include>
				</c:otherwise>
				</c:choose>
</body>
</html>

