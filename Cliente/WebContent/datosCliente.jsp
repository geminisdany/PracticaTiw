<!DOCTYPE html>
<html>
<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". -->
	<div id="main-content">
		<div class="container-fluid" id="formularioRegistroC">
			<h1 id="registroC">Cambio de contraseña</h1>
			<p>Bienvenido a la pa¡gina de cambio de contraseña de
				Talaverámica. Por favor, introduzca su contraseña actual y la
				nueva que desea utilizar, confirmando esta ultima en el recuadro
				correspondiente.</p>
			<p>Si existiera algun problema, no dude en ponerse en contacto
				con nosotros, estaremos encantados de ayudarle.</p>
			<form class="form-horizontal" role="form">
				<div class="row">
					<div class="form-group col-xs-5">
						<label for="pwdP">Contraseña actual<span class="red">*</span><span
							class="glyphicon glyphicon-lock" title="ContraseÃ±a actual"></span></label>
						<input type="password" class="form-control" id="pwdAct"
							name="wordP" placeholder="ContraseÃ±a actual">
					</div>
					<div class="form-group col-xs-7"></div>
				</div>
				<br>
				<div class="row">
					<div class="form-group col-xs-5">
						<label for="pwdP">Contraseña nueva<span class="red">*</span><span
							class="glyphicon glyphicon-lock" title="ContraseÃ±a nueva"></span></label>
						<input type="password" class="form-control" id="pwdNueva"
							name="wordP" placeholder="ContraseÃ±a nueva">
					</div>
					<div class="form-group col-xs-2"></div>
					<div class="form-group col-xs-5">
						<label for="pwdP">Confirmaci&oacute;n de contraseña nueva<span
							class="red">*</span><span class="glyphicon glyphicon-lock"
							title="ConfirmaciÃ³n contraseÃ±a nueva"></span></label> <input
							type="password" class="form-control" id="pwdNueva2" name="wordP"
							placeholder="ContraseÃ±a nueva">
					</div>
				</div>
				<br>
				<div id="botones">
					<button type="submit" class="btn btn-default" id="enviar"
						class="validadorForm" onclick="pwdIguales()">
						Enviar <span class="glyphicon glyphicon-ok"></span>
					</button>
					<span><button type="reset" class="btn btn-default"
							id="cancelar">
							Cancelar <span class="glyphicon glyphicon-remove"></span>
						</button></span>
				</div>
			</form>
		</div>
	</div>
	
</html>