package equationSolver.equationSolver.linearEquationSolver;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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
	
	public EquationComponent() {}

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
