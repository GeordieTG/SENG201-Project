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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class EndDayScreen extends JFrame {

	private JPanel backgroundPane;

	/**
	 * Create the frame.
	 */
	public EndDayScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel endOfDayLabel = new JLabel();
		endOfDayLabel.setText("End of day " + game.getCurrentDay());
		endOfDayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		endOfDayLabel.setForeground(Color.WHITE);
		endOfDayLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		endOfDayLabel.setBounds(252, 44, 364, 47);
		backgroundPane.add(endOfDayLabel);
		
		JLabel pointsGainedTodayLabel = new JLabel("Points gained today:");
		pointsGainedTodayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointsGainedTodayLabel.setForeground(Color.WHITE);
		pointsGainedTodayLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 30));
		pointsGainedTodayLabel.setBounds(103, 343, 325, 56);
		backgroundPane.add(pointsGainedTodayLabel);
		
		JLabel pointsGainedAmount = new JLabel();
		pointsGainedAmount.setText(game.getPointsGainedToday() + "");
		pointsGainedAmount.setForeground(Color.WHITE);
		pointsGainedAmount.setFont(new Font("Consolas", Font.PLAIN, 25));
		pointsGainedAmount.setBounds(429, 351, 153, 45);
		backgroundPane.add(pointsGainedAmount);
		
		JButton nextDayButton = new JButton();
	
		if (game.getCurrentDay() == game.getGameLength()) {
			nextDayButton.setText("Finish");
			nextDayButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					CreditsScreen creditsScreen = new CreditsScreen(game, player, store, battleHub);
					creditsScreen.setVisible(true);
				}
			});
		} else {
			nextDayButton.setText("Start day " + (game.getCurrentDay() + 1));
			nextDayButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String description = game.endDay(player, game, store, battleHub);
					
					if (description == "") description = "Nothing happened overnight!";
					
					JOptionPane.showMessageDialog(null, description);
					
					dispose();
					HomeScreen homeScreen = new HomeScreen(game, player, store, battleHub);
					homeScreen.setVisible(true);
				}
			});
		}

		nextDayButton.setForeground(Color.BLACK);
		nextDayButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 22));
		nextDayButton.setBackground(Color.WHITE);
		nextDayButton.setBounds(289, 442, 306, 47);
		backgroundPane.add(nextDayButton);
		
		JPanel endBattleTextBackground = new JPanel();
		endBattleTextBackground.setLayout(null);
		endBattleTextBackground.setBackground(Color.LIGHT_GRAY);
		endBattleTextBackground.setBounds(182, 161, 526, 148);
		backgroundPane.add(endBattleTextBackground);
		
		JTextArea txtrAsTheLast = new JTextArea();
		txtrAsTheLast.setText("\n\n  As the last light fails, your eyes grow weary as you drift...\n  zzzz....zzzzz......zzz....zzz......................\n");
		txtrAsTheLast.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrAsTheLast.setEditable(false);
		txtrAsTheLast.setBounds(10, 11, 506, 125);
		endBattleTextBackground.add(txtrAsTheLast);
		
		setLocationRelativeTo(null);

	}
}
