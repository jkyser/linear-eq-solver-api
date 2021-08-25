package microservice.equationSolver.linearEquationSolver;

import microservice.equationSolver.Utils.EquationUtils;

public class EquationHolder {
	
	/*
	 * Member variables
	 */
	private String equation;
	private String slope;
	private String yIntercept;
	private EquationSide leftSide;
	private EquationSide rightSide;
	
	public EquationHolder() {
		leftSide = new EquationSide();
		rightSide = new EquationSide();
	}

	/******************************************
	 * Methods for solving linear equations
	 * 
	 * 
	 * 
	 * 
	 * 
	 ******************************************/
	
	/*
	 * Solves a given linear equation by first splitting into components
	 * then processing the various steps to solve a linear equation
	 */
	public void solveYMXBform() {
		// split equation into components
		String[] splitEq = EquationUtils.splitEquation(this.equation);
		this.leftSide.splitIntoComponents(splitEq[0]);
		this.rightSide.splitIntoComponents(splitEq[1]);
		
		// use the utils to solve the equation
		EquationUtils.moveYToLeftSide(this.leftSide, this.rightSide);
		EquationUtils.moveXToRightSide(this.leftSide, this.rightSide);
		EquationUtils.isolateYOnLeftSide(this.leftSide, this.rightSide);
		EquationUtils.reduceRightSideConstants(this.rightSide);
		EquationUtils.divideByYCoefficient(this.leftSide, this.rightSide);
		
		// set the equation to the proper y=mx+b form
		setEquationToYMXB();
	}
	
	/*
	 * Sets the equation to the proper y=mx+b form
	 */
	private void setEquationToYMXB() {
		String eq = "y=";
		
		// get the left side of the equation first
		eq += parseRightSideEquation();
		this.equation = eq;
	}
	
	/*
	 * Returns the left side of the equation for a linear equation including
	 * the '=' symbol
	 */
	private String parseRightSideEquation() {
		String xCompString = "";
		String yIntString = "";
		
		// iterate through the right side and parse/condense
		// to a string
		for (EquationComponent comp: this.rightSide.getComponents()) {
			if (comp.getVariable() != null) {
				// this is the x component
				if (comp.isInt()) {
					xCompString += "" + comp.getConstantInt() + "x";
				} else {
					xCompString += "" + comp.getConstantDouble() + "x";
				}
			} else {
				// this is the y intercept
				if (comp.isInt()) {
					yIntString += "" + comp.getConstantInt();
				} else {
					yIntString += "" + comp.getConstantDouble();
				}
			}
		}
		
		setSlope(xCompString);
		setyIntercept(yIntString);
		
		// return the correctly formatted string
		if (yIntString.charAt(0) == '-') {
			return xCompString + yIntString;
		} else {
			return xCompString + "+" + yIntString;
		}
	}
	
	/******************************************
	 * Getters and Setters
	 * 
	 * 
	 * 
	 * 
	 * 
	 ******************************************/
	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

	public String getyIntercept() {
		return yIntercept;
	}

	private void setyIntercept(String yIntercept) {
		this.yIntercept = yIntercept;
	}

	public String getSlope() {
		return slope;
	}
	
	private void setSlope(String slope) {
		int slopeIndex = 0;
		
		for (int i = 0; i < slope.length(); i++) {
			char c = slope.charAt(i);
			
			if (Character.isLetter(c)) {
				slopeIndex = i;
				break;
			}
		}
		
		this.slope = slope.substring(0, slopeIndex);
	}
}
