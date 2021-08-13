package equationSolver.equationSolver;

import java.util.ArrayList;

import equationSolver.equationSolver.linearEquationSolver.EquationHolder;

public class EquationUtils {
	
	/**********************************************************
	 * Public method to split the equation into an array list
	 * and the private helper methods.
	 * 
	 * 
	 * 
	 * 
	 * 
	 **********************************************************/
	
	/*
	 * Splits the equation string on "+-" into an array list
	 * to easily grab the equation components.
	 */
	public static EquationHolder splitEquation(String equation) {
		EquationHolder splitEquation = new EquationHolder();
		ArrayList<String> eqList = new ArrayList<>();
		
		// iterate through looking for a char that is a delimiter
		for (int i = 0; i < equation.length(); i++) {
			if (breakOnEquals(splitEquation, equation.substring(i, i+1), eqList)) {
				i += 1;
				eqList = new ArrayList<>();
			}

			// add the component to the ArrayList
			String component = splitOnDelimiter(equation, i);
			eqList.add(component);
			
			// push forward i value so we don't read the same string
			i += component.length() - 1;
		}
		
		splitEquation.setRightSide(eqList);
		return splitEquation;
	}
	
	/*
	 * Helper function to split the equation on the given delimiter
	 */
	private static String splitOnDelimiter(String eq, int start) {
		String delimiters = "+-/*";
		int end = 0;
		for (int i = start+1; i < eq.length(); i++) {
			end = i;
			
			String c = String.valueOf(eq.charAt(i));
			if (delimiters.contains(c) || c.equals("=")) {
				break;
			} else if (i == eq.length() - 1) {
				end += 1;
			}
		}
		String component = eq.substring(start, end);
		return component;
	}
	
	/*
	 * Checks if the current value is an "=" character. If it is, then
	 * save that array into the EquationHolder object, as that is the left side
	 * of the equation.
	 */
	private static boolean breakOnEquals(EquationHolder eqHolder, String c,
			ArrayList<String> leftSide) {
		if (c.equals("=")) {
			// break the arrays into left and right at this point
			eqHolder.setLeftSide(leftSide);
			return true;
		}
		return false;
	}
	
	/**********************************************************
	 * Public method to isolate x and y on their respective
	 * sides and the private helper methods.
	 * 
	 * 
	 * 
	 * 
	 * 
	 **********************************************************/
	
	/*
	 * Isolates the y component to the left side and the x component to
	 * the right side.
	 */
	public static void isolateXY(EquationHolder equation) {
		// check if x is on the left side of the equation
		if (xOnLeftSide(equation.getLeftSide())) {
			moveXToRightSide(equation);
		}
		
		// check if y is on the right side
		if (yOnRightSide(equation.getRightSide())) {
			moveYToLeftSide(equation);
		}
	}
	
	/*
	 * Checks if the x variable is on the left side of the equation.
	 */
	private static boolean xOnLeftSide(ArrayList<String> leftSide) {
		for (String component: leftSide) {
			if (component.contains("x")) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Checks if the y variable is on the right side.
	 */
	private static boolean yOnRightSide(ArrayList<String> rightSide) {
		for (String component: rightSide) {
			if (component.contains("y")) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Moves the x variable component to the right side
	 * Don't have to check for it because it is already checked for
	 */
	private static void moveXToRightSide(EquationHolder equation) {
		String xComponent = getComponent(equation.getLeftSide(), "x");
		equation.getLeftSide().remove(xComponent);
		xComponent = changeSign(xComponent);
		equation.getRightSide().add(xComponent);
	}
	
	/*
	 * Moves the y variable component to the left side
	 * Don't have to check for it because it is already checked for
	 */
	private static void moveYToLeftSide(EquationHolder equation) {
		String yComponent = getComponent(equation.getRightSide(), "y");
		equation.getRightSide().remove(yComponent);
		yComponent = changeSign(yComponent);
		equation.getLeftSide().add(yComponent);
	}
	
	/*
	 * Returns the component of the equation requested by the input component
	 */
	private static String getComponent(ArrayList<String> eq, String toFind) {
		for (int i = 0; i < eq.size(); i++) {
			String component = eq.get(i);
			if (component.contains(toFind)) {
				return component;
			}
		}
		return "";
	}
	
	/*
	 * Changes the '+' or '-' sign of the given component
	 */
	private static String changeSign(String component) {
		if (component.charAt(0) == '-') {
			component = component.substring(1);
		} else {
			if (component.charAt(0) == '+') {
				component = "-" + component.substring(1);
			} else {
				component = "-" + component;
			}
		}
		return component;
	}
	
	/**********************************************************
	 * Public method to reduce the constants and the private
	 * helper methods.
	 * 
	 * 
	 * 
	 * 
	 * 
	 **********************************************************/
	
	/*
	 * Reduce constants on both sides of the equation
	 */
	public static void reduceConstants(EquationHolder equation) {
		// reduce left side
		reduceConstants(equation.getLeftSide());
		// reduce right side
		reduceConstants(equation.getRightSide());
	}
	
	/*
	 * Helper method to reduce the constants
	 */
	private static void reduceConstants(ArrayList<String> equation) {
		ArrayList<String> constList = new ArrayList<>();
		int sum = 0;
		
		for (String component: equation) {
			// checking for letter source:
			// https://stackoverflow.com/questions/14278170/how-to-check-whether-a-string-contains-at-least-one-alphabet-in-java
			if (!component.matches(".*[a-zA-Z]+.*")) {
				constList.add(component);
				sum += Integer.valueOf(component);
			}
		}
		
		// remove the constants from the original equation
		equation.removeAll(constList);
		
		// add the reduced sum back in
		if (sum != 0) {
			equation.add(String.valueOf(sum));
		}
	}

	/**********************************************************
	 * Public method to isolate the y variable on the left
	 * side of the equation
	 * 
	 * 
	 * 
	 * 
	 **********************************************************/
	/*
	 * Ensure y is on the left side of the equation with only a coefficient
	 * of 1.
	 */
	public static void isolateYonLeftSide(EquationHolder equation) {
		// check if there are any constants to move to right side
		moveConstToRightSide(equation);
		// divide by any coefficients that y contains
		divideYbyCoefficient(equation);
	}
	
	/*
	 * Moves any remaining constants to the right side of the equation
	 */
	private static void moveConstToRightSide(EquationHolder equation) {
		ArrayList<String> constants = new ArrayList<>();
		if (equation.getLeftSide().size() > 1) {
			for (String component: equation.getLeftSide()) {
				if (!component.matches(".*[a-zA-Z]+.*")) {
					constants.add(component);
				}
			}
			
			equation.getLeftSide().removeAll(constants);
			
			for (String constant: constants) {
				equation.getRightSide().add(changeSign(constant));
			}

			// reduce constants again
			reduceConstants(equation);
		}
	}
	
	/*
	 * Divides y by any remaining coefficients to get just y on the left
	 * side, and also divides the right side by the coefficient
	 */
	private static void divideYbyCoefficient(EquationHolder equation) {
		int coefficient = isolateYCoefficient(equation.getLeftSide());
		divideByCoefficient(equation.getRightSide(), coefficient);
	}
	
	/*
	 * Gets the coefficient of y on the left side of the equation
	 */
	private static int isolateYCoefficient(ArrayList<String> leftSide) {
		String yComponent = leftSide.get(0);
		if (yComponent.equals("y")) {
			return 1;
		}
		
		String coefficient = "";
		for (int i = 0; i < yComponent.length(); i++) {
			char c = yComponent.charAt(i);
			if (c != 'y') {
				coefficient += c;
			}
		}
		
		leftSide.set(0, "y");
		return Integer.valueOf(coefficient);
	}
	
	/*
	 * Divides the right side of the equation by the coefficient supplied
	 */
	private static void divideByCoefficient(ArrayList<String> rightSide, int coefficient) {
		for (int i = 0; i < rightSide.size(); i++) {
			if (rightSide.get(i).contains("x")) {
				String newXComponent = divideXCoefficient(rightSide.get(i), coefficient);
				rightSide.set(i, newXComponent);
				continue;
			}
			
			// divide the constant by the coefficient
			int constant = Integer.valueOf(rightSide.get(i));
			if (constant % coefficient == 0) {
				rightSide.set(i, String.valueOf(constant / coefficient));
			} else {
				rightSide.set(i, String.valueOf((double) constant / coefficient));
			}
		}
	}
	
	/*
	 * Takes care of dividing the coefficient of x
	 */
	private static String divideXCoefficient(String xComponent, int coefficient) {
		String xCoefficientStr = "";
		
		if (xComponent.equals("x")) {
			xCoefficientStr = "1";
		} else {
			for (int i = 0; i < xComponent.length(); i++) {
				char c = xComponent.charAt(i);
				if (c != 'x') {
					xCoefficientStr += c;
				}
			}
		}
		
		int xCoefficient;
		if (xCoefficientStr.contains("-")) {
			xCoefficient = -1;
		} else if (xCoefficientStr.contains("+")) {
			xCoefficient = 1;
		} else {
			xCoefficient = Integer.valueOf(xCoefficientStr);
		}
		
		if (xCoefficient % coefficient == 0) {
			return String.valueOf(xCoefficient / coefficient) + "x";
		} else {
			return String.valueOf((double) xCoefficient / coefficient) + "x";
		}
	}
	
	/**********************************************************
	 * Public method to isolate the y variable on the left
	 * side of the equation
	 * 
	 * 
	 * 
	 * 
	 **********************************************************/
	
	/*
	 * Rebuilds the equation to a plain string format
	 */
	
	public static void rebuildEquation(EquationHolder equation) {
		String rightSide = "";
		
		for (String component: equation.getRightSide()) {
			if (component.contains("x")) {
				rightSide = component + rightSide;
			} else {
				if (component.charAt(0) != '-') {
					rightSide += "+" + component;
				} else {
					rightSide += component;
				}
			}
		}
		
		equation.setEquation(equation.getLeftSide().get(0) + "=" + rightSide);
	}
}
