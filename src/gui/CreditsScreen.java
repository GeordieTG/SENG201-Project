package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.BattleHub;
import main.GameEnvironment;
import main.Player;
import main.Store;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class CreditsScreen extends JFrame {

	private JPanel backgroundPane;

	/**
	 * Create the frame.
	 */
	
	public CreditsScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreditsScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussle of Tribes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel creditsTitle = new JLabel();
		creditsTitle.setBounds(157, 52, 557, 47);
		creditsTitle.setText("Your journey ends here...");
		creditsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		creditsTitle.setForeground(Color.WHITE);
		creditsTitle.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		backgroundPane.add(creditsTitle);
		
		JLabel beansEarnedLabel = new JLabel("Beans Earned:");
		beansEarnedLabel.setBounds(179, 375, 325, 56);
		beansEarnedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		beansEarnedLabel.setForeground(Color.WHITE);
		beansEarnedLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 30));
		backgroundPane.add(beansEarnedLabel);
		
		JLabel finalScoreAmount = new JLabel();
		finalScoreAmount.setBounds(446, 432, 237, 45);
		finalScoreAmount.setText(game.getPoints() + "");
		finalScoreAmount.setForeground(Color.WHITE);
		finalScoreAmount.setFont(new Font("Consolas", Font.PLAIN, 25));
		backgroundPane.add(finalScoreAmount);
		
		JLabel finalScoreLabel = new JLabel("Final Score:");
		finalScoreLabel.setBounds(193, 424, 325, 56);
		finalScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		finalScoreLabel.setForeground(Color.WHITE);
		finalScoreLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 30));
		backgroundPane.add(finalScoreLabel);
		
		JLabel beansEarnedAmount = new JLabel();
		beansEarnedAmount.setBounds(446, 383, 254, 45);
		beansEarnedAmount.setText(player.getTotalBeansGained() + "");
		beansEarnedAmount.setForeground(Color.WHITE);
		beansEarnedAmount.setFont(new Font("Consolas", Font.PLAIN, 25));
		backgroundPane.add(beansEarnedAmount);
		
		JPanel farewellTextBackground = new JPanel();
		farewellTextBackground.setBounds(167, 110, 526, 249);
		farewellTextBackground.setLayout(null);
		farewellTextBackground.setBackground(Color.LIGHT_GRAY);
		backgroundPane.add(farewellTextBackground);
		
		JTextArea farewellText = new JTextArea();
		farewellText.setText("  \n\n\n   No matter how your journey has ended, you have upholded \n   the values of your people and done "
				+ "your tribe proud. Your\n   acts of bravery and fearlessness will be spoken of\n   throughout the lands, and for many years "
				+ "to come. The\n   inspired younger generations will certainly read of your\n   legacy. Until we meet again, " + player.getUsername() + ".");
		farewellText.setFont(new Font("Monospaced", Font.PLAIN, 13));
		farewellText.setEditable(false);
		farewellText.setBounds(10, 11, 506, 227);
		farewellTextBackground.add(farewellText);
		
		JLabel daysLastedLabel = new JLabel("Days Lasted:");
		daysLastedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		daysLastedLabel.setForeground(Color.WHITE);
		daysLastedLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 30));
		daysLastedLabel.setBounds(179, 478, 325, 56);
		backgroundPane.add(daysLastedLabel);
		
		JLabel daysLastedAmountLabel = new JLabel();
		daysLastedAmountLabel.setText(game.getCurrentDay() + " / " + game.getGameLength());
		daysLastedAmountLabel.setForeground(Color.WHITE);
		daysLastedAmountLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		daysLastedAmountLabel.setBounds(446, 484, 208, 45);
		backgroundPane.add(daysLastedAmountLabel);
		
		setLocationRelativeTo(null);
	
	}
}
