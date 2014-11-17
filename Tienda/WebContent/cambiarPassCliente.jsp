<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html lang="es">
<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". -->
	<div id="main-content">
			<form action="registro" method="post" class="form-horizontal" role="form">
			<input type="text" name="action" value="cambiarPass" hidden/>
				<div class="row">
					<div class="form-group col-xs-5">
						<label for="pwdP">Contraseña actual<span class="red">*</span><span
							class="glyphicon glyphicon-lock" title="Contraseña actual"></span></label>
						<input type="password" class="form-control" id="pwdAct"
							name="passActual" placeholder="Contraseña actual">
					</div>
					<div class="form-group col-xs-7"></div>
				</div>
				<br>
				<div class="row">
					<div class="form-group col-xs-5">
						<label for="pwdP">Contraseña nueva<span class="red">*</span><span
							class="glyphicon glyphicon-lock" title="Contraseña nueva"></span></label>
						<input type="password" class="form-control" id="pwdNueva"
							name="pass1C" placeholder="Contraseña nueva">
					</div>
					<div class="form-group col-xs-2"></div>
					<div class="form-group col-xs-5">
						<label for="pwdP">Confirmaci&oacute;n de contraseña nueva<span
							class="red">*</span><span class="glyphicon glyphicon-lock"
							title="ConfirmaciÃ³n contraseña nueva"></span></label> <input
							type="password" class="form-control" id="pwdNueva2" name="pass2C"
							placeholder="Contraseña nueva">
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
</html>