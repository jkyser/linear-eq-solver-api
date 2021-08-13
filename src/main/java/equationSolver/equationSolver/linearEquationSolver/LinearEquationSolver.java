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
		String yInt = EquationUtils.getyIntercept(equation);
		this.equation.setyIntercept(yInt);
		String slope = EquationUtils.getSlope(equation);
		this.equation.setSlope(slope);
	}
	
	/*
	 * Getters and setters
	 */
	public EquationHolder getEquation() {
		return this.equation;
	}
	
	public String getyIntercept() {
		return this.equation.getyIntercept();
	}
	
	public String getSlope() {
		return this.equation.getSlope();
	}
}
