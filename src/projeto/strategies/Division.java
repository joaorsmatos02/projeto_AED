package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Division Class represents the division function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Division implements Strategy {

	/**
	 * Removes the two top elements of state and pushes the result of their division
	 */
	@Override
	public void execute(State state) {
		double y = state.pop();
		double x = state.pop();
		state.push(x / y);
	}
}
