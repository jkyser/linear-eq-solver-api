package microservice.equationSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

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
	/*********************************************
	 * 
	 * Constructor tests
	 * 
	 * 
	 * 
	 *********************************************/
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
	
	
	/****************************************
	 * 
	 * Addition tests
	 * 
	 * 
	 * 
	 * 
	 ****************************************/
	@Test
	@DisplayName("Test positive integer addition")
	void testEquationComponentPositiveIntAdd() {
		EquationComponent original = new EquationComponent("4");
		EquationComponent toAdd = new EquationComponent("2");
		original.add(toAdd);
		
		EquationComponent expected = new EquationComponent("6");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test negative integer addition")
	void testEquationComponentNegativeIntAdd() {
		EquationComponent original = new EquationComponent("4");
		EquationComponent toAdd = new EquationComponent("-2");
		original.add(toAdd);
		
		EquationComponent expected = new EquationComponent("2");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test positive integer addition to double")
	void testEquationComponentPositiveIntAddToDouble() {
		EquationComponent original = new EquationComponent("4.0");
		EquationComponent toAdd = new EquationComponent("2");
		original.add(toAdd);
		
		EquationComponent expected = new EquationComponent("6.0");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test negative integer addition to double")
	void testEquationComponentNegativeIntAddToDouble() {
		EquationComponent original = new EquationComponent("4.0");
		EquationComponent toAdd = new EquationComponent("-2");
		original.add(toAdd);
		
		EquationComponent expected = new EquationComponent("2.0");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test positive double addition to int")
	void testEquationComponentPositiveDoubleAddToInt() {
		EquationComponent original = new EquationComponent("4");
		EquationComponent toAdd = new EquationComponent("2.0");
		original.add(toAdd);
		
		EquationComponent expected = new EquationComponent("6.0");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test negative double addition to int")
	void testEquationComponentNegativeDoubleAddToInt() {
		EquationComponent original = new EquationComponent("4");
		EquationComponent toAdd = new EquationComponent("-2.0");
		original.add(toAdd);
		
		EquationComponent expected = new EquationComponent("2.0");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	/****************************************
	 * 
	 * Subtraction tests
	 * 
	 * 
	 * 
	 * 
	 ****************************************/
	@Test
	@DisplayName("Test positive integer subtraction")
	void testEquationComponentPositiveIntSub() {
		EquationComponent original = new EquationComponent("4");
		EquationComponent toAdd = new EquationComponent("2");
		original.subtract(toAdd);
		
		EquationComponent expected = new EquationComponent("2");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test negative integer subtraction")
	void testEquationComponentNegativeIntSub() {
		EquationComponent original = new EquationComponent("4");
		EquationComponent toAdd = new EquationComponent("-2");
		original.subtract(toAdd);
		
		EquationComponent expected = new EquationComponent("6");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test positive integer subtraction to double")
	void testEquationComponentPositiveIntSubToDouble() {
		EquationComponent original = new EquationComponent("4.0");
		EquationComponent toAdd = new EquationComponent("2");
		original.subtract(toAdd);
		
		EquationComponent expected = new EquationComponent("2.0");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test negative integer subtraction to double")
	void testEquationComponentNegativeIntSubToDouble() {
		EquationComponent original = new EquationComponent("4.0");
		EquationComponent toAdd = new EquationComponent("-2");
		original.subtract(toAdd);
		
		EquationComponent expected = new EquationComponent("6.0");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test positive double subtraction to int")
	void testEquationComponentPositiveDoubleSubToInt() {
		EquationComponent original = new EquationComponent("4");
		EquationComponent toAdd = new EquationComponent("2.0");
		original.subtract(toAdd);
		
		EquationComponent expected = new EquationComponent("2.0");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	@Test
	@DisplayName("Test negative double subtraction to int")
	void testEquationComponentNegativeDoubleSubToInt() {
		EquationComponent original = new EquationComponent("4");
		EquationComponent toAdd = new EquationComponent("-2.0");
		original.subtract(toAdd);
		
		EquationComponent expected = new EquationComponent("6.0");
		assertTrue(compareEquationComponents(original, expected));
	}
	
	
	/****************************************
	 * 
	 * Multiplication tests
	 * 
	 * 
	 * 
	 * 
	 ****************************************/
	
	/****************************************
	 * 
	 * Division tests
	 * 
	 * 
	 * 
	 * 
	 ****************************************/
	
	/******************************************
	 * 
	 * Helper methods
	 * 
	 * 
	 * 
	 * 
	 ******************************************/
	
	/*
	 * Compares the EquationComponent instances in two ArrayLists
	 * and returns true if they are all equal and false otherwise
	 */
	private boolean compareEquationComponents(
					EquationComponent one,
					EquationComponent two) {			
		if (!(one.equals(two))) {
			return false;
		}
		return true;
	}
}
