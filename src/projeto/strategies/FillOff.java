package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The FillOff class represents the fill off function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class FillOff implements Strategy {
	
	/**
	 * Toggles the fill function off
	 */
	@Override
	public void execute(State state) {
		state.setFill(false);
	}

}
