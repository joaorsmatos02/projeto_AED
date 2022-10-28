package projeto.strategies;

import projeto.draw.State;

/**
 * 
 * The Pop Class represents the pop function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Pop implements Strategy {

	/**
	 * Removes the top element of state
	 */
	@Override
	public void execute(State state) {
		state.pop();
	}
}
