package microservice.equationSolver.linearEquationSolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import microservice.equationSolver.Utils.EquationUtils;

@Component
@RequestScope
public class EquationHolder {
	
	/*
	 * Member variables
	 */
	private String equation;
	@Autowired
	private EquationSide leftSide;
	@Autowired
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
