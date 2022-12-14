package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Or Class represents the or function
 * 
 * @author Daniel Lu?s n? 56362
 * @author Jo?o Matos n? 56292
 * @author Jo?o Santos n? 57103
 *
 */

public class Or implements Strategy {

	/**
	 * Performs a logical or operation on the two top elements of state
	 */
	@Override
	public void execute(State state) {
		double x = state.pop();
		double y = state.pop();
		if (x == 1.0 || y == 1.0)
			state.push(1.0);
		else
			state.push(0.0);
	}
}
