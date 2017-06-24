package unitTest;

import static org.junit.Assert.*;

import org.junit.*;

import business.Categoria;
import business.Produto;

public class TestProduto {
	private Produto produto;
	private Categoria categoria;
	
	@Before
	public void setUp(){
		String descBreve = "Prodduto de boa qualidade.";
		String descCompleta = "Produto de boa qualidade fabricado na China e importado do Paraguai";
		produto = new Produto(12345, categoria.INFORMATICA, descBreve, descCompleta);		
	}

	@Test
	public void testHashCode() {
		int expected= produto.getId_produto() * 37;
		assertEquals(expected, produto.hashCode());
	}

	@Test
	public void testGetCateg() {
		assertEquals(produto.getCateg().name() ,"INFORMATICA");
	}

	@Test
	public void testSetCateg() {		
		produto.setCateg(categoria.AUTOMOVEL);		
		assertEquals(produto.getCateg().name() ,"AUTOMOVEL");
	}

	
	@Test
	public void testEqualsTrue() {
		String descBreve = "Prodduto de boa qualidade.";
		String descCompleta = "Produto de boa qualidade fabricado na China e importado do Paraguai";
		Produto produtoAux = new Produto(12345, categoria.INFORMATICA, descBreve, descCompleta);		
		assertEquals(true, produto.equals(produtoAux));
	}
	
	@Test 
	public void testEqualsFalse() {
		String descBreve = "Prodduto de boa qualidade.";
		String descCompleta = "Produto de boa qualidade fabricado na China e importado do Paraguai";
		Produto produtoAux = new Produto(12346, categoria.INFORMATICA, descBreve, descCompleta);		
		assertEquals(false, produto.equals(produtoAux));
	}

	

}
