package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Power class represents the power function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Power implements Strategy {

	/**
	 * Removes the two top elements of state, raises the second one to the power of
	 * the first and pushes the result
	 */
	@Override
	public void execute(State state) {
		double y = state.pop();
		double x = state.pop();
		state.push(Math.pow(x, y));
	}

}
