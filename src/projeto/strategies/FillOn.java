package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The FillOn Class represents the fill on function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class FillOn implements Strategy {
	
	/**
	 * Toggles the fill function on
	 */
	@Override
	public void execute(State state) {
		state.setFill(true);
	}

}
