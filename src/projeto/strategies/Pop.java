package projeto.strategies;

import projeto.draw.State;

/**
 * 
 * The Pop Class represents the pop function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
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
