package projeto.strategies;

import projeto.draw.*;

/**
 * 
 * The Lesser Class represents the lesser function
 * 
 * @author Daniel Lu�s n� 56362
 * @author Jo�o Matos n� 56292
 * @author Jo�o Santos n� 57103
 *
 */

public class Lesser implements Strategy {
	
	/**
	 * Removes the two elements on top of state and adds 1.0 to state if the top
	 * element is larger than the other or 0.0 if it is smaller
	 */
	@Override
	public void execute(State state) {
		double y = state.pop();
		double x = state.pop();
		if(x < y)
			state.push(1.0);
		else
			state.push(0.0);
	}
}