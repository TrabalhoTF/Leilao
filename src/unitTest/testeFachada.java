package unitTest;

import static org.junit.Assert.*;

import org.junit.*;

import business.*;

public class testeFachada {
	private LeilaoFachada fachada;
	
	@Before
	public void setUp() throws LeilaoException{
		fachada = new LeilaoFachada();
	}	

	@Test
	public void testCadastrarUsuarioUsuario() throws LeilaoException {		
		assertTrue(fachada.cadastrarUsuario("001.002.003-45", "José", "jose@jose.com"));
	}
	
	@Test(expected = LeilaoException.class) 
	public void testCadastrarUsuarioUsuarioFalse() throws LeilaoException   {		
		
			
				assertTrue(fachada.cadastrarUsuario("001*002.00345", "José", "jose@jose.com"));
					
	}

	
}
