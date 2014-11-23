<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<script>
$(document).ready(function(){
	$(".dato2").hide();
	$(".dato3").hide();
		$(".uno").click(function(){
			$(".dato1").show();
			$(".dato2").hide();
			$(".dato3").hide();
		});
		$(".dos").click(function(){
			$(".dato2").show();
			$(".dato1").hide();
			$(".dato3").hide();
		});
		$(".tres").click(function(){
			$(".dato3").show();
			$(".dato2").hide();
			$(".dato1").hide();
		});
});
</script>
<script src="js/ValidacionD.js"></script>
<br></br>
<c:set var="cliVal" scope="session" value="${clienteValidado}" />
	
	<div id="main-content">
		<div id="templatemo">	
			<c:choose>
				<c:when test="${cliVal!=null}">
					<form  onSubmit="return validarD(this)" action="cart" method="post" class="form-horizontal">
					<input type="text" name="action" value="guardarFactura" hidden/>
						<div class="container-fluid" id="formularioRegistroC">
							<h3>
								<a href="index.jsp">Home</a><span> ></span> <a
									href="cart?action=mostrarLista">1. Su Carrito</a><span> ></span> <a>2.
									Identificación</a><span> > <a href="cart?action=formPedido">3.
										Envío/Pago</a></span> <span> > 4. Resumen</span>
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
							
							<div class="row">
									<div class="form-group col-md-5">
										<div class="control-group">
											<label class="control-label" for="fpago">Seleccione la forma de pago: 
												<span class="red">* </span>
											</label>
											<div class="controls">
												<select name="opcionPago" id="fpago"
													class="form-control" data-unique="newbilling">
													<option class="uno" value="Tarjeta">Tarjeta</option>
													<option class="dos" value="Paypal">Paypal</option>
													<option class="tres" value="Transferencia">Transferencia</option>
												</select>
											</div>
										</div>
									</div>
						
									<div class="form-group col-md-2"></div>
									<div class="form-group col-md-5">
										
									<div class="dato1">
											<label for="tarjeta">Tarjeta: <span class="red">*
											</span><span title="tarjeta"></span></label> 
											<input type="text" class="form-control" id="tarjeta" name="ctarjeta"
												placeholder="Cuenta de la tarjeta">
									</div>
									<div class="dato2">
											<label for="paypal">Paypal: <span class="red">*
											</span><span title="paypal"></span></label> 
											<input type="text" class="form-control" id="paypal" name="cpaypal"
												placeholder="Cuenta de la paypal">
									</div>
									<div class="dato3">
											<label for="transferencia">Transferencia: <span class="red">*
											</span><span title="transferencia"></span></label> 
											<input type="text" class="form-control" id="transferencia" name="ctransferencia"
												placeholder="Cuenta de la transferencia">
									</div>
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
					<div class="nadah">
							<h3>
								<a href="index.jsp">Home</a><span> ></span> <a
									href="cart?action=mostrarLista">1. Su Carrito</a><span> > <a href="#">  2.
									Identificación</a></span> <span> > 3. Envío/Pago</span> <span> > 4. Fin</span>
							</h3>
						</div>	
						<h1 class="centro">Cliente no Validado: </h1>
						<div id="botones">
							<a href="cart?action=mostrarLista"><button type="button"
										class="btn btn-default" id="atras">Atras</button></a>
								<a data-toggle="modal" data-target="#modalLogin" href="#Iniciar-Sesion"><button type="button"
										class="btn btn-default">Iniciar Sesion</button></a>
								<a href="registro?action=formulario"><button id="submit" type="submit" class="btn btn-default"
									id="continuar" name="submit">Registrarse</button></a>
							</div>	
								<div class="nada"></div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</html>

