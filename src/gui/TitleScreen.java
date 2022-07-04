package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.BattleHub;
import main.GameEnvironment;
import main.MusicPlayer;
import main.Player;
import main.Store;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class TitleScreen {

	private JFrame tussleOfTribesFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleScreen window = new TitleScreen();
					window.tussleOfTribesFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	public TitleScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	private void initialize() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		GameEnvironment game = new GameEnvironment();
		Player player = new Player();
		Store store = new Store(game);
		BattleHub battleHub = new BattleHub();
		MusicPlayer music = new MusicPlayer();
		
		
		battleHub.resetBattleHub(player.getTeam(), game);
		tussleOfTribesFrame = new JFrame();
		tussleOfTribesFrame.setTitle("Tussle of Tribes");
		tussleOfTribesFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(TitleScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		tussleOfTribesFrame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		tussleOfTribesFrame.getContentPane().setBackground(Color.DARK_GRAY);
		tussleOfTribesFrame.setResizable(false);
		tussleOfTribesFrame.setLocationRelativeTo(null);

		JLabel tussleOfTribesTitle = new JLabel("Tussel of Tribes");
		tussleOfTribesTitle.setBounds(134, 51, 594, 206);
		tussleOfTribesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		tussleOfTribesTitle.setFont(new Font("Baekmuk Batang", Font.PLAIN, 60));
		tussleOfTribesTitle.setForeground(new Color(255, 255, 255));
		tussleOfTribesFrame.getContentPane().setLayout(null);
		tussleOfTribesFrame.getContentPane().add(tussleOfTribesTitle);
		
		JButton startButton = new JButton("START");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tussleOfTribesFrame.dispose();
				SetupScreen setUp = new SetupScreen(game, player, store, battleHub);
				setUp.setVisible(true);
			}
		});
		startButton.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 25));
		startButton.setBackground(Color.WHITE);
		startButton.setBounds(286, 437, 302, 47);
		tussleOfTribesFrame.getContentPane().add(startButton);
		
		JLabel logoImage = new JLabel("");
		logoImage.setIcon(new ImageIcon(TitleScreen.class.getResource("/images/TussleOfTribesLogo.png")));
		logoImage.setHorizontalAlignment(SwingConstants.CENTER);
		logoImage.setBounds(257, 168, 352, 258);
		tussleOfTribesFrame.getContentPane().add(logoImage);
		tussleOfTribesFrame.setBounds(100, 100, 900, 600);
		tussleOfTribesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tussleOfTribesFrame.setLocationRelativeTo(null);

	}
}
