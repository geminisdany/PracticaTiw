<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". -->
	
	<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". --> 
	<div id="main-content">
		
			<div class="container-fluid" id="formularioRegistroC">
				<form  action="registro" method="post" class="form-horizontal" role="form">
					<input type="text" name="action" value="editarCliente" hidden/>
					<div class="row">
					  <div class="form-group col-md-5" id="columnas62">
						<label for="nombreC">Nombre <span class="red">*</span><span class="glyphicon glyphicon-user" title="Usuario"></span></label>
						<input type="text" class="form-control" id="nombreC" name="nombreC"
							   value="${cliente.nombre}">
					  </div>
					  <div class="form-group col-md-2"></div>
					   <div class="form-group col-md-5">
						<label for="apellido1C">Apellidos <span class="red">*</span></label>
						<input type="text" class="form-control" id="apellidoC" name="apellidosC" 
							   placeholder="Apellidos" value="${cliente.apellidos}">
					  </div>  
					</div>
					<br>

					<div class="row">
					  <div class="form-group col-md-5">
						<label for="telefonoC">Tel&eacute;fono <span class="red">*</span><span class="glyphicon glyphicon-phone-alt" title="Telefono"></span></label>
						<input type="tel" class="form-control" id="telefonoC" name="telefonoC"
							   placeholder="Telefono" value="${cliente.telefono}">
					  </div>
					  <div class="form-group col-md-2"></div>
					  <div class="form-group col-md-5">
						<label for="emailC">Email <span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Email"></span></label>
						<input type="email" class="form-control" id="emailC" name="emailC" 
								   placeholder="Email" value="${cliente.email}">
					  </div>
					</div>
					<br>
					
					<div class="row">
									<div class="form-group col-md-5">
										<div class="control-group">
											<label class="control-label" for="addressesCountry2">País
												<span class="red">* </span>
											</label>
											<div class="controls">
												<select name="paisC" id="addressesCountry2"
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
										<label for="provinciaC">Provincia <span class="red">*</span></label>
										<input type="text" class="form-control" id="provincia"
											name="provinciaC" placeholder="Provincia" value="${cliente.direccion.provincia}">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-5">
										<label for="CiudadC">Ciudad <span class="red">*</span><span
											title="Ciudad"></span></label> <input type="text"
											class="form-control" id="ciudad" name="ciudadC"
											placeholder="Ciudad" value="${cliente.direccion.ciudad}">
									</div>

									<div class="form-group col-md-2"></div>
									<div class="form-group col-md-5">
										<label for="direccionC">Dirección <span class="red">*
										</span><span title="direccion"></span></label> <input type="text"
											class="form-control" id="direccion" name="direccionC"
											placeholder="Dirección" value="${cliente.direccion.direccion}">
									</div>

								</div>

								<div class="row">
									<div class="form-group col-md-5">
										<label for="cpC">Código postal <span class="red">*</span></label>
										<input type="text" class="form-control" id="cp" name="cpC"
											maxlength="5" placeholder="Código postal" value="${cliente.direccion.cp}">
									</div>

								</div>
				  <div id="botones">
					<button type="submit" class="btn btn-default" id="enviar" class="validadorForm()" onclick="pwdIguales()">Guardar <span class="glyphicon glyphicon-ok"></span></button>
					<span><button type="reset" class="btn btn-default" id="cancelar">Cancelar <span class="glyphicon glyphicon-remove"></span></button></span>
				  </div>
				</form>
			</div>


	</div>
	<!-- FIN del div de "main-content"-->
	
</html>