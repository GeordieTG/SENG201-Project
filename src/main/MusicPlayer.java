

package main;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/** 
 * Class for playing the background music, from a file specified by filepath
 * Credit for royalty free music to TommyMutlu, from pixabay. (https://pixabay.com/music/search/knights%20of%20camelot/)
 * 
 * @author Callum Hampton
 * @author Geordie Gibson
 * */

public class MusicPlayer {
	
	/**
	 * Sound clip used for storing the music
	 */
	private Clip clip;
	
	/**
	 * Audio input stream for handling music
	 */
	AudioInputStream audioInputStream;
	
	/***
	 * Path of the file
	 */
	URL filepath;
	
	/**
	 * Initializes and plays the music file
	 * @throws UnsupportedAudioFileException Handles unsupported file type
	 * @throws IOException Handles IO errors
	 * @throws LineUnavailableException Handles Stream errors
	 */
	public MusicPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		
		// Set the filepath as the music file
		filepath = getClass().getResource("/music/knights-of-camelot-8038.wav");
		
		// Set the value of the stream
		audioInputStream = AudioSystem.getAudioInputStream(filepath);	

		// Set a clip variable of the audio, set it to loop continuously and start it
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
		
	}
}
