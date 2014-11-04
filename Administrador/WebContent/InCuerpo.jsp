<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<!-- Tab panes -->
				<div class="tab-content">
				  <c:if test="${AdmValidado && panelCliente}">
				  		<div class="tab-pane active" id="clientes">
					    	<div class="table-responsive panel panel-default">
								    	<table class="table table-hover">
											<thead>
												<tr>
													<th> ID</th>
													<th>Nombre</th>
													<th>Correo</th>
													<th>Teléfono</th>
													<th class="text-center">Opciones</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach items="${listaClientes}" var="cliente" >
												<tr>
													<td><c:out value="${cliente.idc}"></c:out></td>
													<td><c:out value="${cliente.nombre}"></c:out></td>
													<td><c:out value="${cliente.email}"></c:out></td>
													<td><c:out value="${cliente.tlf}"></c:out></td>
													<td class="text-center">
														<button class="btn btn-info btn-xs" data-toggle="modal" data-toggle="tooltip" data-placement="left" title="Editar Cliente" data-target="#myModal${cliente.idc}">
  															<span class="glyphicon glyphicon-pencil"></span>
														</button>
														<a  class="btn btn-danger btn-xs" data-toggle="modal tooltip" data-placement="left" title="Eliminar Cliente" href="gestionClientes?action=borrar&idc=${cliente.idc}"><span class="glyphicon glyphicon-trash"></span></a></td>
												</tr>
											
											
											<!------------------------ Ventana modal:Editar Cliente -------------------------->
		<div class="modal fade" id="myModal${cliente.idc}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Editar Cliente</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<form action="gestionClientes" method="post" role="form">
							
								<div class="col-md-12">
									<div class="form-group">
										 
										<label>Id Cliente</label> 
										<input name="idc" type="text" readonly class="form-control input-sm" value="${cliente.idc}">
										
									</div>				
									<div class="form-group">
										<label>Nombre</label> 
										<input name="nombre" type="text" class="form-control input-sm" value="${cliente.nombre}" required>
									</div>
									
									<div class="well form-group">
										<label>Dirección</label> 
										<textarea name="direccion" class="form-control input-sm" required><c:out value="${cliente.direccion}"></c:out></textarea>
									</div>
									<div class="form-group">
										<label>Email</label> 
										<input name="email" type="email" class="form-control input-sm" value="${cliente.email}" required>
									</div>
									<div class="form-group">
										<label>Teléfono</label> 
										<input name="tlf" type="number" class="form-control input-sm" value="${cliente.tlf}"required>
									</div>
							</div>
								<div class="text-center"><button type="submit" class="btn btn-primary">Guardar Cambios</button></div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<span><small>Administración en BD de Cliente </small></span>
					
				</div>
			</div>
		</div>
	</div>
											
											
											<!------------------------ Fin ventana modal:Editar Cliente -------------------------->
											
											</c:forEach>
											</tbody>	
										</table>			
					    	</div>
				  		</div>
				  </c:if>
				  
				  
				  <c:if test="${AdmValidado && panelProveedor}">
				  	 <div class="tab-pane active" id="proveedores">	
				  	 	<div class="table-responsive panel panel-default">			  
						 <table class="table table-hover">
				              <thead>
				                <tr>
				                  <th>CIF</th>
				                  <th>Nombre</th>
				                  <th>Email</th>
				                  <th>Pag Web</th>
				                  <th class="text-center">Opciones</th>
				                </tr>
				              </thead>
				              <tbody>
				               <c:forEach items="${listaProveedor}" var="proveedor" >
									<tr>
										<td><c:out value="${proveedor.cif}"></c:out></td>
										<td><c:out value="${proveedor.nombre}"></c:out></td>
										<td><c:out value="${proveedor.email}"></c:out></td>
										<td><c:out value="${proveedor.web}"></c:out></td>
										<td class="text-center">
										<button class="btn btn-info btn-xs" data-toggle="modal" data-toggle="tooltip" data-placement="left" title="Editar Proveedor" data-target="#myModal${proveedor.cif}">
  												<span class="glyphicon glyphicon-pencil"></span>
										</button>
										<a class="btn btn-danger btn-xs" data-toggle="modal tooltip" data-placement="left" title="Eliminar Proveedor" href="gestionProveedores?action=borrar&cif=${proveedor.cif}"> <span class="glyphicon glyphicon-trash"></span></a></td>
									</tr>
									
		<!------------------------ Ventana modal:Editar Proveedor -------------------------->
		<div class="modal fade" id="myModal${proveedor.cif}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Editar Proveedor</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<form action="gestionProveedores" method="post"  role="form">
							
								<div class="col-md-12">
									<div class="form-group">
										<label>CIF Proveedor</label> <input name="cif" type="text"
											class="form-control input-sm" value="${proveedor.cif}"
											readonly>
									</div>
									
									<div class="form-group">
										<label>Nombre</label> 
										<input name="nombre" type="text" class="form-control input-sm" value="${proveedor.nombre}"required>
									</div>
									
									<div class="well form-group">
										<label>Dirección</label> 
										<textarea name="direccion" class="form-control input-sm" required><c:out value="${proveedor.direccion}"></c:out></textarea>
									</div>
									<div class="form-group">
										<label>Email</label> 
										<input name="email" id="email" type="email" class="form-control input-sm" value="${proveedor.email}" required>
									</div>
									<div class="form-group">
										<label>Teléfono</label> 
										<input name="tlf" type="number" class="form-control input-sm" value="${proveedor.tlf}" required>
									</div>
									<div class="form-group">
										<label>Pagina Web</label> 
										<input name="web" type="text" class="form-control input-sm" value="${proveedor.web}"required>
									</div>
							</div>
							<hr />
							<div class="text-center"><button type="submit" class="btn btn-primary">Guardar Cambios</button></div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
											
											
	<!------------------------ Fin ventana modal:Editar Proveedor -------------------------->
									
									
								</c:forEach>
				              </tbody>
		            	</table>
				  	</div>
				  </div>
				  </c:if>
				 
				 
				  <c:if test="${AdmValidado && panelProducto}">
					  <div class="tab-pane active" id="productos">
							<div class="table-responsive panel panel-default">			  
								 <table class="table table-hover">
						              <thead>
						                <tr>
						                  <th>CIF</th>
						                  <th>IDP</th>
						                  <th>Nombre</th>
						                  <th>Precio</th>
						                  <th>En Oferta</th>
						                  <th>Stock</th>
						                  <th class="text-center">Opciones</th>
						                </tr>
						              </thead>
						              <tbody>
						               <c:forEach items="${listaProductos}" var="producto" >
											<tr>
												<td><c:out value="${producto.cif}"></c:out></td>
												<td><c:out value="${producto.idp}"></c:out></td>
												<td><c:out value="${producto.nombre}"></c:out></td>
												<td><c:out value="${producto.pre_act}"></c:out>€</td>
												<td><c:if test="${producto.oferta}">Si</c:if> <c:if test="${!producto.oferta}">No</c:if> </td>
												<td><c:out value="${producto.stock}"></c:out></td>
												<td class="text-center">
													<a class="btn btn-warning btn-xs" data-toggle="tooltip" data-placement="left" title="Ofertar Producto" href="gestionProductos?action=oferta&idp=${producto.idp}"><span class="glyphicon glyphicon-usd"></span></a>					
													<button class="btn btn-info btn-xs" data-toggle="modal" data-toggle="tooltip" data-placement="left" title="Editar Producto" data-target="#myModal${producto.idp}">
  														<span class="glyphicon glyphicon-pencil"></span>
													</button>
													<a class="btn btn-danger btn-xs" data-toggle="modal tooltip" data-placement="left" title="Eliminar Producto" href="gestionProductos?action=borrar&idp=${producto.idp}"><span class="glyphicon glyphicon-trash"></span></a> 
												</td>
											</tr>
											
		<!-------------------- Ventana Modal Editar Producto ---------------------------->
		<div class="modal fade" id="myModal${producto.idp}" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Editar Producto</h4>
				</div>
				<div class="modal-body">
					<div class="">

						<form action="gestionProductos" method="post" role="form">
							<div class="row">
								<div class="well well-xs col-md-5">
									<div class="form-group">
										<label>Id Producto</label> <input name="idp" type="text"
											class="form-control input-sm" value="${producto.idp}"
											readonly>
									</div>
									<div class="form-group">
										<label>Cif Proveedor</label> <input name="cif" type="text"
											class="form-control input-sm" placeholder="${producto.cif}"
											value="${producto.cif}" required>
									</div>
									<div class="form-group">
										<label>Tipo de Producto</label> <input name="tipo" type="text"
											class="form-control input-sm" placeholder="${producto.tipo}"
											value="${producto.tipo}"required>
									</div>
								</div>
								<div class="col-md-7">
									<div class="well text-center">
										<img src="${producto.urlImagen}" width="150px" height="150px"
											alt="no se puede mostrar la imgen" class="img-circle">
									</div>
									<div class="input-group form-group">
										<span class="input-group-addon">URL</span> <input
											name="urlImagen" type="text" class="form-control input-sm"
											placeholder="${producto.urlImagen}"
											value="${producto.urlImagen}" required>
									</div>
								</div>
							</div>
							<div class="well row">
								<div class="input-group form-group">
									<span class="input-group-addon">Nombre</span> <input
										name="nombre" type="text" class="form-control input-sm"
										placeholder="${producto.nombre}" value="${producto.nombre}" required>
								</div>
								<div class="form-group">
									<textarea name="descripcion" class="form-control input-sm" rows="3" placeholder="Descripcion" required><c:out value="${producto.descripcion}"></c:out></textarea>
								</div>
							</div>
							<label for="precio">Precio</label>
							<div class="well row">
								<div class=" col-md-4">
									<div class="input-group">
										<div class="input-group-addon">Min</div>
										<input name="pre_min" class="form-control input-sm text-right" type="number"
											placeholder="${producto.pre_min}" value="${producto.pre_min}" required>
										<span class="input-group-addon">€</span>
									</div>
								</div>
								<div class=" col-md-4">
									<div class="input-group">
										<div class="input-group-addon">Max</div>
										<input name="pre_max" class="form-control input-sm text-right" type="number"
											placeholder="${producto.pre_max}" value="${producto.pre_max}" required>
										<span class="input-group-addon">€</span>
									</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-3">
									<div class="input-group">
										<div class="input-group-addon">Stock</div>
										<input name="stock" class="form-control input-sm" type="number"
											placeholder="${producto.stock}" value="${producto.stock}" required>
									</div>
								</div>
							</div>
							<div class=" row">
								<div class="col-md-6">
									<div class="input-group">
										<div class="input-group-addon">Precio Actual</div>
										<input name="pre_act" class="form-control text-right" type="number"
											placeholder="${producto.pre_act}" value="${producto.pre_act}" required>
										<span class="input-group-addon">€</span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-group">
										<div class="input-group-addon">En Oferta</div>
										<input name="oferta" class="form-control " type="text"
											value="<c:if test="${producto.oferta}">Si</c:if> <c:if test="${!producto.oferta}">No</c:if>"
											readonly>
									</div>
								</div>
							</div>
							<hr/>
							<div class="text-center"> <button type="submit" class="btn btn-primary">Guardar Cambios</button></div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<span><small>Administración en BD de Producto </small></span>		
				</div>
			</div>
		</div>
	</div>
<!------------------------------- Fin Ventana Modal Editar Producto -------------------->
					  					
										</c:forEach>
						              </tbody>
				            	</table>
						  	</div>
					  </div>
					  
				  </c:if>
				  
				  
				  
				  
				  <div class="tab-pane" id="otros">futura implementacion</div>
				</div>
</html>