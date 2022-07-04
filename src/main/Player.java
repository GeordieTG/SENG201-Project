

package main;
import java.util.ArrayList;

import items.Item;

/** 
 * Class for a player, which stores information specified by the player during setup
 * and handles many events to do with players items and team
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class Player {

	/**
	 * Username of player
	 */
	private String username;
	
	/**
	 * Players monsters
	 */
	private ArrayList<Warrior> team = new ArrayList<Warrior>();
	
	/**
	 * Players inventory
	 */
	private ArrayList<Item> inventory = new ArrayList<Item>();
		
	/**
	 * Players bean (currency) balance
	 */
	private double beans;
	
	/**
	 * Count of total beans gained throughout the game
	 */
	private double totalBeansGained = 0;
	
	/**
	 * Get the total beans gained throughout the game
	 * @return Number of beans
	 */
	public double getTotalBeansGained() {
		return totalBeansGained;
	}
	
	/**
	 * Set the number of beans gained
	 * @param totalBeansGained New value of beans gained
	 */
	public void setTotalBeansGainedToday(double totalBeansGained) {
		this.totalBeansGained = totalBeansGained;
	}
	
	/**
	 * Get the username of the player
	 * @return Username
	 */
	public String getUsername () {
		return username;
	}
	
	/**
	 * Set the username of the player
	 * @param username Players username
	 */
	public void setUsername (String username) {
		this.username = username;
	}
	
	/**
	 * Get the bean balance of the player
	 * @return Bean balance
	 */
	public double getBeans() {
		return beans;
	}
	
	/**
	 * Set the players bean balance
	 * @param beans New value of beans balance
	 */
	public void setBeans(double beans) {
		this.beans = Math.round(beans);
	}
	
	/**
	 * Get the players inventory
	 * @return players inventory
	 */
	public ArrayList<Item> getInventory() {
	    return inventory;
	}	
	
	/**
	 * Adds a Warrior to the players team
	 * @param warrior Warrior to add
	 */
	public void addWarriorToTeam(Warrior warrior) {
		team.add(warrior);
	}
	
	/**
	 * Get the players team
	 * @return Players team
	 */
	public ArrayList<Warrior> getTeam() {
	    return team;
	}

	/**
	 * Heals each Warrior in the players team to their heal amount (25% of max health)
	 */
	public void healTeam() {
		// Heals all warriors in the players team for heal amount (25% of max health)
		
		for(int i=0; i < team.size(); i+=1) {
			double newHealth = Math.min(team.get(i).getCurrentHealth() + team.get(i).getMaxHealth()*0.25, team.get(i).getMaxHealth());
			team.get(i).setCurrentHealth(newHealth);
		}
	}

	/**
	 * Adds an item to the players inventory, or updating the quantity of the existing item if they already own at least one
	 * @param item Item to be added
	 */
	public void addItemToInventory(Item item) {
		
		// Adds an item to the inventory
		
		String itemName = item.getItemName();
		
		boolean itemFound = false;
		
		// Try to find the item in the inventory, if found, increment quantity
		for (int i=0; i<inventory.size();i+=1) {
			if (inventory.get(i).getItemName() == itemName) {
				inventory.get(i).setQuantity(inventory.get(i).getQuantity() + 1);
				itemFound = true;
				break;
			}
		}
		
		// If the item was not found in the inventory already, add it
		if (!itemFound) inventory.add(item);
	}
	
	/**
	 * Sells a Warrior back to the shop from the players team
	 * @param index Index of their team, of the Warrior that is being sold
	 */
	public void sellWarrior(int index) {
		
		double currentBalance = getBeans();
		
		setBeans(currentBalance + getTeam().get(index).getValue());
		getTeam().remove(index);
		
	}
	
	/**
	 * Sells an Item back to the shop from the players inventory
	 * @param index Index of their inventory, of the item that is being sold
	 */
	public void sellItem(int index) {
		
		double currentBalance = getBeans();
		int currentQuantity = inventory.get(index).getQuantity();
		
		// Grant the player the value of the item sold
		setBeans(currentBalance + inventory.get(index).getPrice());
		inventory.get(index).setQuantity(currentQuantity - 1);
		// If they no longer have any of this item, remove it from their inventory
		if (inventory.get(index).getQuantity() == 0) {
			inventory.remove(index);
		}
		
	}
	
	/**
	 * Resets a player after a battle, negating any buffs/debuffs that were applied prior or during the battle
	 */
	public void resetPlayer() {
		
		// For each Warrior in the players team, reset their current damage to negate any effects applied during the battle
		for (int i=0;i<team.size();i++){
			
			team.get(i).setCurrentDamage(team.get(i).getBaseDamage() + (team.get(i).getLevel()-1)*50);
			team.get(i).setBoostedAttack(false);
			team.get(i).setBoostedHealth(false);
		}
	}
	
	/**
	 * Checks that the player has Warriors alive to battle with
	 * @return Player has alive monsters or not
	 */
	public boolean checkWarriorsAlive() {
		// Returns whether all Warriors in players team are alive
		
		ArrayList<Warrior> playerTeam = getTeam();
		int numDead = 0;
		
		// Adds one to the counter if the Warrior is dead
		for(int i=0;i<getTeam().size();i++) {
			if (playerTeam.get(i).getCurrentHealth() == 0) numDead+=1;	
		}
		
		// If all are dead, return false
		if (numDead == playerTeam.size()) return false;
		// Otherwise player has at least one alive; return true
		else return true;
	}
}
