package unitTest;

import business.LeilaoException;
import business.LeilaoFachada;
import persistence.DaoException;

public class TesteFachadaSemJunit {

	public static void main(String[] args) throws LeilaoException, DaoException {
		testaCadastroUsuarioTrue();
		testaCadastroUsuarioFalse();
		testaQuantidadeUsuariosCadastrados();
		
		
	}
	
	public static void testaCadastroUsuarioTrue() throws DaoException{
		LeilaoFachada fachada = new LeilaoFachada();
		System.out.println("testaCadastroUsuarioTrue()");

		try {
			fachada.cadastrarUsuario("01.002.003/0001-89", "Jos�", "jose@jose.com.br");
			System.out.println("Cadastro Usuario OK");
		} catch (Exception e) {
			System.out.println("Cadastro Usuario n�o OK");
			System.out.println(e);
		}
		System.out.println(" ");

	}
	
	public static void testaCadastroUsuarioFalse() throws DaoException{
		LeilaoFachada fachada = new LeilaoFachada();
		System.out.println("testaCadastroUsuarioFalse()");
		try {
			fachada.cadastrarUsuario("01*002.003/0001-89", "Jos�", "jose@jose.com.br");
			System.out.println("Cadastro Usuario OK");
			System.out.println(" ");
		} catch (Exception e) {
			System.out.println("Cadastro Usuario n�o OK");
			System.out.println(e);
		}
		System.out.println(" ");
	}
	
	public static void testaQuantidadeUsuariosCadastrados() throws LeilaoException{
		
		try {
			LeilaoFachada fachada = new LeilaoFachada();
			fachada.cadastrarUsuario("01.002.003/0001-89", "Jos�", "jose@jose.com.br");
			fachada.cadastrarUsuario("01.002.003/0001-89", "Jos�", "jose@jose.com.br");
			fachada.cadastrarUsuario("02.002.003/0001-89", "Jos�", "jose@jose.com.br");
			System.out.println(fachada.getListaUsuario().size());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}


}
