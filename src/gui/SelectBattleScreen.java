package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.BattleHub;
import main.Enemy;
import main.GameEnvironment;
import main.Player;
import main.Store;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SelectBattleScreen extends JFrame {

	private JPanel backgroundPane;

	/**
	 * Create the frame.
	 */
	public SelectBattleScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelectBattleScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussel of Tribes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel selectBattleTitle = new JLabel("Select Battle");
		selectBattleTitle.setHorizontalAlignment(SwingConstants.CENTER);
		selectBattleTitle.setForeground(Color.WHITE);
		selectBattleTitle.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		selectBattleTitle.setBounds(263, 11, 364, 47);
		backgroundPane.add(selectBattleTitle);
		
		JButton backButton = new JButton("Back");
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(Color.WHITE);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame home = new HomeScreen(game, player, store, battleHub);
				home.setVisible(true);

			}
		});
		backButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 22));
		backButton.setBounds(10, 517, 121, 33);
		backgroundPane.add(backButton);
		
		if (!battleHub.getBattle(0).getBattleCompleted()) {
			
			Enemy enemyOne = battleHub.getBattle(0).getEnemy();
		
			JLabel enemyOneLabel = new JLabel(enemyOne.getName());
			enemyOneLabel.setForeground(Color.WHITE);
			enemyOneLabel.setFont(new Font("Engravers MT", Font.BOLD | Font.ITALIC, 20));
			enemyOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
			enemyOneLabel.setBounds(59, 72, 217, 33);
			backgroundPane.add(enemyOneLabel);
			
			
			JTextPane battleOneInfoPane = new JTextPane();
			battleOneInfoPane.setText(enemyOne.getDescription(battleHub.getBattle(0), game.getDifficultyMultiplier()));
			battleOneInfoPane.setEditable(false);
			battleOneInfoPane.setBounds(59, 342, 217, 102);
			backgroundPane.add(battleOneInfoPane);
			
			JButton chooseBattleOneButton = new JButton("BATTLE");
			chooseBattleOneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (player.checkWarriorsAlive()) {
						battleHub.getBattle(0).setNextPlayerWarrior(player);
						setVisible(false);
						JFrame battleScreen = new BattleScreen(battleHub.getBattle(0), game, player, store, battleHub);
						battleScreen.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "All your monsters have fainted!");
					}
				}
			});
			chooseBattleOneButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 22));
			chooseBattleOneButton.setBounds(93, 455, 148, 41);
			backgroundPane.add(chooseBattleOneButton);
			
			JLabel enemyOneWarriorOneImage = new JLabel("");
			enemyOneWarriorOneImage.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(enemyOne.getEnemyTeam()[0].getImage())));
			enemyOneWarriorOneImage.setHorizontalAlignment(SwingConstants.CENTER);
			enemyOneWarriorOneImage.setBounds(117, 99, 108, 120);
			backgroundPane.add(enemyOneWarriorOneImage);
			
			JLabel enemyOneWarriorTwoImage = new JLabel("");
			enemyOneWarriorTwoImage.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(enemyOne.getEnemyTeam()[1].getImage())));
			enemyOneWarriorTwoImage.setHorizontalAlignment(SwingConstants.CENTER);
			enemyOneWarriorTwoImage.setBounds(59, 211, 108, 120);
			backgroundPane.add(enemyOneWarriorTwoImage);
			
			JLabel enemyOneWarriorThreeImage = new JLabel("");
			enemyOneWarriorThreeImage.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(enemyOne.getEnemyTeam()[2].getImage())));
			enemyOneWarriorThreeImage.setHorizontalAlignment(SwingConstants.CENTER);
			enemyOneWarriorThreeImage.setBounds(167, 211, 108, 120);
			backgroundPane.add(enemyOneWarriorThreeImage);
			
		}

		if (!battleHub.getBattle(1).getBattleCompleted()) {

			Enemy enemyTwo = battleHub.getBattle(1).getEnemy();

			JLabel enemyTwoLabel = new JLabel(enemyTwo.getName());
			enemyTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			enemyTwoLabel.setForeground(Color.WHITE);
			enemyTwoLabel.setFont(new Font("Engravers MT", Font.BOLD | Font.ITALIC, 20));
			enemyTwoLabel.setBounds(340, 72, 217, 33);
			backgroundPane.add(enemyTwoLabel);
			
			JTextPane battleTwoInfoPane = new JTextPane();
			battleTwoInfoPane.setText(enemyTwo.getDescription(battleHub.getBattle(1), game.getDifficultyMultiplier()));
			battleTwoInfoPane.setEditable(false);
			battleTwoInfoPane.setBounds(350, 342, 217, 102);
			backgroundPane.add(battleTwoInfoPane);
			
			JButton chooseBattleTwoButton = new JButton("BATTLE");
			chooseBattleTwoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					battleHub.getBattle(1).setNextPlayerWarrior(player);
					if (player.checkWarriorsAlive()) {
						setVisible(false);
						JFrame battleScreen = new BattleScreen(battleHub.getBattle(1), game, player, store, battleHub);
						battleScreen.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "All your monsters have fainted!");
					}
				}
			});
			chooseBattleTwoButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 22));
			chooseBattleTwoButton.setBounds(374, 455, 148, 41);
			backgroundPane.add(chooseBattleTwoButton);
			
			JLabel enemyTwoWarriorOneImage = new JLabel("");
			enemyTwoWarriorOneImage.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(enemyTwo.getEnemyTeam()[0].getImage())));
			enemyTwoWarriorOneImage.setHorizontalAlignment(SwingConstants.CENTER);
			enemyTwoWarriorOneImage.setBounds(398, 101, 108, 120);
			backgroundPane.add(enemyTwoWarriorOneImage);
			
			JLabel enemyTwoWarriorTwoImage = new JLabel("");
			enemyTwoWarriorTwoImage.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(enemyTwo.getEnemyTeam()[1].getImage())));
			enemyTwoWarriorTwoImage.setHorizontalAlignment(SwingConstants.CENTER);
			enemyTwoWarriorTwoImage.setBounds(351, 211, 108, 120);
			backgroundPane.add(enemyTwoWarriorTwoImage);
			
			JLabel enemyTwoWarriorThreeImage = new JLabel("");
			enemyTwoWarriorThreeImage.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(enemyTwo.getEnemyTeam()[2].getImage())));
			enemyTwoWarriorThreeImage.setHorizontalAlignment(SwingConstants.CENTER);
			enemyTwoWarriorThreeImage.setBounds(459, 211, 108, 120);
			backgroundPane.add(enemyTwoWarriorThreeImage);
		
		
		}
		

		if (!battleHub.getBattle(2).getBattleCompleted()) {

			Enemy enemyThree = battleHub.getBattle(2).getEnemy();
			
			JLabel enemyThreeLabel = new JLabel(enemyThree.getName());
			enemyThreeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			enemyThreeLabel.setForeground(Color.WHITE);
			enemyThreeLabel.setFont(new Font("Engravers MT", Font.BOLD | Font.ITALIC, 20));
			enemyThreeLabel.setBounds(624, 72, 217, 33);
			backgroundPane.add(enemyThreeLabel);
			
			JTextPane battleThreeInfoPane = new JTextPane();
			battleThreeInfoPane.setText(enemyThree.getDescription(battleHub.getBattle(2), game.getDifficultyMultiplier()));
			battleThreeInfoPane.setEditable(false);
			battleThreeInfoPane.setBounds(624, 342, 217, 102);
			backgroundPane.add(battleThreeInfoPane);
			
			JButton chooseBattleThreeButton = new JButton("BATTLE");
			chooseBattleThreeButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {								
					if (player.checkWarriorsAlive()) {
						battleHub.getBattle(2).setNextPlayerWarrior(player);
						setVisible(false);
						JFrame battleScreen = new BattleScreen(battleHub.getBattle(2), game, player, store, battleHub);
						battleScreen.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "All your monsters have fainted!");
					}
				}
			});
			chooseBattleThreeButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 22));
			chooseBattleThreeButton.setBounds(661, 455, 148, 41);
			backgroundPane.add(chooseBattleThreeButton);
			
			JLabel enemyThreeWarriorOneImage = new JLabel("");
			enemyThreeWarriorOneImage.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(enemyThree.getEnemyTeam()[0].getImage())));
			enemyThreeWarriorOneImage.setHorizontalAlignment(SwingConstants.CENTER);
			enemyThreeWarriorOneImage.setBounds(682, 99, 108, 120);
			backgroundPane.add(enemyThreeWarriorOneImage);
			
			JLabel enemyThreeWarriorTwoImage = new JLabel("");
			enemyThreeWarriorTwoImage.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(enemyThree.getEnemyTeam()[1].getImage())));
			enemyThreeWarriorTwoImage.setHorizontalAlignment(SwingConstants.CENTER);
			enemyThreeWarriorTwoImage.setBounds(624, 211, 108, 120);
			backgroundPane.add(enemyThreeWarriorTwoImage);
			
			JLabel enemyThreeWarriorThreeImage = new JLabel("");
			enemyThreeWarriorThreeImage.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(enemyThree.getEnemyTeam()[2].getImage())));
			enemyThreeWarriorThreeImage.setHorizontalAlignment(SwingConstants.CENTER);
			enemyThreeWarriorThreeImage.setBounds(732, 211, 108, 120);
			backgroundPane.add(enemyThreeWarriorThreeImage);
		
		}
		setLocationRelativeTo(null);
	}
}
