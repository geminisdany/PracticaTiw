<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<br /><br />
<div id="main-content">
	<div class="blank-space"></div>
	<div class="col-md-offset-1 col-md-10">
		<h2 class="centro">${titulo}</h2>
		<h4 class="centro">${descripcion}</h4>
		 <div class="row margintop">
		   <div class="col-md-6"><a  data-toggle="modal" data-target="#modalLogin" href="#Iniciar-Sesion"><button type="submit" class="btn btn-block btn-primary">Volver a Intentarlo</button></a></div>
		   <div class="col-md-6"><a  href="index.jsp"><button type="button"  data-dismiss="modal" class="btn btn-block btn-danger">Volver a Inicio</button></a></div>
	 	</div>
		<div class="nada"></div>
</div>
</div>
</html>