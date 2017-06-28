package unitTest;

import business.Categoria;
import business.Leilao;
import business.LeilaoException;
import business.LeilaoFachada;
import business.Usuario;
import persistence.DaoException;

public class TesteFachadaSemJunit {

	public static void main(String[] args) throws LeilaoException, DaoException {
		testaCadastroUsuarioTrue();
		testaQuantidadeUsuariosCadastrados();
		testaCriarLeilao();
		
		
	}
	
	public static void testaCadastroUsuarioTrue() throws DaoException, LeilaoException{
		LeilaoFachada fachada = new LeilaoFachada();
			fachada.cadastrarUsuario("01.002.003/0001-89", "José", "jose@jose.com.br");
			
	}
	
	public static void testaQuantidadeUsuariosCadastrados() throws LeilaoException{
		
		try {
			LeilaoFachada fachada = new LeilaoFachada();
			
			fachada.cadastrarUsuario("01.002.003/0001-89", "José", "jose@jose.com.br");
			fachada.cadastrarUsuario("01.002.003/0001-89", "José", "jose@jose.com.br");
			fachada.cadastrarUsuario("02.002.003/0001-89", "José", "jose@jose.com.br");
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	public static void testaCriarLeilao() throws LeilaoException, DaoException{
		LeilaoFachada fachada = new LeilaoFachada();

					
			fachada.cadastrarUsuario("01.002.003/0001-89", "José", "jose@jose.com.br");
			fachada.cadastrarUsuario("02.002.003/0001-89", "João", "jose@jose.com.br");
			fachada.cadastrarUsuario("03.002.003/0001-89", "Jorge", "jose@jose.com.br");
			
					
			fachada.cadastrarProduto(22222, Categoria.INFORMATICA, "alguma coisa", "alguma coisa a mais");
			fachada.cadastrarProduto(22223, Categoria.INFORMATICA, "alguma coisa2", "alguma coisa a mais2");
			
			fachada.criarLeilao(55555, false, true, "01.002.003/0001-89" , "22/02/2012", "22/03/2012");
			
			fachada.criarLoteAdtibuirLeilao(55555, 333, 50.10f);
			
			fachada.adicionarProdutoLote(55555, 333, 22222);
			
			System.out.println(fachada.getListaAtivosTipo(true, true).size());
			
	}




}
