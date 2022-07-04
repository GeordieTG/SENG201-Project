

package moves;

import main.Warrior;

/** 
 * This class implements the Move interface, 
 * and is a move where the warrior simply damages the opponent.
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class Stab implements Move{

	// basic attack
	
	/**
	 * Name of the Move
	 */
	private String name = "Stab";
	
	public String getName() {
		return name;
	}
	
	public double getDamage(Warrior playerWarrior) {
		return playerWarrior.getCurrentDamage();
	}
	
	public void useMove(Warrior playerWarrior, Warrior enemyWarrior) {
		
		// BUFFS OWN HEALTH
		System.out.println();
		enemyWarrior.takeDamage(getDamage(playerWarrior));
		
	}
}