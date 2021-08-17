package equationSolver.equationSolver;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import equationSolver.equationSolver.linearEquationSolver.EquationComponent;
import equationSolver.equationSolver.linearEquationSolver.EquationSide;

@SpringBootTest
class EquationSolverApplicationTests {
	
	/***************************************
	 * EquationUtils.splitEquation() tests
	 * 
	 * 
	 * 
	 * 
	 * 
	 ***************************************/
	
	@Test
	@DisplayName("Test if string splitting on '=' works")
	void testSplitEquation() {
		String equation = "x+42=-4y+1-5+46+20";
		String[] splitEq = {"x+42", "-4y+1-5+46+20"};
		assertArrayEquals(splitEq, EquationUtils.splitEquation(equation));
	}
	
	@Test
	@DisplayName("'=' at index 0, equation split should return null")
	void testSplitEquationEqualIndexZero() {
		String incorrectEq = "=-4y+1-5+46+20";
		assertNull(EquationUtils.splitEquation(incorrectEq));
	}
	
	@Test
	@DisplayName("'=' at last index of equation, equation split should return null")
	void testSplitEquationEqualIndexLast() {
		String incorrectEq = "x+42=";
		assertNull(EquationUtils.splitEquation(incorrectEq));
	}
	
	@Test
	@DisplayName("Test that empty string returns null for equation split")
	void testSplitEquationEmptyString() {
		String emptyEq = "";
		assertNull(EquationUtils.splitEquation(emptyEq));
	}
	
	@Nested
	class EquationComponentTest {
		
		@Test
		@DisplayName("Test Equationcomponent constructor parses number - no variable")
		void testEquationComponentConstructor() {
			String component = "4";
			EquationComponent testComponent = new EquationComponent(component);
			assertEquals(4, testComponent.getComponentConst());
		}
	
	}
	
	
//	@Nested
//	class splitIntoComponentsTest {
//	
//		/********************************************
//		 * EquationSide.splitIntoComponents() Tests
//		 * 
//		 * 
//		 * 
//		 * 
//		 * 
//		 ********************************************/
//		
//		@Autowired
//		private ObjectFactory<EquationSide> sideFactory;
//		EquationSide side;
//		
//		@BeforeEach
//		void init() {
//			this.side = sideFactory.getObject();
//		}
//		
//		@Test
//		@DisplayName("Test for correct splitting of components")
//		void testSplitIntoComponents() {
//			String equationSide = "4x+50-5y";
//			ArrayList<EquationComponent> expectedList = new ArrayList<>();
//			EquationComponent toAdd = new EquationComponent
//			
//			side.splitIntoComponents(equationSide);
//			assertArrayEquals(side.getComponents(),)
//		}
//	
//	}
	
}
