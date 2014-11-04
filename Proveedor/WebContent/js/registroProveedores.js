function pwdIguales(){ //Antes de validar el resto del formulario, es indispensable que tanto la contraseña como la confirmación de contraseña sean la misma
	var pwd1 = document.getElementById("contras").value;
	var pwd2 = document.getElementById("pwd2P").value;
	if(pwd1==pwd2){
		return validarF();
	} else {
		alert("Las contraseñas no son iguales. Por favor, introduzca la misma contraseña en ambos campos.");
	}
}

function validarF(){
	var contador = 0;
	//Valido el campo nombre de usuario
	var nombreUsuario = document.getElementById("nombre").value;
	var nom = nombreUsuario.toString();
	if (nom == null || nom == "") {
		alert("El campo Nombre de usuario debe rellenarse");
		document.getElementById("nombre").style.borderColor="red";
		document.getElementById("nombre").style.borderStyle="dotted";
	} else if (nom.match(/[^a-zñáéíóúüçÁÉÍÓÚÇÜ]/gi)){
		document.getElementById("nombre").style.borderColor="red";
		document.getElementById("nombre").style.borderStyle="dotted";
		alert("El nombre del usuario no puede contener números ni estar en blanco");
	} else {
		document.getElementById("nombre").style.borderColor="blue";
		document.getElementById("nombre").style.borderStyle="dotted";
		contador = contador + 1;
	}

	
	//Valido el campo alias de usuario
	var cifProveedor = document.getElementById("cif").value;
	var cif = cifProveedor.toString();
	if (cif == null || cif == "") {
		alert("El campo 'Cif del proveedor' debe rellenarse");
		document.getElementById("cif").style.borderColor="red";
		document.getElementById("cif").style.borderStyle="dotted";
	} else if (cif.match(/[^a-zñÑáéíóúüçÁÉÍÓÚÇÜA-Z\d-]/gi)){
		alert("El CIF del proveedor no puede contener símbolos, excepto el guión, ni estar en blanco");
		document.getElementById("cif").style.borderColor="red";
		document.getElementById("cif").style.borderStyle="dotted";		
	} else {
		document.getElementById("cif").style.borderColor="blue";
		document.getElementById("cif").style.borderStyle="dotted";
		contador = contador + 1;
	}

	
	//Valido el campo email del usuario
	var emailUsuario = document.getElementById("email").value;
	var mail = emailUsuario.toString();
	if (mail.match(/[^\w.@-ñÑáéíóúüçÁÉÍÓÚÇÜ]/g)|| mail == null || mail == ""){
		document.getElementById("email").style.borderColor="orange";
		document.getElementById("email").style.borderStyle="dotted";
		alert("El campo 'Email del proveedor' no puede permanecer vacío, y puede estar formado tanto por letras como por números");
	} else {
		document.getElementById("email").style.borderColor="blue";
		document.getElementById("email").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	
	//Valido el campo 'telefono'
	var telfUsuario = document.getElementById("tlf").value;
	var telf = telfUsuario.toString();
	if (telf == null || telf == "") {
		alert("El campo 'Telefono de proveedor' debe rellenarse");
		document.getElementById("tlf").style.borderColor="red";
		document.getElementById("tlf").style.borderStyle="dotted";
	} else if (telf.match(/[\D]/gi)){
		document.getElementById("tlf").style.borderColor="red";
		document.getElementById("tlf").style.borderStyle="dotted";
		alert("El campo 'Telefono del proveedor' no puede contener letras ni estar en blanco");
	} else {
		document.getElementById("tlf").style.borderColor="blue";
		document.getElementById("tlf").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'contrasena'
	var pwdUsuario = document.getElementById("contras").value;
	var pwd = pwdUsuario.toString();
	if (pwd.match(/[^\w-.@$%&#€¡!¿?ñÑáéíóúüçÁÉÍÓÚÇÜ]/g)|| pwd == null || pwd == ""){
		document.getElementById("contras").style.borderColor="red";
		document.getElementById("contras").style.borderStyle="dotted";
		alert("El campo Contraseña del proveedor no puede permanecer vacío, y puede estar formado tanto por letras como por números");
	} else {
		document.getElementById("contras").style.borderColor="blue";
		document.getElementById("contras").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'confirmar contrasena'
	var pwd2Usuario = document.getElementById("pwd2P").value;
	var pwd2 = pwd2Usuario.toString();
	if (pwd2.match(/[^\w-.@$%&#€¡!¿?ñÑáéíóúüçÁÉÍÓÚÇÜ]/g)|| pwd == null || pwd == ""){
		document.getElementById("pwd2P").style.borderColor="red";
		document.getElementById("pwd2P").style.borderStyle="dotted";
		alert("El campo Contraseña del proveedor no puede permanecer vacío, y puede estar formado tanto por letras como por números");
	} else {
		document.getElementById("pwd2P").style.borderColor="blue";
		document.getElementById("pwd2P").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'direccion'
	var dirUsuario = document.getElementById("direccion").value;
	var direc = dirUsuario.toString();
	if (direc.match(/[^\da-zA-Z-ºñÑáéíóúüÁÉÍÓÚÇÜç]/g)|| direc == null || direc == ""){
		document.getElementById("direccion").style.borderColor="red";
		document.getElementById("direccion").style.borderStyle="dotted";
		alert("El campo 'Direccion del proveedor' no puede permanecer vacío, y puede estar formado tanto por letras como por números");
	} else {
		document.getElementById("direccion").style.borderColor="blue";
		document.getElementById("direccion").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'codigo postal'
	var codpostUsuario = document.getElementById("codpostP").value;
	var cp = codpostUsuario.toString();
	if (cp.match(/[\D]/g)|| cp == null || cp == ""){
		document.getElementById("codpostP").style.borderColor="red";
		document.getElementById("codpostP").style.borderStyle="dotted";
		alert("El campo 'Codigo postal' del proveedor no puede permanecer vacío y sólo puede estar formado por números");
	} else {
		document.getElementById("codpostP").style.borderColor="blue";
		document.getElementById("codpostP").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'ciudad, pais'
	var ciupa = document.getElementById("ciupP").value;
	var cip = ciupa.toString();
	if (cip == null || cip == "") {
		alert("El campo 'Ciudad, País' debe rellenarse");
		document.getElementById("ciupP").style.borderColor="red";
		document.getElementById("ciupP").style.borderStyle="dotted";
	} else if (cip.match(/[^a-záéíóúüçñÑÁÉÍÓÚÇÜ,]/gi)){
		document.getElementById("ciupP").style.borderColor="red";
		document.getElementById("ciupP").style.borderStyle="dotted";
		alert("El campo 'Ciudad, País' no puede contener números ni estar en blanco");
	} else {
		document.getElementById("ciupP").style.borderColor="blue";
		document.getElementById("ciupP").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'web'
	var webUsuario = document.getElementById("web").value;
	var web = webUsuario.toString();
	if (web.match(/[^\w.:=?&-_áéíóúüçñÑÁÉÍÓÚÇÜ]/g)|| web == null || web == ""){
		document.getElementById("web").style.borderColor="red";
		document.getElementById("web").style.borderStyle="dotted";
		alert("El campo 'Web' del proveedor no puede permanecer vacío");
	} else {
		document.getElementById("web").style.borderColor="blue";
		document.getElementById("web").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	if(contador == 10){
		alert("Usuario registrado con éxito");
	} 
}