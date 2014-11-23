/*busca caracteres que no sean espacio en blanco*/
function vacio(c) {  
        for ( i = 0; i < c.length; i++ ) {  
                if ( c.charAt(i) != " " ) {  
                        return true  
                }  
        }  
    return false  
}

function validarPv(formulario){
	/*  NombreUsuario  */
	if(!vacio(formulario.nombre.value)){	
		alert("El campo Nombre de proveedor debe rellenarse");
		formulario.nombre.style.borderColor = "red";
		formulario.nombre.style.borderColor = "dotted";
		return false;
	}else{
		formulario.nombre.style.borderColor = "blue";
		formulario.nombre.style.borderColor = "dotted";
	}
	/*  cif  */
	if(!vacio(formulario.cif.value)){	
		alert("El campo cif de proveedor debe rellenarse");
		formulario.cif.style.borderColor = "red";
		formulario.cif.style.borderColor = "dotted";
		return false;
	}else{
		formulario.cif.style.borderColor = "blue";
		formulario.cif.style.borderColor = "dotted";
	}
	/*  Email */
	var pathCorreo=/^[^@\s]+@[^@\.\s]+(\.[^@\.\s]+)+$/;
	if(!vacio(formulario.email.value)){
		alert("El campo email está vacío, ej: algo@algo.algo");
		formulario.email.style.borderColor = "red";
		formulario.email.style.borderColor = "dotted";
		return false;
	}else{
		formulario.email.style.borderColor = "blue";
		formulario.email.style.borderColor = "dotted";
	}
	if (!(pathCorreo.test(formulario.email.value))){
		alert("Formato de email incorrecto, ej: algo@algo.algo");
		formulario.email.style.borderColor = "red";
		formulario.email.style.borderColor = "dotted";
		return false;
	}else{
		formulario.email.style.borderColor = "blue";
		formulario.email.style.borderColor = "dotted";
	}
	/*TelefonoUsuario*/
	var pathTelefono = /[0-9]{9}/;
	if(!vacio(formulario.tlf.value)){
			alert("Formato de Teléfono incorrecto, tiene que ser de 9 digitos");
			formulario.tlf.style.borderColor = "red";
			formulario.tlf.style.borderColor = "dotted";
		return false;
	}else{
		formulario.tlf.style.borderColor = "blue";
		formulario.tlf.style.borderColor = "dotted";
	}
	if (!(pathTelefono.test(formulario.tlf.value))){
		alert("Formato de Teléfono incorrecto, tiene que ser de 9 digitos");
		formulario.tlf.style.borderColor = "red";
		formulario.tlf.style.borderColor = "dotted";
		return false;
	}else{
		formulario.tlf.style.borderColor = "blue";
		formulario.tlf.style.borderColor = "dotted";
	}
	 /*Direccion*/
	if(!vacio(formulario.direccion.value)){ 
		alert("El campo direccion de proveedor debe rellenarse");
		formulario.direccion.style.borderColor = "red";
		formulario.direccion.style.borderColor = "dotted";
		return false;
	}else{
		formulario.direccion.style.borderColor = "blue";
		formulario.direccion.style.borderColor = "dotted";
	}
	 /*ciudad*/
	if(!vacio(formulario.ciudad.value)){ 
		alert("El campo ciudad de proveedor debe rellenarse");
		formulario.ciudad.style.borderColor = "red";
		formulario.ciudad.style.borderColor = "dotted";
		return false;
	}else{
		formulario.ciudad.style.borderColor = "blue";
		formulario.ciudad.style.borderColor = "dotted";
	}

	/*CP*/
	var pathCP = /[0-9]{5}/
		if(!vacio(formulario.cp.value)){
			alert("El campo de codigo postal de proveedor debe rellenarse");
			formulario.cp.style.borderColor = "red";
			formulario.cp.style.borderColor = "dotted";
			return false;
			}else if (!(pathCP.test(formulario.cp.value))){
				alert("Formato del codigo postal es incorrecto, tiene que ser de 5 digitos");
				formulario.cp.style.borderColor = "red";
				formulario.cp.style.borderColor = "dotted";
			return false;
			}else{
				formulario.cp.style.borderColor = "blue";
				formulario.cp.style.borderColor = "dotted";
			}
	 /*provincia*/
	if(!vacio(formulario.provincia.value)){ 
		alert("El campo provincia de proveedor debe rellenarse");
		formulario.provincia.style.borderColor = "red";
		formulario.provincia.style.borderColor = "dotted";
		return false;
	}else{
		formulario.provincia.style.borderColor = "blue";
		formulario.provincia.style.borderColor = "dotted";
	}
	 /*	pais*/
	if(!vacio(formulario.pais.value)){ 
		alert("El campo pais de proveedor debe rellenarse");
		formulario.pais.style.borderColor = "red";
		formulario.pais.style.borderColor = "dotted";
		return false;
	}else{
		formulario.pais.style.borderColor = "blue";
		formulario.pais.style.borderColor = "dotted";
	}
	
	var ini1 = new RegExp("https://www.");
	var ini2 = new RegExp("http://www.");
	var pathUrl=/^[^@\s]+[^@\.\s]+(\.[^@\.\s]+)+(\.[^@\.\s]+)+$/;
	if(!vacio(formulario.web.value)){
			alert("El campo web está vacío");
			formulario.web.style.borderColor = "red";
			formulario.web.style.borderColor = "dotted";
			return false;
		}else{
			formulario.web.style.borderColor = "blue";
			formulario.web.style.borderColor = "dotted";
		}

	if ((ini1.test(formulario.web.value)) || (ini2.test(formulario.web.value))){
		if (!(pathUrl.test(formulario.web.value))){
			alert("Formato de web incorrecto, ej: https o http://www.algo.algo");
			formulario.web.style.borderColor = "red";
			formulario.web.style.borderColor = "dotted";
			return false;
		}else{			
			formulario.web.style.borderColor = "blue";
			formulario.web.style.borderColor = "dotted";	
		}
	}else{
		alert("Formato de web incorrecto, ej: https o http://www.algo.algo");
		formulario.web.style.borderColor = "red";
		formulario.web.style.borderColor = "dotted";
		return false;
	}
		
	alert("El formulario se ha editado correctamente");
	return true
}
