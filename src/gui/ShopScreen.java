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
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class ShopScreen extends JFrame {

	private JPanel backgroundPane;

	/**
	 * Create the frame.
	 */
	
	public void buyWarrior(int selection, Store store, Player player, GameEnvironment game, BattleHub battleHub) {
		
		// Buys a warrior based on which button pressed (selection) or prints error based on result
		int purchaseSuccessful = store.buyWarrior(store.getTodaysWarriors()[selection - 1], player, game);
		if (purchaseSuccessful == 2) {	
			store.setWarriorPurchased(selection);
			dispose();
			// Get the last item in the  player team list, since this is the one that has just been added
			JFrame confirmPurchase = new SetWarriorNicknameScreen(player.getTeam().get(player.getTeam().size() - 1), game, player, store, battleHub);
			confirmPurchase.setVisible(true);
			
		} else if (purchaseSuccessful == 0) {
			JOptionPane.showMessageDialog(null, "Purchase Unsuccessful! Your team is full! (Try selling a current warrior)");
			
		} else {
			JOptionPane.showMessageDialog(null, "Purchase Unsuccessful! You cannot afford this Warrior!");
		}
		
	}
	
	public void buyItem(int selection, Store store, Player player, GameEnvironment game, BattleHub battleHub) {
		
		int purchaseSuccessful = store.buyItem(selection, player, game);
		
		switch(purchaseSuccessful) {
			case 0:
				JOptionPane.showMessageDialog(null, "Purchase Unsuccessful! There are not enough of this item left to buy!");	
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Purchase Unsuccessful! You cannot afford this item!");	
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "You bought 1 " + store.getStoreItem(selection).getItemName() + " for $" + store.getStoreItem(selection).getPrice());
				// Refresh the shop with new changes after item bought
				dispose();
				JFrame shop = new ShopScreen(game, player, store, battleHub);
				shop.setVisible(true);
				break;
			case -1:
				JOptionPane.showMessageDialog(null, "Purchase Unsuccessful - an unexpected error occured.");
				break;
		}
		
	}
	
	public ShopScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussel of Tribes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel shopLabel = new JLabel("Shop");
		shopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shopLabel.setForeground(Color.WHITE);
		shopLabel.setFont(new Font("Baekmuk Batang", Font.PLAIN, 50));
		shopLabel.setBounds(246, 24, 364, 47);
		backgroundPane.add(shopLabel);
		
		JLabel beanImage = new JLabel("");
		beanImage.setIcon(new ImageIcon(HomeScreen.class.getResource("/images/Bean.png")));
		beanImage.setBounds(718, 0, 40, 52);
		backgroundPane.add(beanImage);
		
		JLabel beansBalance = new JLabel();
		beansBalance.setText(String.valueOf(player.getBeans()));
		beansBalance.setFont(new Font("Tahoma", Font.PLAIN, 22));
		beansBalance.setBackground(Color.CYAN);
		beansBalance.setForeground(Color.WHITE);
		beansBalance.setBounds(747, 5, 127, 38);
		backgroundPane.add(beansBalance);
		
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
		
		
		if (store.getTodaysWarriors()[0] != null) {
			
			JTextPane warriorOneInfoPane = new JTextPane();
			warriorOneInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			warriorOneInfoPane.setEditable(false);
			warriorOneInfoPane.setText(store.getStoreWarrior(1).getDescription());
			warriorOneInfoPane.setBounds(10, 326, 168, 86);
			backgroundPane.add(warriorOneInfoPane);
			
			JLabel warriorOneImage = new JLabel("");
			warriorOneImage.setIcon(new ImageIcon(ShopScreen.class.getResource(store.getStoreWarrior(1).getImage())));
			warriorOneImage.setBounds(10, 178, 168, 137);
			backgroundPane.add(warriorOneImage);
			
			JButton buyWarriorOneButton = new JButton("BUY");
			buyWarriorOneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buyWarrior(1, store, player, game, battleHub);
				}
			});
			buyWarriorOneButton.setBounds(54, 423, 89, 23);
			backgroundPane.add(buyWarriorOneButton);
			
		}
		
		if (store.getTodaysWarriors()[1] != null) {

		
			JTextPane warriorTwoInfoPane = new JTextPane();
			warriorTwoInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			warriorTwoInfoPane.setEditable(false);
			warriorTwoInfoPane.setText(store.getStoreWarrior(2).getDescription());
			warriorTwoInfoPane.setBounds(188, 326, 168, 86);
			backgroundPane.add(warriorTwoInfoPane);
			
			JLabel warriorTwoImage =  new JLabel("");
			warriorTwoImage.setIcon(new ImageIcon(ShopScreen.class.getResource(store.getStoreWarrior(2).getImage())));
			warriorTwoImage.setBounds(188, 178, 168, 137);
			backgroundPane.add(warriorTwoImage);
			
			
			JButton buyWarriorTwoButton = new JButton("BUY");
			buyWarriorTwoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buyWarrior(2, store, player, game, battleHub);
				}
			});
			buyWarriorTwoButton.setBounds(227, 423, 89, 23);
			backgroundPane.add(buyWarriorTwoButton);
			
		}
		
		if (store.getTodaysWarriors()[2] != null) {
			
			JTextPane warriorThreeInfoPane = new JTextPane();
			warriorThreeInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			warriorThreeInfoPane.setEditable(false);
			warriorThreeInfoPane.setText(store.getStoreWarrior(3).getDescription());
			warriorThreeInfoPane.setBounds(366, 326, 168, 86);
			backgroundPane.add(warriorThreeInfoPane);
			
			JLabel warriorThreeImage = new JLabel("");
			warriorThreeImage.setIcon(new ImageIcon(ShopScreen.class.getResource(store.getStoreWarrior(3).getImage())));
			warriorThreeImage.setBounds(366, 178, 168, 137);
			backgroundPane.add(warriorThreeImage);
			
			JButton buyWarriorThreeButton = new JButton("BUY");
			buyWarriorThreeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buyWarrior(3, store, player, game, battleHub);
				}
			});
			buyWarriorThreeButton.setBounds(404, 423, 89, 23);
			backgroundPane.add(buyWarriorThreeButton);
			
		}
		
		JLabel itemOneImage = new JLabel("");
		itemOneImage.setIcon(new ImageIcon(ShopScreen.class.getResource(store.getStoreItem(1).getImage())));
		itemOneImage.setBounds(569, 148, 89, 86);
		backgroundPane.add(itemOneImage);
		
		JLabel itemTwoImage = new JLabel("");
		itemTwoImage.setIcon(new ImageIcon(ShopScreen.class.getResource(store.getStoreItem(2).getImage())));
		itemTwoImage.setBounds(569, 279, 89, 84);
		backgroundPane.add(itemTwoImage);
		
		JLabel itemThreeImage = new JLabel("");
		itemThreeImage.setIcon(new ImageIcon(ShopScreen.class.getResource("/images/LevelUp.png")));
		itemThreeImage.setBounds(569, 408, 89, 86);
		backgroundPane.add(itemThreeImage);
		
		JTextPane itemOneInfoPane = new JTextPane();
		itemOneInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
		itemOneInfoPane.setEditable(false);
		itemOneInfoPane.setText(store.getStoreItem(1).getDescription());
		itemOneInfoPane.setBounds(657, 148, 159, 86);
		backgroundPane.add(itemOneInfoPane);
		
		JTextPane itemTwoInfoPane = new JTextPane();
		itemTwoInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
		itemTwoInfoPane.setEditable(false);
		itemTwoInfoPane.setText(store.getStoreItem(2).getDescription());
		itemTwoInfoPane.setBounds(655, 279, 161, 84);
		backgroundPane.add(itemTwoInfoPane);
		
		JTextPane itemThreeInfoPane = new JTextPane();
		itemThreeInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
		itemThreeInfoPane.setEditable(false);
		itemThreeInfoPane.setText(store.getStoreItem(3).getDescription());
		itemThreeInfoPane.setBounds(657, 408, 159, 86);
		backgroundPane.add(itemThreeInfoPane);
		

		
		JButton buyItemOneButton = new JButton("BUY");
		buyItemOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(1, store, player, game, battleHub);
			}
		});
		buyItemOneButton.setBounds(694, 245, 89, 23);
		backgroundPane.add(buyItemOneButton);
		
		JButton buyItemTwoButton = new JButton("BUY");
		buyItemTwoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(2, store, player, game, battleHub);
			}
		});
		buyItemTwoButton.setBounds(694, 374, 89, 23);
		backgroundPane.add(buyItemTwoButton);
		
		JButton buyItemThreeButton = new JButton("BUY");
		buyItemThreeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(3, store, player, game, battleHub);
			}
		});
		buyItemThreeButton.setBounds(694, 505, 89, 23);
		backgroundPane.add(buyItemThreeButton);
		

		
		JLabel warriorsLabel = new JLabel("Warriors");
		warriorsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warriorsLabel.setForeground(Color.WHITE);
		warriorsLabel.setFont(new Font("Baekmuk Batang", Font.BOLD, 35));
		warriorsLabel.setBounds(91, 100, 364, 47);
		backgroundPane.add(warriorsLabel);
		
		JLabel itemsLabel = new JLabel("Items");
		itemsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemsLabel.setForeground(Color.WHITE);
		itemsLabel.setFont(new Font("Baekmuk Batang", Font.BOLD, 35));
		itemsLabel.setBounds(641, 100, 197, 47);
		backgroundPane.add(itemsLabel);
		
		
		JLabel itemOneQuantityLabel = new JLabel(store.getStoreItem(1).getQuantity() + "/3");
		itemOneQuantityLabel.setFont(new Font("Consolas", Font.BOLD, 16));
		itemOneQuantityLabel.setForeground(Color.WHITE);
		itemOneQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemOneQuantityLabel.setBounds(579, 231, 83, 33);
		backgroundPane.add(itemOneQuantityLabel);

		JLabel itemTwoQuantityLabel = new JLabel(store.getStoreItem(2).getQuantity() + "/3");
		itemTwoQuantityLabel.setFont(new Font("Consolas", Font.BOLD, 16));
		itemTwoQuantityLabel.setForeground(Color.WHITE);
		itemTwoQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemTwoQuantityLabel.setBounds(581, 355, 83, 33);
		backgroundPane.add(itemTwoQuantityLabel);
		
		JLabel itemThreeQuantityLabel = new JLabel(store.getStoreItem(3).getQuantity() + "/3");
		itemThreeQuantityLabel.setFont(new Font("Consolas", Font.BOLD, 16));
		itemThreeQuantityLabel.setForeground(Color.WHITE);
		itemThreeQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemThreeQuantityLabel.setBounds(580, 495, 83, 33);
		backgroundPane.add(itemThreeQuantityLabel);

		setLocationRelativeTo(null);

	}
}
