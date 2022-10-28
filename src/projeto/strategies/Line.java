package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Line Class represents the line function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Line implements Strategy {

	/**
	 * Removes the two top elements on state and draws a line between the current
	 * coordinates and the obtained values
	 */
	@Override
	public void execute(State state) {
		double currentX = state.getX();
		double currentY = state.getY();
		double y = state.pop();
		double x = state.pop();
		StdDraw.line(currentX, currentY, x, y);
		state.setXY(x, y);
	}
}
