package microservice.equationSolver;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import microservice.equationSolver.linearEquationSolver.EquationComponent;
import microservice.equationSolver.linearEquationSolver.EquationSide;

/********************************************
 * EquationSide.splitIntoComponents() Tests
 * 
 * 
 * 
 * 
 * 
 ********************************************/

@SpringBootTest
public class EquationSideTests {
	
	@Test
	@DisplayName("Test for correct splitting of components with only constants")
	void testSplitIntoComponents() {
		String equation = "4+5-6";
		
		ArrayList<EquationComponent> splitEq = new ArrayList<>();
		splitEq.add(new EquationComponent("4"));
		splitEq.add(new EquationComponent("5"));
		splitEq.add(new EquationComponent("-6"));
		
		EquationSide testSplit = new EquationSide();
		testSplit.splitIntoComponents(equation);
		assertTrue(compareListOfEquationComponents(splitEq, testSplit.getComponents()));
	}
	
	@Test
	@DisplayName("Test for correct splitting with constants and variables")
	void testSplitIntoComponentsVarsConsts() {
		String equation = "4y+5-6";
		
		ArrayList<EquationComponent> splitEq = new ArrayList<>();
		splitEq.add(new EquationComponent("4y"));
		splitEq.add(new EquationComponent("5"));
		splitEq.add(new EquationComponent("-6"));
		
		EquationSide testSplit = new EquationSide();
		testSplit.splitIntoComponents(equation);
		assertTrue(compareListOfEquationComponents(splitEq, testSplit.getComponents()));
	}
	
	@Test
	@DisplayName("Test for correct splitting with variables and int/double constants")
	void testSplitIntoComponentsVarsConstsIntDoubles() {
		String equation = "x+2.0-20";
		
		ArrayList<EquationComponent> splitEq = new ArrayList<>();
		splitEq.add(new EquationComponent("x"));
		splitEq.add(new EquationComponent("2.0"));
		splitEq.add(new EquationComponent("-20"));
		
		EquationSide testSplit = new EquationSide();
		testSplit.splitIntoComponents(equation);
		assertTrue(compareListOfEquationComponents(splitEq, testSplit.getComponents()));
	}
	
	@Test
	@DisplayName("Test for correct splitting with two variables")
	void testSplitIntoComponentsTwoVars() {
		String equation = "x-y";
		
		ArrayList<EquationComponent> splitEq = new ArrayList<>();
		splitEq.add(new EquationComponent("x"));
		splitEq.add(new EquationComponent("-y"));
		
		EquationSide testSplit = new EquationSide();
		testSplit.splitIntoComponents(equation);
		assertTrue(compareListOfEquationComponents(splitEq, testSplit.getComponents()));
	}
	
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
	private boolean compareListOfEquationComponents(
					ArrayList<EquationComponent> listOne,
					ArrayList<EquationComponent> listTwo) {
		for (int i = 0; i < listOne.size(); i++) {
			EquationComponent one = listOne.get(i);
			EquationComponent two = listTwo.get(i);
			
			if (!(one.equals(two))) {
				return false;
			}
		}
		return true;
	}
	
}