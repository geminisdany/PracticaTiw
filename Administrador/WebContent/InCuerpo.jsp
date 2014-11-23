<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	
<html>
<script src="js/ValidacionEC.js"></script>
<script src="js/ValidacionPv.js"></script>
<script src="js/ValidacionPd.js"></script>
	<!-- Tab panes -->
				<div class="tab-content">
				  <c:if test="${AdmValidado!=null && panelCliente}">
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
													<td><c:out value="${cliente.id}"></c:out></td>
													<td><c:out value="${cliente.nombre}"></c:out></td>
													<td><c:out value="${cliente.email}"></c:out></td>
													<td><c:out value="${cliente.telefono}"></c:out></td>
													<td class="text-center">
														<button class="btn btn-info btn-xs" data-toggle="modal" data-toggle="tooltip" data-placement="left" title="Editar Cliente" data-target="#myModal${cliente.id}">
  															<span class="glyphicon glyphicon-pencil"></span>
														</button>
														<a  class="btn btn-danger btn-xs" data-toggle="modal tooltip" data-placement="left" title="Eliminar Cliente" href="gestionClientes?action=borrar&idc=${cliente.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
												</tr>
											
											
											<!------------------------ Ventana modal:Editar Cliente -------------------------->
		<div class="modal fade" id="myModal${cliente.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Editar Cliente</h4>
				</div>
				<div class="modal-body">
					<div class="">
				
					
					<form  onSubmit="return validarEC(this)" action="gestionClientes" method="post" class="form-horizontal" role="form">
					<input type="text" name="id" value="${cliente.id}" hidden>
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
						
						<input type="text" class="form-control" id="telefonoC" name="telefonoC"
							   placeholder="Telefono" value="${cliente.telefono}">
					  
					  </div>
					  <div class="form-group col-md-2"></div>
					  <div class="form-group col-md-5">
						<label for="emailC">Email <span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Email"></span></label>
						<input type="text" class="form-control" id="emailC" name="emailC" 
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
								<div class="text-center"> 
								<button type="submit" class="btn btn-primary">Guardar Cambios</button>
								<button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
							</div>
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
				  
				  
				  <c:if test="${AdmValidado!=null && panelProveedor}">
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
										<a class="btn btn-danger btn-xs" data-toggle="modal tooltip" data-placement="left" title="Eliminar Proveedor" href="gestionProveedores?action=borrar&id=${proveedor.id}"> <span class="glyphicon glyphicon-trash"></span></a></td>
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
				
				<div class="">
				<form onSubmit="return validarPv(this)" action="gestionProveedores" class="form-horizontal" role="form" method="post">
				
					<div class="hidden">
						<input type="text" class="form-control" name="id" value="${proveedor.id}">
					</div>
					<div class="row">
					  <div class="form-group col-sm-5" id="columnas62">
						<label for="nombre">Nombre del Proveedor<span class="red">*</span><span class="glyphicon glyphicon-user" title="Usuario"></span></label>
						<input type="text" class="form-control" id="nombre" name="nombre"
							   value="${proveedor.nombre}">
					  </div>
					  <div class="form-group col-sm-2"></div>
					  <div class="form-group col-sm-5" id="columnas6o2">
						<label for="cif">CIF del proveedor<span class="red">*</span></label>
						<input type="text" class="form-control" id="cif" name="cif"
							   value="${proveedor.cif}">
					  </div>
					</div>
					<br>
					
					<div class="row">
					  <div class="form-group col-sm-5">
						<label for="email">Email del proveedor<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Email"></span></label>
						<input type="text" class="form-control" id="email" name="email"
								  value="${proveedor.email}">
					  </div>
					  <div class="form-group col-sm-2"></div>
					  
					  <div class="form-group col-sm-5">
						<label for="tlf">Tel&eacute;fono del proveedor <span class="red">*</span><span class="glyphicon glyphicon-phone-alt" title="Tel&eacute;fono"></span></label>
						<input type="text" class="form-control" id="tlf" name="tlf"
							   value="${proveedor.telefono}">
					  </div>					
					</div>
					
					
					
					<br>
					<div class="row">
					  <div class="form-group col-sm-6">
						<label for="direccion">Direcci&oacute;n<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Direcci&oacute;n"></span></label>
						<input type="text" class="form-control" id="direccion" name="direccion"
							    value="${proveedor.direccion.direccion}">
					  </div>
					  <div class="form-group col-sm-1"></div>
					  <div class="form-group col-sm-5">
						<label for="ciudad">Localidad<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Localidad"></span></label>
						<input type="text" class="form-control" id="ciudad" name="ciudad"
							    value="${proveedor.direccion.ciudad}">
					  </div>
					</div>
					<br>
					<div class="row"> 
					  <div class="form-group col-sm-2">
						<label for="cp"> CP <span class="red">*</span></label>
						<input type="text" class="form-control" id="cp" name="cp"
								 value="${proveedor.direccion.cp}" maxlength="5">
					  </div>
					  <div class="form-group col-sm-1"></div>
					  <div class="form-group col-sm-4">
						<label for=provincia>Provincia<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Provincia"></span></label>
						<input type="text" class="form-control" id="provincia" name="provincia"
							    value="${proveedor.direccion.provincia}">
					  </div>
					  <div class="form-group col-sm-1"></div>
					  <div class="form-group col-sm-4">
						<label for="pais">Pa&iacute;s<span class="red">*</span><span class="glyphicon glyphicon-envelope" title="Pa&iacute;s"></span></label>
						<input type="text" class="form-control" id="pais" name="pais"
							    value="${proveedor.direccion.pais}">
					  </div>
					</div>
					<br>
					<div class="row">
					  
					   <div class="form-group col-sm-5">
						<label for="web">Web del proveedor<span class="red">*</span><span class="glyphicon glyphicon-globe" title="Web"></span></label>
						<input type="text" class="form-control" id="web" name="web"
							    value="${proveedor.web}">
					  </div>
					  
					  <div class="form-group col-sm-7"></div>
					</div>
				  <br>				  
				  <div class="checkbox">
					<label>
					  <input type="checkbox"> Deseo recibir correos con novedades y ofertas de Talaver&aacute;mica
					</label>
				  </div>
				  <br>
				 
				 <div class="text-center"> 
								<button type="submit" class="btn btn-primary">Guardar Cambios</button>
								<button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
							</div>
				
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
				 
				 
				  <c:if test="${AdmValidado!=null && panelProducto}">
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
												<td><c:out value="${producto.proveedor.cif}"></c:out></td>
												<td><c:out value="${producto.id}"></c:out></td>
												<td><c:out value="${producto.nombre}"></c:out></td>
												<td><c:out value="${producto.precio}"></c:out>€</td>
												<td><c:if test="${producto.oferta}">Si</c:if> <c:if test="${!producto.oferta}">No</c:if> </td>
												<td><c:out value="${producto.stock}"></c:out></td>
												<td class="text-center">
													<a class="btn btn-warning btn-xs" data-toggle="tooltip" data-placement="left" title="Ofertar Producto" href="gestionProductos?action=oferta&idp=${producto.id}"><span class="glyphicon glyphicon-usd"></span></a>					
													<button class="btn btn-info btn-xs" data-toggle="modal" data-toggle="tooltip" data-placement="left" title="Editar Producto" data-target="#myModal${producto.id}">
  														<span class="glyphicon glyphicon-pencil"></span>
													</button>
													<a class="btn btn-danger btn-xs" data-toggle="modal tooltip" data-placement="left" title="Eliminar Producto" href="gestionProductos?action=borrar&idp=${producto.id}"><span class="glyphicon glyphicon-trash"></span></a> 
												</td>
											</tr>
											
		<!-------------------- Ventana Modal Editar Producto ---------------------------->
		<div class="modal fade" id="myModal${producto.id}" tabindex="-1"
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

						<form onSubmit="return validarPd(this)" action="gestionProductos" method="post" role="form">
							<div class="row">
								<div class="well well-xs col-md-5">
									<div class="form-group">
										<label>Id Producto</label> <input name="idp" type="text"
											class="form-control input-sm" value="${producto.id}"
											readonly>
									</div>
									<div class="form-group">
										<label>Cif Proveedor</label> <input name="cif" type="text"
											class="form-control input-sm" placeholder="${producto.proveedor.cif}"
											value="${producto.proveedor.cif}" required>
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
							<div class="form-group well well-xs ">
									<label>Categor&iacute;a<span class="red">*</span></label><br>
										<input type="radio" name="tipo" value="vasija" checked>Vasija   
										<input type="radio" name="tipo" value="maceta">Maceta
										<input type="radio" name="tipo" value="copa">Copa
										<input type="radio" name="tipo" value="botijo">Botijo
										<input type="radio" name="tipo" value="tinaja">Tinaja
										<input type="radio" name="tipo" value="fuente">Fuente
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
										<input name="pre_min" class="form-control input-sm text-right" type="text"
											placeholder="${producto.pre_min}" value="${producto.pre_min}" required>
										<span class="input-group-addon">€</span>
									</div>
								</div>
								<div class=" col-md-4">
									<div class="input-group">
										<div class="input-group-addon">Max</div>
										<input name="pre_max" class="form-control input-sm text-right" type="text"
											placeholder="${producto.pre_max}" value="${producto.pre_max}" required>
										<span class="input-group-addon">€</span>
									</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-3">
									<div class="input-group">
										<div class="input-group-addon">Stock</div>
										<input name="stock" class="form-control input-sm" type="text"
											placeholder="${producto.stock}" value="${producto.stock}" required>
									</div>
								</div>
							</div>
							<div class=" row">
								<div class="col-md-6">
									<div class="input-group">
										<div class="input-group-addon">Precio Actual</div>
										<input name="pre_act" class="form-control text-right" type="text"
											placeholder="${producto.precio}" value="${producto.precio}" required>
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
							<div class="text-center"> 
								<button type="submit" class="btn btn-primary">Guardar Cambios</button>
								<button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
							</div>
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
				</div>
				
				
				
				
				
				<c:if test="${AdmValidado!=null && panelImpuestos}">
				  		<div class="tab-pane active" id="Impuestos">
					    	<div class="table-responsive panel panel-default">			    	
									<jsp:include page="impuestos.jsp"></jsp:include>
										    				
					    	</div>
				  		</div>
				  </c:if>
				  
				
				
				
				
				
				<c:if test="${AdmValidado!=null && panelFacturas}">
				  		<div class="tab-pane active" id="facturas">
					    	<div class="table-responsive panel panel-default">	
					    			    	
								    	<jsp:include page="historialFacturas.jsp"></jsp:include>    	
								    				
					    	</div>
				  		</div>
				  </c:if>
				
				
</html>