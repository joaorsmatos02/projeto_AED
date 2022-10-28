package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Power class represents the power function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Power implements Strategy {

	/**
	 * Removes the two top elements of state, raises the second one to the power of
	 * the first and pushes the result
	 */
	@Override
	public void execute(State state) {
		double y = state.pop();
		double x = state.pop();
		state.push(Math.pow(x, y));
	}

}
