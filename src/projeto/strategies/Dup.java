package projeto.strategies;

import projeto.draw.State;

/**
 * 
 * The Dup Class represents the dup function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
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
