function precios(){ //Antes de validar el resto del formulario, es indispensable que el precio minimo sea menor que el maximo
	var pmin = document.getElementById("pre_min").value;
	var pmax = document.getElementById("pre_max").value;
	if(pmin=="" || pmax=="" || pmin=="null" || pmax=="null"){
		alert("Los campos de precios no pueden estar vacíos.");
	}
	if(pmin<pmax){
		return validarF();
	} else {
		alert("El precio mínimo debe ser menor que el precio máximo. Por favor, vuelva a introducir los precios respectivos.");
	}
}

function validarF(){ 
	var contador = 0;
	//Valido el campo nombre de product
	var nombreProdu = document.getElementById("nombre").value;
	var nom = nombreProdu.toString();
	if (nom == null || nom == "") {
		alert("El campo Nombre debe rellenarse");
		document.getElementById("nombre").style.borderColor="red";
		document.getElementById("nombre").style.borderStyle="dotted";
	} else if (nom.match(/[^\da-zA-ZáéíóúüçñÁÉÍÓÚÜÑÇ\s-]/gi)){
		document.getElementById("nombre").style.borderColor="red";
		document.getElementById("nombre").style.borderStyle="dotted";
		alert("El nombre no puede contener símbolos ni estar en blanco");
	} else {
		document.getElementById("nombre").style.borderColor="blue";
		document.getElementById("nombre").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo cantidad de producto
	var cantidadProd = document.getElementById("stock").value;
	var cant = cantidadProd.toString();
	if (cant == null || cant == "") {
		alert("El campo 'Cantidad de producto' debe rellenarse");
		document.getElementById("stock").style.borderColor="red";
		document.getElementById("stock").style.borderStyle="dotted";
	} else if (cant.match(/[\D]/gi)){
		document.getElementById("stock").style.borderColor="red";
		document.getElementById("stock").style.borderStyle="dotted";
		alert("La cantidad del producto tiene que ser números del 0 al 9 y no estar en blanco");
	} else {
		document.getElementById("stock").style.borderColor="blue";
		document.getElementById("stock").style.borderStyle="dotted";
		contador = contador + 1;
	}
		
	//Valido el campo 'precio mínimo'
	var preciominPro = document.getElementById("pre_min").value;
	var pmin = preciominPro.toString();
	if (pmin == null || pmin == "") {
		alert("El campo 'precio mínimo del producto' debe rellenarse");
		document.getElementById("pre_min").style.borderColor="red";
		document.getElementById("pre_min").style.borderStyle="dotted";
	} else if (pmin.match(/[^\d.]/gi)){
		document.getElementById("pre_min").style.borderColor="red";
		document.getElementById("pre_min").style.borderStyle="dotted";
		alert("El campo 'precio mínimo' no puede contener letras ni estar en blanco");
	} else {
		document.getElementById("pre_min").style.borderColor="blue";
		document.getElementById("pre_min").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'precio máximo'
	var preciomaxPro = document.getElementById("pre_max").value;
	var pmax = preciomaxPro.toString();
	if (pmax == null || pmax == "") {
		alert("El campo 'precio máximo del producto' debe rellenarse");
		document.getElementById("pre_max").style.borderColor="red";
		document.getElementById("pre_max").style.borderStyle="dotted";
	} else if (pmax.match(/[^\d.]/gi)){
		document.getElementById("pre_max").style.borderColor="red";
		document.getElementById("pre_max").style.borderStyle="dotted";
		alert("El campo 'precio máximo' no puede contener letras ni estar en blanco");
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
		alert("El campo 'url imágen' no puede permanecer vacío, y puede estar formado tanto por letras como por números");
	} else {
		document.getElementById("urlImagen").style.borderColor="blue";
		document.getElementById("urlImagen").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	if(contador == 5){
		alert("Usuario registrado con éxito");
	} else{
		return false;
	}
}