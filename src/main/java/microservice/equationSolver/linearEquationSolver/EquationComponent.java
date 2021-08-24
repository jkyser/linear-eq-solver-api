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
		if (component.length() == 1) {
			this.variable = component;
			checkAndSetConstant("1");
			return;
		}
		
		for (int i = 0; i < component.length(); i++) {
			char c = component.charAt(i);
			if (Character.isLetter(c)) {
				this.variable = Character.toString(c);
				component = component.substring(0, i);
				break;
			}
		}
		
		if (component.length() == 1 && component.contains("-")) {
			checkAndSetConstant("-1");
		} else {
			checkAndSetConstant(component);
		}
	}
	
	
	/***************************************
	 * 
	 * Addition Methods
	 * 
	 * 
	 * 
	 * 
	 ***************************************/
	/*
	 * Adds the given EquationComponent to this component
	 */
	public void add(EquationComponent toAdd) {
		if (toAdd.isInt()) {
			if (this.isInt) {
				int newInt = this.constantInt + toAdd.getConstantInt();
				this.setConstantInt(newInt);
			} else {
				double newDouble = this.constantDouble + toAdd.getConstantInt();
				this.setConstantDouble(newDouble);
			}
		} else {
			if (this.isDouble) {
				double newDouble = this.constantDouble + toAdd.getConstantDouble();
				this.setConstantDouble(newDouble);
			} else {
				double newDouble = this.constantInt + toAdd.getConstantDouble();
				this.isInt = false;
				this.isDouble = true;
				this.constantDouble = newDouble;
			}
		}
	}
	
	
	/***************************************
	 * 
	 * Subtraction Methods
	 * 
	 * 
	 * 
	 * 
	 ***************************************/
	/*
	 * Subtracts the given EquationComponent to this component
	 */
	public void subtract(EquationComponent toSubtract) {
		if (toSubtract.isInt()) {
			if (this.isInt) {
				int newInt = this.constantInt - toSubtract.getConstantInt();
				this.setConstantInt(newInt);
			} else {
				double newDouble = this.constantDouble - toSubtract.getConstantInt();
				this.setConstantDouble(newDouble);
			}
		} else {
			if (this.isDouble) {
				double newDouble = this.constantDouble - toSubtract.getConstantDouble();
				this.setConstantDouble(newDouble);
			} else {
				double newDouble = this.constantInt - toSubtract.getConstantDouble();
				this.isInt = false;
				this.isDouble = true;
				this.constantDouble = newDouble;
			}
		}
	}
	
	
	/***************************************
	 * 
	 * Multiplication Methods
	 * 
	 * 
	 * 
	 * 
	 ***************************************/
	/*
	 * Multiplies the given EquationComponent to this component
	 */
	public void multiply(EquationComponent toMultiply) {
		if (toMultiply.isInt()) {
			if (this.isInt) {
				int newInt = this.constantInt * toMultiply.getConstantInt();
				this.setConstantInt(newInt);
			} else {
				double newDouble = this.constantDouble * toMultiply.getConstantInt();
				this.setConstantDouble(newDouble);
			}
		} else {
			if (this.isDouble) {
				double newDouble = this.constantDouble * toMultiply.getConstantDouble();
				this.setConstantDouble(newDouble);
			} else {
				double newDouble = this.constantInt * toMultiply.getConstantDouble();
				this.isInt = false;
				this.isDouble = true;
				this.constantDouble = newDouble;
			}
		}
	}
	
	
	/***************************************
	 * 
	 * Division Methods
	 * 
	 * 
	 * 
	 * 
	 ***************************************/
	/*
	 * Divides this component by the given EquationComponent
	 */
	public void divide(EquationComponent dividend) {
		if (this.isInt) {
			if (dividend.isDouble) {
				double result = this.constantInt / dividend.getConstantDouble();
				
				if (result % 1 == 0) {
					this.constantInt = (int) result;
				} else {
					this.isInt = false;
					this.isDouble = true;
					this.constantDouble = this.constantInt / dividend.getConstantDouble();
				}
			} else {
				if (this.constantInt % dividend.getConstantInt() == 0) {
					this.constantInt = this.constantInt / dividend.getConstantInt();
				} else {
					this.isInt = false;
					this.isDouble = true;
					this.constantDouble = this.constantInt / dividend.getConstantInt();
				}
			}
		} else {
			if (dividend.isDouble) {
				this.constantDouble = this.constantDouble / dividend.getConstantDouble();
			} else {
				this.constantDouble = this.constantDouble / dividend.getConstantInt();
			}
		}
	}
	
	
	/***************************************
	 * Equals method for comparing Equation
	 * Component objects
	 * 
	 *
	 * 
	 * 
	 ***************************************/
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof EquationComponent)) {
			return false;
		}
		
		EquationComponent comp = (EquationComponent) obj;
		
		if (this.isDouble != comp.isDouble()) {
			return false;
		}
		
		if (this.isInt != comp.isInt()) {
			return false;
		}
		
		if (comp.isDouble()) {
			if (comp.getConstantDouble() != this.constantDouble) {
				return false;
			}
		} else {
			if (comp.getConstantInt() != this.constantInt) {
				return false;
			}
		}
		
		return true;
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
	
	/***************************************
	 * 
	 * toString method
	 * 
	 * 
	 * 
	 * 
	 ***************************************/

	@Override
	public String toString() {
		return "EquationComponent [variable=" + variable + ", isInt=" + isInt + ", constantInt=" + constantInt
				+ ", isDouble=" + isDouble + ", constantDouble=" + constantDouble + "]";
	}
	
}
