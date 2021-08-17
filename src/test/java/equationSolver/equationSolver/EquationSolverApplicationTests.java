package equationSolver.equationSolver;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EquationSolverApplicationTests {
	
	@Test
	@DisplayName("Test if string splitting on '=' works")
	void testEqualSplit() {
		String equation = "x+42=-4y+1-5+46+20";
		String[] splitEq = {"x+42", "-4y+1-5+46+20"};
		assertArrayEquals(splitEq, EquationUtils.splitEquation(equation));
	}
	
	@Test
	@DisplayName("'=' at index 0, equation split should return null")
	void testInvalidEquationSplit() {
		String incorrectEq = "=-4y+1-5+46+20";
		assertNull(EquationUtils.splitEquation(incorrectEq));
	}
	
}
