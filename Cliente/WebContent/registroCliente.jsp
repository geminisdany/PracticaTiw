<!DOCTYPE html>
<html>


	<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". --> 
	<div id="main-content">
		
			<div class="container-fluid" id="formularioRegistroC">
				<h2 id="registroC">Registro de Clientes</h2>
				<p>Bienvenido a la página de registro de Talaverámica. Por favor, rellene los siguientes campos.</p>
				<form class="form-horizontal" role="form" onSubmit="return validarF()">
					<div class="row">
					  <div class="form-group col-xs-5" id="columnas62">
						<label for="nombreC">Nombre de usuario <span class="red">*</span><span class="glyphicon glyphicon-user" title="Usuario"></span></label>
						<input type="text" class="form-control" id="nombreC" name="nameC"
							   placeholder="Nombre">
					  </div>
					  <div class="form-group col-xs-2"></div>
					  <div class="form-group col-xs-5" id="columnas6o2">
						<label for="aliasC">Alias de usuario <span class="red">*</span></label>
						<input type="text" class="form-control" id="aliasC" name="aliC"
							   placeholder="Alias">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-xs-5">
						<label for="apellido1C">Primer apellido del usuario <span class="red">*</span></label>
						<input type="text" class="form-control" id="apellido1C" name="ape1C" 
							   placeholder="Apellido 1">
					  </div>
					  <div class="form-group col-xs-2"></div>
					  <div class="form-group col-xs-5">
						<label for="apellido2C">Segundo apellido del usuario <span class="red">*</span></label>
						<input type="text" class="form-control" id="apellido2C" name="ape2C"
							   placeholder="Apellido 2">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-xs-5">
						<label for="emailC">Email <span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Email"></span></label>
						<input type="email" class="form-control" id="emailC" name="hotmailC" 
								   placeholder="Email">
					  </div>
					  <div class="form-group col-xs-2"></div>
					  <div class="form-group col-xs-5">
						<label for="telefonoC">Tel&eacute;fono del usuario <span class="red">*</span><span class="glyphicon glyphicon-phone-alt" title="Telefono"></span></label>
						<input type="tel" class="form-control" id="telefonoC" name="phoneC"
							   placeholder="Telefono">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-xs-5">
						<label for="pwdC">Contraseña <span class="red">*</span><span class="glyphicon glyphicon-lock" title="ContraseÃ±a"></span></label>
						<input type="password" class="form-control" id="pwdC" name="wordC"
							   placeholder="Contraseña">
					  </div>
					  <div class="form-group col-xs-2"></div>
					  <div class="form-group col-xs-5">
						<label for="pwd2C">Confirmar contraseña <span class="red">*</span></label>
						<input type="password" class="form-control" id="pwd2C" name="word2C"
							   placeholder="Contraseña">
					  </div>
					</div>
					<br>
					<div class="row">
					  <div class="form-group col-xs-4">
						<label for="direccionC">Direcci&oacute;n <span class="red">*</span><span class="glyphicon glyphicon-lock" title="DirecciÃ³n"></span></label>
						<input type="text" class="form-control" id="direccionC" name="addrC"
							   placeholder="C/calle-numero-escalera-piso-puerta">
					  </div>
					  <div class="form-group col-xs-1"></div>
					  <div class="form-group col-xs-2">
						<label for="codpostC"> C&oacute;digo postal <span class="red">*</span></label>
						<input type="text" class="form-control" id="codpostC" name="postC"
								placeholder="28054" maxlength="5">
					  </div>
					  <div class="form-group col-xs-1"></div>
					  <div class="form-group col-xs-4">
						<label for="ciupC">Ciudad, Pa&iacute;s <span class="red">*</span></label>
						<input type="text" class="form-control" id="ciupC" name="citycC"
							   placeholder="Ciudad, Pais">
					  </div>
					</div>
				  <div class="checkbox">
					<label>
					  <input type="checkbox"> Deseo recibir correos con novedades y ofertas de Talaver&aacute;mica
					</label>
				  </div>
				  <br>
				  <div id="botones">
					<button type="submit" class="btn btn-default" id="enviar" class="validadorForm()" onclick="pwdIguales()">Enviar <span class="glyphicon glyphicon-ok"></span></button>
					<span><button type="reset" class="btn btn-default" id="cancelar">Cancelar <span class="glyphicon glyphicon-remove"></span></button></span>
				  </div>
				</form>
			</div>


	</div>
	<!-- FIN del div de "main-content"-->



</html>