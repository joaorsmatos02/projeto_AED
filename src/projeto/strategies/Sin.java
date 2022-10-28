package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Sin Class represents the Sin function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Sin implements Strategy {

	/**
	 * Gets the top element from state and pushes its sin value
	 */
	@Override
	public void execute(State state) {
		state.push(Math.sin(state.pop()));
	}

}