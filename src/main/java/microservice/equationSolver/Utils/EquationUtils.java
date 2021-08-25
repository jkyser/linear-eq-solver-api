package microservice.equationSolver.Utils;

import java.util.ArrayList;

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
			
			// break when = sign found
			if (c == '=') {
				equalIndex = i;
				break;
			}
		}
		
		// check for incorrect equal sign location here
		if (equalIndex == 0 || equalIndex == equation.length() - 1) {
			return null;
		}
		
		// return array of strings representing equation broken on = sign
		eqArray[0] = equation.substring(0, equalIndex);
		eqArray[1] = equation.substring(equalIndex + 1);
		return eqArray;
	}
	
	/*
	 * Isolates the y variable component to the left side
	 */
	public static void moveYToLeftSide(EquationSide left, EquationSide right) {
		EquationComponent yComponent = null;
		
		// iterate through right side and grab the component whose
		// variable is y
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
		
		// iterate through left side and grab the component whose
		// variable is x
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
		ArrayList<EquationComponent> compsToMove = new ArrayList<>();
		
		// add all components to compsToMove whose variable is null
		// indicating there is no associated variable
		for (EquationComponent comp: left.getComponents()) {
			if (comp.getVariable() == null) {
				compsToMove.add(comp);
			}
		}
		
		// shift everything to the right side that is not the y variable component
		for (EquationComponent comp: compsToMove) {
			left.removeFromSide(comp);
			right.addToSide(comp);
		}
	}
	
	/*
	 * Reduces down the constants on the right side
	 */
	public static void reduceRightSideConstants(EquationSide right) {
		// get all of the constants
		ArrayList<EquationComponent> compsToReduce = new ArrayList<>();
		
		for (EquationComponent comp: right.getComponents()) {
			if (comp.getVariable() == null) {
				compsToReduce.add(comp);
			}
		}
		
		// remove each component from the right side and add them all together
		// into one equation component
		EquationComponent reducedConstant = new EquationComponent("0");
		
		for (EquationComponent comp: compsToReduce) {
			right.removeFromSide(comp);
			reducedConstant.add(comp);
		}
		
		// add the reduced constant back to the right side
		// necessary to change sign because of addToSide() implementation
		reducedConstant.changeSign();
		right.addToSide(reducedConstant);
	}
	
	/*
	 * Divides the y component by its coefficient on the left and right side
	 */
	public static void divideByYCoefficient(EquationSide left, EquationSide right) {
		// get the constant to divide by
		Integer intConst = null;
		Double doubleConst = null;
		
		// there should only be one component on the left side containing
		// the y variable, but the loop is to ensure I get the right
		// constant in case something upstream happened, that way
		// no data is lost at this point
		for (EquationComponent comp: left.getComponents()) {
			if (comp.getVariable() != null) {
				if (comp.getVariable().contains("y")) {
					// check for int or double constant
					if (comp.isInt()) {
						intConst = comp.getConstantInt();
					} else {
						doubleConst = comp.getConstantDouble();
					}
				}
			}
		}
		
		// create a new component for the dividend
		String div;
		if (intConst != null) {
			div = String.valueOf(intConst);
		} else {
			div = String.valueOf(doubleConst);
		}
		EquationComponent dividend = new EquationComponent(div);
		
		// divide all components on left and right sides by the constant
		for (EquationComponent comp: left.getComponents()) {
			comp.divide(dividend);
		}
		
		for (EquationComponent comp: right.getComponents()) {
			comp.divide(dividend);
		}
	}
	
}
