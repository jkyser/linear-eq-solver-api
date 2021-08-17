package equationSolver.equationSolver.linearEquationSolver;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EquationComponent {
	
	/*
	 * Member variables
	 */
	private boolean containsVariable;
	private String variable;
	private int componentConst;
	
	public EquationComponent() {}
	
}
