package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import items.Item;
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

public class SelectWarriorForItemScreen extends JFrame {

	private JPanel backgroundPane;


	/**
	 * Create the frame.
	 */
	public SelectWarriorForItemScreen(int inventoryIndex, Item item, GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel lblManageTribe = new JLabel("Choose a Warrior to use item on");
		lblManageTribe.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageTribe.setForeground(Color.WHITE);
		lblManageTribe.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		lblManageTribe.setBounds(10, 11, 850, 139);
		backgroundPane.add(lblManageTribe);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame inventory = new InventoryScreen(game, player, store, battleHub);
				inventory.setVisible(true);
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
			warriorOneInfoPane.setBounds(37, 344, 168, 86);
			backgroundPane.add(warriorOneInfoPane);
			
			JLabel warriorOneImage = new JLabel("");
			warriorOneImage.setIcon(new ImageIcon(SelectWarriorForItemScreen.class.getResource(player.getTeam().get(0).getImage())));
			warriorOneImage.setBounds(49, 205, 168, 137);
			backgroundPane.add(warriorOneImage);
			
			JButton selectWarriorOneButton = new JButton("SELECT");
			selectWarriorOneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					item.useItem(inventoryIndex, player.getTeam().get(0), player);
					JOptionPane.showMessageDialog(null, "Item used!");
					JFrame inventory = new InventoryScreen(game, player, store, battleHub);
					dispose();
					inventory.setVisible(true);
				}
			});
			selectWarriorOneButton.setBounds(80, 441, 89, 23);
			backgroundPane.add(selectWarriorOneButton);
			
		}
		
		if (player.getTeam().size() > 1) {
			JTextPane warriorTwoInfoPane = new JTextPane();
			warriorTwoInfoPane.setText(player.getTeam().get(1).getDescription());
			warriorTwoInfoPane.setEditable(false);
			warriorTwoInfoPane.setBounds(255, 344, 168, 86);
			backgroundPane.add(warriorTwoInfoPane);
			
			JLabel warriorTwoImage = new JLabel("");
			warriorTwoImage.setIcon(new ImageIcon(SelectWarriorForItemScreen.class.getResource(player.getTeam().get(1).getImage())));
			warriorTwoImage.setBounds(255, 205, 168, 137);
			backgroundPane.add(warriorTwoImage);
			
			JButton selectWarriorTwoButton = new JButton("SELECT");
			selectWarriorTwoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					item.useItem(inventoryIndex, player.getTeam().get(1), player);
					JOptionPane.showMessageDialog(null, "Item used!");
					JFrame inventory = new InventoryScreen(game, player, store, battleHub);
					dispose();
					inventory.setVisible(true);
				}
			});
			selectWarriorTwoButton.setBounds(297, 441, 89, 23);
			backgroundPane.add(selectWarriorTwoButton);
			
		}
		
		if (player.getTeam().size() > 2) {
			JTextPane warriorThreeInfoPane = new JTextPane();
			warriorThreeInfoPane.setText(player.getTeam().get(2).getDescription());
			warriorThreeInfoPane.setEditable(false);
			warriorThreeInfoPane.setBounds(474, 344, 168, 86);
			backgroundPane.add(warriorThreeInfoPane);
			
			JLabel warriorThreeImage = new JLabel("");
			warriorThreeImage.setIcon(new ImageIcon(SelectWarriorForItemScreen.class.getResource(player.getTeam().get(2).getImage())));
			warriorThreeImage.setBounds(474, 205, 168, 137);
			backgroundPane.add(warriorThreeImage);

			JButton selectWarriorThreeButton = new JButton("SELECT");
			selectWarriorThreeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					item.useItem(inventoryIndex, player.getTeam().get(2), player);
					JOptionPane.showMessageDialog(null, "Item used!");
					JFrame inventory = new InventoryScreen(game, player, store, battleHub);
					dispose();
					inventory.setVisible(true);
				}
			});
			selectWarriorThreeButton.setBounds(513, 441, 89, 23);
			backgroundPane.add(selectWarriorThreeButton);
			

		}

		if (player.getTeam().size() > 3) {

			JLabel warriorFourImage = new JLabel("");
			warriorFourImage.setIcon(new ImageIcon(SelectWarriorForItemScreen.class.getResource(player.getTeam().get(3).getImage())));
			warriorFourImage.setBounds(680, 205, 168, 137);
			backgroundPane.add(warriorFourImage);
			
			JTextPane warriorFourInfoPane = new JTextPane();
			warriorFourInfoPane.setText(player.getTeam().get(3).getDescription());
			warriorFourInfoPane.setEditable(false);
			warriorFourInfoPane.setBounds(680, 344, 168, 86);
			backgroundPane.add(warriorFourInfoPane);
			
			JButton selectWarriorFourButton = new JButton("SELECT");
			selectWarriorFourButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					item.useItem(inventoryIndex, player.getTeam().get(3), player);
					JOptionPane.showMessageDialog(null, "Item used!");
					JFrame inventory = new InventoryScreen(game, player, store, battleHub);
					dispose();
					inventory.setVisible(true);
				}
			});
			selectWarriorFourButton.setBounds(720, 441, 89, 23);
			backgroundPane.add(selectWarriorFourButton);

			}
		setLocationRelativeTo(null);
	}
}

