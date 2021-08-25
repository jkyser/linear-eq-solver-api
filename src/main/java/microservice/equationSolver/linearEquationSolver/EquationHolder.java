package microservice.equationSolver.linearEquationSolver;

import microservice.equationSolver.Utils.EquationUtils;

public class EquationHolder {
	
	/*
	 * Member variables
	 */
	private String equation;
	private EquationSide leftSide;
	private EquationSide rightSide;
	
	public EquationHolder() {}

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
		String[] splitEq = EquationUtils.splitEquation(this.equation);
		leftSide.splitIntoComponents(splitEq[0]);
		rightSide.splitIntoComponents(splitEq[1]);
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
	
}
