package projeto.strategies;

import projeto.draw.State;

/**
 * 
 * The Dup Class represents the dup function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Dup implements Strategy {

	/**
	 * Duplicates the top of state
	 */
	@Override
	public void execute(State state) {
		state.push(state.peek());
	}
}
