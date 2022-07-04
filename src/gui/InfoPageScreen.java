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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class InfoPageScreen extends JFrame {

	private JPanel backgroundPane;

	/**
	 * Create the frame.
	 */
	public InfoPageScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfoPageScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussle of Tribes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel gameInfoLabel = new JLabel("Game Information");
		gameInfoLabel.setBounds(0, 27, 874, 47);
		gameInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameInfoLabel.setForeground(Color.WHITE);
		gameInfoLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		backgroundPane.add(gameInfoLabel);
		
		JButton startButton = new JButton("Start your noble quest");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame home = new HomeScreen(game, player, store, battleHub);
				home.setVisible(true);
			}
		});
		startButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 25));
		startButton.setBounds(231, 467, 421, 47);
		backgroundPane.add(startButton);
		
		JPanel welcomeTextBorder = new JPanel();
		welcomeTextBorder.setBackground(Color.LIGHT_GRAY);
		welcomeTextBorder.setBounds(131, 85, 610, 339);
		backgroundPane.add(welcomeTextBorder);
		welcomeTextBorder.setLayout(null);
		
		JTextArea welcomeText = new JTextArea();
		welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 13));
		welcomeText.setText("Welcome to Tussel of Tribes, a game of bravery, love and sacrifice, \r\nwhere you venture far and wide on a journey to "
				+ "discover the origins of\r\nthe long lost Tribes. You will face numerous encounters on your crusade \r\nfor worthiness, challenging your endurance, "
				+ "resilliance and wit. \r\n\r\nAs you progress your pilgrimage, you will find value in the long lost\r\ncurrency of magic beans, to trade at the local"
				+ " markets, or tempt the \r\nhearts of foreign Warriors as they discover a sense of belonging in your\r\nfellowship. \r\n\r\nYou will lead your tribe "
				+ "against countless skirmishes in order to \r\nrewrite history and find gratification in your endeavour to be the\r\ngreatest Tribe in the lands.\r\n\r\nYour "
				+ "prestiege as a Tribe will rise with every victorious encounter,\r\ngreatly so in overcoming overwhelming odds against tougher opponents.\r\nYou will be "
				+ "rewarded generously with magic beans. \r\n");
		
		welcomeText.setEditable(false);
		welcomeText.setBounds(10, 11, 590, 317);
		welcomeTextBorder.add(welcomeText);
		
		setLocationRelativeTo(null);
	}
}
