package unitTest;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.time.LocalDate;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.junit.Test;

import business.ValidadorDados;

public class ValidadorTeste {

	
	@Test
	public void compararDatasIguais(){
		LocalDate dataA = LocalDate.of(2012, 10, 15);
		LocalDate dataB = LocalDate.of(2012, 10, 15);
		
		assertEquals(0, ValidadorDados.compararDatas(dataA, dataB));
	}
	
	@Test
	public void compararDatasDataInicialMenor(){
		
		LocalDate dataA = LocalDate.of(2012, 10, 14);
		LocalDate dataB = LocalDate.of(2012, 10, 15);
		
		assertEquals(1, ValidadorDados.compararDatas(dataA, dataB));
	}
	
	@Test
	public void compararDatasDataFinalMenor(){
		LocalDate dataA = LocalDate.of(2012, 10, 15);
		LocalDate dataB = LocalDate.of(2012, 10, 14);
		
		assertEquals(-1, ValidadorDados.compararDatas(dataA, dataB));
	}
	
		
	@Test
	public void testValidaCpfTrue(){
		assertEquals("123.456.789-11", ValidadorDados.validarCpfCnpj("123.456.789-11"));
	}
	
	@Test
	public void testValidaCpfFalse(){
		assertEquals(null, ValidadorDados.validarCpfCnpj("123.456.789-1a"));
	}
	
	@Test
	public void testValidaCnpjTrue(){
		assertEquals("12.345.678/9012-34", ValidadorDados.validarCpfCnpj("12.345.678/9012-34"));
	}
	
	@Test
	public void testValidaCnpjFalse(){
		assertEquals(null, ValidadorDados.validarCpfCnpj("12.345.678/a012-34"));
	}

}
