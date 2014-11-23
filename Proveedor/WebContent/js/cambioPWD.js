function pwdIguales(){ //Antes de validar el resto del formulario, es indispensable que tanto la contraseña nueva como la confirmación de contraseña nueva sean la misma
	var pwd1 = document.getElementById("pwdNueva").value;
	var pwd2 = document.getElementById("pwdNueva2").value;
	if(pwd1==pwd2){
		return validarF();
	} else {
		alert("Las contraseñas nuevas no son iguales. Por favor, introduzca la misma contraseña en ambos campos.");
		return false;
	}
}

function validarF(){ //En este caso, primero hay que validar que la contraseña actual es la que corresponde al usuario desde el cual se solicita la operación, y después realizar el cambio de contraseña en la base de datos de Talaverámica
	var contador = 0;
	//Valido que la contraseña actual sea la que está asociada realmente al usuario según la BBDD
	var pwd0 = document.getElementById("pwdAct").value;
	//var pwd0bbdd = contraseña almacenada en la BBDD para este usuario (--> hay que realizar una consulta, para lo cual habrá que almacenar el usuario cuando inicie sesión);
	if (pwd0 != pwd0bbdd) {
		alert("La contraseña introducida como actual no es correcta.");
	} else {
		//Se han superado las dos comprobaciones, por lo que se puede borrar la antigua contraseña y dar de alta la nueva en la BBDD
	}
}