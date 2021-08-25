package microservice.equationSolver;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import microservice.equationSolver.Utils.EquationUtils;
import microservice.equationSolver.linearEquationSolver.EquationComponent;
import microservice.equationSolver.linearEquationSolver.EquationSide;

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
	
	/***************************************
	 * EquationUtils.moveYToLeftSide() tests
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
	@DisplayName("Tests correct functionailty for moveYToLeftSide")
	void testMoveYToLeftSide() {
		String left = "x+42";
		String right = "-4y+1-5+46+20";
		String leftExpected = "x+42+4y";
		String rightExpected = "1-5+46+20";
		
		EquationSide leftSideActual = new EquationSide();
		leftSideActual.splitIntoComponents(left);
		EquationSide rightSideActual = new EquationSide();
		rightSideActual.splitIntoComponents(right);
		
		EquationSide leftSideExpected = new EquationSide();
		leftSideExpected.splitIntoComponents(leftExpected);
		EquationSide rightSideExpected = new EquationSide();
		rightSideExpected.splitIntoComponents(rightExpected);
		
		EquationUtils.moveYToLeftSide(leftSideActual, rightSideActual);
		assertTrue(
			compareListOfEquationComponents(leftSideActual.getComponents(), 
											leftSideExpected.getComponents()) && 
			compareListOfEquationComponents(rightSideActual.getComponents(),
											rightSideExpected.getComponents()));
	}
	
	@Test
	@DisplayName("Tests correct functionailty for moveYToLeftSide with no movement needed")
	void testMoveYToLeftSideNoChange() {
		String left = "x+42+4y";
		String right = "1-5+46+20";
		String leftExpected = "x+42+4y";
		String rightExpected = "1-5+46+20";
		
		EquationSide leftSideActual = new EquationSide();
		leftSideActual.splitIntoComponents(left);
		EquationSide rightSideActual = new EquationSide();
		rightSideActual.splitIntoComponents(right);
		
		EquationSide leftSideExpected = new EquationSide();
		leftSideExpected.splitIntoComponents(leftExpected);
		EquationSide rightSideExpected = new EquationSide();
		rightSideExpected.splitIntoComponents(rightExpected);
		
		EquationUtils.moveYToLeftSide(leftSideActual, rightSideActual);
		assertTrue(
			compareListOfEquationComponents(leftSideActual.getComponents(), 
											leftSideExpected.getComponents()) && 
			compareListOfEquationComponents(rightSideActual.getComponents(),
											rightSideExpected.getComponents()));
	}
	
	@Test
	@DisplayName("Tests correct functionailty for moveXToRightSide")
	void testMoveXToRightSide() {
		String left = "x+42";
		String right = "-4y+1-5+46+20";
		String leftExpected = "42";
		String rightExpected = "-4y+1-5+46+20-x";
		
		EquationSide leftSideActual = new EquationSide();
		leftSideActual.splitIntoComponents(left);
		EquationSide rightSideActual = new EquationSide();
		rightSideActual.splitIntoComponents(right);
		
		EquationSide leftSideExpected = new EquationSide();
		leftSideExpected.splitIntoComponents(leftExpected);
		EquationSide rightSideExpected = new EquationSide();
		rightSideExpected.splitIntoComponents(rightExpected);
		
		EquationUtils.moveXToRightSide(leftSideActual, rightSideActual);
		assertTrue(
			compareListOfEquationComponents(leftSideActual.getComponents(), 
											leftSideExpected.getComponents()) && 
			compareListOfEquationComponents(rightSideActual.getComponents(),
											rightSideExpected.getComponents()));
	}
	
	@Test
	@DisplayName("Tests correct functionailty for moveXToRightSide with no movement needed")
	void testMoveXToRightSideNoChange() {
		String left = "42";
		String right = "-4y+1-5+46+20-x";
		String leftExpected = "42";
		String rightExpected = "-4y+1-5+46+20-x";
		
		EquationSide leftSideActual = new EquationSide();
		leftSideActual.splitIntoComponents(left);
		EquationSide rightSideActual = new EquationSide();
		rightSideActual.splitIntoComponents(right);
		
		EquationSide leftSideExpected = new EquationSide();
		leftSideExpected.splitIntoComponents(leftExpected);
		EquationSide rightSideExpected = new EquationSide();
		rightSideExpected.splitIntoComponents(rightExpected);
		
		EquationUtils.moveXToRightSide(leftSideActual, rightSideActual);
		assertTrue(
			compareListOfEquationComponents(leftSideActual.getComponents(), 
											leftSideExpected.getComponents()) && 
			compareListOfEquationComponents(rightSideActual.getComponents(),
											rightSideExpected.getComponents()));
	}
	
	/***************************************
	 * EquationUtils.isolateYOnLeftSide() tests
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
	@DisplayName("Test isolateYOnLeftSide for basic functionality")
	void testIsolateYOnLeftSide() {
		String left = "x+42";
		String right = "-4y+1-5+46+20";
		String leftExpected = "4y";
		String rightExpected = "1-5+46+20-x-42";
		
		EquationSide leftSideActual = new EquationSide();
		leftSideActual.splitIntoComponents(left);
		EquationSide rightSideActual = new EquationSide();
		rightSideActual.splitIntoComponents(right);
		
		EquationSide leftSideExpected = new EquationSide();
		leftSideExpected.splitIntoComponents(leftExpected);
		EquationSide rightSideExpected = new EquationSide();
		rightSideExpected.splitIntoComponents(rightExpected);
		
		EquationUtils.moveYToLeftSide(leftSideActual, rightSideActual);
		EquationUtils.moveXToRightSide(leftSideActual, rightSideActual);
		EquationUtils.isolateYOnLeftSide(leftSideActual, rightSideActual);
		
		assertTrue(
			compareListOfEquationComponents(leftSideActual.getComponents(), 
											leftSideExpected.getComponents()) && 
			compareListOfEquationComponents(rightSideActual.getComponents(),
											rightSideExpected.getComponents()));
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
