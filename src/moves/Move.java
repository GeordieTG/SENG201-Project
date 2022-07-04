
package moves;

import main.Warrior;

/** 
 * Interface for a move, to be assigned to a Warrior to use in battle
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public interface Move {
	
	
	/**
	 * Gets the name of the move
	 * @return Move name
	 */
	public String getName();
	
	/**
	 * Uses the move
	 * @param playerWarrior Warrior the move is being used by
	 * @param enemyWarrior Warrior the move is being used against
	 */
	public void useMove(Warrior playerWarrior, Warrior enemyWarrior);
	
	/**
	 * Gets the damage the move deals
	 * @param playerWarrior Warrior using the move
	 * @return Move's damage
	 */
	public double getDamage(Warrior playerWarrior);
}
