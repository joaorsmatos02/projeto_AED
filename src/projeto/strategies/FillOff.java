package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The FillOff class represents the fill off function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
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
