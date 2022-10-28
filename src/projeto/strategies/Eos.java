package projeto.strategies;

import projeto.draw.State;

/**
 * 
 * The Eos Class represents the eos function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Eos implements Strategy {

	/**
	 * Adds 1.0 to the state if it is not empty or 0.0 if it is empty
	 */
	@Override
	public void execute(State state) {
		if (state.isEmpty())
			state.push(0.0);
		else
			state.push(1.0);
	}

}
