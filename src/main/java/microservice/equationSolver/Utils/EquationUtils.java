package microservice.equationSolver.Utils;

import microservice.equationSolver.linearEquationSolver.EquationComponent;
import microservice.equationSolver.linearEquationSolver.EquationSide;

/***************************************************************************
 * Utility class to provide common functionality between different equation
 * solvers
 * 
 *
 *
 *
 ***************************************************************************/
public class EquationUtils {

	/*
	 * Splits a given equation on the equals sign, returns String array
	 * with 0 index being left side of equation and 1 index being right
	 * side of the equation
	 */
	public static String[] splitEquation(String equation) {
		String[] eqArray = new String[2];
		
		int equalIndex = 0;
		for (int i = 0; i < equation.length(); i++) {
			char c = equation.charAt(i);
			
			if (c == '=') {
				equalIndex = i;
				break;
			}
		}
		
		// check for incorrect formatting here
		if (equalIndex == 0 || equalIndex == equation.length() - 1) {
			return null;
		}
		
		eqArray[0] = equation.substring(0, equalIndex);
		eqArray[1] = equation.substring(equalIndex + 1);
		return eqArray;
	}
	
	/*
	 * Isolates the y variable component to the left side
	 */
	public static void moveYToLeftSide(EquationSide left, EquationSide right) {
		EquationComponent yComponent = null;
		
		for (EquationComponent comp: right.getComponents()) {
			if (comp.getVariable() != null) {	
				if (comp.getVariable().contains("y")) {
					yComponent = comp;
					break;
				}
			}
		}
		
		if (yComponent != null) {
			right.removeFromSide(yComponent);
			left.addToSide(yComponent);
		}
	}
	
	/*
	 * Isolates the x variable component to the right side
	 */
	public static void moveXToRightSide(EquationSide left, EquationSide right) {
		EquationComponent xComponent = null;
		
		for (EquationComponent comp: left.getComponents()) {
			if (comp.getVariable() != null) {
				if (comp.getVariable().contains("x")) {
					xComponent = comp;
					break;
				}
			}
		}
		
		if (xComponent != null) {
			left.removeFromSide(xComponent);
			right.addToSide(xComponent);
		}
	}
	
	/*
	 * Clears the entire left side except for the y component
	 */
	public static void isolateYOnLeftSide(EquationSide left, EquationSide right ) {
		
	}
}
