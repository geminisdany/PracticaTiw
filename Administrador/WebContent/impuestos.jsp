<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<div>
	<h3>Gestionar impuestos Generales.</h3>
	<form action="gestionFacturas">
		<div class="hidden">
			<input type="text" name="action" value="guardarImpuestosGenerales" />
		</div>
		<label>Impuesto</label><input type="text" name="precio" /> <label>Impuesto
			Porcentaje</label><input type="text" name="precioPorcentaje" /> <input
			type="submit" />
	</form>
</div>
<br />
<div>
	<h3>Gestionar impuestos a un Proveedor.</h3>
	<form action="gestionFacturas">
		<div class="hidden">
			<input type="text" name="action" value="guardarImpuestosProveedor" />
		</div>
		<label>Proveedor</label> <select name="">
			<option class="uno" value="Tarjeta">Tarjeta</option>
			<option class="dos" value="Paypal">Paypal</option>
			<option class="tres" value="Transferencia">Transferencia</option>
		</select> <label>Impuesto</label><input type="text" name="precio" /> <label>Impuesto
			Porcentaje</label><input type="text" name="precioPorcentaje" /> <input
			type="submit" />
	</form>
</div>
<br />
<div>
	<h3>Gestionar impuestos a un Producto</h3>
	<form action="gestionFacturas">
		<div class="hidden">
			<input type="text" name="action" value="guardarImpuestosProducto" />
		</div>
		<label>Producto</label> <select name="">
			<option class="uno" value="Tarjeta">Tarjeta</option>
			
		</select> <label>Impuesto</label><input type="text" name="precio" /> <label>Impuesto
			Porcentaje</label><input type="text" name="precioPorcentaje" /> <input
			type="submit" />
	</form>
</div>
</html>