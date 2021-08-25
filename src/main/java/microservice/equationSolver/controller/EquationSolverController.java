package microservice.equationSolver.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import microservice.equationSolver.linearEquationSolver.EquationHolder;

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
public class EquationSolverController {
	
	/*
	 * Solves linear equation
	 */
	@RequestMapping(value = "/linearequation",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EquationHolder solveLinearEquation(@RequestBody EquationHolder equation) {
		
		equation.solveYMXBform();
		return equation;
	}
	
}
