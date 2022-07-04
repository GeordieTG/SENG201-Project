


package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import items.LevelUp;
import items.Potion;
import items.StatBooster;
import moves.AttackUppercut;
import moves.Stab;
import moves.WeakeningWhack;

/** 
 * This class implements key aspects of the game functionality, and keeps track of metrics such as score,
 * game length and current day. This class also contains functions to create instances of certain classes,
 * such as Warriors and items, and for the former, stores the base stats of these consequently. Functionality
 * is also implemented related to validity of strings and other end of day functions.
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class GameEnvironment {
	
	/**
	 * Length of the game specified by the player
	 */
	private int gameLength = 0;
	
	/**
	 * Scalar value depending on the player selected difficult, used to influence aspects of the game such 
	 * as beans earned from battles
	 */
	private double difficultyMultiplier;
	
	/**
	 * Current day of the game
	 */
	private int currentDay = 1;
	/**
	 * Number of battles completed today (maximum of three)
	 */
	private int battlesCompletedToday = 0;
	/**
	 * Number of points gained today
	 */
	private double pointsGainedToday = 0;
	/**
	 * Total points gained during the game
	 */
	private double points = 0;
	
	/**
	 * List of all warriors to be selected from randomly if a new monster joins overnight
	 */
	private ArrayList<Warrior> warriors;
	
	/**
	 * Sets the points of the game
	 * @param points New number of points to be added to score
	 */
	public void setPoints(double points) {
		this.points = (Math.round(points));
		
	}
	
	/**
	 * Gets the number of points of the game
	 * @return Number of points
	 */
	public double getPoints() {
		return points;
	}

	/**
	 * Gets the number of pointed gained today
	 * @return Number of points gained today
	 */
	public double getPointsGainedToday() {
		return pointsGainedToday;
	}
	
	/**
	 * Sets the number of points gained today
	 * @param pointsGainedToday New value of points gained today
	 */
	public void setPointsGainedToday(double pointsGainedToday) {
		this.pointsGainedToday = pointsGainedToday;
	}
	
	/**
	 * Get the length of the game 
	 * @return Length of game
	 */
	public int getGameLength() {
		return gameLength;
	}
	
	/**
	 * Set the length of the game
	 * @param gameLength Specified length of the game
	 */
	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}
	
	/**
	 * Set the current day
	 * @param day New current day
	 */
	public void setCurrentDay(int day) {
		this.currentDay = day;
	}
	
	/**
	 * Get the current day
	 * @return Current day
	 */
	public int getCurrentDay() {
		return currentDay;
	}

	/**
	 * Get the number of battles completed today
	 * @return Number of battles completed today
	 */
	public int getBattlesCompletedToday() {
		return battlesCompletedToday;
	}
	
	/**
	 * Set the number of battles completed today
	 * @param battlesCompletedToday New number of battles completed today
	 */
	public void setBattlesCompletedToday(int battlesCompletedToday) {
		this.battlesCompletedToday = battlesCompletedToday;
	}
	
	/**
	 * Get the difficulty multiplier of the game
	 * @return Difficulty multipler
	 */
	public double getDifficultyMultiplier() {
		return difficultyMultiplier;
	}
	
	/**
	 * Set the difficulty multiplier
	 * @param difficulty New difficulty multiplier
	 */
	public void setDifficultyMultiplier(double difficulty){
		difficultyMultiplier = difficulty;
	}
	
	
	// Warrior STATS
	
	/**
	 * Create an instance of Warrior, passing in stats of a 'Reaper' Warrior. 
	 * @param nickname Nickname of the Warrrior (selected by player)
	 * @return New Warrior object
	 */
	public Warrior createReaper(String nickname) {
		// Creates a Reaper
		if (nickname == null) nickname = "Reaper";
		Warrior warrior = new Warrior("Reaper", nickname, 500, 500, 100, 100, 1, 500, new Stab(), new WeakeningWhack(), "/images/Reaper.png");
		return warrior;
	}
	
	/**
	 * Create an instance of Warrior, passing in stats of a 'Archer' Warrior. 
	 * @param nickname Nickname of the Warrrior (selected by player)
	 * @return New Warrior object
	 */
	public Warrior createArcher(String nickname) {
		// Creates a Archer
		if (nickname == null) nickname = "Archer";
		Warrior warrior = new Warrior("Archer", nickname, 550, 550, 115, 115, 1, 500, new Stab(), new AttackUppercut(), "/images/Archer.png");
		return warrior;
	}
	
	/**
	 * Create an instance of Warrior, passing in stats of a 'BadNewsBear' Warrior. 
	 * @param nickname Nickname of the Warrrior (selected by player)
	 * @return New Warrior object
	 */
	public Warrior createBadNewsBear(String nickname) {
		// Creates a BadNewsBear
		if (nickname == null) nickname = "BadNewsBear";
		Warrior warrior = new Warrior("BadNewsBear", nickname, 600, 600, 125, 125, 1, 500, new Stab(), new WeakeningWhack(), "/images/BadNewsBear.png");
		return warrior;
	}
	
	/**
	 * Create an instance of Warrior, passing in stats of a 'Barbarian' Warrior. 
	 * @param nickname Nickname of the Warrrior (selected by player)
	 * @return New Warrior object
	 */
	public Warrior createBarbarian(String nickname) {
		// Creates a Barbarian
		if (nickname == null) nickname = "Barbarian";
		Warrior warrior = new Warrior("Barbarian", nickname, 500, 500, 100, 100, 1, 500, new Stab(), new WeakeningWhack(), "/images/Barbarian.png");
		return warrior;
	}
	
	/**
	 * Create an instance of Warrior, passing in stats of a 'Ghost' Warrior. 
	 * @param nickname Nickname of the Warrrior (selected by player)
	 * @return New Warrior object
	 */
	public Warrior createGhost(String nickname) {
		// Creates a Ghost
		if (nickname == null) nickname = "Ghost";
		Warrior warrior = new Warrior("Ghost", nickname, 550, 550, 115, 115, 1, 500, new Stab(), new AttackUppercut(), "/images/Ghost.png");
		return warrior;
	}
	
	/**
	 * Create an instance of Warrior, passing in stats of a 'WiseOldMan' Warrior. 
	 * @param nickname Nickname of the Warrrior (selected by player)
	 * @return New Warrior object
	 */
	public Warrior createWiseOldMan(String nickname) {
		// Creates a WiesOldMan
		if (nickname == null) nickname = "WiseOldMan";
		Warrior warrior = new Warrior("WiseOldMan", nickname, 600, 600, 125, 125, 1, 500, new AttackUppercut(), new WeakeningWhack(), "/images/WiseOldMan.png");
		return warrior;
	}
	
	/**
	 * Create an instance of Warrior, passing in stats of a 'Wizard' Warrior. 
	 * @param nickname Nickname of the Warrrior (selected by player)
	 * @return New Warrior object
	 */
	public Warrior createWizard(String nickname) {
		// Creates a Wizard
		if (nickname == null) nickname = "Wizard";
		Warrior warrior = new Warrior("Wizard", nickname, 500, 500, 100, 100, 1, 500, new Stab(), new WeakeningWhack(), "/images/Wizard.png");
		return warrior;
	}
	
	/**
	 * Create an instance of Warrior, passing in stats of a 'Skeleton' Warrior. 
	 * @param nickname Nickname of the Warrrior (selected by player)
	 * @return New Warrior object
	 */
	public Warrior createSkeleton(String nickname) {
		// Creates a Skeleton
		if (nickname == null) nickname = "Skeleton";
		Warrior warrior = new Warrior("Skeleton", nickname, 550, 550, 115, 115, 1, 500, new Stab(), new AttackUppercut(), "/images/Skeleton.png");
		return warrior;
	}

	/**
	 * Create an instance of Warrior, passing in stats of a 'Witch' Warrior. 
	 * @param nickname Nickname of the Warrrior (selected by player)
	 * @return New Warrior object
	 */
	public Warrior createWitch(String nickname) {
		// Creates a Witch
		if (nickname == null) nickname = "Witch";
		Warrior warrior = new Warrior("Witch", nickname, 600, 600, 125, 125, 1, 500, new Stab(), new WeakeningWhack(), "/images/Witch.png");
		return warrior;
	}
		
	/**
	 * Create an instance of Potion, passing in stats for a 'Small Potion' Potion
	 * @return new Potion object
	 */
	public Potion createSmallPotion() {
		Potion potion = new Potion("Small Potion", 500, 25);
		return potion;
	}
	
	/**
	 * Create an instance of Potion, passing in stats for a 'Medium Potion' Potion
	 * @return new Potion object
	 */
	public Potion createMediumPotion() {
		Potion potion = new Potion("Medium Potion", 1000, 50);
		return potion;
	}
	
	/**
	 * Create an instance of Potion, passing in stats for a 'Large Potion' Potion
	 * @return new Potion object
	 */
	public Potion createLargePotion() {
		Potion potion = new Potion("Large Potion", 2000, 75);
		return potion;
	}
	
	/**
	 * Create an instance of StatBooster, passing in stats for an 'Attack Boost' StatBooster
	 * @return new StatBooster object
	 */
	public StatBooster createAttackBoost() {
		StatBooster statBooster = new StatBooster("Attack Boost", 1.5, "attack", 100);
		return statBooster;
	}
	
	/**
	 * Create an instance of StatBooster, passing in stats for an 'Health Boost' StatBooster
	 * @return new StatBooster object
	 */
	public StatBooster createHealthBoost() {
		StatBooster statBooster = new StatBooster("Health Boost", 1.5, "health", 50);
		return statBooster;
	}
	
	/**
	 * Create an instance of LevelUp, passing in corresponding price
	 * @return new LevelUp object
	 */
	public LevelUp createLevelUp() {
		LevelUp levelUp = new LevelUp(100);
		return levelUp;
	}
	
	
	/**
	 * Determines whether the given string is valid (letters of alphabet, 3-15 characters)
	 * @param name String in question
	 * @return Whether of not the string is valid
	 */
	public boolean validString(String name) {
		// Checks that the string is valid
		boolean valid = true;
		    
		//Checks to see if the name contains invalid characters    
		    if(!name.matches("^[a-zA-Z]*$")) {
		    	valid = false;
		    }

		    if(name.length() < 3 | name.length() > 15) {
		    	valid = false;
		    }    
	
		return valid;
	}
	
	/**
	 * Determines based on the Warriors the player has left, and their balance, 
	 * whether the game can not continue and should end
	 * @param player Player of game
	 * @param store Instance of store
	 * @return Whether or not the game should end
	 */ 
	public boolean shouldEndGame(Player player, Store store) {
		
		// Returns whether or not the game should end, this occurs when player has no monsters and not enough gold to buy another.
		
		double minimumWarriorPrice = Double.POSITIVE_INFINITY;
		
		// For each warrior in the store, check if it can be afforded by the player
		for(int i=0;i<3;i++) {
			if (store.getStoreWarrior(i+1) != null && store.getStoreWarrior(i+1).getValue() < minimumWarriorPrice){
				minimumWarriorPrice = store.getStoreWarrior(i+1).getValue();
			}
		}
		
		// If the player has no Warriors left in their team, and can't afford any in the store, return true
		if (player.getTeam().size() == 0) {
			if (player.getBeans() < minimumWarriorPrice) {
				return true;
			} 	
		}
		// Otherwise the game should not end, return false
		return false;
		
	}
	
	/**
	 * Implements the events that should take place when the day has ended and a new day is starting,
	 * including random overnight events (Warriors can leave, join, or level up).Also calls relevant
	 * functions for resetting/re-randomizing the game state for the next day.
	 * @param player Player of game
	 * @param game Game Environment instance
	 * @param store Store instance
	 * @param battleHub BattleHub instance
	 * @return The message that should be displayed to the user depending on what happened overnight
	 */
	public String endDay(Player player, GameEnvironment game, Store store, BattleHub battleHub) {

		// Returns a String containing a description of what happened overnight
		
		warriors = new ArrayList<> (Arrays.asList(game.createReaper(null), game.createBarbarian(null), game.createWizard(null), game.createWitch(null), game.createSkeleton(null), 
				game.createWiseOldMan(null), game.createBadNewsBear(null), game.createArcher(null), game.createGhost(null)));
		
		String description = "";
		
		Random rng = new Random();
		
		// RANDOM WARRIOR LEAVES
		int randomInt;
		
		// MONSTER LEAVES
		for(int i=0;i<player.getTeam().size();i++) {
			if (player.getTeam().get(i).getHasFaintedToday()){
				// If monster has fainted today, 1/15 chance to leave
				randomInt = rng.nextInt(15);
				player.getTeam().get(i).setHasFaintedToday(false);
			} else {
				// Otherwise 1/30 chance to leave
				randomInt = rng.nextInt(30);
			}
			
			if (randomInt == 1) {
				description += (player.getTeam().get(i).getNickname() + " left overnight!\n");
				player.getTeam().remove(i);
			}
		}
		
		// NEW MONSTER JOINS
		for(int i=0; i<4-player.getTeam().size();i++) {
			randomInt = rng.nextInt(15);
			if (randomInt == 1) {
				// Get a random Warrior
				randomInt = rng.nextInt(9);
				Warrior newWarrior = warriors.get(randomInt);
				newWarrior.setLevel(game.getCurrentDay());
				player.getTeam().add(newWarrior);
				description += (newWarrior.getType() + " join your team overnight!\n");
			}
		}
		
		// LEVEL UP
		for(int i=0;i<player.getTeam().size();i++) {
			randomInt = rng.nextInt(10);
			
			if (randomInt == 1) {
				player.getTeam().get(i).levelUp();
				description += (player.getTeam().get(i).getNickname() + " levelled up overnight!\n");
			}
		}
		
		// Run other functions to reset/re-randomize state of game
		
		player.healTeam();
		
		store.resetStore(game);
		
		battleHub.resetBattleHub(player.getTeam(), game);
		
		game.setPointsGainedToday(0);
		
		game.setBattlesCompletedToday(0);
		
		// Update the current day
		setCurrentDay(getCurrentDay() + 1);
		
		return description;
		
	}
}
