package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Product Class represents the product function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Product implements Strategy {

	/**
	 * Removes the two top elements of state and pushes their product
	 */
	@Override
	public void execute(State state) {
		double y = state.pop();
		double x = state.pop();
		state.push(x * y);
	}

}
