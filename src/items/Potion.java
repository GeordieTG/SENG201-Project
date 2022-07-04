package items;

import main.Player;
import main.Warrior;

/** 
 * Class for a Potion, which implements Item. A potion is used to heal a Warrior. 
 * The amount a Warrior is healed for is derived from one of three Potion types:
 * Small, Medium or Large.
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */
public class Potion implements Item {
	/**
	 * Name of the Potion
	 */
	private String itemName;
	/**
	 * Amount the Potion heals for
	 */
	private int healAmount;
	/**
	 * Price of the item
	 */
	private double price;
	/**
	 * Quantity of the Potion
	 */
	private int quantity = 1;
	/**
	 * Filepath of the image for the Potion
	 */
	private String image;
	
	/**
	 * Constructor for potion
	 * @param itemName Items name
	 * @param healAmount Amount to heal	
	 * @param price Price
	 */
	public Potion(String itemName, int healAmount, double price) {
		// Can be small, medium, or large potion
		this.itemName = itemName;
		this.healAmount = healAmount;
		this.price = price;
		this.image = "/images/Potion.png";
	}

	public String getItemName() {
		return itemName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	public String getImage() {
		return image;
	}
	
	
	
	public void useItem(int inventoryIndex, Warrior warrior, Player player) {	

		
		// If the health of the Warrior after using the potion exceeds its max health, set its health to max.
		if (healAmount + warrior.getCurrentHealth() > warrior.getMaxHealth()) warrior.setCurrentHealth(warrior.getMaxHealth());
		// Otherwise add the heal amount of the potion to the Warriors current health
		else warrior.setCurrentHealth(healAmount + warrior.getCurrentHealth());
		quantity -= 1;
		
		// If quantity of the item is now 0, remove it from their inventory
		if (quantity == 0) {
			player.getInventory().remove(inventoryIndex);
		}

	}
	
	public String getDescription() {

		String description = "";
		description += itemName;
		description += "\n";
		description += "Heals a Warrior for " + healAmount + " HP";
		description += "\n";
		description += "($" + price + ")";
		return description;
		
	}
}