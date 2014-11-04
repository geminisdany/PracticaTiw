/*busca caracteres que no sean espacio en blanco*/
function vacio(c) {  
        for ( i = 0; i < c.length; i++ ) {  
                if ( c.charAt(i) != " " ) {  
                        return true  
                }  
        }  
    return false  
}
function validar(formulario){
	/*  NombreUsuario  */
	if(!vacio(formulario.nombreC.value)){ //Comprueba si el NombreUsuario esta vacio	
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
	/* DNI */
	var pathDNI= /[0-9]{8}/
		if(!vacio(formulario.dni.value)){	
			alert("El campo DNI de usuario debe rellenarse");
			formulario.dni.style.borderColor = "red";
			formulario.dni.style.borderColor = "dotted";
			return false;
		}else if (!(pathDNI.test(formulario.dni.value))){				
				alert("Formato de DNI incorrecto, tiene que ser de 8 digitos");
				formulario.dni.style.borderColor = "red";
				formulario.dni.style.borderColor = "dotted";
			return false;
			}else{
				formulario.dni.style.borderColor = "blue";
				formulario.dni.style.borderColor = "dotted";
	}
	/* Pais */
	if(!vacio(formulario.pais.value)){ //Comprueba si el NombreUsuario esta vacio	
		alert("El campo pais de usuario debe seleccionarse");
		formulario.pais.style.borderColor = "red";
		formulario.pais.style.borderColor = "dotted";
		return false;
	}else{
		formulario.pais.style.borderColor = "blue";
		formulario.pais.style.borderColor = "dotted";
	}
	/*  provincia  */
	if(!vacio(formulario.provincia.value)){ //Comprueba si el NombreUsuario esta vacio	
		alert("El campo provincia de usuario debe rellenarse");
		formulario.provincia.style.borderColor = "red";
		formulario.provincia.style.borderColor = "dotted";
		return false;
	}else if (formulario.provincia.value.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		alert("La provincia del usuario no puede contener números ni estar en blanco");
		formulario.provincia.style.borderColor = "red";
		formulario.provincia.style.borderColor = "dotted";
		return false;
	}else{
		formulario.provincia.style.borderColor = "blue";
		formulario.provincia.style.borderColor = "dotted";
	}
	/*  ciudad  */
	if(!vacio(formulario.ciudad.value)){ //Comprueba si el NombreUsuario esta vacio	
		alert("El campo ciudad de usuario debe rellenarse");
		formulario.ciudad.style.borderColor = "red";
		formulario.ciudad.style.borderColor = "dotted";
		return false;
	}else if (formulario.ciudad.value.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		alert("La ciudad del usuario no puede contener números ni estar en blanco");
		formulario.ciudad.style.borderColor = "red";
		formulario.ciudad.style.borderColor = "dotted";
		return false;
	}else{
		formulario.ciudad.style.borderColor = "blue";
		formulario.ciudad.style.borderColor = "dotted";
	}
	/*Direccion*/
	if(!vacio(formulario.direccion.value)){ //Comprueba si el NombreUsuario esta vacio	
		alert("El campo direccion de usuario debe rellenarse");
		formulario.direccion.style.borderColor = "red";
		formulario.direccion.style.borderColor = "dotted";
		return false;
	}else{
		formulario.direccion.style.borderColor = "blue";
		formulario.direccion.style.borderColor = "dotted";
	}
	/*CP*/
	var pathCP = /[0-9]{5}/
		if(!vacio(formulario.cp.value)){	//como no es un obligatorio solo se verifica si el usuario ha escrito algo 
			alert("El campo de codigo postal de usuario debe rellenarse");
			formulario.cp.style.borderColor = "red";
			formulario.cp.style.borderColor = "dotted";
			return false;
			}else if (!(pathCP.test(formulario.cp.value))){//Comprueba el formato del teléfono 
				alert("Formato del codigo postal es incorrecto, tiene que ser de 5 digitos");
				formulario.cp.style.borderColor = "red";
				formulario.cp.style.borderColor = "dotted";
			return false;
			}else{
				formulario.cp.style.borderColor = "blue";
				formulario.cp.style.borderColor = "dotted";
			}	
		/*TelefonoUsuario*/
	var pathTelefono = /[0-9]{9}/
	if(!vacio(formulario.phoneC.value)){	//como no es un obligatorio solo se verifica si el usuario ha escrito algo 
		alert("El campo Telefono de usuario debe rellenarse");
		formulario.phoneC.style.borderColor = "red";
		formulario.phoneC.style.borderColor = "dotted";
		return false;
		}else if (!(pathTelefono.test(formulario.phoneC.value))){//Comprueba el formato del teléfono 
			alert("Formato de Teléfono incorrecto, tiene que ser de 9 digitos");
			formulario.phoneC.style.borderColor = "red";
			formulario.phoneC.style.borderColor = "dotted";
		return false;
		}else{
			formulario.phoneC.style.borderColor = "blue";
			formulario.phoneC.style.borderColor = "dotted";
		}
	/*Forma de pago*/
	
	
	/*Forma de envio*/


	/*plazo de entrega*/

		/*  condiciones  */
	if(!formulario.condiciones.checked){
		alert("La casilla de condiciones de terminos no está marcada");
		return false;
	}else{
		alert("La compra se ha realizado con exito, le mandamos a la pagina principal");
	}

	alert("El formulario se ha rellenado correctamente");
	return true
}