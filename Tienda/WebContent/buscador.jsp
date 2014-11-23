<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<div class="container" style="padding-top: 1em;">
	<nav class="navbar navbar-default" role="navigation">
		<!-- El logotipo y el icono que despliega el menú se agrupan
         para mostrarlos mejor en los dispositivos móviles -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Desplegar navegación</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<p class="navbar-brand" >Buscar por:</p>
		</div>

		<!-- Agrupar los enlaces de navegación, los formularios y cualquier
         otro elemento que se pueda ocultar al minimizar la barra -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">

			<!-- ********************Formulario de busqueda Basica ************************-->
			<form action="catalogo" method="get">
				<input type="text" name="action" value="busquedaBasica" hidden>
				<ul class="nav navbar-nav">
					<li><a><select class="btn btn-default btn-xs"
							name="opcion" id="addressesCountry2" data-unique="newbilling">
								<option value="producto">Nombre</option>
								<option value="tipo">Tipo</option>
								<option value="proveedor">Proveedor</option>
								<option value="precioMayor">Precio Mayor que</option>
								<option value="precioMenor">Precio Menor que</option>
								<option value="precioIgual">Precio Igual que</option>
						</select></a></li>
				</ul>
				<div class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" name="palabraClave"
							placeholder="Buscar">
					</div>
					<button type="submit" class="btn btn-default">Buscar</button>
				</div>
				
				<div class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input name="busquedaExacta" type="checkbox"> busqueda exacta
					</div>
				</div>
				
				
			</form >
			<!-- FIN Formulario de busqueda Basica -->

			<ul class="nav navbar-nav navbar-right">
				<li class="ava"><a href="#">Avanzado</a></li>
			</ul>
		</div>
	</nav>
</div>
<div class="container" style="padding-top: 1em;">
	<div class="datos">
		<nav class="navbar navbar-default" role="navigation">
			<!-- El logotipo y el icono que despliega el menú se agrupan
			 para mostrarlos mejor en los dispositivos móviles -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Desplegar navegación</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Avanzado:</a>
			</div>
			<!-- Agrupar los enlaces de navegación, los formularios y cualquier
			 otro elemento que se pueda ocultar al minimizar la barra -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">

				<!-- **********************Formulario de busqueda Avanzada *********************-->
				<form action="catalogo" method="get">
				<input type="text" name="action" value="busquedaAvanzada" hidden>
					<ul class="nav navbar-nav">	
						<li>
							<a>
								<select class="btn btn-default btn-xs" name="campo1" data-unique="newbilling">
									<option value="nombre">Nombre</option>
									<option value="tipo">Tipo</option>
									<option value="proveedor">Proveedor</option>
								</select>
							</a>
						</li>
						<li class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" name="valor1" class="form-control" placeholder="Buscar">
							</div>
						</li>
						
						<li><a><select class="btn btn-default btn-xs" name="operador" data-unique="newbilling">
									<option value="and">AND</option>
									<option value="or">OR</option>
							</select></a></li>
						<li><a><select class="btn btn-default btn-xs" name="campo2" data-unique="newbilling">
									<option value="nombre">Nombre</option>
									<option value="tipo">Tipo</option>
									<option value="proveedor">Proveedor</option>
							</select></a></li>
						<li class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" name="valor2" class="form-control" placeholder="Buscar">
							</div>
							<button type="submit" class="btn btn-default">Buscar</button>
						</li>
					
					
				</ul>
				</form>
				<!--Fin Formulario de busqueda Avanzada -->
				<ul class="nav navbar-nav navbar-right">
					<li class="cerrar"><a href="#">Cerrar</a></li>
				</ul>
			</div>
		</nav>
	</div>
</div>
</html>