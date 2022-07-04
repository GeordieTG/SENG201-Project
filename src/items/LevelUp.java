

package items;

import main.Player;
import main.Warrior;

/** 
 * LevelUp class which implements the functionality of an Item. LevelUp items increase the level of a 
 * Warrior by one
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class LevelUp implements Item {
	
	/**
	 * Name of the LevelUp
	 */
	private String itemName;

	/**
	 * Quantity of the LevelUp
	 */
	private int quantity = 1;
	/**
	 * Price of each LevelUp
	 */
	private double price;
	/**
	 * Filepath of the LevelUp's image
	 */
	private String image;
	
	/**
	 * Constructor for a LevelUp item
	 * @param price Price of LevelUp
	 */
	public LevelUp(double price) {
		this.itemName = "Level Up";
		this.price = price;
		this.image = "/images/LevelUp.png";
	}

	/**
	 * Get the name of the item
	 * @return name of the item
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Form the description of the LevelUp item
	 * @return Description of LevelUp
	 */
	public String getDescription() {
		String description = "";
		description += itemName;
		description += "\n";
		description += "Adds 1 level to a warrior";
		description += "\n";
		description += "($" + price + ")";
		return description;
	}
	
	/**
	 * 
	 */
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
		warrior.levelUp();
		quantity -= 1;
		
		if (quantity == 0) {
			player.getInventory().remove(inventoryIndex);
		}
	}
	
}
