package microservice.equationSolver.linearEquationSolver;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EquationSide {
	
	/*
	 * Member variables
	 */
	private ArrayList<EquationComponent> components;
	private String charsToSplitOn = "+-";
	
	public EquationSide() {
		this.components = new ArrayList<>();
	}
	
	/*****************************************************
	 * Methods for splitting and processing the component
	 * instances
	 * 
	 * 
	 * 
	 * 
	 *****************************************************/
	
	/*
	 * Method to split the given side of the equation into its
	 * constituent components by storing all values into an 
	 * EquationComponent instance 
	 */
	public void splitIntoComponents(String eqSide) {
		int start = 0;
		int end = 0;
		while (true) {
			end = getSplitIndex(eqSide, end);
			createNewComponent(eqSide, start, end);
			
			if (end == -1) {
				break;
			} else {
				start = end;
			}
		}
	}
	
	/*
	 * Returns the index of where to split off the component
	 * Returns -1 if splitIndex is already at the end of the string
	 */
	private int getSplitIndex(String eq, int splitIndex) {
		if (splitIndex >= eq.length() - 1) {
			return -1;
		}
		
		for (int i = splitIndex; i < eq.length(); i++) {
			char c = eq.charAt(i);
			
			// only call it a split index if we encounter a symbol we are splitting
			// on and it is also not the first symbol we are checking because we 
			// want to include that symbol for our component
			if (this.charsToSplitOn.indexOf(c) != -1 && i != splitIndex) {
				splitIndex = i;
				break;
			} else if (i == eq.length() - 1) {
				splitIndex = i + 1;
			}
		}
		
		return splitIndex;
	}
	
	/*
	 * Creates a new instance of a component for this side of the
	 * equation given the index to split on
	 */
	private void createNewComponent(String eq, int start, int end) {
		if (end == -1) {
			return;
		}
		
		String component = eq.substring(start, end);
		this.components.add(new EquationComponent(component));
	}
	
	/******************************************************
	 * Getters and Setters
	 * 
	 * 
	 * 
	 * 
	 * 
	 ******************************************************/

	public ArrayList<EquationComponent> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<EquationComponent> components) {
		this.components = components;
	}
	
}
