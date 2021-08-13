package equationSolver.equationSolver.linearEquationSolver;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 
 * 
 * 
 * 
 * 
 */
@CrossOrigin
@Controller
@RequestMapping("/solve")
public class LinearEquationSolverHandler {
	
	/*
	 * Solves linear equation
	 */
	@RequestMapping(value = "/linearequation",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EquationHolder solveLinearEquation(@RequestBody EquationHolder equation) {
		System.out.println("First print in handler: " + equation);
		
		LinearEquationSolver solver = 
				new LinearEquationSolver(equation.getEquation());
		solver.solve();
		
		System.out.println("Second print in handler: " + solver.getEquation());
		System.out.println("y-intercept: " + solver.getyIntercept());
		System.out.println("slope: " + solver.getSlope());
		
		return solver.getEquation();
	}
	
}
