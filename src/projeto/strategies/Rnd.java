package projeto.strategies;

import projeto.draw.*;
import java.util.Random;

/**
 * 
 * The Lesser Rnd represents the rnd function
 * 
 * @author Daniel Luís nº 56362
 * @author João Matos nº 56292
 * @author João Santos nº 57103
 *
 */

public class Rnd implements Strategy {

	/**
	 * Pushes a random number between 0.0 and 1.0 to state
	 */
	@Override
	public void execute(State state) {
		Random rd = new Random();
		state.push(rd.nextDouble());
	}
}
