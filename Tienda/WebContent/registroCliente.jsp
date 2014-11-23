<!DOCTYPE html>

<html lang="es">
<script src="js/ValidacionR.js"></script>

<br></br>

	<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". --> 
	<div id="main-content">
		
			<div class="container-fluid" id="formularioRegistroC">
				<h2 id="registroC">Registro de Clientes</h2>
				<p>Bienvenido a la página de registro de Talaverámica. Por favor, rellene los siguientes campos.</p>
				
				<form onSubmit="return validarR(this)" action="registro" method="post" class="form-horizontal" role="form">
				
					<input type="text" name="action" value="registrar" hidden/>
					<div class="row">
					  <div class="form-group col-md-5" id="columnas62">
						<label for="nombreC">Nombre <span class="red">*</span><span class="glyphicon glyphicon-user" title="Usuario"></span></label>
						<input type="text" class="form-control" id="nombreC" name="nombreC"
							   placeholder="Nombre">
					  </div>
					  <div class="form-group col-md-2"></div>
					   <div class="form-group col-md-5">
						<label for="apellido1C">Apellidos <span class="red">*</span></label>
						
						<input type="text" class="form-control" id="apellidosC" name="apellidosC" 
							   placeholder="Apellido">
							   
					  </div>  
					</div>
					<br>

					<div class="row">
					  <div class="form-group col-md-5">
						<label for="telefonoC">Tel&eacute;fono <span class="red">*</span><span class="glyphicon glyphicon-phone-alt" title="Telefono"></span></label>
						
						<input type="text" class="form-control" id="telefonoC" name="telefonoC"
							   placeholder="Telefono">
							   
					  </div>
					  <div class="form-group col-md-2"></div>
					  <div class="form-group col-md-5">
						<label for="emailC">Email <span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Email"></span></label>
						
						<input type="text" class="form-control" id="emailC" name="emailC" 
								   placeholder="Email">
								   
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-md-5">
						<label for="pwdC">Contraseña <span class="red">*</span><span class="glyphicon glyphicon-lock" title="ContraseÃ±a"></span></label>
						<input type="password" class="form-control" name="pass1C"
							   placeholder="Contraseña">
					  </div>
					  <div class="form-group col-md-2"></div>
					  <div class="form-group col-md-5">
						<label for="pwd2C">Confirmar contraseña <span class="red">*</span></label>
						<input type="password" class="form-control" name="pass2C"
							   placeholder="Contraseña">
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
											name="provinciaC" placeholder="Provincia">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-5">
										<label for="CiudadC">Ciudad <span class="red">*</span><span
											title="Ciudad"></span></label> <input type="text"
											class="form-control" id="ciudad" name="ciudadC"
											placeholder="Ciudad">
									</div>

									<div class="form-group col-md-2"></div>
									<div class="form-group col-md-5">
										<label for="direccionC">Dirección <span class="red">*
										</span><span title="direccion"></span></label> <input type="text"
											class="form-control" id="direccion" name="direccionC"
											placeholder="Dirección">
									</div>

								</div>

								<div class="row">
									<div class="form-group col-md-5">
										<label for="cpC">Código postal <span class="red">*</span></label>
										<input type="text" class="form-control" id="cp" name="cpC"
											maxlength="5" placeholder="Código postal">
									</div>

								</div>
					
				  <div class="checkbox">
					<label>
					  <input type="checkbox"> Deseo recibir correos con novedades y ofertas de Talaver&aacute;mica
					</label>
				  </div>
				  <br>
				  <div id="botones">
						<button id="submit" type="submit" class="btn btn-default" id="continuar" name="submit" >
								Enviar <span class="glyphicon glyphicon-ok"></span><span></span>
							</button>
					<span><button type="reset" class="btn btn-default" id="cancelar">Cancelar <span class="glyphicon glyphicon-remove"></span></button></span>
				  </div>
				</form>
			</div>


	</div>
	<!-- FIN del div de "main-content"-->



</html>