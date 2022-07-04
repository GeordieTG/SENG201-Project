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

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class BattleSummaryScreen extends JFrame {

	private JPanel backgroundPane;

	/**
	 * Create the frame.
	 */
	public BattleSummaryScreen(boolean battleWon, Battle battle, GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setResizable(false);

		player.resetPlayer();
		battle.getEnemy().resetEnemyStats();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(BattleSummaryScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussle of Tribes\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel battleSummaryTitle = new JLabel();
		if (battleWon) {
			battleSummaryTitle.setText("You Win!");
		} else {
			battleSummaryTitle.setText("You Lose!");
		}
		
		battleSummaryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		battleSummaryTitle.setForeground(Color.WHITE);
		battleSummaryTitle.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		battleSummaryTitle.setBounds(247, 103, 364, 47);
		backgroundPane.add(battleSummaryTitle);
		
		JButton homeButton = new JButton();

		homeButton.setText("Back to tribe");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame manageTribeScreen = new ManageTribeScreen(game, player, store, battleHub);
				manageTribeScreen.setVisible(true);
			}
		});

		homeButton.setForeground(Color.BLACK);
		homeButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 22));
		homeButton.setBackground(Color.WHITE);
		homeButton.setBounds(301, 481, 280, 47);
		backgroundPane.add(homeButton);
		
		JLabel beansWonLabel = new JLabel("Beans won:");
		beansWonLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 30));
		beansWonLabel.setForeground(Color.WHITE);
		beansWonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		beansWonLabel.setBounds(267, 341, 168, 56);
		backgroundPane.add(beansWonLabel);
		
		JLabel pointsGainedLabel = new JLabel("Points gained:");
		pointsGainedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointsGainedLabel.setForeground(Color.WHITE);
		pointsGainedLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 30));
		pointsGainedLabel.setBounds(220, 408, 219, 56);
		backgroundPane.add(pointsGainedLabel);
		
		JLabel beansWonAmount = new JLabel();
		if (battleWon) beansWonAmount.setText(battle.getReward(battle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier()) + "");
		else beansWonAmount.setText(0 + "");
		beansWonAmount.setFont(new Font("Consolas", Font.PLAIN, 25));
		beansWonAmount.setForeground(Color.WHITE);
		beansWonAmount.setBounds(443, 352, 153, 45);
		backgroundPane.add(beansWonAmount);
		
		JLabel pointsGainedAmount = new JLabel();
		if (battleWon) pointsGainedAmount.setText(battle.getPointsReward(battle.getEnemy().getAverageLevel(), game.getDifficultyMultiplier()) + "");
		else pointsGainedAmount.setText(0 + "");
		pointsGainedAmount.setForeground(Color.WHITE);
		pointsGainedAmount.setFont(new Font("Consolas", Font.PLAIN, 25));
		pointsGainedAmount.setBounds(443, 418, 153, 45);
		backgroundPane.add(pointsGainedAmount);
		
		JPanel endBattleTextBackground = new JPanel();
		endBattleTextBackground.setLayout(null);
		endBattleTextBackground.setBackground(Color.LIGHT_GRAY);
		endBattleTextBackground.setBounds(179, 181, 526, 148);
		backgroundPane.add(endBattleTextBackground);
		
		JTextArea endBattleTextPane = new JTextArea();
		endBattleTextPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
		endBattleTextPane.setEditable(false);
		endBattleTextPane.setBounds(10, 11, 506, 125);
		endBattleTextBackground.add(endBattleTextPane);
		
		if (battleWon) {
			endBattleTextPane.setText("\n\n  You emerge victorious, " + player.getUsername() + "!\n  Word of your victory will spread "
					+ "throughout the lands.\n  Return home to celebrate, and bathe in your riches. \n");
		} else {
			endBattleTextPane.setText("\n\n\n  Defeat is not surrender, " + player.getUsername() + ". \n  Take this loss as a lesson. Come back stronger.");
			
		}
		setLocationRelativeTo(null);
		
		
	}
}
