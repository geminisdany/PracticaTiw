/*busca caracteres que no sean espacio en blanco*/
function vacio(c) {  
        for ( i = 0; i < c.length; i++ ) {  
                if ( c.charAt(i) != " " ) {  
                        return true  
                }  
        }  
    return false  
}

function validarPd(formulario){
	/*  cif del producto  */	
	if(!vacio(formulario.cif.value)){	
		alert("El campo cif de producto debe rellenarse");
		formulario.cif.style.borderColor = "red";
		formulario.cif.style.borderColor = "dotted";
		return false;
	}else{
		formulario.cif.style.borderColor = "blue";
		formulario.cif.style.borderColor = "dotted";
	}
	/*Url*/	
	var ini1 = new RegExp("https://");
	var ini2 = new RegExp("http://");
	var pathUrl=/^[^@\s]+[^@\.\s]+(\.[^@\.\s]+)+(\.[^@\.\s]+)+$/;
	if(!vacio(formulario.urlImagen.value)){
			alert("El campo web está vacío");
			formulario.urlImagen.style.borderColor = "red";
			formulario.urlImagen.style.borderColor = "dotted";
			return false;
		}else{
			formulario.urlImagen.style.borderColor = "blue";
			formulario.urlImagen.style.borderColor = "dotted";
		}

	if ((ini1.test(formulario.urlImagen.value)) || (ini2.test(formulario.urlImagen.value))){
		if (!(pathUrl.test(formulario.urlImagen.value))){
			alert("Formato de web incorrecto, ej: https o http://algo.algo.algo");
			formulario.urlImagen.style.borderColor = "red";
			formulario.urlImagen.style.borderColor = "dotted";
			return false;
		}else{			
			formulario.urlImagen.style.borderColor = "blue";
			formulario.urlImagen.style.borderColor = "dotted";	
		}
	}else{
		formulario.urlImagen.style.borderColor = "red";
		formulario.urlImagen.style.borderColor = "dotted";
		return false;
	}

	/*  nombre del producto  */	
	if(!vacio(formulario.nombre.value)){	
		alert("El campo nombre de producto debe rellenarse");
		formulario.nombre.style.borderColor = "red";
		formulario.nombre.style.borderColor = "dotted";
		return false;
	}else{
		formulario.nombre.style.borderColor = "blue";
		formulario.nombre.style.borderColor = "dotted";
	}
	/*  descipcion del producto  */	
	if(!vacio(formulario.descripcion.value)){	
		alert("El campo descripcion de producto debe rellenarse");
		formulario.descripcion.style.borderColor = "red";
		formulario.descripcion.style.borderColor = "dotted";
		return false;
	}else{
		formulario.descripcion.style.borderColor = "blue";
		formulario.descripcion.style.borderColor = "dotted";
	}
	/*  precio min*/	
	var min = /[0-9]/gi;
	if (!(min.test(formulario.pre_min.value))){
		alert("Formato de precio minimo incorrecto");
		formulario.pre_min.style.borderColor = "red";
		formulario.pre_min.style.borderColor = "dotted";
		return false;
	}else{
		formulario.pre_min.style.borderColor = "blue";
		formulario.pre_min.style.borderColor = "dotted";
	}
	if(!vacio(formulario.pre_min.value)){	
		alert("El campo precio minimo de producto debe rellenarse");
		formulario.pre_min.style.borderColor = "red";
		formulario.pre_min.style.borderColor = "dotted";
		return false;
	}else{
		if(formulario.pre_min.value >= 0 && !formulario.pre_min.value.match(/[,-]/gi)){
			formulario.pre_min.style.borderColor = "blue";
			formulario.pre_min.style.borderColor = "dotted";
		}else{
			alert("El campo precio minimo no puede ser negativo o con signo");
			formulario.pre_min.style.borderColor = "red";
			formulario.pre_min.style.borderColor = "dotted";
			return false;
		}
	}
	
	
	/*  precio max*/ 
	var max = /[0-9]/gi;
	if (!(max.test(formulario.pre_max.value))){//Comprueba el formato del email 
		alert("Formato de precio maximo incorrecto");
		formulario.pre_max.style.borderColor = "red";
		formulario.pre_max.style.borderColor = "dotted";
		return false;
	}else{
		formulario.pre_max.style.borderColor = "blue";
		formulario.pre_max.style.borderColor = "dotted";
	}	
	if(!vacio(formulario.pre_max.value)){	
		alert("El campo precio maximo de producto debe rellenarse");
		formulario.pre_max.style.borderColor = "red";
		formulario.pre_max.style.borderColor = "dotted";
		return false;
	}else{
		if(formulario.pre_max.value >= 0 && !formulario.pre_max.value.match(/[,-]/gi)){
			formulario.pre_max.style.borderColor = "blue";
			formulario.pre_max.style.borderColor = "dotted";
		}else{
			alert("El campo precio maximo no puede ser negativo o con signo");
			formulario.pre_max.style.borderColor = "red";
			formulario.pre_max.style.borderColor = "dotted";
			return false;
		}
	}
	var pmin2 = parseFloat(formulario.pre_min.value );
	var pmax2 = parseFloat(formulario.pre_max.value);
	if(pmax2 < pmin2 ){
		alert("El campo precio minimo no puede ser mayor o igual al prexio maximo");
		formulario.pre_min.style.borderColor = "red";
		formulario.pre_min.style.borderColor = "dotted";
		formulario.pre_max.style.borderColor = "red";
		formulario.pre_max.style.borderColor = "dotted";
		return false;
	}
	
	/*  Stock producto */ 
	var st = /[0-9]/gi;
	if (!(st.test(formulario.stock.value))){//Comprueba el formato del email 
		alert("Formato de stock incorrecto");
		formulario.stock.style.borderColor = "red";
		formulario.stock.style.borderColor = "dotted";
		return false;
	}else{
		formulario.stock.style.borderColor = "blue";
		formulario.stock.style.borderColor = "dotted";
	}	
	if(!vacio(formulario.stock.value)){	
		alert("El campo stock de producto debe rellenarse");
		formulario.stock.style.borderColor = "red";
		formulario.stock.style.borderColor = "dotted";
		return false;
	}else{
		if(formulario.stock.value >= 0 && !formulario.stock.value.match(/[,-]/gi)){
			formulario.stock.style.borderColor = "blue";
			formulario.stock.style.borderColor = "dotted";
		}else{
			alert("El campo stock no puede ser negativo o contener signo");
			formulario.stock.style.borderColor = "red";
			formulario.stock.style.borderColor = "dotted";
			return false;
		}
	}
	/*  precio actual del  producto */
	var pa = /[0-9]/gi;
	if (!(pa.test(formulario.pre_act.value))){//Comprueba el formato del email 
		alert("Formato de precio actual incorrecto");
		formulario.pre_act.style.borderColor = "red";
		formulario.pre_act.style.borderColor = "dotted";
		return false;
	}else{
		formulario.pre_act.style.borderColor = "blue";
		formulario.pre_act.style.borderColor = "dotted";
	}	
	if(!vacio(formulario.pre_act.value)){	
		alert("El campo precio actual del producto debe rellenarse");
		formulario.pre_act.style.borderColor = "red";
		formulario.pre_act.style.borderColor = "dotted";
		return false;
	}else{
		if(formulario.pre_act.value >= 0 && !formulario.pre_act.value.match(/[,-]/gi)){
			formulario.pre_act.style.borderColor = "blue";
			formulario.pre_act.style.borderColor = "dotted";
		}else{
			alert("El campo precio actual no puede ser negativo o contener signo");
			formulario.pre_act.style.borderColor = "red";
			formulario.pre_act.style.borderColor = "dotted";
			return false;
		}
	}
	var act = parseFloat(formulario.pre_act.value );
	var pmin3 = parseFloat(formulario.pre_min.value );
	var pmax3 = parseFloat(formulario.pre_max.value);
	if( act <= pmax3 && act >= pmin3 ){
		
	}else{
		alert("El campo precio actual tiene que estar entre el precio minimo y maximo");
		formulario.pre_act.style.borderColor = "red";
		formulario.pre_act.style.borderColor = "dotted";
		return false;
	}
		
	alert("El formulario se ha editado correctamente");
	return true
}