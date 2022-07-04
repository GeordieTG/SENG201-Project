package items;

import main.Player;
import main.Warrior;

/** 
 * Interface for an item, to be used by a player, on a Warrior, to affect its stats
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */
public class StatBooster implements Item{
	/**
	 * Items name
	 */
	private String itemName;
	/**
	 * Amount boosted
	 */
	private double boostAmount;

	/**
	 * Quantity of item
	 */
	private int quantity = 1;
	/**
	 * Type of StatBooster (0 = attack, 1 = health)
	 */
	private String boostType;
	/**
	 * Price
	 */
	private double price;
	/**
	 * Filepath of item
	 */
	private String image;
	
	
	/**
	 * Constructor for StatBooster
	 * @param itemName Items name
	 * @param boostAmount Amount boost
	 * @param boostType Type of Boost
	 * @param price Price
	 */
	public StatBooster(String itemName, double boostAmount, String boostType, double price) {
		// Can be small, medium, or large potion
		this.itemName = itemName;
		this.boostAmount = boostAmount;
		this.boostType = boostType;
		this.price = price;
		if (boostType == "attack") {
			this.image = "/images/AttackUp.png";
		} else {
			this.image = "/images/HPUp.png";
		}
	}
	
	/**
	 * Get items name
	 * @return name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Get items quantity
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Set the quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Get description of item
	 * @return description
	 */
	public String getDescription() {

		String description = "";
		description += itemName;
		description += "\n";
		description += "Boosts a warriors " + boostType +  " by " + ((boostAmount * 100) - 100) + "%";
		description += "\n";
		description += "($" + price + ")";
		return description;
	}
	
	/**
	 * Gets the price of the item
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Get filepath of the image
	 * @return filepath
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Uses the given item on the given Warrior
	 * @param inventoryIndex Index of the inventory of which item is being used
	 * @param warrior Warrior the item is being used on
	 * @param player Player of Game
	 */
	public void useItem(int inventoryIndex, Warrior warrior, Player player) {	

		// If boost is of type attack (0)
		if (boostType == "attack") {
			// Update warriors attack stat
			warrior.setCurrentDamage(warrior.getCurrentDamage() * boostAmount);
			// Set that the warrior has boosted attack to true
			warrior.setBoostedAttack(true);
			
		} else if (boostType == "health"){
			// Update warriors max health
			warrior.setCurrentHealth(warrior.getMaxHealth() * boostAmount);
			// Set that the warrior has boosted health to true
			warrior.setBoostedHealth(true);
		}
		
		quantity -= 1;
		if (quantity == 0) {
			player.getInventory().remove(inventoryIndex);
		}
	}
}
