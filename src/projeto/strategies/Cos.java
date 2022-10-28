package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Cos Class represents the cos function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
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
