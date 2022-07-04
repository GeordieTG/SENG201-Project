
package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/** 
 * This class implements an enemy to be assigned to a battle
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class Enemy {

	/**
	 * ArrayList of possible enemy names
	 */
	private ArrayList<String> enemyNames = new ArrayList<String>(Arrays.asList("Richard", "Kourish", "Neville", "Miguel", "Walter", "Paul", "Andy", "Andreas", "Ramakrishnan", "Tim", "Andrew", "John199", "Daniel", "Henry", "Rhys", "DeShawn",
			"James", "Derek", "Isaac", "Mero", "Quinn", "Zeb", "Caleb", "Leo", "Mikey", "Mac", "Lachie", "Jed", "Bob", "Olivia", "Tiffany", "Brittney", "Emma", "Bronah", "Belinda", "Patricia", 
			"Jose", "Karen", "Sharon", "Larry", "Ronald", "Tom", "Timothy", "Madeline", "Margaret")); 
	
	/**
	 * List of the enemies team
	 */
	private Warrior[] enemyTeam = new Warrior[3];
	
	/**
	 * Name of enemy
	 */
	private String enemyName;
	
	/**
	 * Average level of the enemy team
	 */
	private double averageLevel;
	
	/**
	 * Constructor to create an enemy
	 * @param game Game Environment instance
	 * @param difficulty Difficulty of the enemy
	 */
	public Enemy(GameEnvironment game, String difficulty) {
		
		Random rng = new Random();
		this.enemyName = enemyNames.get(rng.nextInt(enemyNames.size()));
		setEnemyTeam(game, difficulty);
		this.averageLevel = (enemyTeam[0].getLevel() + enemyTeam[1].getLevel() + enemyTeam[2].getLevel())/3;
		
	}
	
	/**
	 * Gets the name of the enemy
	 * @return Name of enemy
	 */
	public String getName() {
		return enemyName;
	}
	
	/**
	 * Gets the average level of the enemy team
	 * @return Average level of team
	 */
	public double getAverageLevel(){
		
		return averageLevel;
		
	}

	/**
	 * Gets the enemy team
	 * @return Enemy team
	 */
	public Warrior[] getEnemyTeam() {
		
		return enemyTeam;
	
	}
	
	/**
	 * Forms a description for an enemy
	 * @param battle Battle enemy is assigned to
	 * @param difficultyMultiplier Scaler dependant of game difficulty
	 * @return Description of enemy
	 */
	public String getDescription(Battle battle, double difficultyMultiplier) {
		
		
		String description = "";
		description += ("Average Warrior Level ~ " + getAverageLevel());
		description += "\n";
		description += ("Reward: " + battle.getReward(getAverageLevel(), difficultyMultiplier));
		
		return description;
	}
	
	/**
	 * Sets the enemy team using random factors and factoring in difficulty for different battles
	 * @param game Game Environment instance
	 * @param difficulty Difficutly of the enemy
	 */
	public void setEnemyTeam(GameEnvironment game, String difficulty) {
			
		ArrayList<Warrior> warriors = new ArrayList<> (Arrays.asList(game.createReaper(null), game.createBarbarian(null), game.createWizard(null), game.createWitch(null), game.createSkeleton(null), 
				game.createWiseOldMan(null), game.createBadNewsBear(null), game.createArcher(null), game.createGhost(null)));
		
		Random rng = new Random();
		
		int minLevel = 0;
		int maxLevel = 0;
		
		
		// Scale the minimum level of the monster based on the current day, and difficulty
		if (difficulty == "Easy") {
			
			minLevel = game.getCurrentDay();
			
		} else if (difficulty == "Medium") {
			
			minLevel = game.getCurrentDay() + 2;
			
		} else if (difficulty == "Hard") {
			
			minLevel = game.getCurrentDay() + 4;
			
		}
		
		maxLevel = minLevel + 3;
		
		// Set enemy random warrior in slot 1
		int randomInt = rng.nextInt(9);
		enemyTeam[0] = warriors.get(randomInt);
		warriors.remove(randomInt);
		
		// Set the level for enemy random warrior in slot 1
		randomInt = rng.nextInt(minLevel, maxLevel);
		enemyTeam[0].setLevel(randomInt);
		
		randomInt = rng.nextInt(8);
		enemyTeam[1] = warriors.get(randomInt);
		warriors.remove(randomInt);
		
		randomInt = rng.nextInt(minLevel, maxLevel);
		enemyTeam[1].setLevel(randomInt);
		
		randomInt = rng.nextInt(7);
		enemyTeam[2] = warriors.get(randomInt);
		warriors.remove(randomInt);
		
		randomInt = rng.nextInt(minLevel, maxLevel);
		enemyTeam[2].setLevel(randomInt);
			
	}
	
	
	/**
	 * Resets the enemy stats, after a battle is lost, negating the effects applied in the previous battle
	 */
	public void resetEnemyStats() {
		
		
		// Restores the enemies stats after a battle
		for (int i=0;i<3;i++) {
			enemyTeam[i].setCurrentDamage(enemyTeam[i].getBaseDamage() + (50*enemyTeam[i].getLevel()-1));
			enemyTeam[i].setCurrentHealth(enemyTeam[i].getMaxHealth());
		}
	}
}
