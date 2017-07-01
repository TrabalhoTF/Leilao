package unitTest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import business.ValidadorDados;

public class ValidadorTeste {


	@Test
	public void compararDatasIguais(){
		assertEquals(0,ValidadorDados.compararDatas("10/10/2012", "10/10/2012"));
		LocalDate dataA = LocalDate.of(2012, 10, 15);
		LocalDate dataB = LocalDate.of(2012, 10, 15);

		assertEquals(0, ValidadorDados.compararDatas(dataA, dataB));
	}

	public void compararDatasDataInicialMenor(){
		assertEquals(1,ValidadorDados.compararDatas("09/10/2012", "10/10/2012"));
		LocalDate dataA = LocalDate.of(2012, 10, 14);
		LocalDate dataB = LocalDate.of(2012, 10, 15);

		assertEquals(1, ValidadorDados.compararDatas(dataA, dataB));
	}


	@Test
	public void compararDatasDataFinalMenor(){
		assertEquals(-1,ValidadorDados.compararDatas("10/10/2012", "09/10/2012"));
	}

	@Test
	public void compararDatasDataInicialInvalida(){
		assertEquals(999,ValidadorDados.compararDatas("10/102012", "09/10/2012"));
	}

	@Test
	public void compararDatasDataFinalInvalida(){
		assertEquals(999,ValidadorDados.compararDatas("10/10/2012", "30/02/2012"));
	}


	@Test
	public void testValidaCpfTrue(){
		assertEquals(true, ValidadorDados.validarCpfCnpj("123.456.789-11"));
		assertEquals("123.456.789-11", ValidadorDados.validarCpfCnpj("123.456.789-11"));
	}

	@Test
	public void testValidaCpfFalse(){
		assertEquals(false, ValidadorDados.validarCpfCnpj("123.456.789-1a"));
		assertEquals(null, ValidadorDados.validarCpfCnpj("123.456.789-1a"));
	}

	@Test
	public void testValidaCnpjTrue(){
		assertEquals(true, ValidadorDados.validarCpfCnpj("12.345.678/9012-34"));
		assertEquals("12.345.678/9012-34", ValidadorDados.validarCpfCnpj("12.345.678/9012-34"));
	}

	@Test
	public void testValidaCnpjFalse(){
		assertEquals(false, ValidadorDados.validarCpfCnpj("12.345.678/a012-34"));
		assertEquals(null, ValidadorDados.validarCpfCnpj("12.345.678/a012-34"));
	}

}
