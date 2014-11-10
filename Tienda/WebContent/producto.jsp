<!DOCTYPE html>
<html>

	<!-- CONTENIDO QUE DEBERA CAMBIAR: todo el div de "main-content". --> 
	<div id="main-content">
		<div class="blank-space"></div>
		
		<div class="container-fluid">
			<div id="ofertas" class="section-content">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title">
							<h2>Producto</h2>
						</div>
					</div>
				</div>
				<div class="row" id="productoEstiloCliente">
					<div class="col-md-4">
						<div class="member-item">
							<div class="member-thumb">
								<img src="${producto.urlImagen}" alt="girl 1">
							</div>
							<div class="member-content">
								<h4>${producto.nombre}</h4>
								<p>${producto.pre_max}</p>
							</div>
						</div>
					</div> <!-- /.col-md-4 -->
					<div class="col-md-8">
						<div class="member-item">
							<div class="member-thumb" id="datosProductoCliente">
								<p class="formatoCamposProducto">Descripcion: ${producto.descripcion}</p>
								<p class="formatoCamposProducto">Stock: ${producto.stock}</p>
								<p class="formatoCamposProducto">Proveedor que lo proporciona:${producto.cif}</p>
							</div>
		
								<form  action="cart"   class="form-inline" role="form" method="get">
								  <div class="form-group ">
								    <label class="formatoCamposProducto control-label " >Cantidad</label>
								    <input type="number" class="form-control" name="cantidad" value="1">
								    <input type="text" name="action" value="modificar" hidden/>
								    <input type="text" name="id" value="${producto.idp}" hidden/> 
								  </div>
								  <div class="row blank-space"></div>
								  <div class="form-group">
									  <button class="btn btn-success" data-toggle="modal tooltip" type="submit"
												data-placement="left" title="Agregar al carrito">Comprar
									  </button>
									  <a class="btn btn-danger" data-toggle="modal tooltip"
											data-placement="left" title="Agregar al carrito"
											href="catalogo">Cancelar</a>
								  </div>
								  
								</form>
								
								
							</div>
							
						</div>
					</div> <!-- /.col-md-4 -->
				</div> <!-- /.row -->
			</div> <!-- /#about -->
		</div> <!-- /.container-fluid -->

	<!-- FIN del div de "main-content"-->

</html>