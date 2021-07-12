package GameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Entity.Animation;

public class MenuState extends  GameState{
	
	private Animation animation;

	public MenuState (GameStateManager gsm){
		this.gsm = gsm;
		animation = new Animation();
		BufferedImage frame;
		BufferedImage[] frames = new BufferedImage[2];
		try {
			for(int i = 0; i < 2; i++) {
				frame = ImageIO.read(getClass().getResourceAsStream(String.format("/Background/Home/home%d.png", i)));
				frames[i] = frame;
			}
			animation.setFrames(frames);
			animation.setDelay(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		animation.update();
	}
	public void draw(Graphics2D g) {
		g.drawImage(animation.getImage(), 0, 0, null);
	}
	public void keyPressed(int k) {
		gsm.setState(GameStateManager.LEVELSTATE, 1);
	}
	public void keyReleased(int k) {}
	public void mouseClicked(int x, int y) {}
	public void init(int state) {}
}
