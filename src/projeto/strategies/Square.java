package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Square Class represents the square function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Square implements Strategy {

	/**
	 * Removes the top element from state and draws a square using the current
	 * coordinates and the obtained number
	 */
	@Override
	public void execute(State state) {
		double r = state.pop();
		double x = state.getX();
		double y = state.getY();
		if (state.isFill())
			StdDraw.filledSquare(x, y, r);
		else
			StdDraw.square(x, y, r);
	}

}
