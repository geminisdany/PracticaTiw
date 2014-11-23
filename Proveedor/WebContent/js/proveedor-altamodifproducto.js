function precios(){ //Antes de validar el resto del formulario, es indispensable que el precio minimo sea menor que el maximo
	var pmin = document.getElementById("pre_min").value;
	var pmax = document.getElementById("pre_max").value;
	if(pmin=="" || pmax=="" || pmin=="null" || pmax=="null"){
		alert("Los campos de precios no pueden estar vacíos.");
		return false;
	}
	var stock = document.getElementById("stock").value;
	var umstock = document.getElementById("umbralStock").value;
	if(stock=="" || umstock=="" || stock=="null" || umstock=="null"){
		alert("Los campos de stock no pueden estar vacíos.");
		return false;
	}
	
	var pmin2 = parseFloat(pmin);
	var pmax2 = parseFloat(pmax);
	var stock2 = parseInt(stock);
	var umbstock2 = parseInt(umstock);
	if(pmin2 < pmax2 && stock2 > umbstock2){
		return validarF();
	} else {
		alert("El precio mínimo debe ser menor que el precio máximo y la cantidad mayor que el umbral mínimo de stock. Por favor, vuelva a introducir los campos respectivos.");
		return false;
	}
}

function validarF(){ 
	var contador = 0;
	var resultado = "";
	
	//Valido el campo nombre de product
	var nombreProdu = document.getElementById("nombre").value;
	var nom = nombreProdu.toString();
	if (nom == null || nom == "") {
		resultado = resultado.concat("El campo Nombre debe rellenarse." + '\n');
		document.getElementById("nombre").style.borderColor="red";
		document.getElementById("nombre").style.borderStyle="dotted";
	} else if (nom.match(/[^\da-zA-ZáéíóúüçñÁÉÍÓÚÜÑÇ\s-]/gi)){
		document.getElementById("nombre").style.borderColor="red";
		document.getElementById("nombre").style.borderStyle="dotted";
		resultado = resultado.concat("El nombre no puede contener símbolos ni estar en blanco." + '\n');
	} else {
		document.getElementById("nombre").style.borderColor="blue";
		document.getElementById("nombre").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo cantidad de producto
	var cantidadProd = document.getElementById("stock").value;
	var cant = cantidadProd.toString();
	if (cant == null || cant == "") {
		resultado = resultado.concat("El campo 'Cantidad de producto' debe rellenarse." + '\n');
		document.getElementById("stock").style.borderColor="red";
		document.getElementById("stock").style.borderStyle="dotted";
	} else if (cant.match(/[\D]/gi)){
		document.getElementById("stock").style.borderColor="red";
		document.getElementById("stock").style.borderStyle="dotted";
		resultado = resultado.concat("La cantidad del producto tiene que ser números del 0 al 9 y no estar en blanco." + '\n');
	} else {
		document.getElementById("stock").style.borderColor="blue";
		document.getElementById("stock").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo umbral minimo de stock
	var cantidadProd = document.getElementById("umbralStock").value;
	var cant = cantidadProd.toString();
	if (cant == null || cant == "") {
		resultado = resultado.concat("El campo 'Umbral mínimo de stock' debe rellenarse." + '\n');
		document.getElementById("umbralStock").style.borderColor="red";
		document.getElementById("umbralStock").style.borderStyle="dotted";
	} else if (cant.match(/[\D]/gi)){
		document.getElementById("umbralStock").style.borderColor="red";
		document.getElementById("umbralStock").style.borderStyle="dotted";
		resultado = resultado.concat("El umbral mínimo de stock tiene que ser números del 0 al 9 y no estar en blanco." + '\n');
	} else {
		document.getElementById("umbralStock").style.borderColor="blue";
		document.getElementById("umbralStock").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'precio mínimo'
	var preciominPro = document.getElementById("pre_min").value;
	var pmin = preciominPro.toString();
	if (pmin == null || pmin == "") {
		resultado = resultado.concat("El campo 'precio mínimo del producto' debe rellenarse." + '\n');
		document.getElementById("pre_min").style.borderColor="red";
		document.getElementById("pre_min").style.borderStyle="dotted";
	} else if (pmin.match(/[^\d.]/gi)){
		document.getElementById("pre_min").style.borderColor="red";
		document.getElementById("pre_min").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'precio mínimo' no puede contener letras ni estar en blanco." + '\n');
	} else {
		document.getElementById("pre_min").style.borderColor="blue";
		document.getElementById("pre_min").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'precio máximo'
	var preciomaxPro = document.getElementById("pre_max").value;
	var pmax = preciomaxPro.toString();
	if (pmax == null || pmax == "") {
		resultado = resultado.concat("El campo 'precio máximo del producto' debe rellenarse." + '\n');
		document.getElementById("pre_max").style.borderColor="red";
		document.getElementById("pre_max").style.borderStyle="dotted";
	} else if (pmax.match(/[^\d.]/gi)){
		document.getElementById("pre_max").style.borderColor="red";
		document.getElementById("pre_max").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'precio máximo' no puede contener letras ni estar en blanco." + '\n');
	} else {
		document.getElementById("pre_max").style.borderColor="blue";
		document.getElementById("pre_max").style.borderStyle="dotted";
		contador = contador + 1;
	}
		
	//Valido el campo 'imagen del producto'
	var imagdestino = document.getElementById("urlImagen").value;
	var imgdst = imagdestino.toString();
	if (imgdst == null || imgdst == ""){
		document.getElementById("urlImagen").style.borderColor="red";
		document.getElementById("urlImagen").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'url imágen' no puede permanecer vacío, y puede estar formado tanto por letras como por números." + '\n');
	} else {
		document.getElementById("urlImagen").style.borderColor="blue";
		document.getElementById("urlImagen").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	if(contador == 6){
		alert("El producto es correcto");
	} else{
		alert(resultado);
		return false;
	}
}