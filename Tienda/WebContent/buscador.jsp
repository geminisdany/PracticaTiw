<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form action="catalogo" method="get" class="navbar-form " role="search">
        <input type="text" name="action" value="buscar" hidden> Producto
        <div class="form-group">
          <label class=" radio-inline">
		  <input type="radio" name="opcion" id="inlineRadio1" value="producto" checked> Producto
			</label>
			<label class="radio-inline">
			  <input type="radio" name="opcion" id="inlineRadio2" value="tipo"> Tipo
			</label>
			<label class="radio-inline">
			  <input type="radio" name="opcion" id="inlineRadio3" value="proveedor"> Proveedor
			</label>    
          <input type="text" name="palabraClave" class="form-control" placeholder="Ej. Vasijas AND Botijos">
        </div>
        <button type="submit" class="btn btn-default">Buscar</button>
      </form>   
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</html>