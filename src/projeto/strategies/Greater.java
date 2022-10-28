package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Greater Class represents the greater function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Greater implements Strategy {

	/**
	 * Removes the two elements on top of state and adds 1.0 to state if the top
	 * element is smaller than the other or 0.0 if it is larger
	 */
	@Override
	public void execute(State state) {
		double y = state.pop();
		double x = state.pop();
		if (x > y)
			state.push(1.0);
		else
			state.push(0.0);
	}
}
