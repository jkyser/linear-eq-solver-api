package microservice.equationSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import microservice.equationSolver.linearEquationSolver.EquationComponent;

/****************************************************
 * Tests for EquationComponent Class
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 ****************************************************/

@SpringBootTest
public class EquationComponentTests {
	
	@Test
	@DisplayName("Test Equationcomponent constructor parses number - no variable")
	void testEquationComponentConstructorInt() {
		String component = "4";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(4, testComponent.getConstantInt());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses double - no variable")
	void testEquationComponentConstructorDouble() {
		String component = "4.2";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(4.2, testComponent.getConstantDouble());
	}

	@Test
	@DisplayName("Test EquationComponent constructor parses negative int - no variable")
	void testEquationComponentConstructorNegInt() {
		String component = "-4";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(-4, testComponent.getConstantInt());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses negative double - no variable")
	void testEquationComponentConstructorNegDouble() {
		String component = "-4.2";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(-4.2, testComponent.getConstantDouble());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses variable")
	void testEquationComponentConstructorVariableInt() {
		String component = "4y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals("y", testComponent.getVariable());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses int with variable")
	void testEquationComponentConstructorIntVariable() {
		String component = "4y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(4, testComponent.getConstantInt());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses negative int with variable")
	void testEquationComponentConstructorNegIntVariable() {
		String component = "-4y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(-4, testComponent.getConstantInt());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses variable with double")
	void testEquationComponentConstructorVariableDouble() {
		String component = "4.2y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals("y", testComponent.getVariable());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses double with variable")
	void testEquationComponentConstructorDoubleVariable() {
		String component = "4.2y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(4.2, testComponent.getConstantDouble());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses negative double with variable")
	void testEquationComponentConstructorNegDoubleVariable() {
		String component = "-4.2y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(-4.2, testComponent.getConstantDouble());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses constant with no variable constant")
	void testEquationComponentConstructorConstantWithNoConstant() {
		String component = "y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(1, testComponent.getConstantInt());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses variable with no constant")
	void testEquationComponentConstructorVariableWithNoConstant() {
		String component = "y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals("y", testComponent.getVariable());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses constant with no variable constant negative")
	void testEquationComponentConstructorConstantWithNoConstantNegative() {
		String component = "-y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(-1, testComponent.getConstantInt());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses variable with no constant negative")
	void testEquationComponentConstructorVariableWithNoConstantNegative() {
		String component = "-y";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals("y", testComponent.getVariable());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses constant with a + symbol in it")
	void testEquationComponentConstructorConstantPlusSymbol() {
		String component = "+20";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(20, testComponent.getConstantInt());
	}
	
	@Test
	@DisplayName("Test EquationComponent constructor parses double constant with a + symbol in it")
	void testEquationComponentConstructorDoubleConstantPlusSymbol() {
		String component = "+20.2";
		EquationComponent testComponent = new EquationComponent(component);
		assertEquals(20.2, testComponent.getConstantDouble());
	}
}
