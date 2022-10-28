package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Rline Class represents the Rline function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Rline implements Strategy {

	/**
	 * Removes the two top values from state and draws a line between the current
	 * coordinates and those coordinates plus the obtained values
	 */
	@Override
	public void execute(State state) {
		double deltaY = state.pop();
		double deltaX = state.pop();
		double x = state.getX();
		double y = state.getY();
		StdDraw.line(x, y, x + deltaX, y + deltaY);
		state.setXY(x + deltaX, y + deltaY);
	}

}
