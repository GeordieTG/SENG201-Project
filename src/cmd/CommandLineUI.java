package cmd;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import items.Item;
import main.Battle;
import main.BattleHub;
import main.GameEnvironment;
import main.Player;
import main.Store;
import main.Warrior;

public class CommandLineUI {
	
	public int getValidInt(int min, int max) {
		// Ask for an input until a valid input is chosen, and return it
		boolean valid = false;
		int playerSelection = 0;
		
		System.out.println("Select a number between " + min + " and " + max);
		while(!valid) {
			Scanner intScanner = new Scanner(System.in);
			
			try {
				playerSelection = intScanner.nextInt();
				if(playerSelection < min | playerSelection > max) {
					System.out.println("You must select a number between " + min + " and " + max);
				}
				else {
					valid = true;
				}
			}
			catch(Exception e) {
				System.out.println("You must select a whole number!");
			}
		}
		return playerSelection;
	}
	
	
	public String getValidName(GameEnvironment game) {
		
		boolean valid = false;
		String name = null;
		
		while(!valid) {
		    Scanner intScanner = new Scanner(System.in);
		    name = intScanner.nextLine();
		    if (game.validString(name)) {
		    	valid = true;
		    } else {
		    	System.out.println("Name must contain only letters and be between 5 and 15 characters.");
		    }
		}
		return name;
	}
	
	
	
	public void setup(GameEnvironment game, Player player) {
		// Setup stage of game
		//intro
		System.out.println("Welcome to Tussle of Tribes!");
		
		// input the username
		System.out.println("What's your name?");
		String name = getValidName(game);
		player.setUsername(name);
		System.out.println("Welcome " + name + "!");   

		// Get a valid selection and call the function to set the game length
		System.out.println("Please select the number of days you want to play for:");   
		int selection = getValidInt(5, 15);
		game.setGameLength(selection);

		// Select difficulty of game
		
		System.out.println("Please choose the difficulty you wish to play. You have three choices:");
		System.out.println("(1) Easy - ");
		System.out.println("(2) Medium - ");
		System.out.println("(3) Hard - ");
		
		selection = getValidInt(1,3);
		
		//Prompts the user to choose the difficulty
	    switch(selection){

	    case 1:
	        System.out.println("You have choosen easy");
	        game.setDifficultyMultiplier(1);
	        break;

	    case 2:
	        System.out.println("You have choosen medium");
	        game.setDifficultyMultiplier(0.75);
	        break;

	    case 3:
	        System.out.println("You have choosen hard");
	        game.setDifficultyMultiplier(0.50);
	        break;
	    }
	    
	    player.setBeans(game.getDifficultyMultiplier() * 1000);
	    		
		// Select starter
		//Prompts the user to choose their starting rip off pokemon from the list
		
		System.out.println("\nNow it's time for you to choose your first Warrior! Below is a list of Warriors for you to choose from:");
		System.out.println("\n To choose your option from here on out, enter the number corresponding to your choice");
		System.out.println("(1) Reaper");
		System.out.println("(2) Barbarian");
		System.out.println("(3) Wizard");
		
		System.out.println("Enter your choice:");
		selection = getValidInt(1,3);
				
		
		// Ask user if nickname is wanted. If not, keep nickname null and it will be set to warrior type upon creation
		System.out.println("Do you want to give your warrior a nickname?");
		System.out.println("(1) Yes");
		System.out.println("(2) No");		
		
		int nicknameSelection = getValidInt(1,2);
		
		String nickname = null;
		
		switch(nicknameSelection) {
			case 1:
				System.out.println("Enter a nickname:");
				nickname = getValidName(game);
			case 2:
				;
		}
		
		Warrior warrior = null;
		
	    switch(selection){

	    case 1:
	        warrior = game.createReaper(nickname);
	        break;

	    case 2:
	        warrior = game.createBarbarian(nickname);
	        break;

	    case 3:
	        warrior = game.createWizard(nickname);
	        break;
	    }
	    
	    player.addWarriorToTeam(warrior);
	    warrior.setLevel(5);
	    
	    // Get the nickname of the warrior just added
	    String type = player.getTeam().get(0).getType();
	    nickname = player.getTeam().get(0).getNickname();
	    System.out.println("You've chosen " + type + "! (" + nickname + ")");
	    
	    System.out.println("Welcome to Tussel of Tribes, a game of bravery, love and sacrifice, \nwhere you venture far and wide on a journey to discover the origins of\nthe long lost Tribes. You will face numerous encounters on your crusade \nfor worthiness, challenging your endurance, resilliance and wit.\n\nAs you progress your pilgrimage, you will find value in the long lost\ncurrency of magic beans, to trade at the local markets, or tempt the \nhearts of foreign Warriors as they discover a sense of belonging in your\\r\\nfellowship. \\r\\n\\r\\nYou will lead your tribe against countless skirmishes in order to \\r\\nrewrite history and find gratification in your endeavour to be the\\r\\ngreatest Tribe in the lands.\n\nYour prestiege as a Tribe will rise with every victorious encounter,\ngreatly so in overcoming overwhelming odds against tougher opponents.\nYou will be rewarded generously with magic beans. \n");
	 }
	
	
	
	public void shop(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		
		// SHOPPING!!!
		
		System.out.println("------------");
		System.out.println("    SHOP    ");
		System.out.println("------------");
		
		System.out.println("Gold: " + player.getBeans());
		
		Item item1 = store.getStoreItem(1);
		Item item2 = store.getStoreItem(2);
		Item item3 = store.getStoreItem(3);
		
		Warrior warrior1 = store.getStoreWarrior(1);
		Warrior warrior2 = store.getStoreWarrior(2);
		Warrior warrior3 = store.getStoreWarrior(3);
		
		System.out.println("Items:");
		System.out.println("(1) " + item1.getItemName() + " - " + item1.getDescription() + " ($" + item1.getPrice() + ") " + item1.getQuantity() + "/3");
		System.out.println("(2) " + item2.getItemName() + " - " + item2.getDescription() + " ($" + item2.getPrice() + ") " + item2.getQuantity() + "/3");
		System.out.println("(3) " + item3.getItemName() + " - " + item3.getDescription() + " ($" + item3.getPrice() + ") " + item3.getQuantity() + "/3");
		System.out.println("\nWarriors:");
		System.out.println("(4) " + warrior1.getType() + " | " + "Attack - " + warrior1.getCurrentDamage() + " | Health - " + warrior1.getMaxHealth() +
				" | Level - " + warrior1.getLevel() + " | ($" + warrior1.getValue() + ")");
		System.out.println("(5) " + warrior2.getType() + " | " + "Attack - " + warrior2.getCurrentDamage() + " | Health - " + warrior2.getMaxHealth() +
				" | Level - " + warrior2.getLevel() + " | ($" + warrior2.getValue() + ")");
		System.out.println("(6) " + warrior3.getType() + " | " + "Attack - " + warrior3.getCurrentDamage() + " | Health - " + warrior3.getMaxHealth() +
				" | Level - " + warrior3.getLevel() + " | ($" + warrior3.getValue() + ")");
		System.out.println("\n(7) HOME");
		
		int selection = getValidInt(1, 7);
		
		if (selection == 7) homeScreen(game, player, store, battleHub);
		else if (selection <= 3){
			int purchaseSuccessful;
			
			purchaseSuccessful = store.buyItem(selection, player, game);
			
			switch(purchaseSuccessful) {
				case 0:
					System.out.println("Purchase Unsuccessful! There are not enough of this item left to buy!");
					break;
				case 1:
					System.out.println("Purchase Unsuccessful! You cannot afford this item!");
					break;
				case 2:
					System.out.println("You bought 1 " + store.getStoreItem(selection).getItemName() + " for " + store.getStoreItem(selection).getPrice());
					break;
				case -1:
					System.out.println("Purchase Unsuccessful - an unexpected error occured.");
					break;
			}
			shop(game, player, store, battleHub);
			
		} else {
			
			int purchaseSuccessful = store.buyWarrior(store.getTodaysWarriors()[selection - 4], player, game);
			
			if (purchaseSuccessful == 2) {
				System.out.println("Purchase Successful!");	
				
			} else if (purchaseSuccessful == 0) {
				System.out.println("Purchase Unsuccessful! Your team is full! (Try selling a current warrior)");
				
			} else {
				System.out.println("Purchase Unsuccessful! You cannot afford this Warrior!");
				
			}
			shop(game, player, store, battleHub);
			
		}
	}
		
	
	public void inventory(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		System.out.println("----------------");
		System.out.println("    INVENTORY    ");
		System.out.println("----------------");
		
		System.out.println("Gold: " + player.getBeans());
		
		ArrayList<Item> inventory = player.getInventory();
		
		ArrayList<Warrior> team = player.getTeam();
		
		int i;
		
		for (i=0;i<inventory.size();i++) {
			System.out.println("(" + (i+1) + ") " + inventory.get(i).getItemName() + " (x" + inventory.get(i).getQuantity() + ")");
		}
		
		System.out.println("\n(" + (i+1) + ") HOME");
		
		int selection = getValidInt(1, i+1);
		
		// If the option is the last, home has been selected
		if (selection == i+1) {
			homeScreen(game, player, store, battleHub);
		// Otherwise an item has been chosen to use on a warrior
		} else {
			
			System.out.println("Select a warrior to use this item on:");
			
			printWarriors(game, player, store);
			
			selection = getValidInt(1, team.size());
			
			inventory.get(i - 1).useItem(i-1, team.get(selection - 1), player);
			
			System.out.println("Item used!");
			
			inventory(game, player, store, battleHub);
			
		}
	}
	
	
	public void printWarriors(GameEnvironment game, Player player, Store store){
		
		ArrayList<Warrior> team = player.getTeam();
		
		int i;
		
		for (i=0;i<team.size();i++) {
			Warrior currentWarrior = team.get(i);
			System.out.println("\n(" + (i+1) + ") " + currentWarrior.getNickname() + " (" + currentWarrior.getType() + ") [$" + currentWarrior.getValue() + "] Level " + currentWarrior.getLevel());
			String stats = "";
			stats += "Attack: " + currentWarrior.getCurrentDamage() + "   Health: " + currentWarrior.getCurrentHealth() + "/" + currentWarrior.getMaxHealth();
			if (currentWarrior.getBoostedAttack()) stats += "\nAttack Boosted! ";
			if (currentWarrior.getBoostedHealth()) stats += "Health Boosted!";
			System.out.println(stats);
		}
	}
	
	
	public void chooseBattle(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		
		System.out.println("\nSelect your opponent!");
		
		for(int i=0;i<3;i++) {
			
			Battle battle = battleHub.getBattle(i);
			
			double averageLevel = battle.getEnemy().getAverageLevel();
			
			if (!battle.getBattleCompleted()) System.out.println("(" + (i+1) + ") " + battle.getEnemy().getName() + " | Average Lamontster Level ~ " + averageLevel);
			else System.out.println("(" + (i+1) + ") Battle already fought!");

		}
		
		System.out.println("(4) HOME");
		
		int selection = getValidInt(1, 4);
		
		if (selection == 4) homeScreen(game, player, store, battleHub);
		else {	
			boolean warriorsAlive = player.checkWarriorsAlive();
			if (warriorsAlive) battle(game, player, store, battleHub, selection);
			else {
				System.out.println("You cannot start a battle with warriors that are no longer with us!");
				homeScreen(game, player, store, battleHub);
			}
			
		}
	}
	
	public void battle(GameEnvironment game, Player player, Store store, BattleHub battleHub, int battleSelection) {
		
		
		Battle thisBattle = battleHub.getBattle(battleSelection - 1);
				
		System.out.println("You've chosen to fight " + thisBattle.getEnemy().getName() + "!");
		
		
		int playerTurnResult;
		int enemyTurnResult;
		Random rng = new Random();
		
		double thisTurnsDamage;
		Warrior thisTurnsEnemyWarrior;
		Warrior thisTurnsPlayerWarrior;
		
		thisBattle.setBattleCompleted(false);
		
		while (!thisBattle.getBattleCompleted()) {
			
			System.out.println("-----------------------------------------");
			
			System.out.println("\nYour turn! Choose a move to use:");
			System.out.println("\nYou: " + thisBattle.getActivePlayerWarrior().getNickname() + " | Level " + 
								thisBattle.getActivePlayerWarrior().getLevel() + " | " + thisBattle.getActivePlayerWarrior().getCurrentHealth() + "/" + thisBattle.getActivePlayerWarrior().getMaxHealth() + "HP");
			System.out.println("Opponent: " + thisBattle.getActiveEnemyWarrior().getNickname() + " | Level " + 
								thisBattle.getActiveEnemyWarrior().getLevel() + " | " + thisBattle.getActiveEnemyWarrior().getCurrentHealth() + "/" + thisBattle.getActiveEnemyWarrior().getMaxHealth() + "HP");
		
			for(int i=0;i<2;i++) {
				System.out.println("(" + (i+1) + ") " + thisBattle.getActivePlayerWarrior().getMove(i).getName() + " | " + 
									thisBattle.getActivePlayerWarrior().getMove(i).getDamage(thisBattle.getActivePlayerWarrior()) + " Damage");
			}
			
			int moveSelection = getValidInt(1,3);
			
			System.out.println("-----------------------------------------");
			
			// Defining variables for the current warriors as the battle stands before the move is carried out
			thisTurnsDamage = thisBattle.getActivePlayerWarrior().getMove(moveSelection - 1).getDamage(thisBattle.getActivePlayerWarrior());
			thisTurnsEnemyWarrior = thisBattle.getActiveEnemyWarrior();
			thisTurnsPlayerWarrior = thisBattle.getActivePlayerWarrior();
			
			playerTurnResult = thisBattle.playerMove(moveSelection, player, game);
			System.out.println(thisTurnsPlayerWarrior.getType() + " used " + thisBattle.getActivePlayerWarrior().getMove(moveSelection - 1).getName() + "!");
			
			switch (playerTurnResult) {
				
				case 0:
					System.out.println("");
					System.out.println("\nYou killed their warrior, but " + thisBattle.getEnemy().getName() + " subbed in " + thisBattle.getActiveEnemyWarrior().getType() + "!");
					break;
					
				case 1:
					System.out.println("\nYou dealt " + thisTurnsDamage + " damage to " + thisTurnsEnemyWarrior.getType());
					break;
					
				case 2:
					System.out.println("\nYou Win!");
					thisBattle = battleHub.getBattle(battleSelection);
					double points = thisBattle.getPointsReward(thisBattle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier());
					double reward = thisBattle.getReward(thisBattle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier());
					
					thisBattle.battleWon(reward, points, player, game);
					
					if (game.getBattlesCompletedToday() != 0) {
						// If this isn't the last battle for the day (battleLost will reset daily battles completed to 0 if it was)
						homeScreen(game, player, store, battleHub);
					}
					break;
			}
			
			if (thisBattle.getBattleCompleted()) {
				break;
			}
			
			moveSelection = rng.nextInt(1,3);
			
			// Defining variables for the current warriors as the battle stands before the move is carried out
			thisTurnsDamage = thisBattle.getActiveEnemyWarrior().getMove(moveSelection - 1).getDamage(thisBattle.getActiveEnemyWarrior());
			thisTurnsPlayerWarrior = thisBattle.getActivePlayerWarrior();
			thisTurnsEnemyWarrior = thisBattle.getActiveEnemyWarrior();
			
			enemyTurnResult = thisBattle.enemyMove(player, game);
			
			System.out.println("\n" + thisTurnsEnemyWarrior.getType() + " used " + thisBattle.getActiveEnemyWarrior().getMove(moveSelection - 1).getName() + "!");
			
			switch (enemyTurnResult) {
			
				case 0:
					System.out.println("\nThey defeated your " + thisTurnsPlayerWarrior.getType());
					break;
					
				case 1:
					System.out.println("\nThey dealt " + thisTurnsDamage + " damage to " + thisTurnsPlayerWarrior.getType());
					break;
					
				case 2:
					System.out.println("\nThey dealt " + thisTurnsDamage + " damage to " + thisTurnsPlayerWarrior.getType());
					System.out.println("\nYou have no more warriors left to fight.");
					System.out.println("\nYou lose!");

					thisBattle = battleHub.getBattle(battleSelection);
					double points = thisBattle.getPointsReward(thisBattle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier());
					double reward = thisBattle.getReward(thisBattle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier());
					
					thisBattle.battleLost(game);
					
					if (game.getBattlesCompletedToday() != 0) {
						// If this isn't the last battle for the day (battleLost will reset daily battles completed to 0 if it was)
						homeScreen(game, player, store, battleHub);
					}
					break;
			}
			
		}
		
	}
	
	public void homeScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		// Home screen of game
		
		System.out.println("-----------");
		System.out.println("HOME SCREEN");
		System.out.println("-----------");
		
		System.out.println("Gold: " + player.getBeans());
		System.out.println("Day - " + game.getCurrentDay() + "/" + game.getGameLength());
		
		System.out.println("Please select an option:");
		System.out.println("(1) View Battles");
		System.out.println("(2) Manage Team");
		System.out.println("(3) Inventory");
		System.out.println("(4) Shop");
		System.out.println("(5) End Day");
		System.out.println("(6) Quit");
		
		int selection = getValidInt(1, 6);
		
		switch(selection) {
			case 1:
				chooseBattle(game, player, store, battleHub);
				break;
				
			case 2:
				manageTeam(game, player, store, battleHub);
				break;
				
			case 3:
				inventory(game, player, store, battleHub);
				break;
				
			case 4:
				shop(game, player, store, battleHub);
				break;
				
			case 5:
				game.endDay(player, game, store, battleHub);
				break;
				
			case 6:
				quit(game, player, store, battleHub);
				break;
	
				
		}
		
	}
	
	
	public void manageTeam(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		System.out.println("Select a warrior if you want to sell it:");
		printWarriors(game, player, store);
		
		System.out.println("\n(" + (player.getTeam().size()+1) + ") HOME");
		int selection = getValidInt(1, player.getTeam().size() + 1);
		
		if (selection == player.getTeam().size() + 1) {
			
			homeScreen(game, player, store, battleHub);
			
		} else {
			
			System.out.println("Are you sure you want to sell your " + player.getTeam().get(selection-1).getType() + "?");
			System.out.println("(1) Yes");
			System.out.println("(2) No");
			
			int confirmSelection = getValidInt(1, 2);
			
			if (confirmSelection == 1) {
				player.sellWarrior(selection - 1);
				System.out.println("Warrior sold!");
			}
			manageTeam(game, player, store, battleHub);
		}
		
	}
		

	public void quit(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		// TODO Auto-generated method stub
		System.out.println("Are you sure you want to quit?");
		System.out.println("(1) Yes");
		System.out.println("(2) No");
		
		int selection = getValidInt(1, 2);
		
		if (selection == 2) homeScreen(game, player, store, battleHub);
		else System.exit(0);
	}


	public static void main(String[] args) {
		
		CommandLineUI cmd = new CommandLineUI();
		GameEnvironment game = new GameEnvironment();
		Player player = new Player();
		Store store = new Store(game);

		
		BattleHub battleHub = new BattleHub();
		cmd.setup(game, player);
		battleHub.resetBattleHub(player.getTeam(), game);
		cmd.homeScreen(game, player, store, battleHub);
		
	}
}

