
package moves;

import main.Warrior;

/** 
 * This class implements the Move interface, and is a move where the warriors attack is boosted upon using.
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class AttackUppercut implements Move {
	
	/**
	 * The name of the move
	 */
	private String name = "AttackUppercut";

	
	/**
	 * Returns the name of the move
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the damage of the move
	 * 
	 * @param playerWarrior The Warrior using the move
	 * @return The damage of the move 
	 */
	public double getDamage(Warrior playerWarrior) {
		
		// Deal a smaller amount of damage for this move
		return playerWarrior.getCurrentDamage()*0.75;
		
	}
	
	/**
	 * Uses the move and applies the resulting changes to health and/or attack
	 * 
	 * @param playerWarrior			The Warrior using the move
	 * @param enemyWarrior			The Warrior the move is being used against
	 */
	
	public void useMove(Warrior playerWarrior, Warrior enemyWarrior) {
		// Enemy takes damage, update players attack stat
		enemyWarrior.takeDamage(getDamage(playerWarrior));
		playerWarrior.setCurrentDamage(Math.round(playerWarrior.getCurrentDamage()*1.1));	
	}
}
