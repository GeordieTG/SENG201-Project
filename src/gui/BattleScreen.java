package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Battle;
import main.BattleHub;
import main.GameEnvironment;
import main.Player;
import main.Store;
import main.Warrior;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleScreen extends JFrame {

	private JPanel backgroundPane;
	
	private JTextField playerRedHealthBar;
	private JTextField playerWhiteHealthBar;
	private JTextField playerHealthBarBoostedWhite;
	private JLabel isBoostedLabel;
	private JTextField enemyWhiteHealthBar;
	private JTextField enemyRedHealthBar;
	private JTextField enemyMoveOneLabel;
	private JTextField enemyMoveTwoLabel;
	private JTextField playerRemainingWarriorOneInfo;
	private JTextField playerRemainingWarriorTwoInfo;
	private JTextField playerRemainingWarriorThreeInfo;
	private JTextField enemyRemainingWarriorTwoInfo;
	private JTextField enemyRemainingWarriorThreeInfo;
	private JTextField enemyRemainingWarriorOneInfo;
	private JTextField playerBackupOneRedHealthBar;
	private JTextField playerBackupTwoRedHealthBar;
	private JTextField playerBackupThreeRedHealthBar;
	private JTextField enemyBackupOneWhiteHealthBar;
	private JTextField enemyBackupTwoWhiteHealthBar;
	private JTextField enemyBackupThreeWhiteHealthBar;
	private JTextField playerBackupOneWhiteHealthBar;
	private JTextField playerBackupTwoWhiteHealthBar;
	private JTextField playerBackupThreeWhiteHealthBar;
	private JTextField enemyBackupOneRedHealthBar;
	
	private Warrior activePlayerWarrior;
	private Warrior activeEnemyWarrior;
	
	/**
	 * Create the frame.
	 */
	
	
	public BattleScreen(Battle activeBattle, GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setResizable(false);
		
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		setLocationRelativeTo(null);
		
		activePlayerWarrior = activeBattle.getActivePlayerWarrior();
		activeEnemyWarrior = activeBattle.getActiveEnemyWarrior();
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(BattleScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussle of Tribes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);

		JLabel battleTitleLabel = new JLabel();
		battleTitleLabel.setText(player.getUsername() + " vs " + activeBattle.getEnemy().getName());
		battleTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		battleTitleLabel.setForeground(Color.WHITE);
		battleTitleLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		battleTitleLabel.setBounds(35, 11, 811, 47);
		backgroundPane.add(battleTitleLabel);
		
	
		
		JLabel battleLogo = new JLabel("");
		battleLogo.setIcon(new ImageIcon(BattleScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		battleLogo.setHorizontalAlignment(SwingConstants.CENTER);
		battleLogo.setBounds(352, 140, 167, 140);
		backgroundPane.add(battleLogo);
		
		// ACTIVE PLAYER WARRIOR
		
		JLabel playerWarriorImage = new JLabel("");
		playerWarriorImage.setHorizontalAlignment(SwingConstants.CENTER);
		playerWarriorImage.setIcon(new ImageIcon(BattleScreen.class.getResource(activeBattle.getActivePlayerWarrior().getImage())));
		playerWarriorImage.setBounds(83, 140, 167, 140);
		backgroundPane.add(playerWarriorImage);
		
		playerRedHealthBar = new JTextField();
		playerRedHealthBar.setBackground(new Color(178, 34, 34));
		playerRedHealthBar.setEditable(false);
		// Set health bar depending on percantage health remaining
		playerRedHealthBar.setBounds(83, 291, (int) (167*(activePlayerWarrior.getCurrentHealth()/activePlayerWarrior.getMaxHealth())), 20);
		backgroundPane.add(playerRedHealthBar);
		playerRedHealthBar.setColumns(10);
		
		playerWhiteHealthBar = new JTextField();
		playerWhiteHealthBar.setEditable(false);
		playerWhiteHealthBar.setColumns(10);
		playerWhiteHealthBar.setBackground(new Color(255, 255, 255));
		playerWhiteHealthBar.setBounds(83, 291, 167, 20);
		backgroundPane.add(playerWhiteHealthBar);
		
		
		JLabel playerWarriorLabel = new JLabel();
		playerWarriorLabel.setText(activeBattle.getActivePlayerWarrior().getNickname());
		playerWarriorLabel.setForeground(new Color(255, 255, 255));
		playerWarriorLabel.setFont(new Font("Engravers MT", Font.PLAIN, 15));
		playerWarriorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerWarriorLabel.setBounds(32, 69, 262, 38);
		backgroundPane.add(playerWarriorLabel);
		
		JButton playerMoveOneButton = new JButton();
		playerMoveOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activeBattle.playerMove(1, player, game);
				// If battle completed after player move, player won
				if (activeBattle.getBattleCompleted()) {	
					
					double reward = activeBattle.getReward(activeBattle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier());
					double pointsReward = activeBattle.getPointsReward(activeBattle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier());
					
					activeBattle.battleWon(reward, pointsReward, player, game);
					
					dispose();
					BattleSummaryScreen battleSummary = new BattleSummaryScreen(true, activeBattle, game, player, store, battleHub);
					battleSummary.setVisible(true);
					return;
				}

				activeBattle.enemyMove(player, game);
				// If battle completed after enemy move, player lost
				if (activeBattle.getBattleCompleted()) {	
					
					activeBattle.battleLost(game);
					
					dispose();
					BattleSummaryScreen battleSummary = new BattleSummaryScreen(false, activeBattle, game, player, store, battleHub);
					battleSummary.setVisible(true);
					return;
				}
				
				dispose();
				BattleScreen newBattleScreenOne = new BattleScreen(activeBattle, game, player, store, battleHub);
				newBattleScreenOne.setVisible(true);

			}
		});
		playerMoveOneButton.setText(activePlayerWarrior.getMove(0).getName() + " " + activePlayerWarrior.getMove(0).getDamage(activePlayerWarrior));
		playerMoveOneButton.setBounds(48, 318, 232, 23);
		backgroundPane.add(playerMoveOneButton);
		
		JButton playerMoveTwoButton = new JButton();
		playerMoveTwoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activeBattle.playerMove(2, player, game);
				// If battle completed after player move, player won
				if (activeBattle.getBattleCompleted()) {	
					
					double reward = activeBattle.getReward(activeBattle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier());
					double pointsReward = activeBattle.getPointsReward(activeBattle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier());
					
					activeBattle.battleWon(reward, pointsReward, player, game);
					
					dispose();
					BattleSummaryScreen battleSummary = new BattleSummaryScreen(true, activeBattle, game, player, store, battleHub);
					battleSummary.setVisible(true);
					return;
				}

				activeBattle.enemyMove(player, game);
				// If battle completed after enemy move, player lost
				if (activeBattle.getBattleCompleted()) {	
					
					activeBattle.battleLost(game);
					
					dispose();
					BattleSummaryScreen battleSummary = new BattleSummaryScreen(false, activeBattle, game, player, store, battleHub);
					battleSummary.setVisible(true);
					return;
				}
				dispose();
				BattleScreen newBattleScreenTwo = new BattleScreen(activeBattle, game, player, store, battleHub);
				newBattleScreenTwo.setVisible(true);
			}
		});
		playerMoveTwoButton.setText(activePlayerWarrior.getMove(1).getName() + " " + activePlayerWarrior.getMove(1).getDamage(activePlayerWarrior));
		playerMoveTwoButton.setBounds(48, 344, 232, 23);
		backgroundPane.add(playerMoveTwoButton);
		
		
		if (activePlayerWarrior.getBoostedHealth()) {
			playerHealthBarBoostedWhite = new JTextField();
			playerHealthBarBoostedWhite.setEditable(false);
			playerHealthBarBoostedWhite.setFont(new Font("Tahoma", Font.PLAIN, 10));
			playerHealthBarBoostedWhite.setHorizontalAlignment(SwingConstants.CENTER);
			playerHealthBarBoostedWhite.setColumns(10);
			playerHealthBarBoostedWhite.setBackground(new Color(255, 255, 255));
			playerHealthBarBoostedWhite.setBounds(249, 291, 80, 20);
			backgroundPane.add(playerHealthBarBoostedWhite);
			
			isBoostedLabel = new JLabel("BOOSTED!");
			isBoostedLabel.setForeground(new Color(255, 255, 255));
			isBoostedLabel.setHorizontalAlignment(SwingConstants.CENTER);
			isBoostedLabel.setBounds(249, 266, 80, 14);
			backgroundPane.add(isBoostedLabel);
		}
		
		// PLAYER BACKUP WARRIORS
		
		JLabel playerRemainingWarriorsLabel = new JLabel("Remaining Warriors:");
		playerRemainingWarriorsLabel.setForeground(new Color(255, 255, 255));
		playerRemainingWarriorsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		playerRemainingWarriorsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerRemainingWarriorsLabel.setBounds(59, 379, 214, 28);
		backgroundPane.add(playerRemainingWarriorsLabel);
		
		// BACKUP ONE
		
		if(player.getTeam().size() > 1 && player.getTeam().get(1).getCurrentHealth() > 0 && player.getTeam().get(1) != activeBattle.getActivePlayerWarrior()) {
		
			Warrior backUpWarriorOne = player.getTeam().get(1);
			playerRemainingWarriorOneInfo = new JTextField();
			playerRemainingWarriorOneInfo.setEditable(false);
			playerRemainingWarriorOneInfo.setText(backUpWarriorOne.getNickname());
			playerRemainingWarriorOneInfo.setHorizontalAlignment(SwingConstants.CENTER);
			playerRemainingWarriorOneInfo.setBounds(10, 407, 95, 28);
			backgroundPane.add(playerRemainingWarriorOneInfo);
			playerRemainingWarriorOneInfo.setColumns(10);
			
			playerBackupOneRedHealthBar = new JTextField();
			playerBackupOneRedHealthBar.setEditable(false);
			playerBackupOneRedHealthBar.setColumns(10);
			playerBackupOneRedHealthBar.setBackground(new Color(255, 0, 0));
			playerBackupOneRedHealthBar.setBounds(10, 442, (int) Math.min((95*(backUpWarriorOne.getCurrentHealth()/backUpWarriorOne.getMaxHealth())), 95), 20);
			backgroundPane.add(playerBackupOneRedHealthBar);
			
			playerBackupOneWhiteHealthBar = new JTextField();
			playerBackupOneWhiteHealthBar.setEditable(false);
			playerBackupOneWhiteHealthBar.setColumns(10);
			playerBackupOneWhiteHealthBar.setBackground(Color.WHITE);
			playerBackupOneWhiteHealthBar.setBounds(10, 442, 95, 20);
			backgroundPane.add(playerBackupOneWhiteHealthBar);
		
		}
		
		// BACKUP TWO
		if(player.getTeam().size() > 2 && player.getTeam().get(2).getCurrentHealth() > 0 && player.getTeam().get(2) != activeBattle.getActivePlayerWarrior()) {
		
			Warrior backUpWarriorTwo = player.getTeam().get(2);
			playerRemainingWarriorTwoInfo = new JTextField();
			playerRemainingWarriorTwoInfo.setEditable(false);
			playerRemainingWarriorTwoInfo.setText(backUpWarriorTwo.getNickname());
			playerRemainingWarriorTwoInfo.setHorizontalAlignment(SwingConstants.CENTER);
			playerRemainingWarriorTwoInfo.setColumns(10);
			playerRemainingWarriorTwoInfo.setBounds(115, 407, 95, 28);
			backgroundPane.add(playerRemainingWarriorTwoInfo);
			
			playerBackupTwoRedHealthBar = new JTextField();
			playerBackupTwoRedHealthBar.setEditable(false);
			playerBackupTwoRedHealthBar.setColumns(10);
			playerBackupTwoRedHealthBar.setBackground(new Color(255, 0, 0));
			playerBackupTwoRedHealthBar.setBounds(115, 442, (int) Math.min((95*(backUpWarriorTwo.getCurrentHealth()/backUpWarriorTwo.getMaxHealth())), 95), 20);
			backgroundPane.add(playerBackupTwoRedHealthBar);
			
			playerBackupTwoWhiteHealthBar = new JTextField();
			playerBackupTwoWhiteHealthBar.setEditable(false);
			playerBackupTwoWhiteHealthBar.setColumns(10);
			playerBackupTwoWhiteHealthBar.setBackground(Color.WHITE);
			playerBackupTwoWhiteHealthBar.setBounds(115, 442, 95, 20);
			backgroundPane.add(playerBackupTwoWhiteHealthBar);


		}
		
		// BACKUP THREE
		if(player.getTeam().size() > 3 && player.getTeam().get(3).getCurrentHealth() > 0 && player.getTeam().get(3) != activeBattle.getActivePlayerWarrior()) {
			
			Warrior backUpWarriorThree = player.getTeam().get(3);
			playerRemainingWarriorThreeInfo = new JTextField();
			playerRemainingWarriorThreeInfo.setText(backUpWarriorThree.getNickname());
			playerRemainingWarriorThreeInfo.setEditable(false);
			playerRemainingWarriorThreeInfo.setHorizontalAlignment(SwingConstants.CENTER);
			playerRemainingWarriorThreeInfo.setColumns(10);
			playerRemainingWarriorThreeInfo.setBounds(220, 407, 95, 28);
			backgroundPane.add(playerRemainingWarriorThreeInfo);
			
			playerBackupThreeRedHealthBar = new JTextField();
			playerBackupThreeRedHealthBar.setEditable(false);
			playerBackupThreeRedHealthBar.setColumns(10);
			playerBackupThreeRedHealthBar.setBackground(new Color(255, 0, 0));
			playerBackupThreeRedHealthBar.setBounds(220, 442, (int) Math.min((95*(backUpWarriorThree.getCurrentHealth()/backUpWarriorThree.getMaxHealth())), 95), 20);
			backgroundPane.add(playerBackupThreeRedHealthBar);
			
			playerBackupThreeWhiteHealthBar = new JTextField();
			playerBackupThreeWhiteHealthBar.setEditable(false);
			playerBackupThreeWhiteHealthBar.setColumns(10);
			playerBackupThreeWhiteHealthBar.setBackground(Color.WHITE);
			playerBackupThreeWhiteHealthBar.setBounds(220, 442, 95, 20);
			backgroundPane.add(playerBackupThreeWhiteHealthBar);
			
		}
		
		// ACTIVE ENEMY WARRIOR
		
		enemyRedHealthBar = new JTextField();
		enemyRedHealthBar.setEditable(false);
		enemyRedHealthBar.setColumns(10);
		enemyRedHealthBar.setBackground(new Color(178, 34, 34));
		enemyRedHealthBar.setBounds(620, 291, (int)(167*(activeEnemyWarrior.getCurrentHealth()/activeEnemyWarrior.getMaxHealth())), 20);
		backgroundPane.add(enemyRedHealthBar);
		
		enemyWhiteHealthBar = new JTextField();
		enemyWhiteHealthBar.setEditable(false);
		enemyWhiteHealthBar.setColumns(10);
		enemyWhiteHealthBar.setBackground(Color.WHITE);
		enemyWhiteHealthBar.setBounds(620, 291, 167, 20);
		backgroundPane.add(enemyWhiteHealthBar);
		
		JLabel enemyWarriorImage = new JLabel("");
		enemyWarriorImage.setIcon(new ImageIcon(BattleScreen.class.getResource(activeBattle.getActiveEnemyWarrior().getImage())));
		enemyWarriorImage.setHorizontalAlignment(SwingConstants.CENTER);
		enemyWarriorImage.setBounds(620, 140, 167, 140);
		backgroundPane.add(enemyWarriorImage);
		
		
		enemyMoveOneLabel = new JTextField();
		enemyMoveOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMoveOneLabel.setText(activeEnemyWarrior.getMove(0).getName() + " " + activeEnemyWarrior.getMove(0).getDamage(activeEnemyWarrior));
		enemyMoveOneLabel.setEditable(false);
		enemyMoveOneLabel.setBounds(584, 318, 230, 23);
		backgroundPane.add(enemyMoveOneLabel);
		enemyMoveOneLabel.setColumns(10);
		
		enemyMoveTwoLabel = new JTextField();
		enemyMoveTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMoveTwoLabel.setText(activeEnemyWarrior.getMove(1).getName() + " " + activeEnemyWarrior.getMove(1).getDamage(activeEnemyWarrior));
		enemyMoveTwoLabel.setEditable(false);
		enemyMoveTwoLabel.setColumns(10);
		enemyMoveTwoLabel.setBounds(584, 349, 230, 23);
		backgroundPane.add(enemyMoveTwoLabel);

		
		JLabel enemyRemainingWarriorsLabel = new JLabel("Remaining Warriors:");
		enemyRemainingWarriorsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enemyRemainingWarriorsLabel.setForeground(Color.WHITE);
		enemyRemainingWarriorsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		enemyRemainingWarriorsLabel.setBounds(600, 379, 214, 28);
		backgroundPane.add(enemyRemainingWarriorsLabel);
		
		JLabel enemyWarriorLabel = new JLabel();
		enemyWarriorLabel.setText(activeBattle.getActiveEnemyWarrior().getNickname());
		enemyWarriorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enemyWarriorLabel.setForeground(Color.WHITE);
		enemyWarriorLabel.setFont(new Font("Engravers MT", Font.PLAIN, 15));
		enemyWarriorLabel.setBounds(574, 69, 262, 38);
		backgroundPane.add(enemyWarriorLabel);
		
		JLabel playerWarriorHealth = new JLabel();
		playerWarriorHealth.setText(activeBattle.getActivePlayerWarrior().getCurrentHealth() + " / " + activeBattle.getActivePlayerWarrior().getMaxHealth());
		playerWarriorHealth.setForeground(Color.WHITE);
		playerWarriorHealth.setHorizontalAlignment(SwingConstants.CENTER);
		playerWarriorHealth.setBounds(115, 271, 102, 20);
		backgroundPane.add(playerWarriorHealth);
		
		JLabel enemyWarriorHealth = new JLabel();
		enemyWarriorHealth.setText(activeBattle.getActiveEnemyWarrior().getCurrentHealth() + " / " + activeBattle.getActiveEnemyWarrior().getMaxHealth());
		enemyWarriorHealth.setHorizontalAlignment(SwingConstants.CENTER);
		enemyWarriorHealth.setForeground(Color.WHITE);
		enemyWarriorHealth.setBounds(658, 271, 96, 20);
		backgroundPane.add(enemyWarriorHealth);
		
		JLabel playerWarriorLevel = new JLabel();
		playerWarriorLevel.setText("Level " + activePlayerWarrior.getLevel());
		playerWarriorLevel.setHorizontalAlignment(SwingConstants.CENTER);
		playerWarriorLevel.setForeground(Color.WHITE);
		playerWarriorLevel.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		playerWarriorLevel.setBounds(83, 101, 167, 28);
		backgroundPane.add(playerWarriorLevel);
		
		JLabel enemyWarriorLevel = new JLabel();
		enemyWarriorLevel.setText("Level " + activeEnemyWarrior.getLevel());
		enemyWarriorLevel.setHorizontalAlignment(SwingConstants.CENTER);
		enemyWarriorLevel.setForeground(Color.WHITE);
		enemyWarriorLevel.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		enemyWarriorLevel.setBounds(620, 101, 167, 28);
		backgroundPane.add(enemyWarriorLevel);


		// ENEMY BACKUP 1
		if(activeBattle.getEnemy().getEnemyTeam()[1].getCurrentHealth() > 0 && activeBattle.getEnemy().getEnemyTeam()[1] != activeBattle.getActiveEnemyWarrior()) {
		
			Warrior enemyBackUpWarriorOne = activeBattle.getEnemy().getEnemyTeam()[1];
			
			enemyRemainingWarriorOneInfo = new JTextField();
			enemyRemainingWarriorOneInfo.setText(enemyBackUpWarriorOne.getType());
			enemyRemainingWarriorOneInfo.setEditable(false);
			enemyRemainingWarriorOneInfo.setColumns(10);
			enemyRemainingWarriorOneInfo.setHorizontalAlignment(SwingConstants.CENTER);
			enemyRemainingWarriorOneInfo.setBounds(553, 407, 95, 28);
			backgroundPane.add(enemyRemainingWarriorOneInfo);
			
			enemyBackupOneRedHealthBar = new JTextField();
			enemyBackupOneRedHealthBar.setEditable(false);
			enemyBackupOneRedHealthBar.setColumns(10);
			enemyBackupOneRedHealthBar.setBackground(new Color(255, 0, 0));
			enemyBackupOneRedHealthBar.setBounds(553, 442, (int) Math.min((95*(enemyBackUpWarriorOne.getCurrentHealth()/enemyBackUpWarriorOne.getMaxHealth())), 95), 20);
			backgroundPane.add(enemyBackupOneRedHealthBar);
			
			enemyBackupOneWhiteHealthBar = new JTextField();
			enemyBackupOneWhiteHealthBar.setEditable(false);
			enemyBackupOneWhiteHealthBar.setColumns(10);
			enemyBackupOneWhiteHealthBar.setBackground(Color.WHITE);
			enemyBackupOneWhiteHealthBar.setBounds(553, 442, 95, 20);
			backgroundPane.add(enemyBackupOneWhiteHealthBar);
			
		}
		
		
		if(activeBattle.getEnemy().getEnemyTeam()[2].getCurrentHealth() > 0 && activeBattle.getEnemy().getEnemyTeam()[2] != activeBattle.getActiveEnemyWarrior()) {

			Warrior enemyBackUpWarriorTwo = activeBattle.getEnemy().getEnemyTeam()[2];

			enemyRemainingWarriorTwoInfo = new JTextField();
			enemyRemainingWarriorTwoInfo.setText(enemyBackUpWarriorTwo.getType());
			enemyRemainingWarriorTwoInfo.setEditable(false);
			enemyRemainingWarriorTwoInfo.setHorizontalAlignment(SwingConstants.CENTER);
			enemyRemainingWarriorTwoInfo.setColumns(10);
			enemyRemainingWarriorTwoInfo.setBounds(658, 407, 95, 28);
			backgroundPane.add(enemyRemainingWarriorTwoInfo);
			
			enemyBackupOneRedHealthBar = new JTextField();
			enemyBackupOneRedHealthBar.setEditable(false);
			
			enemyBackupOneRedHealthBar.setColumns(10);
			enemyBackupOneRedHealthBar.setBackground(new Color(255, 0, 0));
			enemyBackupOneRedHealthBar.setBounds(658, 442, (int) Math.min((95*(enemyBackUpWarriorTwo.getCurrentHealth()/enemyBackUpWarriorTwo.getMaxHealth())), 95), 20);
			backgroundPane.add(enemyBackupOneRedHealthBar);
			
			enemyBackupTwoWhiteHealthBar = new JTextField();
			enemyBackupTwoWhiteHealthBar.setEditable(false);
			enemyBackupTwoWhiteHealthBar.setColumns(10);
			enemyBackupTwoWhiteHealthBar.setBackground(Color.WHITE);
			enemyBackupTwoWhiteHealthBar.setBounds(658, 442, 95, 20);
			backgroundPane.add(enemyBackupTwoWhiteHealthBar);


		}
		setLocationRelativeTo(null);
	}
}
