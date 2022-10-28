package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The FillOn Class represents the fill on function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
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
