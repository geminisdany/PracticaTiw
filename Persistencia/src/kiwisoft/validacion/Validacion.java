package kiwisoft.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
	
	//Constructor para el init del servlet

	public Validacion () {
		super();
	}
	
	//Metodos de validacion
	
	public boolean sinNumero(String dato) { 
		if (dato == " " || dato == null){		
			return false;
		}else if (!dato.trim().matches("^[A-Za-z+][\\s[A-Za-z]+]*$")) {
			return false;
		}else{
			return true;
		}
	}
	
	public boolean sinRestriccion(String dato) {
		if (dato == " " || dato == null){		
			return false;
		}else{
			return true;
		}
	
	}
	
	
	public boolean soloNumero(String dato, int size) {
		if (dato == " " || dato == null){		
			return false;
		}else{
			Pattern datoPattern = Pattern.compile("(\\d{1,"+size+"})");
			Matcher aux = datoPattern.matcher(dato);
			if(!aux.matches()){
				return false;
			}else{
				return true;
			}
		}
	}	
	public boolean soloEmail(String dato) {
		if (dato == " " || dato == null){		
			return false;
		}else if(!dato.trim().matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")){
			return false;			  
		}else{
			return true;
		}
	}
	public boolean soloUrl(String dato) {
		if (dato == " " || dato == null){		
			return false;
		}else if(!dato.trim().matches("<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>")){
			return false;		  
		}else{
			return true;
		}
	}
	public boolean cif(String dato){
		if (dato == " " || dato == null){
			return false; 
		} else if (!dato.trim().matches("^[A-Za-z0-9+]*$")) {
			return false;
		}else{
			return true;
		}
	}
	public boolean precio (String dato){
		if (dato == " " || dato == null){		
			return false;
		}else{
			Pattern datoPattern = Pattern.compile("^[-+]?\\d+(\\.{0,1}(\\d+?))?$");
			Matcher aux = datoPattern.matcher(dato);
			if (aux.matches()){
				return true;
			} else {
				return false;
			}
		}
	}
	public boolean stringIguales (String dato1, String dato2){
		if (dato1.equals(dato2)){
			return true;
		} else {
			return false;
		}
	}
	public boolean menoroIgual (Double dato1, Double dato2){
		if (dato1 <= dato2){
			return true;
		} else {
			return false;
		}
	}
	public boolean mayor (int dato1, int dato2){
		if (dato1 > dato2){
			return true;
		} else {
			return false;
		}
	}
}
