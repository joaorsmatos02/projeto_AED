package projeto.strategies;

import projeto.draw.State;

/**
 * 
 * The Swap Class represents the swap function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Swap implements Strategy {

	/**
	 * Swaps the two elements on top of state
	 */
	@Override
	public void execute(State state) {
		double a = state.pop();
		double b = state.pop();
		state.push(a);
		state.push(b);
	}

}
