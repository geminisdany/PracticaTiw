/*busca caracteres que no sean espacio en blanco*/
function vacio(c) {  
        for ( i = 0; i < c.length; i++ ) {  
                if ( c.charAt(i) != " " ) {  
                        return true  
                }  
        }  
    return false  
}

function validarP(formulario){
	/*  cantidad */
	var can = /[0-9]/gi;
	if (!(can.test(formulario.cantidad.value))){
		alert("Formato de cantidad incorrecto");
		formulario.cantidad.style.borderColor = "red";
		formulario.cantidad.style.borderColor = "dotted";
		return false;
	}else{
		formulario.cantidad.style.borderColor = "blue";
		formulario.cantidad.style.borderColor = "dotted";
	}	
	if(!vacio(formulario.cantidad.value)){	
		alert("El campo cantidad de producto debe rellenarse");
		formulario.cantidad.style.borderColor = "red";
		formulario.cantidad.style.borderColor = "dotted";
		return false;
	}else{
		if(formulario.cantidad.value >= 0 && !formulario.cantidad.value.match(/[,.-]/gi)){
			formulario.cantidad.style.borderColor = "blue";
			formulario.cantidad.style.borderColor = "dotted";
		}else{
			alert("El campo cantidad no puede ser negativo o contener signo");
			formulario.cantidad.style.borderColor = "red";
			formulario.cantidad.style.borderColor = "dotted";
			return false;
		}
	}
	if (formulario.cantidad.value == 0) {
		alert("El campo cantidad no puede ser 0");
		formulario.cantidad.style.borderColor = "red";
		formulario.cantidad.style.borderColor = "dotted";
		return false;
	}
	if (formulario.cantidad.value > formulario.stock.value){
		alert("La cantidad no puede superar el stock");
		formulario.cantidad.style.borderColor = "red";
		formulario.cantidad.style.borderColor = "dotted";
		return false;
	}
	return true
}
