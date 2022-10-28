package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Point Class represents the point function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
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
