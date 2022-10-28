package projeto.strategies;

import projeto.draw.State;

/**
 * 
 * The Size Class represents the size function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Size implements Strategy {

	/**
	 * Pushes to the current size of state to itself
	 */
	@Override
	public void execute(State state) {
		state.push((double) state.size());
	}

}
