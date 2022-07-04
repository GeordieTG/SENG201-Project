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

public class InventoryScreen extends JFrame {

	private JPanel backgroundPane;

	/**
	 * Create the frame.
	 */
	public InventoryScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InventoryScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussle of Tribes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel inventoryTitle = new JLabel("Inventory");
		inventoryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryTitle.setForeground(Color.WHITE);
		inventoryTitle.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		inventoryTitle.setBounds(250, 43, 364, 47);
		backgroundPane.add(inventoryTitle);
		
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
		
		if (player.getInventory().size() > 0) {
		
			JLabel itemOneImage = new JLabel("");
			itemOneImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(player.getInventory().get(0).getImage())));
			itemOneImage.setBounds(45, 166, 89, 73);
			backgroundPane.add(itemOneImage);
			
			JTextPane itemOneInfoPane = new JTextPane();
			itemOneInfoPane.setText(player.getInventory().get(0).getDescription());
			itemOneInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			itemOneInfoPane.setEditable(false);
			itemOneInfoPane.setBounds(132, 153, 159, 86);
			backgroundPane.add(itemOneInfoPane);
			
			JLabel itemOneQuantityLabel = new JLabel("x" + player.getInventory().get(0).getQuantity());
			itemOneQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
			itemOneQuantityLabel.setForeground(Color.WHITE);
			itemOneQuantityLabel.setFont(new Font("Consolas", Font.BOLD, 16));
			itemOneQuantityLabel.setBounds(56, 224, 83, 33);
			backgroundPane.add(itemOneQuantityLabel);
			
			JButton useItemOneButton = new JButton("USE");
			useItemOneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame selectWarrior = new SelectWarriorForItemScreen(0, player.getInventory().get(0), game, player, store, battleHub);
					dispose();
					selectWarrior.setVisible(true);
				}
			});
			useItemOneButton.setBounds(132, 250, 70, 23);
			backgroundPane.add(useItemOneButton);
			
			JButton sellItemOneButton = new JButton("SELL");
			sellItemOneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellItem(0);
					JOptionPane.showMessageDialog(null, "Item sold!");
					// Refresh window
					dispose();
					JFrame inventoryScreen = new InventoryScreen(game, player, store, battleHub);
					inventoryScreen.setVisible(true);
				}
			});
			sellItemOneButton.setBounds(221, 250, 70, 23);
			backgroundPane.add(sellItemOneButton);
			
		}
		
		if (player.getInventory().size() > 1) {
			
			JLabel itemTwoImage = new JLabel("");
			itemTwoImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(player.getInventory().get(1).getImage())));
			itemTwoImage.setBounds(311, 167, 89, 73);
			backgroundPane.add(itemTwoImage);
			
			JTextPane itemTwoInfoPane = new JTextPane();
			itemTwoInfoPane.setText(player.getInventory().get(1).getDescription());
			itemTwoInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			itemTwoInfoPane.setEditable(false);
			itemTwoInfoPane.setBounds(388, 153, 159, 86);
			backgroundPane.add(itemTwoInfoPane);
			
			JLabel itemTwoQuantityLabel = new JLabel("x" + player.getInventory().get(1).getQuantity());
			itemTwoQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
			itemTwoQuantityLabel.setForeground(Color.WHITE);
			itemTwoQuantityLabel.setFont(new Font("Consolas", Font.BOLD, 16));
			itemTwoQuantityLabel.setBounds(312, 224, 83, 33);
			backgroundPane.add(itemTwoQuantityLabel);
			
			JButton useItemTwoButton = new JButton("USE");
			useItemTwoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame selectWarrior = new SelectWarriorForItemScreen(1, player.getInventory().get(1), game, player, store, battleHub);
					dispose();
					selectWarrior.setVisible(true);
				}
			});
			useItemTwoButton.setBounds(388, 250, 70, 23);
			backgroundPane.add(useItemTwoButton);
			
			JButton sellItemTwoButton = new JButton("SELL");
			sellItemTwoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellItem(1);
					JOptionPane.showMessageDialog(null, "Item sold!");
					// Refresh window
					dispose();
					JFrame inventoryScreen = new InventoryScreen(game, player, store, battleHub);
					inventoryScreen.setVisible(true);
				}
			});
			sellItemTwoButton.setBounds(477, 250, 70, 23);
			backgroundPane.add(sellItemTwoButton);
			
		}
		
		if (player.getInventory().size() > 2) {
		
			JLabel itemThreeImage = new JLabel("");
			itemThreeImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(player.getInventory().get(2).getImage())));
			itemThreeImage.setBounds(557, 166, 89, 73);
			backgroundPane.add(itemThreeImage);
			
			JTextPane itemThreeInfoPane = new JTextPane();
			itemThreeInfoPane.setText(player.getInventory().get(2).getDescription());
			itemThreeInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			itemThreeInfoPane.setEditable(false);
			itemThreeInfoPane.setBounds(644, 153, 159, 86);
			backgroundPane.add(itemThreeInfoPane);
			
			JLabel itemThreeQuantityLabel = new JLabel("x" + player.getInventory().get(2).getQuantity());
			itemThreeQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
			itemThreeQuantityLabel.setForeground(Color.WHITE);
			itemThreeQuantityLabel.setFont(new Font("Consolas", Font.BOLD, 16));
			itemThreeQuantityLabel.setBounds(568, 224, 83, 33);
			backgroundPane.add(itemThreeQuantityLabel);
			
			JButton useItemThreeButton = new JButton("USE");
			useItemThreeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame selectWarrior = new SelectWarriorForItemScreen(2, player.getInventory().get(2), game, player, store, battleHub);
					dispose();
					selectWarrior.setVisible(true);
				}
			});
			useItemThreeButton.setBounds(644, 250, 70, 23);
			backgroundPane.add(useItemThreeButton);
			
			JButton sellItemThreeButton = new JButton("SELL");
			sellItemThreeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellItem(2);
					JOptionPane.showMessageDialog(null, "Item sold!");
					// Refresh window
					dispose();
					JFrame inventoryScreen = new InventoryScreen(game, player, store, battleHub);
					inventoryScreen.setVisible(true);
				}
			});
			sellItemThreeButton.setBounds(733, 250, 70, 23);
			backgroundPane.add(sellItemThreeButton);
		
		}
		
		if (player.getInventory().size() > 3) {
			
			JLabel itemFourImage = new JLabel("");
			itemFourImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(player.getInventory().get(3).getImage())));
			itemFourImage.setBounds(45, 325, 89, 73);
			backgroundPane.add(itemFourImage);
			
			JTextPane itemFourInfoPane = new JTextPane();
			itemFourInfoPane.setText(player.getInventory().get(3).getDescription());
			itemFourInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			itemFourInfoPane.setEditable(false);
			itemFourInfoPane.setBounds(132, 312, 159, 86);
			backgroundPane.add(itemFourInfoPane);
			
			JLabel itemFourQuantityLabel = new JLabel("x" + player.getInventory().get(3).getQuantity());
			itemFourQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
			itemFourQuantityLabel.setForeground(Color.WHITE);
			itemFourQuantityLabel.setFont(new Font("Consolas", Font.BOLD, 16));
			itemFourQuantityLabel.setBounds(56, 383, 83, 33);
			backgroundPane.add(itemFourQuantityLabel);
			
			JButton useItemFourButton = new JButton("USE");
			useItemFourButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame selectWarrior = new SelectWarriorForItemScreen(3, player.getInventory().get(3), game, player, store, battleHub);
					dispose();
					selectWarrior.setVisible(true);
				}
			});
			useItemFourButton.setBounds(132, 409, 70, 23);
			backgroundPane.add(useItemFourButton);
			
			JButton sellItemFourButton = new JButton("SELL");
			sellItemFourButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellItem(3);
					JOptionPane.showMessageDialog(null, "Item sold!");
					// Refresh window
					dispose();
					JFrame inventoryScreen = new InventoryScreen(game, player, store, battleHub);
					inventoryScreen.setVisible(true);
				}
			});
			sellItemFourButton.setBounds(221, 409, 70, 23);
			backgroundPane.add(sellItemFourButton);
			
		}
		
		if (player.getInventory().size() > 4) {
		
			JLabel itemFiveImage = new JLabel("");
			itemFiveImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(player.getInventory().get(4).getImage())));
			itemFiveImage.setBounds(301, 325, 89, 73);
			backgroundPane.add(itemFiveImage);
			
			JTextPane itemFiveInfoPane = new JTextPane();
			itemFiveInfoPane.setText(player.getInventory().get(4).getDescription());
			itemFiveInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			itemFiveInfoPane.setEditable(false);
			itemFiveInfoPane.setBounds(388, 312, 159, 86);
			backgroundPane.add(itemFiveInfoPane);
			
			JLabel itemFiveQuantityLabel = new JLabel("x" + player.getInventory().get(4).getQuantity());
			itemFiveQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
			itemFiveQuantityLabel.setForeground(Color.WHITE);
			itemFiveQuantityLabel.setFont(new Font("Consolas", Font.BOLD, 16));
			itemFiveQuantityLabel.setBounds(312, 383, 83, 33);
			backgroundPane.add(itemFiveQuantityLabel);
			
			JButton useItemFiveButton = new JButton("USE");
			useItemFiveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame selectWarrior = new SelectWarriorForItemScreen(4, player.getInventory().get(4), game, player, store, battleHub);
					dispose();
					selectWarrior.setVisible(true);
				}
			});
			
			useItemFiveButton.setBounds(388, 409, 70, 23);
			backgroundPane.add(useItemFiveButton);
			
			JButton sellItemFiveButton = new JButton("SELL");
			sellItemFiveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellItem(4);
					JOptionPane.showMessageDialog(null, "Item sold!");
					// Refresh window
					dispose();
					JFrame inventoryScreen = new InventoryScreen(game, player, store, battleHub);
					inventoryScreen.setVisible(true);
				}
			});
			sellItemFiveButton.setBounds(477, 409, 70, 23);
			backgroundPane.add(sellItemFiveButton);
		
		}
		
		if (player.getInventory().size() > 5) {
			
			JLabel itemSixImage = new JLabel("");
			itemSixImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(player.getInventory().get(5).getImage())));
			itemSixImage.setBounds(557, 325, 89, 73);
			backgroundPane.add(itemSixImage);
			
			JTextPane itemSixInfoPane = new JTextPane();
			itemSixInfoPane.setText(player.getInventory().get(5).getDescription());
			itemSixInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			itemSixInfoPane.setEditable(false);
			itemSixInfoPane.setBounds(644, 312, 159, 86);
			backgroundPane.add(itemSixInfoPane);
			
			JLabel itemSixQuantityLabel = new JLabel("x" + player.getInventory().get(5).getQuantity());
			itemSixQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
			itemSixQuantityLabel.setForeground(Color.WHITE);
			itemSixQuantityLabel.setFont(new Font("Consolas", Font.BOLD, 16));
			itemSixQuantityLabel.setBounds(568, 383, 83, 33);
			backgroundPane.add(itemSixQuantityLabel);
			
			JButton useItemSixButton = new JButton("USE");
			useItemSixButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame selectWarrior = new SelectWarriorForItemScreen(5, player.getInventory().get(5), game, player, store, battleHub);
					dispose();
					selectWarrior.setVisible(true);
				}
			});
			useItemSixButton.setBounds(654, 409, 70, 23);
			backgroundPane.add(useItemSixButton);

			JButton sellItemSixButton = new JButton("SELL");
			sellItemSixButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player.sellItem(5);
					JOptionPane.showMessageDialog(null, "Item sold!");
					// Refresh window
					dispose();
					JFrame inventoryScreen = new InventoryScreen(game, player, store, battleHub);
					inventoryScreen.setVisible(true);
				}
			});
			sellItemSixButton.setBounds(733, 409, 70, 23);
			backgroundPane.add(sellItemSixButton);
		
		}
		setLocationRelativeTo(null);
	}
}
