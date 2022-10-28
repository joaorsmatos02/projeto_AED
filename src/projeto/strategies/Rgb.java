package projeto.strategies;

import projeto.draw.*;
import java.awt.Color;

/**
 * 
 * The Rgb Class represents the rgb function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Rgb implements Strategy {

	/**
	 * Removes the three top elements in state and sets a new rgb color using their
	 * values
	 */
	@Override
	public void execute(State state) {
		double b = state.pop();
		double g = state.pop();
		double r = state.pop();
		Color rgb = new Color((int) r, (int) g, (int) b);
		StdDraw.setPenColor(rgb);

	}
}
