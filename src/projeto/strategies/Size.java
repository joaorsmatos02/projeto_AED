package projeto.strategies;

import projeto.draw.State;

/**
 * 
 * The Size Class represents the size function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
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
