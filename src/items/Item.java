

package items;

import main.Player;
import main.Warrior;

/** 
 * Interface for an item, to be used by a player, on a Warrior, to affect its stats
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public interface Item {
	
	/**
	 * Uses the given item on the given Warrior
	 * @param inventoryIndex Index of the inventory of which item is being used
	 * @param warrior Warrior the item is being used on
	 * @param player Player of Game
	 */
	public void useItem(int inventoryIndex, Warrior warrior, Player player);
	
	/**
	 * Gets name of item
	 * @return Item's name
	 */
	public String getItemName();
	
	/**
	 * Gets quantity of item
	 * @return Quantity of item
	 */
	public int getQuantity();
	
	/**
	 * Forms a description for the item
	 * @return Description of the item
	 */
	public String getDescription();
	
	/**
	 * Sets the quantity of the item
	 * @param quantity New value of quantity
	 */
	public void setQuantity(int quantity);
	
	/**
	 * Gets the price of the item
	 * @return Price of item
	 */
	public double getPrice();
	
	/**
	 * Gets the file path of the item
	 * @return Item filepath
	 */
	public String getImage();
	
}
