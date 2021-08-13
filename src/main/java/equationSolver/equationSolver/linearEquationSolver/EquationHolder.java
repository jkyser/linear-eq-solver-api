package equationSolver.equationSolver.linearEquationSolver;

import java.util.ArrayList;

public class EquationHolder {
	private String equation;
	private String yIntercept;
	private String slope;
	private ArrayList<String> leftSide;
	private ArrayList<String> rightSide;
	
	public String getyIntercept() {
		return yIntercept;
	}

	public void setyIntercept(String yIntercept) {
		this.yIntercept = yIntercept;
	}

	public String getSlope() {
		return slope;
	}

	public void setSlope(String slope) {
		this.slope = slope;
	}
	public String getEquation() {
		return equation;
	}
	
	public void setEquation(String equation) {
		this.equation = equation;
	}
	
	public ArrayList<String> getLeftSide() {
		return leftSide;
	}

	public void setLeftSide(ArrayList<String> leftSide) {
		this.leftSide = leftSide;
	}

	public ArrayList<String> getRightSide() {
		return rightSide;
	}

	public void setRightSide(ArrayList<String> rightSide) {
		this.rightSide = rightSide;
	}

	public String toString() {
		return this.equation;
	}
}
