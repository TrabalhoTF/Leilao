package business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ValidadorDados { 
	public static String validarEmail(String email){
		String aux = null;

		if(email.contains("@")){
			aux = email;			
		}

		return aux;		
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

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.STRICT);

		try {
			LocalDate date = LocalDate.parse(data, dateTimeFormatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		} 		
	}


	public static String validarCpfCnpj(String cpf){
		String aux = null;
		int cont = 0;

		// 000.000.000-00
		if(cpf.replace(".","").replace("-","").length() == 11){
			if(cpf.substring(3,4).equals(".") && cpf.substring(7,8).equals(".") && cpf.substring(11,12).equals("-") ){
				for (int i = 0; i < cpf.replace(".","").replace("-","").length(); i++) {
					if (Character.isDigit(cpf.replace(".","").replace("-","").charAt(i))) 
						cont +=1;
				}			
			}			
		}		

		if(cpf.replace(".","").replace("-","").replace("/","").length() == 14){
			if(cpf.substring(2,3).equals(".") && cpf.substring(6,7).equals(".") && cpf.substring(10,11).equals("/")&& cpf.substring(15,16).equals("-")){
				if(cpf.replace(".","").replace("-","").replace("/","").length() == 14){			
					if(cpf.substring(2,3).equals(".") && cpf.substring(6,7).equals(".") && cpf.substring(10,11).equals("/")&& cpf.substring(15,16).equals("-")){				
						for (int i = 0; i < cpf.replace(".","").replace("-","").length(); i++) {
							if (Character.isDigit(cpf.replace(".","").replace("-","").charAt(i))) 
								cont +=1;
						}			
					}


					if(cont == 11){
						aux = cpf;			
					}

					if(cont == 14){
						aux = cpf;
					}
				}
			}
		}
		return aux;
	}

	// DD / MM / AAAA
	// 01 2 34 5 6789

	// Compara duas datas,
	//se data A < que data B retorna 1
	//se data B < que data A retorna -1
	//se data A = data b retorna 0




	//se as uma das datas for invalida retorna 999
	public static int compararDatas(String dataA, String dataB){
		if(validarData(dataA) && validarData(dataB)){
			int valorA= Integer.parseInt(dataA.substring(0,2))*9+
					Integer.parseInt(dataA.substring(3,5))*8+
					Integer.parseInt(dataA.substring(6,10))*7;

			int valorB= Integer.parseInt(dataB.substring(0,2))*9+
					Integer.parseInt(dataB.substring(3,5))*8+
					Integer.parseInt(dataB.substring(6,10))*7;

			if(valorA < valorB){
				return 1;
			} else if (valorA > valorB){
				return -1;				
			} else{
			
			}
		}
		return 0;
	}
	public static int compararDatas(LocalDate dataA ,LocalDate dataB){
		if(dataA.isBefore(dataB)){
			return 1;			
		} else if(dataA.isAfter(dataB)){
			return -1;			
		} else {
			return 0;
		}		
	}
}
