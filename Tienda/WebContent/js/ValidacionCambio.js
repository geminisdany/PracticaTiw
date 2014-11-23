/*busca caracteres que no sean espacio en blanco*/
function vacio(c) {  
        for ( i = 0; i < c.length; i++ ) {  
                if ( c.charAt(i) != " " ) {  
                        return true  
                }  
        }  
    return false  
}

function validarCambio(formulario){
	/*  contraseñaUsuario vieja*/
	if(!vacio(formulario.passActual.value)){	
		alert("El campo contraseña actual de usuario debe rellenarse");
		formulario.passActual.style.borderColor = "red";
		formulario.passActual.style.borderColor = "dotted";
		return false;
	}
	
	/*  contraseñaUsuario nueva*/
	var p1 = formulario.pass1C.value;
	var p2 = formulario.pass2C.value;
	if(!vacio(formulario.pass1C.value)){ //Comprueba si el PassUsuario esta vacio	
		alert("El campo contraseña está vacío");
		formulario.pass1C.style.borderColor = "red";
		formulario.pass1C.style.borderColor = "dotted";
		return false;
	}else{
		var espacios = false;
		var cont = 0;		 
		while (!espacios && (cont < p1.length)) {
		if (p1.charAt(cont) == " ")
			espacios = true;
			cont++;
		}	 
		if (espacios) {
		alert ("La contraseña no puede contener espacios en blanco");
		return false;
		}
		formulario.pass1C.style.borderColor = "blue";
		formulario.pass1C.style.borderColor = "dotted";
	}
		/*  comprobar contraseña */
    if (p1 != p2) {
		alert("Las contraseña no coincide");
		formulario.pass2C.style.borderColor = "red";
		formulario.pass2C.style.borderColor = "dotted";
		return false;
    } else {
		formulario.pass1C.style.borderColor = "blue";
		formulario.pass1C.style.borderColor = "dotted";
		formulario.pass2C.style.borderColor = "blue";
		formulario.pass2C.style.borderColor = "dotted";
	}
	return true
}
