package equationSolver.equationSolver.linearEquationSolver;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

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
	
	public String getRecvEquation() {
		return this.equation;
	}
}
