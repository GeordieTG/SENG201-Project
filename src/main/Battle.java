package main;
import java.util.ArrayList;
import java.util.Random;

/** 
 * This class implements the functionality of a battle
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class Battle {

	/** 
	 * Reference to players team
	 * */
	private ArrayList<Warrior> playerTeam = new ArrayList<Warrior>();
	
	/**
	 * Team index of the current player warrior battling
	 */
	private int activePlayerWarriorIndex;
	
	/**
	 * Enemy of the battle
	 */
	private Enemy enemy;
	
	/**
	 * Team index of the current player warrior battling
	 */
	private int activeEnemyWarriorIndex;
	
	/**
	 * Stores whether the battle has been completed
	 */
	private boolean battleCompleted;


	/**
	 * Battle constructor
	 * @param playerTeam Player team
	 * @param game Game Environment instance
	 * @param difficulty Game difficulty
	 */
	public Battle(ArrayList<Warrior> playerTeam, GameEnvironment game, String difficulty) {
		
		this.playerTeam = playerTeam;
		this.battleCompleted = false;
		this.enemy = new Enemy(game, difficulty);
		this.activePlayerWarriorIndex = 0;
		this.activeEnemyWarriorIndex = 0;
		
	}


	/**
	 * 
	 * @return Enemy of the battle
	 */
	public Enemy getEnemy() {
		return enemy;
	}
	
	/**
	 * 
	 * @return Whether battle has been completed
	 */
	public boolean getBattleCompleted() {
		return battleCompleted;
	}
	
	/**
	 * 
	 * @return Index of active player warrior
	 */
	public Warrior getActivePlayerWarrior() {
		return playerTeam.get(activePlayerWarriorIndex);
	}
	
	/**
	 * 
	 * @return Index of active enemy monster
	 */
	public Warrior getActiveEnemyWarrior() {
		return enemy.getEnemyTeam()[activeEnemyWarriorIndex];
	}
	
	/**
	 * 
	 * @param player Games player
	 */
	public void setNextPlayerWarrior(Player player) {
		// Find the next Warrior that isn't 0HP to use in battle
		for(int i = activePlayerWarriorIndex; i<player.getTeam().size(); i+=1) {
			if (!(player.getTeam().get(i).getCurrentHealth() < 0.001)) {
				activePlayerWarriorIndex = i;
				break;
			}
		}
	}
	
	/**
	 * Increments the active enemy index to the next warrior
	 */
	public void setNextEnemyWarrior() {
		// Increments the warrior the enemy is using
		this.activeEnemyWarriorIndex += 1;
	}
	
	/**
	 * 
	 * @return Players team
	 */
	public ArrayList<Warrior> getPlayerTeam(){
		return playerTeam;
	}
	
	/**
	 * 
	 * @param battleCompleted Whether battle has been completed
	 */
	public void setBattleCompleted(boolean battleCompleted) {
		this.battleCompleted = battleCompleted;
	}
	
	/**
	 * Calculates the reward for a battle
	 * @param averageLevel Average level of the enemy team
	 * @param difficultyMultiplier Scalar depending on difficulty
	 * @return Reward of the battle in beans
	 */
	public double getReward(double averageLevel, double difficultyMultiplier) {
		// Calculate reward
		double reward = Math.round((100*difficultyMultiplier)*averageLevel);
		return reward;
	}
	
	
	/**
	 * Calculates the points gained from winning the battle
	 * @param averageLevel Average level of the enemy team
	 * @param difficultyMultiplier Scalar depending on difficulty
	 * @return Number of points to be gained
	 */
	public double getPointsReward(double averageLevel, double difficultyMultiplier) {
		// Calculate point reward
		double reward = Math.round(100*(1/difficultyMultiplier)*averageLevel);
		return reward;
	}
	
	
	// MAIN FUNCTIONS
	
	/**
	 * Determines whether the current player Warrior is alive
	 * @return Whether the Warrior is alive
	 */
	public boolean playerWarriorAlive() {
		return !(getActivePlayerWarrior().getCurrentHealth() < 0.001);
	}
	
	/**
	 * Determines whether the current player Warrior is alive
	 * @return Whether the Warrior is alive
	 */
	public boolean enemyWarriorAlive() {
		return !(getActiveEnemyWarrior().getCurrentHealth() < 0.001);
	}
	
	/**
	 * Determines whether the player has more alive Warriors to battle
	 * @return Whether the player has more Warriors
	 */
	public boolean playerHasMoreWarriors() {
		// Returns whether the player has more warriors to use after the current one
		
		for(int i=0;i<playerTeam.size();i++) {
			if (playerTeam.get(i).getCurrentHealth() != 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Determines whether the enemy has more alive Warriors to battle
	 * @return Whether the enemy has more Warriors
	 */
	public boolean enemyHasMoreWarriors() {
		// Return whether enemy has more warriors remaining after the current one
		// NOTE* Enemy team size is always 3
		return (activeEnemyWarriorIndex) < 2;
	}
	
	/**
	 * Implements the events that occur when a players turn occurs
	 * @param moveSelection Index of move selected to use
	 * @param player Player of the game
	 * @param game Game Environment instance
	 * @return Outcome of the battle - 0 = Player killed enemy warrior but they have more, 1 = Player didn't kill enemy warrior, 2 = Game won
	 */
	public int playerMove(int moveSelection, Player player, GameEnvironment game) {
		
		// Returns an integer corresponding to the outcome of the turn
		// 0 = Player killed enemy warrior but they have more, 1 = Player didn't kill enemy warrior, 2 = game won
		
		Warrior playerWarrior = getActivePlayerWarrior();
		Warrior enemyWarrior = getActiveEnemyWarrior();
		
		// PLAYER USES MOVE
		playerWarrior.getMove(moveSelection - 1).useMove(playerWarrior, enemyWarrior);
		
		if (!enemyWarriorAlive()) {
			// You killed enemy warrior.
			
			// if they don't have more warriors
			if (!enemyHasMoreWarriors()) {
				battleCompleted = true;
				// Increments the battles completed for the day
				
				return 2;
			// If they do
			} else {
				setNextEnemyWarrior();
				return 0;
			}
		}
		return 1;
	}
	
	/**
	 * Implements the events that occur when an enemy turn occurs
	 * @param player Player of Game
	 * @param game Game Environment instance
	 * @return Outcome of the battle - 0 = Enemy killed player warrior but they have more, 1 = Enemy didn't kill player warrior, 2 = game lost
	 */
	public int enemyMove(Player player, GameEnvironment game) {
		
		// Returns an integer corresponding to the outcome of the turn
		// 0 = Enemy killed player warrior but they have more, 1 = Enemy didn't kill player warrior, 2 = game lost
		
		Warrior playerWarrior = getActivePlayerWarrior();
		Warrior enemyWarrior = getActiveEnemyWarrior();
		
		Random rng = new Random();
		
		enemyWarrior.getMove(rng.nextInt(1)).useMove(enemyWarrior, playerWarrior);
		
		// If this player warrior is still alive after the turn
		if (!playerWarriorAlive()) {
			
			if (!playerHasMoreWarriors()) {
				battleCompleted = true;
				return 2;
				
			} else {
				setNextPlayerWarrior(player);
				return 0;
			}
		}
		
		return 1;
	}
	
	
	/**
	 * Implements the events that occur when a battle in won
	 * @param beansGained Number of beans gained from the battle
	 * @param pointsGained Number of points gained from the battle
	 * @param player Player of Game
	 * @param game Game Environment instance
	 */
	public void battleWon(double beansGained, double pointsGained, Player player, GameEnvironment game) {
		
		// Call setters for player/game attributes to update them according to the rewards from battle.
		// Also update the values such as number of battles completed today
		game.setBattlesCompletedToday(game.getBattlesCompletedToday() + 1);
		player.setBeans(player.getBeans() + beansGained);
		player.setTotalBeansGainedToday(player.getTotalBeansGained() + beansGained);
		game.setPoints(game.getPoints() + pointsGained);
		game.setPointsGainedToday(game.getPointsGainedToday() + pointsGained);
		
	}
	
	/**
	 * Implements the events that occur when a battle is lost
	 * @param game Game Environment instance
	 */
	public void battleLost(GameEnvironment game) {
		
		// Only update the battles completed today - no rewards are granted
		game.setBattlesCompletedToday(game.getBattlesCompletedToday() + 1);
		
	}

}

