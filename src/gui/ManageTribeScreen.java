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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class ManageTribeScreen extends JFrame {

	private JPanel backgroundPane;
	private JTextPane warriorFourInfoPane;
	private JButton sellWarriorFourButton;
	private JLabel warriorFourImage;

	/**
	 * Create the frame.
	 */
	public ManageTribeScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManageTribeScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussle of Tribes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel manageTribeTitle = new JLabel("Manage Tribe");
		manageTribeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		manageTribeTitle.setForeground(Color.WHITE);
		manageTribeTitle.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		manageTribeTitle.setBounds(252, 23, 364, 47);
		backgroundPane.add(manageTribeTitle);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame home = new HomeScreen(game, player, store, battleHub);
				home.setVisible(true);
			}
		});
		backButton.setForeground(Color.BLACK);
		backButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 22));
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(10, 517, 121, 33);
		backgroundPane.add(backButton);
		
		// Check if there is a warrior to fill this space
		
		if (player.getTeam().size() > 0) {
			JTextPane warriorOneInfoPane = new JTextPane();
			warriorOneInfoPane.setText(player.getTeam().get(0).getDescription());
			warriorOneInfoPane.setEditable(false);
			warriorOneInfoPane.setBounds(30, 309, 168, 86);
			backgroundPane.add(warriorOneInfoPane);
			
			JLabel warriorOneImage = new JLabel("");
			warriorOneImage.setIcon(new ImageIcon(ManageTribeScreen.class.getResource(player.getTeam().get(0).getImage())));
			warriorOneImage.setBounds(30, 170, 168, 137);
			backgroundPane.add(warriorOneImage);
			
			JButton sellWarriorOneButton = new JButton("SELL");
			sellWarriorOneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellWarrior(0);
					JOptionPane.showMessageDialog(null, "Warrior sold!");
					// Refresh window
					dispose();
					JFrame tribeScreen = new ManageTribeScreen(game, player, store, battleHub);
					tribeScreen.setVisible(true);
				}
			});
			sellWarriorOneButton.setBounds(69, 406, 89, 23);
			backgroundPane.add(sellWarriorOneButton);
			
		}
		
		if (player.getTeam().size() > 1) {
			JTextPane warriorTwoInfoPane = new JTextPane();
			warriorTwoInfoPane.setText(player.getTeam().get(1).getDescription());
			warriorTwoInfoPane.setEditable(false);
			warriorTwoInfoPane.setBounds(253, 309, 168, 86);
			backgroundPane.add(warriorTwoInfoPane);
			
			JLabel warriorTwoImage = new JLabel("");
			warriorTwoImage.setIcon(new ImageIcon(ManageTribeScreen.class.getResource(player.getTeam().get(1).getImage())));
			warriorTwoImage.setBounds(253, 170, 168, 137);
			backgroundPane.add(warriorTwoImage);
			
			JButton sellWarriorTwoButton = new JButton("SELL");
			sellWarriorTwoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellWarrior(1);
					JOptionPane.showMessageDialog(null, "Warrior sold!");
					// Refresh window
					dispose();
					JFrame tribeScreen = new ManageTribeScreen(game, player, store, battleHub);
					tribeScreen.setVisible(true);
				}
			});
			sellWarriorTwoButton.setBounds(294, 406, 89, 23);
			backgroundPane.add(sellWarriorTwoButton);
			
		}
		
			
			if (player.getTeam().size() > 2) {
			JTextPane warriorThreeInfoPane = new JTextPane();
			warriorThreeInfoPane.setText(player.getTeam().get(2).getDescription());
			warriorThreeInfoPane.setEditable(false);
			warriorThreeInfoPane.setBounds(472, 309, 168, 86);
			backgroundPane.add(warriorThreeInfoPane);
			
			JLabel warriorThreeImage = new JLabel("");
			warriorThreeImage.setIcon(new ImageIcon(ManageTribeScreen.class.getResource(player.getTeam().get(2).getImage())));
			warriorThreeImage.setBounds(472, 170, 168, 137);
			backgroundPane.add(warriorThreeImage);

			JButton sellWarriorThreeButton = new JButton("SELL");
			sellWarriorThreeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellWarrior(2);
					JOptionPane.showMessageDialog(null, "Warrior sold!");
					// Refresh window
					dispose();
					JFrame tribeScreen = new ManageTribeScreen(game, player, store, battleHub);
					tribeScreen.setVisible(true);
				}
			});
			sellWarriorThreeButton.setBounds(513, 406, 89, 23);
			backgroundPane.add(sellWarriorThreeButton);
			}
			
			
		if (player.getTeam().size() > 3) {
			JTextPane warriorFourInfoPane;
			warriorFourInfoPane = new JTextPane();
			warriorFourInfoPane.setText(player.getTeam().get(3).getDescription());
			warriorFourInfoPane.setEditable(false);
			warriorFourInfoPane.setBounds(682, 309, 168, 86);
			backgroundPane.add(warriorFourInfoPane);
			
			JLabel warriorFourImage;
			warriorFourImage = new JLabel("");
			warriorFourImage.setIcon(new ImageIcon(ManageTribeScreen.class.getResource(player.getTeam().get(3).getImage())));
			warriorFourImage.setBounds(682, 170, 168, 137);
			backgroundPane.add(warriorFourImage);

			JButton sellWarriorFourButton;
			sellWarriorFourButton = new JButton("SELL");
			sellWarriorFourButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellWarrior(3);
					JOptionPane.showMessageDialog(null, "Warrior sold!");
					// Refresh window
					dispose();
					JFrame tribeScreen = new ManageTribeScreen(game, player, store, battleHub);
					tribeScreen.setVisible(true);
				}
			});
			sellWarriorFourButton.setBounds(723, 406, 89, 23);
			backgroundPane.add(sellWarriorFourButton);
		}
		setLocationRelativeTo(null);
	}
}
