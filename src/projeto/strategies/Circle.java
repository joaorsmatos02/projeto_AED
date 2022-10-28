package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Circle Class represents the circle function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Circle implements Strategy {

	/**
	 * Removes the top element of state and draws a circle with center on the
	 * current coordinates and radius of the obtained value
	 */
	@Override
	public void execute(State state) {
		double r = state.pop();
		double x = state.getX();
		double y = state.getY();
		if (state.isFill())
			StdDraw.filledCircle(x, y, r);
		else
			StdDraw.circle(x, y, r);
	}
}
