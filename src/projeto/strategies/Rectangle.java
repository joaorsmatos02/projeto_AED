package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Rectangle Class represents the rectangle function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Rectangle implements Strategy {

	/**
	 * Removes the two top elements of state and draws a rectangle using them and
	 * the current coordinates
	 */
	@Override
	public void execute(State state) {
		double w = state.pop();
		double h = state.pop();
		double x = state.getX();
		double y = state.getY();
		if (state.isFill())
			StdDraw.filledRectangle(x, y, 2 * w, 2 * h);
		else
			StdDraw.rectangle(x, y, w, h);
	}
}
