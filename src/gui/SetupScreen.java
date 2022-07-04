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
import main.Warrior;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class SetupScreen extends JFrame {

	private JPanel backgroundPane;
	private JTextField usernameEntry;
	private final ButtonGroup difficultyButtonGroup = new ButtonGroup();
	private final ButtonGroup starterSelectButtonGroup = new ButtonGroup();
	private JTextField nicknameEntry;


	/**
	 * Create the frame.
	 */
	public SetupScreen(GameEnvironment game, Player player, Store store, BattleHub battleHub) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetupScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		setTitle("Tussle of Tribes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 711);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.DARK_GRAY);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		
		JLabel getStartedTitle = new JLabel("Get Started");
		getStartedTitle.setBounds(85, 16, 772, 47);
		getStartedTitle.setHorizontalAlignment(SwingConstants.CENTER);
		getStartedTitle.setFont(new Font("Baekmuk Batang", Font.PLAIN, 40));
		getStartedTitle.setForeground(Color.WHITE);
		
		JLabel askNameLabel = new JLabel("What is your name?");
		askNameLabel.setBounds(49, 69, 178, 33);
		askNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		askNameLabel.setForeground(Color.WHITE);
		askNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		usernameEntry = new JTextField();
		usernameEntry.setText(null);
		usernameEntry.setBounds(234, 75, 357, 20);
		usernameEntry.setColumns(10);
		
		JLabel gameLengthLabel = new JLabel("How many days would you like to play?");
		gameLengthLabel.setBounds(49, 120, 322, 33);
		gameLengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gameLengthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gameLengthLabel.setForeground(Color.WHITE);
		
		JSlider gameLengthSlider = new JSlider();
		gameLengthSlider.setBounds(395, 120, 291, 45);
		gameLengthSlider.setPaintLabels(true);
		gameLengthSlider.setPaintTicks(true);
		gameLengthSlider.setSnapToTicks(true);
		gameLengthSlider.setMinorTickSpacing(1);
		gameLengthSlider.setMinimum(5);
		gameLengthSlider.setMaximum(15);
		gameLengthSlider.setBackground(Color.DARK_GRAY);
		gameLengthSlider.setForeground(Color.WHITE);
		
		JLabel lowerDayBoundLabel = new JLabel("5");
		lowerDayBoundLabel.setBounds(383, 120, 18, 33);
		lowerDayBoundLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lowerDayBoundLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lowerDayBoundLabel.setForeground(Color.WHITE);
		
		JLabel selectDifficultyLabel = new JLabel("Select Difficulty:");
		selectDifficultyLabel.setBounds(49, 171, 165, 33);
		selectDifficultyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectDifficultyLabel.setForeground(Color.WHITE);
		selectDifficultyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton easyButton = new JRadioButton("Easy");
		easyButton.setBounds(182, 177, 66, 27);
		difficultyButtonGroup.add(easyButton);
		easyButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		easyButton.setBackground(Color.DARK_GRAY);
		easyButton.setForeground(Color.WHITE);
		
		JRadioButton mediumButton = new JRadioButton("Medium");
		mediumButton.setBounds(246, 177, 92, 27);
		difficultyButtonGroup.add(mediumButton);
		mediumButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mediumButton.setForeground(Color.WHITE);
		mediumButton.setBackground(Color.DARK_GRAY);
		
		JRadioButton hardButton = new JRadioButton("Hard");
		hardButton.setBounds(337, 177, 75, 27);
		difficultyButtonGroup.add(hardButton);
		hardButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hardButton.setForeground(Color.WHITE);
		hardButton.setBackground(Color.DARK_GRAY);
		
		JLabel upperDayBoundLabel = new JLabel("15");
		upperDayBoundLabel.setBounds(693, 121, 168, 33);
		upperDayBoundLabel.setHorizontalAlignment(SwingConstants.LEFT);
		upperDayBoundLabel.setForeground(Color.WHITE);
		upperDayBoundLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		JLabel warriorSelectLabel = new JLabel("Select your first Warrior:");
		warriorSelectLabel.setBounds(49, 223, 352, 19);
		warriorSelectLabel.setHorizontalAlignment(SwingConstants.LEFT);
		warriorSelectLabel.setForeground(Color.WHITE);
		warriorSelectLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backgroundPane.setLayout(null);
		backgroundPane.add(getStartedTitle);
		backgroundPane.add(askNameLabel);
		backgroundPane.add(usernameEntry);
		backgroundPane.add(gameLengthLabel);
		backgroundPane.add(lowerDayBoundLabel);
		backgroundPane.add(upperDayBoundLabel);
		backgroundPane.add(selectDifficultyLabel);
		backgroundPane.add(gameLengthSlider);
		backgroundPane.add(easyButton);
		backgroundPane.add(mediumButton);
		backgroundPane.add(hardButton);
		backgroundPane.add(warriorSelectLabel);
		
		JToggleButton warriorOneButton = new JToggleButton("Select");
		starterSelectButtonGroup.add(warriorOneButton);
		warriorOneButton.setBounds(182, 524, 121, 23);
		backgroundPane.add(warriorOneButton);
		
		JToggleButton warriorTwoButton = new JToggleButton("Select");
		starterSelectButtonGroup.add(warriorTwoButton);
		warriorTwoButton.setBounds(420, 524, 121, 23);
		backgroundPane.add(warriorTwoButton);
		
		JToggleButton warriorThreeButton = new JToggleButton("Select");
		starterSelectButtonGroup.add(warriorThreeButton);
		warriorThreeButton.setBounds(645, 524, 121, 23);
		backgroundPane.add(warriorThreeButton);
		
		Warrior warriorOne = game.createReaper(null);
		
		JTextPane warriorOneInfoPane = new JTextPane();
		warriorOneInfoPane.setEditable(false);
		warriorOneInfoPane.setText(warriorOne.getDescription());
		warriorOneInfoPane.setBounds(156, 427, 168, 86);
		backgroundPane.add(warriorOneInfoPane);
		
		Warrior warriorTwo = game.createBarbarian(null);
		
		JTextPane warriorTwoInfoPane = new JTextPane();
		warriorTwoInfoPane.setEditable(false);
		warriorTwoInfoPane.setText(warriorTwo.getDescription());
		warriorTwoInfoPane.setBounds(393, 427, 168, 86);
		backgroundPane.add(warriorTwoInfoPane);
		
		Warrior warriorThree = game.createWizard(null);
		
		JTextPane warriorThreeInfoPane = new JTextPane();
		warriorThreeInfoPane.setEditable(false);
		warriorThreeInfoPane.setText(warriorThree.getDescription());
		warriorThreeInfoPane.setBounds(623, 427, 168, 86);
		backgroundPane.add(warriorThreeInfoPane);
		
		JLabel warriorNicknameLabel = new JLabel("Warrior Nickname (Optional):");
		warriorNicknameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		warriorNicknameLabel.setForeground(Color.WHITE);
		warriorNicknameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		warriorNicknameLabel.setBounds(49, 612, 275, 33);
		backgroundPane.add(warriorNicknameLabel);
		
		nicknameEntry = new JTextField();
		nicknameEntry.setColumns(10);
		nicknameEntry.setBounds(288, 619, 357, 20);
		backgroundPane.add(nicknameEntry);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!game.validString(usernameEntry.getText())) {
					JOptionPane.showMessageDialog(null, "Your name must be between 5-15 alpahabetic characters!");
					return;
				} else {
					player.setUsername(usernameEntry.getText());
				}
				
				game.setGameLength(gameLengthSlider.getValue());
				
				if (difficultyButtonGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(null,  "Please select a difficulty!");
					return;
				} else {
				    if (easyButton.isSelected()) {	    	
				    	game.setDifficultyMultiplier(1);	
				    } else if (mediumButton.isSelected()){
				    	game.setDifficultyMultiplier(0.75);
				    } else {
				    	game.setDifficultyMultiplier(0.5);
				    }
				    
				}
				
				// Only check valid if nickname not null, because it is optional
				if (nicknameEntry.getText().length() != 0) {
					if (!game.validString(nicknameEntry.getText())){
						JOptionPane.showMessageDialog(null, "Your nickname must be between 5-15 alpahabetic characters!");
						return;
					}
				} 
				
				if (starterSelectButtonGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(null,  "Please select a starter!");
					return;
				} else {
					Warrior newWarrior;
					if (warriorOneButton.isSelected()) {
						newWarrior = warriorOne;
					} else if (warriorTwoButton.isSelected()) {
						newWarrior = warriorTwo;
					} else {
						newWarrior = warriorThree;
					}
					player.addWarriorToTeam(newWarrior);
					if (nicknameEntry.getText().length() > 0) newWarrior.setNickname(nicknameEntry.getText());
					else newWarrior.setNickname(newWarrior.getType());
				}
				
				player.setBeans(2500*game.getDifficultyMultiplier());

				dispose();
				JFrame infoPage = new InfoPageScreen(game, player, store, battleHub);
				infoPage.setVisible(true);
			}
		});
		confirmButton.setForeground(Color.BLACK);
		confirmButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 20));
		confirmButton.setBackground(Color.WHITE);
		confirmButton.setBounds(847, 628, 121, 33);
		backgroundPane.add(confirmButton);
		
		JLabel warriorOneImage = new JLabel("");
		warriorOneImage.setIcon(new ImageIcon(SetupScreen.class.getResource(warriorOne.getImage())));
		warriorOneImage.setBounds(156, 290, 168, 137);
		backgroundPane.add(warriorOneImage);
		
		JLabel warriorTwoImage = new JLabel("");
		warriorTwoImage.setIcon(new ImageIcon(SetupScreen.class.getResource(warriorTwo.getImage())));
		warriorTwoImage.setBounds(393, 290, 168, 137);
		backgroundPane.add(warriorTwoImage);

		JLabel warriorThreeImage = new JLabel("");
		warriorThreeImage.setIcon(new ImageIcon(SetupScreen.class.getResource(warriorThree.getImage())));
		warriorThreeImage.setBounds(623, 290, 168, 137);
		backgroundPane.add(warriorThreeImage);
		
		setLocationRelativeTo(null);
		
	}
	
}
