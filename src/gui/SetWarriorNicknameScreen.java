package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import main.BattleHub;
import main.GameEnvironment;
import main.Player;
import main.Store;
import main.Warrior;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class SetWarriorNicknameScreen extends JFrame {

	private JPanel backgroundPane;
	private JTextField nicknameEntry;
	/**
	 * Create the frame.
	 */
	public SetWarriorNicknameScreen(Warrior purchasedWarrior, GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetWarriorNicknameScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		
		setTitle("Tussel of Tribes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		JLabel setNicknameTitle = new JLabel("Set Nickname (Optional)");
		setNicknameTitle.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		setNicknameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		setNicknameTitle.setForeground(Color.WHITE);
		setNicknameTitle.setBounds(192, 48, 458, 73);
		backgroundPane.add(setNicknameTitle);
		
		JTextPane warriorInfoPane = new JTextPane();
		warriorInfoPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
		warriorInfoPane.setEditable(false);
		warriorInfoPane.setText(purchasedWarrior.getDescription());
		warriorInfoPane.setBounds(335, 260, 168, 86);
		backgroundPane.add(warriorInfoPane);
		
		JLabel warriorImage =  new JLabel("");
		warriorImage.setIcon(new ImageIcon(ShopScreen.class.getResource(purchasedWarrior.getImage())));
		warriorImage.setBounds(335, 124, 168, 137);
		backgroundPane.add(warriorImage);
		
		
		JLabel warriorNicknameLabel = new JLabel("Warrior Nickname (Optional)");
		warriorNicknameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		warriorNicknameLabel.setForeground(Color.WHITE);
		warriorNicknameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		warriorNicknameLabel.setBounds(49, 612, 203, 33);
		backgroundPane.add(warriorNicknameLabel);
	
		nicknameEntry = new JTextField();
		nicknameEntry.setHorizontalAlignment(SwingConstants.CENTER);
		nicknameEntry.setBounds(345, 366, 147, 33);
		backgroundPane.add(nicknameEntry);
		nicknameEntry.setColumns(10);
		
		JButton finishButton = new JButton("FINISH");
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nicknameEntry.getText().length() != 0) {
					boolean stringValid = game.validString(nicknameEntry.getText());
					if (stringValid) {
						purchasedWarrior.setNickname(nicknameEntry.getText());
						dispose();
						JFrame shopScreen = new ShopScreen(game, player, store, battleHub);
						shopScreen.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(null, "Your nickname must be between 5-15 alpahabetic characters!");
						dispose();
						JFrame SetWarriorNicknameScreen = new SetWarriorNicknameScreen(purchasedWarrior, game, player, store, battleHub);
						SetWarriorNicknameScreen.setVisible(true);
					}
				} else {
					purchasedWarrior.setNickname(purchasedWarrior.getType());
					dispose();
					JFrame shopScreen = new ShopScreen(game, player, store, battleHub);
					shopScreen.setVisible(true);
				}

			}
		});
		finishButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 25));
		finishButton.setBounds(271, 426, 302, 47);
		backgroundPane.add(finishButton);
		
		setLocationRelativeTo(null);
	}
}
