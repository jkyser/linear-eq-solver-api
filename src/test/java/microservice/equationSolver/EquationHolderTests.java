package microservice.equationSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import microservice.equationSolver.linearEquationSolver.EquationHolder;

@SpringBootTest
public class EquationHolderTests {
	
	EquationHolder holder;
	
	@BeforeEach
	void initEquationHolder() {
		holder = new EquationHolder();
	}
	
	@Test
	@DisplayName("Test solvYMXBform() basic functionality")
	void testSolveYMXBform() {
		String equation = "4x+6=-5y+20";
		String solvedEquation = "y=-0.8x+2.8";
		
		holder.setEquation(equation);
		holder.solveYMXBform();
		
		assertEquals(solvedEquation, holder.getEquation());
	}
	
	@Test
	@DisplayName("Test slope is set correctly")
}
