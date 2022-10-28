package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Point Class represents the point function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Point implements Strategy {

	/**
	 * Removes the two numbers on top of state and uses them as coordinates to draw
	 * a point
	 */
	@Override
	public void execute(State state) {
		double y = state.pop();
		double x = state.pop();
		StdDraw.point(x, y);
	}

}
