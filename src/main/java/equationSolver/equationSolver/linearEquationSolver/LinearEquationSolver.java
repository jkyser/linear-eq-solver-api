package equationSolver.equationSolver.linearEquationSolver;

import equationSolver.equationSolver.EquationUtils;

public class LinearEquationSolver {
	
	private EquationHolder equation;
	
	public LinearEquationSolver(String equation) {
		this.equation = EquationUtils.splitEquation(equation);
	}
	
	/*
	 * Public Methods
	 */
	public void solve() {
		EquationUtils.isolateXY(equation);
		EquationUtils.reduceConstants(equation);
		EquationUtils.isolateYonLeftSide(equation);
		EquationUtils.rebuildEquation(equation);
	}
	
	/*
	 * Getters and setters
	 */
	public String getEquation() {
		return equation.getEquation();
	}
}
