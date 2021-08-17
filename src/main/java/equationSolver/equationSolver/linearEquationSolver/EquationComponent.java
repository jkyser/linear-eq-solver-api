package equationSolver.equationSolver.linearEquationSolver;

public class EquationComponent {
	
	/**********************************
	 * Member variables
	 * 
	 * 
	 * 
	 * 
	 * 
	 **********************************/
	private String variable = null;
	private int componentConst;
	
	public EquationComponent(String component) {
		this.componentConst = Integer.valueOf(component);
	}

	/**********************************
	 * Getters and Setters
	 * 
	 * 
	 * 
	 * 
	 **********************************/

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public int getComponentConst() {
		return componentConst;
	}

	public void setComponentConst(int componentConst) {
		this.componentConst = componentConst;
	}
	
}
