package microservice.equationSolver;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import microservice.equationSolver.Utils.EquationUtils;

@SpringBootTest
class EquationUtilsTests {
	
	/***************************************
	 * EquationUtils.splitEquation() tests
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 ***************************************/
	
	@Test
	@DisplayName("Test if string splitting on '=' works")
	void testSplitEquation() {
		String equation = "x+42=-4y+1-5+46+20";
		String[] splitEq = {"x+42", "-4y+1-5+46+20"};
		assertArrayEquals(splitEq, EquationUtils.splitEquation(equation));
	}
	
	@Test
	@DisplayName("'=' at index 0, equation split should return null")
	void testSplitEquationEqualIndexZero() {
		String incorrectEq = "=-4y+1-5+46+20";
		assertNull(EquationUtils.splitEquation(incorrectEq));
	}
	
	@Test
	@DisplayName("'=' at last index of equation, equation split should return null")
	void testSplitEquationEqualIndexLast() {
		String incorrectEq = "x+42=";
		assertNull(EquationUtils.splitEquation(incorrectEq));
	}
	
	@Test
	@DisplayName("Test that empty string returns null for equation split")
	void testSplitEquationEmptyString() {
		String emptyEq = "";
		assertNull(EquationUtils.splitEquation(emptyEq));
	}
	
}
