package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Square Class represents the square function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
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
