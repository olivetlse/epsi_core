package fr.epsi.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class MathUtilsTests {

	@ParameterizedTest(name = "La factorielle de {0} est {1}")
	@CsvFileSource(resources = "/Factorial.csv", numLinesToSkip = 1)
	void factorial(int number, double expectedResult) {
		assertEquals(MathUtils.factorial(number)).isEqual(expectedResult);
		//assertEquals(expectedResult, MathUtils.factorial(number), 0);

	}

	@ParameterizedTest(name = "{0} est un nombre premier")
	@ValueSource(ints = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 })
	void isPrimeNumber(int n) {
		assertTrue(MathUtils.isPrimeNumber(n));
	}

	@ParameterizedTest(name = "{0} n est pas un nombre premier")
	@ValueSource(ints = { 1, 4, 6, 8, 27 })
	void isNotPrimeNumber(int n) {
		assertFalse(MathUtils.isPrimeNumber(n));
	}
}
