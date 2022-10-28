package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Division Class represents the division function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Division implements Strategy {

	/**
	 * Removes the two top elements of state and pushes the result of their division
	 */
	@Override
	public void execute(State state) {
		double y = state.pop();
		double x = state.pop();
		state.push(x / y);
	}
}
