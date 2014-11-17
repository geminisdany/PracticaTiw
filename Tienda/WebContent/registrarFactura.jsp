<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<body>
<c:set var="cliVal" scope="session" value="${clienteValidado}" />
	
	<div id="main-content">
		<div id="templatemo">	
			<c:choose>
				<c:when test="${cliVal!=null}">
					<form  action="cart" method="post" class="form-horizontal">
					<input type="text" name="action" value="guardarFactura" hidden/>
						<div class="container-fluid" id="formularioRegistroC">
							<h3>
								<a href="index.jsp">Home</a><span> ></span> <a
									href="gestionCompra.jsp">1. Su Carrito</a><span> ></span> <a>2.
									Identificación</a><span> > <a href="registrarFactura.jsp">3.
										Envío/Pago</a></span> <span> > 4. Fin</span>
							</h3>
							
							
							<div class="container-fluid">
								<p>
									Bienvenido a la página de registro de envío.    Los campos con <span class="red">*</span>
									son obligatorios. Para cambiar sus datos ingrese en la seccion MIS DATOS
								</p>
							<h3>Direccion de envío</h3>
								<div class="row">
									<div class="form-group col-md-5" id="columnas62">
										<label for="nombreC">Nombre de usuario <span class="glyphicon glyphicon-user"
											title="Usuario"></span></label> <input type="text"
											class="form-control" id="nombreC" name="nombreC"
											value="${cliente.nombre}" readonly>
									</div>
									<div class="form-group col-md-2"></div>
									<div class="form-group col-md-5">
										<label for="telefonoC">Teléfono del usuario<span
											class="glyphicon glyphicon-phone-alt" title="Teléfono"></span></label>
										<input type="text" class="form-control" id="telefonoC"
											name="phoneC" maxlength="9"
											value="${cliente.telefono}" readonly>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-5">
										<div class="control-group">
											<label class="control-label" for="addressesCountry2">País
												<span class="red">* </span>
											</label>
											<div class="controls">
												<select name="paisF" id="addressesCountry2"
													class="form-control" data-unique="newbilling">
													<option value="Spain">España</option>
													<option value="Portugal">Portugal</option>
													<option value="Francia">Francia</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group col-md-2"></div>
									<div class="form-group col-md-5">
										<label for="provincia">Provincia <span class="red">*</span></label>
										<input type="text" class="form-control" id="provincia"
											name="provinciaF" placeholder="Provincia" value="${cliente.direccion.provincia}">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-5">
										<label for="Ciudad">Ciudad <span class="red">*</span><span
											title="Ciudad"></span></label> <input type="text"
											class="form-control" id="ciudad" name="ciudadF"
											placeholder="Ciudad" value="${cliente.direccion.ciudad}">
									</div>

									<div class="form-group col-md-2"></div>
									<div class="form-group col-md-5">
										<label for="direccion">Dirección <span class="red">*
										</span><span title="direccion"></span></label> <input type="text"
											class="form-control" id="direccion" name="direccionF"
											placeholder="Dirección" value="${cliente.direccion.direccion}">
									</div>

								</div>

								<div class="row">
									<div class="form-group col-md-5">
										<label for="cp">Código postal <span class="red">*</span></label>
										<input type="text" class="form-control" id="cp" name="cpF"
											maxlength="5" placeholder="Código postal" value="${cliente.direccion.cp}">
									</div>

								</div>


							</div>
							
							<h3>Seleccione la forma de pago:</h3>
							<div id="opcionePago">
								<div class="pago">
									<input type="radio" name="opcionPago" value="Tarjeta">
									Tarjeta
								</div>
								<div class="pago">
									<input type="radio" name="opcionPago" value="Paypal">
									Paypal
								</div>
								<div class="pago">
									<input type="radio" name="opcionPago" value="Transferencia" checked>
									Tranferencia
								</div>
							</div>

							<br></br>
							<div id="botones">
								<a href="cart?action=mostrarLista"><button type="button"
										class="btn btn-default" id="atras">Atras</button></a>
								<button id="submit" type="submit" class="btn btn-default"
									id="continuar" name="submit">Confirmar Compra</button>

							</div>

						</div>
					</form>

				</c:when>
				<c:otherwise>
					<div class="blank-space"></div>
					Cliente no Validado, Inicia Sesion, presiendo el boton Entrar o registrate
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>

