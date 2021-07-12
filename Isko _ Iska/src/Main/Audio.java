package Main;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
		
	private String dir;
	private File sound;
	private Clip c;
	
	public Audio(String s) {
		dir = s;
		sound = new File(dir);
		try {
			c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(sound));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void play() {
		c.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		c.stop();
	}
}
