package moves;

import main.Warrior;

/** 
 * 
 * This class implements the Move interface, and is a move where the enemy warriors attack drops upon using.
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class WeakeningWhack implements Move{
	
	private String name = "WeakeningWhack";
	
	public String getName() {
		return name;
	}

	/**
	 * Get damage of move
	 * @return damage
	 */
	
	public double getDamage(Warrior playerWarrior) {
		
		// Less damage as it has effects
		return playerWarrior.getCurrentDamage()*0.75;
	}
	
	/**
	 * Use the move 
	 * @param playerWarrior Player warrior
	 * @param enemyWarrior Enemy warrior
	 */
	public void useMove(Warrior playerWarrior, Warrior enemyWarrior) {
		
		// DEBUFFS ENEMY ATTACK
		enemyWarrior.takeDamage(getDamage(playerWarrior));
		enemyWarrior.setCurrentDamage(Math.round(enemyWarrior.getCurrentDamage()*0.9));
		
	}
}
