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
	private boolean isInt = false;
	private int constantInt;
	private boolean isDouble = false;
	private double constantDouble;
	
	/***********************************
	 * Constructor
	 * 
	 * 
	 * 
	 * 
	 * 
	 ***********************************/
	
	public EquationComponent(String component) {
		// check for int or double to initialize the nested
		// constant class with the correct constant
		try {
			this.constantInt = Integer.parseInt(component);
			this.isInt = true;
		} catch (NumberFormatException e) {
			this.constantDouble = Double.parseDouble(component);
			this.isDouble = true;
		}
	}

	/**********************************
	 * Getters and Setters
	 * 
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

	public boolean isInt() {
		return isInt;
	}

	public void setInt(boolean isInt) {
		this.isInt = isInt;
	}

	public int getConstantInt() {
		return constantInt;
	}

	public void setConstantInt(int constantInt) {
		this.constantInt = constantInt;
	}

	public boolean isDouble() {
		return isDouble;
	}

	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}

	public double getConstantDouble() {
		return constantDouble;
	}

	public void setConstantDouble(double constantDouble) {
		this.constantDouble = constantDouble;
	}
	
}
