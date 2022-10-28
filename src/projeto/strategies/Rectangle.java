package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Rectangle Class represents the rectangle function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
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
