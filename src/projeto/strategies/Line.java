package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Line Class represents the line function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
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
