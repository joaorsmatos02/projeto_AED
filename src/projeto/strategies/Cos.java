package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Cos Class represents the cos function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Cos implements Strategy {

	/**
	 * Removes the top element of state and pushes its cos value
	 */
	@Override
	public void execute(State state) {
		state.push(Math.cos(state.pop()));
	}

}
