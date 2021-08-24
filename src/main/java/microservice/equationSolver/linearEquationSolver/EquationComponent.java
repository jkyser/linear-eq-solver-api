package microservice.equationSolver.linearEquationSolver;

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
		// assess if there is a variable present in the component
		if (component.matches("[0-9]+")) {
			// check for int or double to initialize the member variable
			checkAndSetConstant(component);
		} else {
			parseConstVariable(component);
		}
	}

	/**********************************
	 * Helper methods
	 * 
	 * 
	 * 
	 * 
	 * 
	 **********************************/
	/*
	 * Sets the constant value depending on if the input was an int or double
	 */
	private void checkAndSetConstant(String component) {
		try {
			this.constantInt = Integer.parseInt(component);
			this.isInt = true;
		} catch (NumberFormatException e) {
			this.constantDouble = Double.parseDouble(component);
			this.isDouble = true;
		}
	}
	
	/*
	 * Parses a constructor input that contains a variable and a constant
	 */
	private void parseConstVariable(String component) {
		for (int i = 0; i < component.length(); i++) {
			char c = component.charAt(i);
			if (Character.isLetter(c)) {
				this.variable = Character.toString(c);
				component = component.substring(0, i);
				break;
			}
		}
		
		checkAndSetConstant(component);
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
