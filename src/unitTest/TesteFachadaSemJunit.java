package unitTest;

import business.LeilaoException;
import business.LeilaoFachada;

public class TesteFachadaSemJunit {

	public static void main(String[] args) throws LeilaoException {
		LeilaoFachada fachada = new LeilaoFachada();
		
		try {
			fachada.cadastrarUsuario("01*002.003/0001-89", "José", "jose@jose.com.br");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
