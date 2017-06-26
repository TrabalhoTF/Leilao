package unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import business.Usuario;

public class TesteUsuario { 
	Usuario usuario;
	
	@Before
	public  void testeSetUp() {
		usuario = new Usuario("999.999.999-99", "João", "joao@joao.com.br");
	}

	@Test
	public void testHashCodeCPF() {
		assertEquals((999 + 999)*(999 + 99) *37, usuario.hashCode());		
	}
	
	@Test
	public void testHashCodeCNPJ() {
		// XX.XXX.XXX/0001-XX
		usuario.setCnpj_cpf("99.999.999/9999-99");
		assertEquals(((99 + 999)*(999 + 9999) +99 ) *37, usuario.hashCode());		
	}

	@Test
	public void testEquals() {
		Usuario usuario2 = new Usuario("999.999.999-99", "João", "joao@joao.com.br");		
		assertEquals(true, usuario.equals(usuario2));
	}
	@Test
	public void testEqualsFalse() {
		Usuario usuario2 = new Usuario("999.999.999-98", "João", "joao@joao.com.br");		
		assertEquals(false, usuario.equals(usuario2));
	}

}
