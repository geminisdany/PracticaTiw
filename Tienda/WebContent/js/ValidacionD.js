/*busca caracteres que no sean espacio en blanco*/
function vacio(c) {  
        for ( i = 0; i < c.length; i++ ) {  
                if ( c.charAt(i) != " " ) {  
                        return true  
                }  
        }  
    return false  
}
function validarD(formulario){
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
	/*TelefonoUsuario*/
	var pathTelefono = /[0-9]{9}/
	if(!vacio(formulario.telefonoC.value)){
		alert("El campo Telefono de usuario debe rellenarse");
		formulario.telefonoC.style.borderColor = "red";
		formulario.telefonoC.style.borderColor = "dotted";
		return false;
		}else if (!(pathTelefono.test(formulario.telefonoC.value))){
			alert("Formato de Teléfono incorrecto, tiene que ser de 9 digitos");
			formulario.telefonoC.style.borderColor = "red";
			formulario.telefonoC.style.borderColor = "dotted";
		return false;
		}else{
			formulario.telefonoC.style.borderColor = "blue";
			formulario.telefonoC.style.borderColor = "dotted";
		}
	/* Pais */
	if(!vacio(formulario.paisF.value)){ 
		alert("El campo pais de usuario debe seleccionarse");
		formulario.paisF.style.borderColor = "red";
		formulario.paisF.style.borderColor = "dotted";
		return false;
	}else{
		formulario.paisF.style.borderColor = "blue";
		formulario.paisF.style.borderColor = "dotted";
	}
	/*  provincia  */
	if(!vacio(formulario.provinciaF.value)){ 
		alert("El campo provincia de usuario debe rellenarse");
		formulario.provinciaF.style.borderColor = "red";
		formulario.provinciaF.style.borderColor = "dotted";
		return false;
	}else if (formulario.provinciaF.value.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		alert("La provincia del usuario no puede contener números ni estar en blanco");
		formulario.provinciaF.style.borderColor = "red";
		formulario.provinciaF.style.borderColor = "dotted";
		return false;
	}else{
		formulario.provinciaF.style.borderColor = "blue";
		formulario.provinciaF.style.borderColor = "dotted";
	}
	/*  ciudad  */

	if(!vacio(formulario.ciudadF.value)){ 
		alert("El campo ciudad de usuario debe rellenarse");
		formulario.ciudadF.style.borderColor = "red";
		formulario.ciudadF.style.borderColor = "dotted";
		return false;
	}else if (formulario.ciudadF.value.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		alert("La ciudad del usuario no puede contener números ni estar en blanco");
		formulario.ciudadF.style.borderColor = "red";
		formulario.ciudadF.style.borderColor = "dotted";
		return false;
	}else{
		formulario.ciudadF.style.borderColor = "blue";
		formulario.ciudadF.style.borderColor = "dotted";
	}
	/*Direccion*/

	if(!vacio(formulario.direccionF.value)){ 
		alert("El campo direccion de usuario debe rellenarse");
		formulario.direccionF.style.borderColor = "red";
		formulario.direccionF.style.borderColor = "dotted";
		return false;
	}else{
		formulario.direccionF.style.borderColor = "blue";
		formulario.direccionF.style.borderColor = "dotted";
	}

	/*CP*/
	var pathCP = /[0-9]{5}/
		if(!vacio(formulario.cpF.value)){
			alert("El campo de codigo postal de usuario debe rellenarse");
			formulario.cpF.style.borderColor = "red";
			formulario.cpF.style.borderColor = "dotted";
			return false;
			}else if (!(pathCP.test(formulario.cpF.value))){
				alert("Formato del codigo postal es incorrecto, tiene que ser de 5 digitos");
				formulario.cpF.style.borderColor = "red";
				formulario.cpF.style.borderColor = "dotted";
			return false;
			}else{
				formulario.cpF.style.borderColor = "blue";
				formulario.cpF.style.borderColor = "dotted";
			}	


	/*Forma de pago*/
	if(!vacio(formulario.opcionPago.value)){ 
		alert("El campo forma de pago de usuario debe seleccionarse");
		formulario.opcionPago.style.borderColor = "red";
		formulario.opcionPago.style.borderColor = "dotted";
		return false;
	}else{
		formulario.opcionPago.style.borderColor = "blue";
		formulario.opcionPago.style.borderColor = "dotted";
	}
	var aux = formulario.opcionPago.value;
	if (aux == "Tarjeta") {
		/*tarjeta*/
		if(!vacio(formulario.ctarjeta.value)){ 
			alert("El campo tarjeta debe rellenarse");
			formulario.ctarjeta.style.borderColor = "red";
			formulario.ctarjeta.style.borderColor = "dotted";
			return false;
		}else{
			formulario.ctarjeta.style.borderColor = "blue";
			formulario.ctarjeta.style.borderColor = "dotted";
		}
	}
	if (aux == "Paypal") {
		/*cpaypal*/
		if(!vacio(formulario.cpaypal.value)){ 
			alert("El campo paypal debe rellenarse");
			formulario.cpaypal.style.borderColor = "red";
			formulario.cpaypal.style.borderColor = "dotted";
			return false;
		}else{
			formulario.cpaypal.style.borderColor = "blue";
			formulario.cpaypal.style.borderColor = "dotted";
		}
	}
	if (aux == "Transferencia") {
		/*ctransferencia*/
		if(!vacio(formulario.ctransferencia.value)){ 
			alert("El campo transferencia debe rellenarse");
			formulario.ctransferencia.style.borderColor = "red";
			formulario.ctransferencia.style.borderColor = "dotted";
			return false;
		}else{
			formulario.ctransferencia.style.borderColor = "blue";
			formulario.ctransferencia.style.borderColor = "dotted";
		}
	}



	
	

	alert("El formulario se ha rellenado correctamente");
	return true
}