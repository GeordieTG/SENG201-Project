


package main;
import java.util.ArrayList;

/** 
 * Class for the battles for the day, stores 3 battle instances
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */
public class BattleHub {

	/**
	 * List of todays three battle objects
	 */
	private Battle[] battles = new Battle[3];
	
	/**
	 * Gets the battle given a selection
	 * @param selection Index of selected battle
	 * @return Battle at index selection
	 */
	public Battle getBattle(int selection) {
		return battles[selection];
	}
	
	/**
	 * Resets the battle for a new day
	 * @param playerTeam Players team
	 * @param game Game Environment instance
	 */
	public void resetBattleHub(ArrayList<Warrior> playerTeam, GameEnvironment game) {
		
		// Set each slot of the battlehub to a new battle, each with differing difficulty
		this.battles[0] = new Battle(playerTeam, game, "Easy");
		this.battles[1] = new Battle(playerTeam, game, "Medium");
		this.battles[2] = new Battle(playerTeam, game, "Hard");
		
	}
	
}
