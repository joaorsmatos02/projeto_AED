package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Product Class represents the product function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
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
