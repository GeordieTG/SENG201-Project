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
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class QuitScreen extends JFrame {

	private JPanel backgroundPane;


	/**
	 * Create the frame.
	 */
	public QuitScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(QuitScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussel of Tribes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel confirmQuitLabel = new JLabel("Are you sure you want to quit?");
		confirmQuitLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		confirmQuitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confirmQuitLabel.setForeground(Color.WHITE);
		confirmQuitLabel.setBounds(100, 208, 660, 73);
		backgroundPane.add(confirmQuitLabel);
		
		JButton noButton = new JButton("No");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame home = new HomeScreen(game, player, store, battleHub);
				home.setVisible(true);
			}
		});
		noButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 25));
		noButton.setBounds(440, 308, 302, 47);
		backgroundPane.add(noButton);
		
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		yesButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 25));
		yesButton.setBounds(116, 308, 302, 47);
		backgroundPane.add(yesButton);
		
		setLocationRelativeTo(null);
	}

}
