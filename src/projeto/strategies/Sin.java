package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Sin Class represents the Sin function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
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