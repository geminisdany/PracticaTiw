/*busca caracteres que no sean espacio en blanco*/
function vacio(c) {  
        for ( i = 0; i < c.length; i++ ) {  
                if ( c.charAt(i) != " " ) {  
                        return true  
                }  
        }  
    return false  
}

function validarR(formulario){
	/*  NombreUsuario  */
	if(!vacio(formulario.nombreC.value)){	
		alert("El campo Nombre de usuario debe rellenarse");
		formulario.nombreC.style.borderColor = "red";
		formulario.nombreC.style.borderColor = "dotted";
		return false;
	}else if (formulario.nombreC.value.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		alert("El nombre del usuario no puede contener números ni estar en blanco");
		formulario.nombreC.style.borderColor = "red";
		formulario.nombreC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.nombreC.style.borderColor = "blue";
		formulario.nombreC.style.borderColor = "dotted";
	}
	/*  Apellido 1 usuario	  */
	if(!vacio(formulario.apellidosC.value)){	
		alert("El campo Apellido de usuario debe rellenarse");
		formulario.apellidosC.style.borderColor = "red";
		formulario.apellidosC.style.borderColor = "dotted";
		return false;
	}else if (formulario.apellidosC.value.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		alert("El Apellido del usuario no puede contener números ni estar en blanco");
		formulario.apellidosC.style.borderColor = "red";
		formulario.apellidosC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.apellidosC.style.borderColor = "blue";
		formulario.apellidosC.style.borderColor = "dotted";
	}
	/*TelefonoUsuario*/
	var pathTelefono = /[0-9]{9}/
	if(!vacio(formulario.telefonoC.value)){
			alert("Formato de Teléfono incorrecto, tiene que ser de 9 digitos");
			formulario.telefonoC.style.borderColor = "red";
			formulario.telefonoC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.telefonoC.style.borderColor = "blue";
		formulario.telefonoC.style.borderColor = "dotted";
	}
	if (!(pathTelefono.test(formulario.telefonoC.value))){
		alert("Formato de Teléfono incorrecto, tiene que ser de 9 digitos");
		formulario.telefonoC.style.borderColor = "red";
		formulario.telefonoC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.telefonoC.style.borderColor = "blue";
		formulario.telefonoC.style.borderColor = "dotted";
	}
	/*Donde tiene el validador del email?*/
	/*  Email */
	 var pathCorreo=/^[^@\s]+@[^@\.\s]+(\.[^@\.\s]+)+$/
	 
	if(!vacio(formulario.emailC.value)){
		alert("El campo email está vacío");
		formulario.emailC.style.borderColor = "red";
		formulario.emailC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.emailC.style.borderColor = "blue";
		formulario.emailC.style.borderColor = "dotted";
	}
	if (!(pathCorreo.test(formulario.emailC.value))){
		alert("Formato de email incorrecto, Ej algo@algo.algo");
		formulario.emailC.style.borderColor = "red";
		formulario.emailC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.emailC.style.borderColor = "blue";
		formulario.emailC.style.borderColor = "dotted";
	}
	
	/*  contraseñaUsuario */
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
	/* Pais */
	if(!vacio(formulario.paisC.value)){ 
		alert("El campo pais de usuario debe seleccionarse");
		formulario.paisC.style.borderColor = "red";
		formulario.paisC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.paisC.style.borderColor = "blue";
		formulario.paisC.style.borderColor = "dotted";
	}
	/*  provincia  */
	if(!vacio(formulario.provinciaC.value)){ 
		alert("El campo provincia de usuario debe rellenarse");
		formulario.provinciaC.style.borderColor = "red";
		formulario.provinciaC.style.borderColor = "dotted";
		return false;
	}else if (formulario.provinciaC.value.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		alert("La provincia del usuario no puede contener números ni estar en blanco");
		formulario.provinciaC.style.borderColor = "red";
		formulario.provinciaC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.provinciaC.style.borderColor = "blue";
		formulario.provinciaC.style.borderColor = "dotted";
	}
	/*  ciudad  */

	if(!vacio(formulario.ciudadC.value)){ 
		alert("El campo ciudad de usuario debe rellenarse");
		formulario.ciudadC.style.borderColor = "red";
		formulario.ciudadC.style.borderColor = "dotted";
		return false;
	}else if (formulario.ciudadC.value.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		alert("La ciudad del usuario no puede contener números ni estar en blanco");
		formulario.ciudadC.style.borderColor = "red";
		formulario.ciudadC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.ciudadC.style.borderColor = "blue";
		formulario.ciudadC.style.borderColor = "dotted";
	}
    /*Direccion*/

	if(!vacio(formulario.direccionC.value)){ 
		alert("El campo direccion de usuario debe rellenarse");
		formulario.direccionC.style.borderColor = "red";
		formulario.direccionC.style.borderColor = "dotted";
		return false;
	}else{
		formulario.direccionC.style.borderColor = "blue";
		formulario.direccionC.style.borderColor = "dotted";
	}

	/*CP*/
	var pathCP = /[0-9]{5}/
		if(!vacio(formulario.cpC.value)){
			alert("El campo de codigo postal de usuario debe rellenarse");
			formulario.cpC.style.borderColor = "red";
			formulario.cpC.style.borderColor = "dotted";
			return false;
			}else if (!(pathCP.test(formulario.cpC.value))){
				alert("Formato del codigo postal es incorrecto, tiene que ser de 5 digitos");
				formulario.cpC.style.borderColor = "red";
				formulario.cpC.style.borderColor = "dotted";
			return false;
			}else{
				formulario.cpC.style.borderColor = "blue";
				formulario.cpC.style.borderColor = "dotted";
			}	


	alert("El formulario se ha rellenado correctamente");
	return true
}
