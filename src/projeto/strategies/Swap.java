package projeto.strategies;

import projeto.draw.State;

/**
 * 
 * The Swap Class represents the swap function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
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
