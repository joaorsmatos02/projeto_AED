package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Not Class represents the not function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Not implements Strategy {

	/**
	 * Removes the top element from state and adds 1.0 if it was 0.0, or adds 0.0 in
	 * any other case
	 */
	@Override
	public void execute(State state) {
		double x = state.pop();
		if (x == 0.0)
			state.push(1.0);
		else
			state.push(0.0);
	}
}
