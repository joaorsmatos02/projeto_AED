package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Move Class represents the move function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Move implements Strategy {

	/**
	 * Removes the two top elements of state and changes the current coordinates to
	 * the obtained values
	 */
	@Override
	public void execute(State state) {
		double y = state.pop();
		double x = state.pop();
		state.setXY(x, y);
	}
}
