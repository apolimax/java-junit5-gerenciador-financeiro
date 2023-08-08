import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	Calculadora calc = new Calculadora();
	
	@BeforeEach
	public void setup() {
		System.out.println("--- Before Each --");
	}
	
	@AfterEach
	public void teardown() {
		System.out.println("--- After Each --");
	} 
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("--- Before All --");
	}
	
	@AfterAll
	public static void tearDownAll() {
		System.out.println("--- After All --");
	}

	@Test
	public void testSoma() {
		Assertions.assertTrue(calc.soma(2, 3) == 5);
		Assertions.assertEquals(5, calc.soma(2, 3));
	}
	
	@Test
	public void assertivas() {
		Assertions.assertEquals("Casa", "Casa");
		Assertions.assertNotEquals("Casa", "casa");
		Assertions.assertTrue("Casa".endsWith("sa"));
		Assertions.assertTrue("Casa".startsWith("Ca"));
		Assertions.assertFalse("Casa".startsWith("ca"));
		
		List<String> s1 = new ArrayList<>();
		List<String> s2 = new ArrayList<>();
		List<String> s3 = null;
		
		Assertions.assertEquals(s1, s2);
		Assertions.assertSame(s1, s1); // mesmo objeto/referência
		Assertions.assertNull(s3);
		Assertions.assertNotNull(s1);
	}
	
	@Test
	public void deveRetornarNumeroInteiro() {
		Calculadora calc = new Calculadora();
		Assertions.assertEquals(2, calc.dividir(4, 2));
	}
	
	@Test
	public void deveRetornarNumeroNegativo() {
		Calculadora calc = new Calculadora();
		Assertions.assertEquals(-2, calc.dividir(4, -2));
	}
	
	@Test
	public void deveRetornarNumeroDecimal() {
		Calculadora calc = new Calculadora();
		//Assertions.assertEquals(3.33, calc.dividir(10, 3));
		Assertions.assertEquals(3.33, calc.dividir(10, 3), 0.01);
	}
	
	@Test
	public void deveRetornarZeroComNumeradorZero() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(0, 2);
		Assertions.assertEquals(0, resultado);
	}
	
	@Test
	public void deveLancarExcecaoQuandoDividirPorZero() {
		ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {
			float resultado = 10 / 0;
		});
		Assertions.assertEquals("/ by zero", exception.getMessage());
	}
}
