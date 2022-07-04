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
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class HomeScreen extends JFrame {

	private JPanel backgroundPane;

	public HomeScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		
		// Check if the game should end, if so go to CreditScreen
		if (game.shouldEndGame(player, store)) {
			dispose();
			CreditsScreen creditsScreen = new CreditsScreen(game, player, store, battleHub);
			creditsScreen.setVisible(true);
		} else if (game.getBattlesCompletedToday() == 3) {
			
			dispose();
			JFrame endDay = new EndDayScreen(game, player, store, battleHub);
			endDay.setVisible(true);
			
		} else {
			setIconImage(Toolkit.getDefaultToolkit().getImage(HomeScreen.class.getResource("/images/TussleOfTribesLogo.png")));
			setFont(new Font("Baekmuk Batang", Font.PLAIN, 20));
			setForeground(Color.BLACK);
			setResizable(false);
			setTitle("Tussle of Tribes");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 900, 600);
			backgroundPane = new JPanel();
			backgroundPane.setBackground(Color.DARK_GRAY);
			backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(backgroundPane);
			backgroundPane.setLayout(null);
			
			JLabel homeLabel = new JLabel("Home");
			homeLabel.setBounds(251, 31, 364, 47);
			homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			homeLabel.setForeground(Color.WHITE);
			homeLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
			backgroundPane.add(homeLabel);
			
			JButton battleButton = new JButton("Battle");
			battleButton.setBackground(Color.WHITE);
			battleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					JFrame manageBattleScreen = new SelectBattleScreen(game, player, store, battleHub);
					manageBattleScreen.setVisible(true);
				}
			});
			battleButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 25));
			battleButton.setBounds(286, 138, 302, 47);
			backgroundPane.add(battleButton);
			
			JButton manageTribeButton = new JButton("Manage Tribe");
			manageTribeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					JFrame manageTribe = new ManageTribeScreen(game, player, store, battleHub);
					manageTribe.setVisible(true);
				}
			});
			manageTribeButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 25));
			manageTribeButton.setBounds(286, 206, 302, 47);
			backgroundPane.add(manageTribeButton);
			
			JButton inventoryButton = new JButton("Inventory");
			inventoryButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					JFrame inventory = new InventoryScreen(game, player, store, battleHub);
					inventory.setVisible(true);
				}
			});
			inventoryButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 25));
			inventoryButton.setBounds(286, 275, 302, 47);
			backgroundPane.add(inventoryButton);
			
			JButton shopButton = new JButton("Shop");
			shopButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					JFrame shop = new ShopScreen(game, player, store, battleHub);
					shop.setVisible(true);
				}
			});
			shopButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 25));
			shopButton.setBounds(286, 343, 302, 47);
			backgroundPane.add(shopButton);
			
			JButton quitButton = new JButton("Quit");
			quitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					JFrame quit = new QuitScreen(game, player, store, battleHub);
					quit.setVisible(true);
				}
			});
			quitButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 22));
			quitButton.setBounds(10, 517, 121, 33);
			backgroundPane.add(quitButton);
			
			JLabel beanImage = new JLabel("");
			beanImage.setIcon(new ImageIcon(HomeScreen.class.getResource("/images/Bean.png")));
			beanImage.setBounds(620, 41, 40, 52);
			backgroundPane.add(beanImage);
			
			JLabel beansBalance = new JLabel();
			beansBalance.setText(String.valueOf(player.getBeans()));
			beansBalance.setFont(new Font("Tahoma", Font.PLAIN, 22));
			beansBalance.setBackground(Color.CYAN);
			beansBalance.setForeground(Color.WHITE);
			beansBalance.setBounds(652, 41, 127, 52);
			backgroundPane.add(beansBalance);
			
			JLabel dayCounterLabel = new JLabel();
			dayCounterLabel.setText("Day " + game.getCurrentDay() + " / " + game.getGameLength());
			dayCounterLabel.setForeground(Color.WHITE);
			dayCounterLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			dayCounterLabel.setBackground(Color.CYAN);
			dayCounterLabel.setBounds(10, 5, 183, 38);
			backgroundPane.add(dayCounterLabel);
			
			JLabel battleCounterLabel = new JLabel();
			battleCounterLabel.setText("Completed " + game.getBattlesCompletedToday() + " / 3 Battles today");
			battleCounterLabel.setForeground(Color.WHITE);
			battleCounterLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			battleCounterLabel.setBackground(Color.CYAN);
			battleCounterLabel.setBounds(10, 40, 290, 38);
			backgroundPane.add(battleCounterLabel);
			
			JLabel scoreLabel = new JLabel();
			scoreLabel.setText("Score: " + game.getPoints());
			scoreLabel.setForeground(Color.WHITE);
			scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			scoreLabel.setBackground(Color.CYAN);
			scoreLabel.setBounds(625, 11, 183, 38);
			backgroundPane.add(scoreLabel);
			
			JButton sleepButton = new JButton("Sleep");
			sleepButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					EndDayScreen endDayScreen = new EndDayScreen(game, player, store, battleHub);
					endDayScreen.setVisible(true);
				}
			});
			sleepButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 22));
			sleepButton.setBounds(765, 517, 121, 33);
			backgroundPane.add(sleepButton);
			
			setLocationRelativeTo(null);
		
		}
	}
}
