package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The And Class represents the and function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class And implements Strategy {

	/**
	 * Removes the two top elements of state and performs the and logical operation
	 * on them
	 */
	@Override
	public void execute(State state) {
		double x = state.pop();
		double y = state.pop();
		if (x == 1.0 && y == 1.0)
			state.push(1.0);
		else
			state.push(0.0);
	}
}
