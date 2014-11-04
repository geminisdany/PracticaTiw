function validarF(){
	var contador = 0;
	//Valido el campo nombre de usuario
	var nombreUsuario = document.getElementById("nombreC").value;
	var nom = nombreUsuario.toString();
	if (nom == null || nom == "") {
		alert("El campo Nombre de usuario debe rellenarse");
		document.getElementById("nombreC").style.borderColor="red";
		document.getElementById("nombreC").style.borderStyle="dotted";
	} else if (nom.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		document.getElementById("nombreC").style.borderColor="red";
		document.getElementById("nombreC").style.borderStyle="dotted";
		alert("El nombre del usuario no puede contener números ni estar en blanco");
	} else {
		document.getElementById("nombreC").style.borderColor="blue";
		document.getElementById("nombreC").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("nombre si");
	
	//Valido el campo alias de usuario
	var aliasUsuario = document.getElementById("aliasC").value;
	var alias = aliasUsuario.toString();
	if (alias == null || alias == "") {
		alert("El campo 'Alias de usuario' debe rellenarse");
		document.getElementById("aliasC").style.borderColor="red";
		document.getElementById("aliasC").style.borderStyle="dotted";
	} else if (alias.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüçABCDEFGHIJLMNÑOPQRSTUVWXYZ]/gi)){
		document.getElementById("aliasC").style.borderColor="red";
		document.getElementById("aliasC").style.borderStyle="dotted";
		alert("El alias del usuario no puede contener números ni estar en blanco");
	} else {
		document.getElementById("aliasC").style.borderColor="blue";
		document.getElementById("aliasC").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("alias si");
	
	//Valido el campo 'apellido 1'
	var apellido1Usuario = document.getElementById("apellido1C").value;
	var apellido1 = apellido1Usuario.toString();
	if (apellido1 == null || apellido1 == "") {
		alert("El campo 'Apellido 1' debe rellenarse");
		document.getElementById("apellido1C").style.borderColor="red";
		document.getElementById("apellido1C").style.borderStyle="dotted";
	} else if (alias.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüçABCDEFGHIJKLMNÑOPQRSTUVWXYZ]/gi)){
		document.getElementById("apellido1C").style.borderColor="red";
		document.getElementById("apellido1C").style.borderStyle="dotted";
		alert("El apellido 1 del usuario no puede contener números ni estar en blanco");
	} else {
		document.getElementById("apellido1C").style.borderColor="blue";
		document.getElementById("apellido1C").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("ape1 si");
	
	//Valido el campo 'apellido2'
	var apellido2Usuario = document.getElementById("apellido2C").value;
	var apellido2 = apellido2Usuario.toString();
	if (apellido2 == null || apellido2 == "") {
		alert("El campo 'Apellido 2' debe rellenarse");
		document.getElementById("apellido2C").style.borderColor="red";
		document.getElementById("apellido2C").style.borderStyle="dotted";
	} else if (alias.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç]/gi)){
		document.getElementById("apellido2C").style.borderColor="red";
		document.getElementById("apellido2C").style.borderStyle="dotted";
		alert("El apellido 2 del usuario no puede contener números ni estar en blanco");
	} else {
		document.getElementById("apellido2C").style.borderColor="blue";
		document.getElementById("apellido2C").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("ape2 si");
	
	//Valido el campo email del usuario
	var emailUsuario = document.getElementById("emailC").value;
	var mail = emailUsuario.toString();
	if (mail.match(/[^0123456789.@abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ-_]/g)|| mail == null || mail == ""){
		document.getElementById("emailC").style.borderColor="orange";
		document.getElementById("emailC").style.borderStyle="dotted";
		alert("El campo 'Email del usuario' no puede permanecer vacío, y puede estar formado tanto por letras como por números");
	} else {
		document.getElementById("emailC").style.borderColor="blue";
		document.getElementById("emailC").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("mail si");
	
	//Valido el campo 'telefono'
	var telfUsuario = document.getElementById("telefonoC").value;
	var telf = telfUsuario.toString();
	if (telf == null || telf == "") {
		alert("El campo 'Telefono de usuario' debe rellenarse");
		document.getElementById("telefonoC").style.borderColor="red";
		document.getElementById("telefonoC").style.borderStyle="dotted";
	} else if (telf.match(/[^0123456789]/gi)){
		document.getElementById("telefonoC").style.borderColor="red";
		document.getElementById("telefonoC").style.borderStyle="dotted";
		alert("El campo 'Telefono del usuario' no puede contener letras ni estar en blanco");
	} else {
		document.getElementById("telefonoC").style.borderColor="blue";
		document.getElementById("telefonoC").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("telefono si");
	
	//Valido el campo 'contrasena'
	var pwdUsuario = document.getElementById("pwdC").value;
	var pwd = pwdUsuario.toString();
	if (pwd.match(/[^0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ-_@$%&#€¡!¿?]/g)|| pwd == null || pwd == ""){
		document.getElementById("pwdC").style.borderColor="red";
		document.getElementById("pwdC").style.borderStyle="dotted";
		alert("El campo Contraseña del usuario no puede permanecer vacío, y puede estar formado tanto por letras como por números");
	} else {
		document.getElementById("pwdC").style.borderColor="blue";
		document.getElementById("pwdC").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("contrasenia si");
	
	//Valido el campo 'confirmar contrasena'
	var pwd2Usuario = document.getElementById("pwd2C").value;
	var pwd2 = pwd2Usuario.toString();
	if (pwd2.match(/[^0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ-_@$%&#€¡!¿?]/g)|| pwd == null || pwd == ""){
		document.getElementById("pwd2C").style.borderColor="red";
		document.getElementById("pwd2C").style.borderStyle="dotted";
		alert("El campo Contraseña del usuario no puede permanecer vacío, y puede estar formado tanto por letras como por números");
	} else {
		document.getElementById("pwd2C").style.borderColor="blue";
		document.getElementById("pwd2C").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("confirm si");
	
	//Valido el campo 'direccion'
	var dirUsuario = document.getElementById("direccionC").value;
	var direc = dirUsuario.toString();
	if (direc.match(/[^0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ-º/]/g)|| direc == null || direc == ""){
		document.getElementById("direccionC").style.borderColor="red";
		document.getElementById("direccionC").style.borderStyle="dotted";
		alert("El campo 'Direccion del usuario' no puede permanecer vacío, y puede estar formado tanto por letras como por números");
	} else {
		document.getElementById("direccionC").style.borderColor="blue";
		document.getElementById("direccionC").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("dir si");
	
	//Valido el campo 'codigo postal'
	var codpostUsuario = document.getElementById("codpostC").value;
	var cp = codpostUsuario.toString();
	if (cp.match(/[^0123456789]/g)|| cp == null || cp == ""){
		document.getElementById("codpostC").style.borderColor="red";
		document.getElementById("codpostC").style.borderStyle="dotted";
		alert("El campo 'Codigo postal' del usuario no puede permanecer vacío y sólo puede estar formado por números");
	} else {
		document.getElementById("codpostC").style.borderColor="blue";
		document.getElementById("codpostC").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("cop si");
	
	//Valido el campo 'ciudad, pais'
	var ciupa = document.getElementById("ciupC").value;
	var cp = ciupa.toString();
	if (cp == null || cp == "") {
		alert("El campo 'Ciudad, País' debe rellenarse");
		document.getElementById("ciupC").style.borderColor="red";
		document.getElementById("ciupC").style.borderStyle="dotted";
	} else if (cp.match(/[^abcdefghijklmnñopqrstuvwxyzáéíóúüç,]/gi)){
		document.getElementById("ciupC").style.borderColor="red";
		document.getElementById("ciupC").style.borderStyle="dotted";
		alert("El 'Ciudad, País' no puede contener números ni estar en blanco");
	} else {
		document.getElementById("ciupC").style.borderColor="blue";
		document.getElementById("ciupC").style.borderStyle="dotted";
		contador = contador + 1;
	}
	alert("cpais si");
	
	if(contador == 11){
		alert("Usuario registrado con éxito");
	}
	alert("contadoes si");
}