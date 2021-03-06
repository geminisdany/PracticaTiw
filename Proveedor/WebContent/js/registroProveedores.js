function pwdIguales(){ //Antes de validar el resto del formulario, es indispensable que tanto la contraseña como la confirmación de contraseña sean la misma
	var pwd1 = document.getElementById("contras").value;
	var pwd2 = document.getElementById("pwd2P").value;
	if(pwd1==pwd2){
		return validarF();
	} else {
		alert("Las contraseñas no son iguales. Por favor, introduzca la misma contraseña en ambos campos.");
		return false;
	}
}

function validarF(){
	var contador = 0;
	var resultado = "";
	//Valido el campo nombre de usuario
	var nombreUsuario = document.getElementById("nombre").value;
	var nom = nombreUsuario.toString();
	if (nom == null || nom == "") {
		resultado = resultado.concat("El campo Nombre de usuario debe rellenarse" + '\n');
		document.getElementById("nombre").style.borderColor="red";
		document.getElementById("nombre").style.borderStyle="dotted";
	} else if (nom.match(/[^\s\da-zA-ZñáéíóúüçÁÉÍÓÚÇÜÑ&-]/gi)){
		document.getElementById("nombre").style.borderColor="red";
		document.getElementById("nombre").style.borderStyle="dotted";
		resultado = resultado.concat("El nombre del usuario no puede contener símbolos ni estar en blanco" + '\n');
	} else {
		document.getElementById("nombre").style.borderColor="blue";
		document.getElementById("nombre").style.borderStyle="dotted";
		contador = contador + 1;
	}

	
	//Valido el campo alias de usuario
	var cifProveedor = document.getElementById("cif").value;
	var cif = cifProveedor.toString();
	if (cif == null || cif == "") {
		resultado = resultado.concat("El campo 'Cif del proveedor' debe rellenarse" + '\n');
		document.getElementById("cif").style.borderColor="red";
		document.getElementById("cif").style.borderStyle="dotted";
	} else if (cif.match(/[^a-zñÑA-Z\d-]/gi)){
		resultado = resultado.concat("El CIF del proveedor no puede contener símbolos, excepto el guión, ni estar en blanco" + '\n');
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
	if (mail.match(/[^\w\d.@-_ñÑ&#/]/g)|| mail == null || mail == ""){
		document.getElementById("email").style.borderColor="orange";
		document.getElementById("email").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'Email del proveedor' no puede permanecer vacío, y puede estar formado tanto por letras como por números" + '\n');
	} else {
		document.getElementById("email").style.borderColor="blue";
		document.getElementById("email").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	
	//Valido el campo 'telefono'
	var telfUsuario = document.getElementById("tlf").value;
	var telf = telfUsuario.toString();
	if (telf == null || telf == "") {
		resultado = resultado.concat("El campo 'Telefono de proveedor' debe rellenarse" + '\n');
		document.getElementById("tlf").style.borderColor="red";
		document.getElementById("tlf").style.borderStyle="dotted";
	} else if (telf.match(/[\D]/gi)){
		document.getElementById("tlf").style.borderColor="red";
		document.getElementById("tlf").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'Telefono del proveedor' no puede contener letras ni estar en blanco" + '\n');
	} else {
		document.getElementById("tlf").style.borderColor="blue";
		document.getElementById("tlf").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'contrasena'
	var pwdUsuario = document.getElementById("contras").value;
	var pwd = pwdUsuario.toString();
	if (pwd.match(/[^\w\d-.@$%&#€/¡!¿?ñÑáéíóúüçÁÉÍÓÚÇÜ]/g)|| pwd == null || pwd == ""){
		document.getElementById("contras").style.borderColor="red";
		document.getElementById("contras").style.borderStyle="dotted";
		resultado = resultado.concat("El campo Contraseña del proveedor no puede permanecer vacío, y puede estar formado tanto por letras como por números" + '\n');
	} else {
		document.getElementById("contras").style.borderColor="blue";
		document.getElementById("contras").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'confirmar contrasena'
	var pwd2Usuario = document.getElementById("pwd2P").value;
	var pwd2 = pwd2Usuario.toString();
	if (pwd2.match(/[^\w\d-.@$%&#€/¡!¿?ñÑáéíóúüçÁÉÍÓÚÇÜ]/g)|| pwd == null || pwd == ""){
		document.getElementById("pwd2P").style.borderColor="red";
		document.getElementById("pwd2P").style.borderStyle="dotted";
		resultado = resultado.concat("El campo Contraseña del proveedor no puede permanecer vacío, y puede estar formado tanto por letras como por números" + '\n');
	} else {
		document.getElementById("pwd2P").style.borderColor="blue";
		document.getElementById("pwd2P").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'direccion'
	var dirUsuario = document.getElementById("direccion").value;
	var direc = dirUsuario.toString();
	if (direc.match(/[^\s\da-zA-Z-º/ñÑáéíóúüÁÉÍÓÚÇÜç]/g)|| direc == null || direc == ""){
		document.getElementById("direccion").style.borderColor="red";
		document.getElementById("direccion").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'Direccion del proveedor' no puede permanecer vacío, y puede estar formado tanto por letras como por números" + '\n');
	} else {
		document.getElementById("direccion").style.borderColor="blue";
		document.getElementById("direccion").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'ciudad'
	var ciupa = document.getElementById("ciudad").value;
	var cip = ciupa.toString();
	if (cip == null || cip == "") {
		resultado = resultado.concat("El campo 'Localidad' debe rellenarse" + '\n');
		document.getElementById("ciudad").style.borderColor="red";
		document.getElementById("ciudad").style.borderStyle="dotted";
	} else if (cip.match(/[^\sa-zA-Z-ñÑáéíóúüÁÉÍÓÚÇÜç]/gi)){
		document.getElementById("ciudad").style.borderColor="red";
		document.getElementById("ciudad").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'Localidad' no puede contener números ni símbolos ni estar en blanco" + '\n');
	} else {
		document.getElementById("ciudad").style.borderColor="blue";
		document.getElementById("ciudad").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'codigo postal'
	var codpostUsuario = document.getElementById("cp").value;
	var cp = codpostUsuario.toString();
	if (cp.match(/[\D]/g)|| cp == null || cp == ""){
		document.getElementById("cp").style.borderColor="red";
		document.getElementById("cp").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'Codigo postal' del proveedor no puede permanecer vacío y sólo puede estar formado por números" + '\n');
	} else {
		document.getElementById("cp").style.borderColor="blue";
		document.getElementById("cp").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'provincia'
	var ciupa = document.getElementById("provincia").value;
	var cip = ciupa.toString();
	if (cip == null || cip == "") {
		resultado = resultado.concat("El campo 'Provincia' debe rellenarse" + '\n');
		document.getElementById("provincia").style.borderColor="red";
		document.getElementById("provincia").style.borderStyle="dotted";
	} else if (cip.match(/[^\sa-zA-Z-ñÑáéíóúüÁÉÍÓÚÇÜç]/gi)){
		document.getElementById("provincia").style.borderColor="red";
		document.getElementById("provincia").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'Provincia' no puede contener números ni símbolos ni estar en blanco" + '\n');
	} else {
		document.getElementById("provincia").style.borderColor="blue";
		document.getElementById("provincia").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'pais'
	var ciupa = document.getElementById("pais").value;
	var cip = ciupa.toString();
	if (cip == null || cip == "") {
		resultado = resultado.concat("El campo 'País' debe rellenarse" + '\n');
		document.getElementById("pais").style.borderColor="red";
		document.getElementById("pais").style.borderStyle="dotted";
	} else if (cip.match(/[^\sa-zA-Z-ñÑáéíóúüÁÉÍÓÚÇÜç]/gi)){
		document.getElementById("pais").style.borderColor="red";
		document.getElementById("pais").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'País' no puede contener números ni símbolos ni estar en blanco" + '\n');
	} else {
		document.getElementById("pais").style.borderColor="blue";
		document.getElementById("pais").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	//Valido el campo 'web'
	var webUsuario = document.getElementById("web").value;
	var web = webUsuario.toString();
	if (web.match(/[^\w\d.:=?&-/_áéíóúüçñÑÁÉÍÓÚÇÜ]/g)|| web == null || web == ""){
		document.getElementById("web").style.borderColor="red";
		document.getElementById("web").style.borderStyle="dotted";
		resultado = resultado.concat("El campo 'Web' del proveedor no puede permanecer vacío" + '\n');
	} else {
		document.getElementById("web").style.borderColor="blue";
		document.getElementById("web").style.borderStyle="dotted";
		contador = contador + 1;
	}
	
	if(contador == 12){
		alert("Usuario registrado con éxito");
	} else{
		alert(resultado);
		return false;
	}
}