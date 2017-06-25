package unitTest;

import business.LeilaoException;
import business.LeilaoFachada;

public class TesteFachadaSemJunit {

	public static void main(String[] args) throws LeilaoException {
		testaCadastroUsuarioTrue();
		testaCadastroUsuarioFalse();
		testaQuantidadeUsuariosCadastrados();
		
		
	}
	
	public static void testaCadastroUsuarioTrue(){
		LeilaoFachada fachada = new LeilaoFachada();
		System.out.println("testaCadastroUsuarioTrue()");

		try {
			fachada.cadastrarUsuario("01.002.003/0001-89", "José", "jose@jose.com.br");
			System.out.println("Cadastro Usuario OK");
		} catch (Exception e) {
			System.out.println("Cadastro Usuario não OK");
			System.out.println(e);
		}
		System.out.println(" ");

	}
	
	public static void testaCadastroUsuarioFalse(){
		LeilaoFachada fachada = new LeilaoFachada();
		System.out.println("testaCadastroUsuarioFalse()");
		try {
			fachada.cadastrarUsuario("01*002.003/0001-89", "José", "jose@jose.com.br");
			System.out.println("Cadastro Usuario OK");
		} catch (Exception e) {
			System.out.println("Cadastro Usuario não OK");
			System.out.println(e);
		}
		System.out.println(" ");
	}
	
	public static void testaQuantidadeUsuariosCadastrados() throws LeilaoException{
		LeilaoFachada fachada = new LeilaoFachada();
		fachada.cadastrarUsuario("01.002.003/0001-89", "José", "jose@jose.com.br");
		fachada.cadastrarUsuario("01.002.003/0001-89", "José", "jose@jose.com.br");

		
		System.out.println(fachada.getListaUsuario().size());
		
	}


}
