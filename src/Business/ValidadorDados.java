package Business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ValidadorDados { 
	public static boolean validaData(String data) {
		String dateFormat = "dd/MM/uuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter
				.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate date = LocalDate.parse(data, dateTimeFormatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		} 
	}

	public static boolean validarEmail(String email){
		return email.contains("@");		
	}
	
	public static boolean validarId(int id){
		boolean aux = false;
		if(id>0){
			if(id<100000){
				aux = true;
			}			
		}
		
		return aux;
	}
	
	public static boolean validarValor( float valor){
		boolean aux = false;
		if(valor > 0){
			aux = true;
		}
		return aux;
	}
	
	public static boolean validarData(String data){
		String dateFormat = "dd/MM/uuuu";

	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
	    .ofPattern(dateFormat)
	    .withResolverStyle(ResolverStyle.STRICT);
	    try {
	        LocalDate date = LocalDate.parse(data, dateTimeFormatter);
	        return true;
	    } catch (DateTimeParseException e) {
	       return false;
	    } 		
	}
	
	public static boolean validarCpfCnpj(String cpf){
		boolean aux = false;
		int cont = 0;
		
		if(cpf.replace(".","").replace("-","").length() == 11){
			for (int i = 0; i < cpf.replace(".","").replace("-","").length(); i++) {
			      if (Character.isDigit(cpf.replace(".","").replace("-","").charAt(i))) 
			         cont +=1;
			   }			
		}
		
		if(cpf.replace(".","").replace("-","").replace("/","").length() == 14){
			for (int i = 0; i < cpf.replace(".","").replace("-","").length(); i++) {
			      if (Character.isDigit(cpf.replace(".","").replace("-","").charAt(i))) 
			         cont +=1;
			   }			
		}
		if(cont == 11){
			aux = true;			
		}
		
		if(cont == 14){
			aux = true;			
		}
		
		
		return aux;
	}
}