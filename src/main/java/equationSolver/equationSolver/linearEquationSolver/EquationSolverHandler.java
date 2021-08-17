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
public class EquationSolverHandler {
	
	/*
	 * Solves linear equation
	 */
	@RequestMapping(value = "/linearequation",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EquationHolder solveLinearEquation(@RequestBody EquationHolder equation) {
		
		System.out.println(equation.getEquation());
		
		return new EquationHolder();
	}
	
}
