package unitTest;

import static org.junit.Assert.*;

import org.junit.*;

import business.Usuario;

public class TesteUsuario { 
	Usuario usuario;
	
	@Before
	public  void testeSetUp() {
		usuario = new Usuario("999.999.999-99", "João", "joao@joao.com.br");
	}

	@Test
	public void testHashCode() {
		assertEquals((1+2+3)*37, usuario.hashCode());		
	}

	@Test
	public void testEquals2() {
		fail("Not yet implemented");
	}

}
