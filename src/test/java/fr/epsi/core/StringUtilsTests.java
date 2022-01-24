package fr.epsi.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTests {

	@Test
	void test() {

	}

	@ParameterizedTest(name = "{0} est un palindrome")
	@ValueSource(strings = { "ete", "a but tuba" })

	void isPalindrome(String sentense) {
		assertTrue(StringUtils.isPalindrome(sentense));
	}

	@ParameterizedTest(name = "{0} n est pas un palindrome")
	@ValueSource(strings = { "ile", "je code" })

	void isNotPalindrome(String sentense) {
		assertFalse(StringUtils.isPalindrome(sentense));

	}

	@ParameterizedTest(name = "{0} encodee :{1}  ")
	@CsvFileSource(resources = "/cesar.csv", numLinesToSkip = 1)

	void cesarEncode(String sentence, String request, int step) {
		assertEquals(request, StringUtils.cesarEncode(sentence, step));

	}

	@ParameterizedTest(name = "{1} decodee donne :{0}  ")
	@CsvFileSource(resources = "/cesar.csv", numLinesToSkip = 1)

	void cesarDecode(String sentence, String request, int step) {
		assertEquals(sentence, StringUtils.cesarDecode(request, step));
	}
}
