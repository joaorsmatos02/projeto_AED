package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Equals Class represents the equals function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Equals implements Strategy {

	/**
	 * Removes the two top elements in state and adds 1.0 to the state if they are
	 * equal or 0.0 if they are not
	 */
	@Override
	public void execute(State state) {
		double x = state.pop();
		double y = state.pop();
		if (x == y)
			state.push(1.0);
		else
			state.push(0.0);
	}

}
