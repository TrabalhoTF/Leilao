package UnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import business.ValidadorDados;

public class ValidadorTeste {

	@Test
	public void testValidaDataTrue() {
		assertEquals(true, ValidadorDados.validaData("21/12/2015"));
	}
	
	@Test
	public void testValidaDataFalseMes() {
		assertEquals(false, ValidadorDados.validaData("21/13/2015"));
	}
	
	@Test
	public void testValidaDataFalseDia() { 
		assertEquals(false, ValidadorDados.validaData("29/02/2015"));
	}
	
	@Test
	public void testValidaDataFalseAno() {
		assertEquals(false, ValidadorDados.validaData("28/02/00000"));
	}
	
	@Test
	public void testValidaCpfTrue(){
		assertEquals(true, ValidadorDados.validarCpfCnpj("123.456.789-11"));
	}
	
	@Test
	public void testValidaCpfFalse(){
		assertEquals(false, ValidadorDados.validarCpfCnpj("123.456.789-1a"));
	}
	
	@Test
	public void testValidaCnpjTrue(){
		assertEquals(true, ValidadorDados.validarCpfCnpj("12.345.678/9012-34"));
	}
	
	@Test
	public void testValidaCnpjFalse(){
		assertEquals(false, ValidadorDados.validarCpfCnpj("12.345.678/a012-34"));
	}

}
