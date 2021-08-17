package equationSolver.equationSolver;


/***************************************************************************
 * Utility class to provide common functionality between different equation
 * solvers
 * 
 *
 *
 *
 ***************************************************************************/
public class EquationUtils {

	/*
	 * Splits a given equation on the equals sign, returns String array
	 * with 0 index being left side of equation and 1 index being right
	 * side of the equation
	 */
	public static String[] splitEquation(String equation) {
		String[] eqArray = new String[2];
		
		int equalIndex = 0;
		for (int i = 0; i < equation.length(); i++) {
			char c = equation.charAt(i);
			
			if (c == '=') {
				equalIndex = i;
				break;
			}
		}
		
		eqArray[0] = equation.substring(0, equalIndex);
		eqArray[1] = equation.substring(equalIndex + 1);
		return eqArray;
	}
	
}
