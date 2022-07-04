

package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import items.Item;

/** 
 * Class for a store, which stores the state of the current store for the day, 
 * and handles purchasing of these items
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 **/

public class Store {
	
	/**
	 * List of Potion Items avaliable
	 */
	private Item[] potionItems;
	/**
	 * List of StatBooster Items avaliable
	 */
	private Item[] statBoostItems;
	/**
	 * List of LevelUp Items avaliable
	 */
	private Item[] levelUpItems;
	
	/**
	 * Warriors avaliable from the store
	 */
	ArrayList<Warrior> warriors;
	
	/**
	 * Items in todays store
	 */
	private Item[] todaysStore = new Item[3];
	/**
	 * Warriors in todays store
	 */
	private Warrior[] todaysWarriors = new Warrior[3];
	
	/**
	 * Constructor for store
	 * @param game Game Environment instance
	 */
	public Store(GameEnvironment game) {
		
		Random rng = new Random();
		
		int randomInt;
		
		// Create lists of 
		
		potionItems = new Item[] {game.createSmallPotion(), game.createMediumPotion(), game.createLargePotion()};
		statBoostItems = new Item[] {game.createAttackBoost(), game.createHealthBoost()};
		levelUpItems = new Item[] {game.createLevelUp()};
		
		randomInt = rng.nextInt(3);
		todaysStore[0] = potionItems[randomInt];
		
		randomInt = rng.nextInt(3);
		todaysStore[0].setQuantity(randomInt + 1);
		
		randomInt = rng.nextInt(2);
		todaysStore[1] = statBoostItems[randomInt];
		
		randomInt = rng.nextInt(3);
		todaysStore[1].setQuantity(randomInt + 1);
		
		randomInt = rng.nextInt(1);
		todaysStore[2] = levelUpItems[randomInt];
		
		randomInt = rng.nextInt(3);
		todaysStore[2].setQuantity(randomInt + 1);
		
		warriors = new ArrayList<> (Arrays.asList(game.createReaper(null), game.createBarbarian(null), game.createWizard(null), game.createWitch(null), game.createSkeleton(null), 
				game.createWiseOldMan(null), game.createBadNewsBear(null), game.createArcher(null), game.createGhost(null)));
		
			
		
		// Set todays random warrior in slot 1
		randomInt = rng.nextInt(9);
		todaysWarriors[0] = warriors.get(randomInt);
		warriors.remove(randomInt);
				
		// Set the level for todays random warrior in slot 1
		randomInt = rng.nextInt(game.getCurrentDay(), game.getCurrentDay() + 5);
		todaysWarriors[0].setLevel(randomInt);
		
		randomInt = rng.nextInt(8);
		todaysWarriors[1] = warriors.get(randomInt);
		warriors.remove(randomInt);
		
		randomInt = rng.nextInt(game.getCurrentDay() + 3, game.getCurrentDay() + 8);
		todaysWarriors[1].setLevel(randomInt);
		
		randomInt = rng.nextInt(7);
		todaysWarriors[2] = warriors.get(randomInt);
		warriors.remove(randomInt);
				
		randomInt = rng.nextInt(game.getCurrentDay() + 5, game.getCurrentDay() + 10);
		todaysWarriors[2].setLevel(randomInt);
		
	}
	
	/**
	 * Get todays warriors
	 * @return Todays warriors
	 */
	public Warrior[] getTodaysWarriors() {
		return todaysWarriors;
	}
	
	/**
	 * Get Store item in slot specified (slots [1-3])
	 * @param slotNum Slot number
	 * @return Store Item
	 */
	public Item getStoreItem(int slotNum) {
		return todaysStore[slotNum - 1];
	}
	
	/**
	 * Get Store Warrior in slot specified (slots [1-3])
	 * @param slotNum Slot number
	 * @return Store Warrior
	 */
	public Warrior getStoreWarrior(int slotNum) {
		return todaysWarriors[slotNum - 1];
	}
	
	/**
	 * Set the given Warrior selection as null, so it no longer appears in the store (it has been purchased)
	 * @param selection Monster selection [1-3]
	 */
	public void setWarriorPurchased(int selection) {
		// Sets the purchased warrior to null
		
		todaysWarriors[selection - 1] = null;
	}
	
	/**
	 * Resets the state of the store for the next day, and re-randomises the Items and Warriors that feature
	 * @param game Game Environment instance
	 */
	public void resetStore(GameEnvironment game) {
		
		// Resets the store
		
		warriors = new ArrayList<> (Arrays.asList(game.createReaper(null), game.createBarbarian(null), game.createWizard(null), game.createWitch(null), game.createSkeleton(null), 
				game.createWiseOldMan(null), game.createBadNewsBear(null), game.createArcher(null), game.createGhost(null)));
				
		
		Random rng = new Random();
		
		int randomInt = rng.nextInt(3);
		todaysStore[0] = potionItems[randomInt];
		// *** SET RANDOM QUANTITY ***
		
		randomInt = rng.nextInt(3);
		todaysStore[0].setQuantity(randomInt + 1);
		
		randomInt = rng.nextInt(2);
		todaysStore[1] = statBoostItems[randomInt];
		
		randomInt = rng.nextInt(3);
		todaysStore[1].setQuantity(randomInt + 1);
		
		randomInt = rng.nextInt(1);
		todaysStore[2] = levelUpItems[randomInt];
		
		randomInt = rng.nextInt(3);
		todaysStore[2].setQuantity(randomInt + 1);
		
		
		// Set todays random warrior in slot 1
		randomInt = rng.nextInt(9);
		todaysWarriors[0] = warriors.get(randomInt);
		warriors.remove(randomInt);
				
		// Set the level for todays random warrior in slot 1
		randomInt = rng.nextInt(game.getCurrentDay(), game.getCurrentDay() + 5);
		todaysWarriors[0].setLevel(randomInt);
		
		randomInt = rng.nextInt(8);
		todaysWarriors[1] = warriors.get(randomInt);
		warriors.remove(randomInt);
		
		randomInt = rng.nextInt(game.getCurrentDay() + 3, game.getCurrentDay() + 8);
		todaysWarriors[1].setLevel(randomInt);
		
		randomInt = rng.nextInt(7);
		todaysWarriors[2] = warriors.get(randomInt);
		warriors.remove(randomInt);
		
		randomInt = rng.nextInt(game.getCurrentDay() + 5, game.getCurrentDay() + 10);
		todaysWarriors[2].setLevel(randomInt);
		
	}
	

	
	/**
	 * Buys the specified Warrior from the store, if it can be afforded
	 * @param chosenWarrior Warrior chosen for purchase
	 * @param player Player of game
	 * @param game Game Environment instance
	 * @return Number corresponding to the outcome of the attempted purchase: 0 = team full, 1 = player can't afford Warrior, 2 = purchase successful
	 */
	public int buyWarrior(Warrior chosenWarrior, Player player, GameEnvironment game) {
		
		// Return 2 if successful
		int purchaseSuccessful = -1;
		double currentBalance = player.getBeans();
		
		// If the item cannot be affored, return error code 1
		if (!(player.getBeans() >= chosenWarrior.getValue())) return 1;
		
		// Return 0 if team full
		if (player.getTeam().size() == 4) return 0;
		
		player.addWarriorToTeam(chosenWarrior);
		player.setBeans(currentBalance - chosenWarrior.getValue());
		
		purchaseSuccessful = 2;
		
		return purchaseSuccessful;
	}
	
	/**
	 * Buys the specified Item from the store, if it can be afforded
	 * @param slotNum Item chosen for purchase
	 * @param player Player of game
	 * @param game Game Environment instance
	 * @return Number corresponding to the outcome of the attempted purchase: 0 = not enough left, 1 = player can't afford Item, 2 = purchase successful
	 */
	public int buyItem(int slotNum, Player player, GameEnvironment game) {
		
		int purchaseSuccessful = -1;
		
		// If theres not enough left, return error code 0
		if (!(getStoreItem(slotNum).getQuantity() > 0)) return 0;
		// If the item cannot be affored, return error code 1
		if (!(player.getBeans() >= getStoreItem(slotNum).getPrice())) return 1;
		
		switch(slotNum) {
			
		// SLOT 1 SELECTED
			case 1:
				
				Item slot1 = todaysStore[0];
				String slot1Name = slot1.getItemName();
				
				 {
				switch (slot1Name) {
				case "Small Potion":
					player.addItemToInventory(game.createSmallPotion());
					break;
					
				case "Medium Potion":
					player.addItemToInventory(game.createMediumPotion());	
					break;
					
				case "Large Potion":
					player.addItemToInventory(game.createLargePotion());
					break;
				}
				purchaseSuccessful = 2;
				break;
				}
	
		// SLOT 2 SELECTED
			case 2:
				
				Item slot2 = todaysStore[1];
				String slot2Name = slot2.getItemName();
				
				switch (slot2Name) {
				case "Attack Boost":
					player.addItemToInventory(game.createAttackBoost());
					break;
					
				case "Health Boost":
					player.addItemToInventory(game.createHealthBoost());
					break;
					
				}
			purchaseSuccessful = 2;
			break;
	
		// SLOT 3 SELECTED
			case 3:
				
				Item slot3 = todaysStore[2];
				String slot3Name = slot3.getItemName();
				
				switch (slot3Name) {
				case "Level Up":
					player.addItemToInventory(game.createLevelUp());
					break;
	
				}
				purchaseSuccessful = 2;
				break;
			}
		// Charge the player 
		player.setBeans(player.getBeans() - getStoreItem(slotNum).getPrice());
		// Decrement the store quantity by 1
		getStoreItem(slotNum).setQuantity(getStoreItem(slotNum).getQuantity() - 1);
		// 
		return purchaseSuccessful;
	}

}
