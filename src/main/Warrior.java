

package main;
import java.util.ArrayList;

import moves.Move;

/** 
 * Class for a Warrior, which is a member of either a players team, or the store. Warriors have moves, which allow it to
 * damage other Warriors in battle, and can have Items used on them to have an effect on their stats. 
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class Warrior {
	
	/**
	 * Type of the Warrior
	 */
	private String type;
	/**
	 * Nickname of the Warrior
	 */
	private String nickname;
	/**
	 * Maximum Health of the Warrior
	 */
	private double maxHealth;
	/**
	 * Current Health of the Warrior
	 */
	private double currentHealth;
	/**
	 * Base damage stat of the Warrior
	 */
	private double baseDamage;
	/**
	 * Current damage the Warrior deals
	 */
	private double currentDamage;
	/**
	 * Level of the Warrior. When this is increased, the stats of the Warrior increase
	 */
	private int level;
	/**
	 * Determines whether the attack of a Warrior is currently boosted
	 */
	private boolean boostedAttack;
	/**
	 * Determines whether the health of a Warrior is currently Boosted
	 */
	private boolean boostedHealth;
	/**
	 * Value, in beans, of the Warrior
	 */
	private double value;
	/**
	 * Filepath of the Warriors image
	 */
	private String image;
	/**
	 * Determines whether the Warrior has fainted today
	 */
	private boolean hasFaintedToday;
	
	/**
	 * Moves of the Warrior
	 */
	private Move[] moves = new Move[2];
	
	
	/**
	 * Constructor of a Warrior
	 * @param type Type
	 * @param nickname Nickname
	 * @param maxHealth Maximum Health
	 * @param currentHealth Current Health
	 * @param baseDamage Base Damage stat
	 * @param currentDamage Current damage the Warrior deals
	 * @param level Initial Level
	 * @param value Value in beans of the Warrior
	 * @param move1 Warriors first move
	 * @param move2 Warriors second move 
	 * @param image Filepath of the Warriors image
	 */
	public Warrior(String type, String nickname, double maxHealth, double currentHealth, double baseDamage, double currentDamage, int level, double value, Move move1, Move move2, String image) {
		this.type = type;
		this.nickname = nickname;
		this.maxHealth = maxHealth;
		this.currentHealth = currentHealth;
		this.baseDamage = baseDamage;
		this.currentDamage = currentDamage;
		this.value = value;
		this.level = level;
		this.moves[0] = move1;
		this.moves[1] = move2;
		this.image = image;
		this.hasFaintedToday = false;
	}
	
	/**
	 * Get the type of the Warrior
	 * @return Warrior type
	 */
	public String getType(){
		return this.type;
	}
	
	/**
	 * Get the nickname of the Warrior
	 * @return Nickanme
	 */
	public String getNickname() {
		return this.nickname;
	}
	
	/**
	 * Set the current damage of the Warrior
	 * @param damage New damage of the Warrior
	 */
	public void setCurrentDamage(double damage) {
		this.currentDamage = damage;		
	}
	
	/**
	 * Get the max health of the Warrior
	 * @return Max Health
	 */
	public double getMaxHealth() {
		return this.maxHealth;
	}
	
	/**
	 * Get the current health of the Warrior
	 * @return Current Health
	 */
	public double getCurrentHealth() {
		return this.currentHealth;
	}
	
	/**
	 * Set the type of the Warrior
	 * @param type Type
	 */
	public void setType(String type) {
	    this.type = type;
	}

	/**
	 * Set the nickname of the Warrior
	 * @param nickname new Nickname
	 */
	public void setNickname(String nickname) {
	    this.nickname = nickname;
	}

	/**
	 * Set the max health of the Warrior
	 * @param maxHealth Maximum health
	 */
	public void setMaxHealth(double maxHealth) {
	    this.maxHealth = maxHealth;
	}

	/**
	 * Set the current health of the Warrior
	 * @param currentHealth New current health
	 */
	public void setCurrentHealth(double currentHealth) {
	    this.currentHealth = currentHealth;
	}
	
	/**
	 * Get the base damage of the Warrior
	 * @return base damage
	 */
	public double getBaseDamage() {
		return baseDamage;
	}
	
	/**
	 * Set the base damage of the Warrior
	 * @param baseDamage new base damage
	 */
	public void setBaseDamage(double baseDamage) {
		this.baseDamage = baseDamage;
	}
	
	/**
	 * Get the Warriors level
	 * @return Level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Set the level of the Warrior, and level it up the appropriate number of times
	 * @param level New level
	 */
	public void setLevel(int level) {
		
		int currentLevel = this.level;
		
		for (int i=0; i<(level-currentLevel); i++) {
			levelUp();
		}
	}
	
	
	/**
	 * Get the value of the Warrior
	 * @return Value
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Set the value of the Warrior
	 * @param value new value
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * Get the filepath of the Warriors image
	 * @return image filepath
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Level up the Warrior to the next level
	 */
	public void levelUp() {
		level += 1;
		maxHealth += 50;
		currentHealth += 50;
		currentDamage += 50;
		value += 100;
		
	}
	
	/**
	 * Form a description for the Warrior, based on its attributes
	 * @return Description
	 */
	public String getDescription() {
		
		String description = "";
		description += (type)+ "\n";
		if (nickname != type) description += ("(" + nickname + ")\n");
		description += ("Level: " + level + " ($" + value + ")");
		description += "\n";
		description += (currentDamage + " Damage");
		description += "\n";
		description += (currentHealth + "/" + maxHealth + "HP");
		description += "\n";
		return description;

	}
	
	
	/**
	 * Get whether the Warrior has boosted attack
	 * @return Whether Warrior has boosted attack
	 */
	public boolean getBoostedAttack() {
		return boostedAttack;
	}
	
	/**
	 * Set the status of Boosted Attack
	 * @param isBoosted New Boosted Attack value
	 */
	public void setBoostedAttack(boolean isBoosted) {
		this.boostedAttack = isBoosted;
	}
	
	/**
	 * Get the state of Boosted Health
	 * @return Whether Warrior has boosted Health
	 */
	public boolean getBoostedHealth() {
		return boostedHealth;
	}
	
	/**
	 * Sets the state of BoostedHealth
	 * @param isBoosted Whether Warriors health is boosted
	 */
	public void setBoostedHealth(boolean isBoosted) {
		this.boostedHealth = isBoosted;
	}
	
	/**
	 * Gets the move of the Warrior specified
	 * @param selection Index of the move selection
	 * @return Move
	 */
	public Move getMove(int selection){
		return moves[selection];
	}
	
	/**
	 * Sets move one of the Warrior
	 * @param move1 New move
	 */
	public void setMove1(Move move1) {
		// Sets the moves of the warrior
		this.moves[0] = move1;

	}
	
	/**
	 * Sets move two of the Warrior
	 * @param move2 New move
	 */
	public void setMove2(Move move2) {
		
		// Sets the moves of the warrior
		this.moves[1] = move2;

	}
	
	/**
	 * Gets the current Damage of the Warrior
	 * @return current damage
	 */
	public double getCurrentDamage() {
		
		return currentDamage;
	}

	/**
	 * Gets whether the Warrior has fainted today
	 * @return Whether Warrior has fainted today
	 */
	public boolean getHasFaintedToday() {
		return hasFaintedToday;
	}

	/**
	 * Set whether the Warrior has fainted today
	 * @param hasFaintedToday New value of has Fainted
	 */
	public void setHasFaintedToday(boolean hasFaintedToday) {
		this.hasFaintedToday = hasFaintedToday;
	}
	
	/**
	 * Heals the Warrior for the given amount
	 * @param healAmount Amount to heal by
	 */
	public void healWarrior(int healAmount) {

	    if (this.currentHealth + healAmount >= this.maxHealth) {
	        this.currentHealth = this.maxHealth;
	    } else {
	        this.currentHealth += healAmount;
	    }
	}
	
	
	/**
	 * Subtracts the given damage from the Warrior health, representing taking damage
	 * @param damage Damage taken
	 */
	public void takeDamage(double damage) {
		
		currentHealth -= damage;
		if (currentHealth <= 0) {
			currentHealth = 0;
			hasFaintedToday = true;
		}		
	}
}
