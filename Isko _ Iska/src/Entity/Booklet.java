package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Booklet extends GameObject{
	
	private Animation animation;
	private Animation spharkAnimation;
	private Animation destroyAnimation;
	private String color;
	
	private boolean destroy;
	
	public Booklet(int x, int y, String s) {
		super(x, y);
		color = s;
		animation = new Animation();
		spharkAnimation = new Animation();
		destroyAnimation = new Animation();
		BufferedImage frame;
		BufferedImage[] bi = new BufferedImage[14];
		BufferedImage[] bi2 = new BufferedImage[14];
		BufferedImage[] bi3 = new BufferedImage[3];
		for(int i = 0; i < 14; i++) {
			try {
				frame = ImageIO.read(getClass().getResourceAsStream(String.format("/Sprites/Booklet/%sbook%d.png", s, i)));
				bi[i] = frame;
				frame = ImageIO.read(getClass().getResourceAsStream(String.format("/Sprites/Booklet/%ssphark%d.png", s, i)));
				bi2[i] = frame;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		animation.setFrames(bi);
		animation.setDelay(100);
		spharkAnimation.setFrames(bi2);
		spharkAnimation.setDelay(100);
		width = animation.getImage().getWidth();
		height = animation.getImage().getHeight();
		for(int i = 0; i < 3; i++) {
			try {
				frame = ImageIO.read(getClass().getResourceAsStream(String.format("/Sprites/Booklet/destroy%d.png", i)));
				bi3[i] = frame;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		destroyAnimation.setFrames(bi3);
		destroyAnimation.setDelay(150);
		destroy = false;
	}
	
	public String getColor() {
		return color;
	}
	
	public void destroy() {
		destroy = true;
	}

	public boolean hasPlayedOnce() {
		return destroyAnimation.hasPlayedOnce();
	}
	
	public void update() {
		if(!destroy) {
			animation.update();
			spharkAnimation.update();		
		}else {
			destroyAnimation.update();
		}
	}

	
	public void draw(Graphics2D g) {
		if(!destroy) {
			g.drawImage(spharkAnimation.getImage(), x - 56, y - 42, null);
			g.drawImage(animation.getImage(), x, y, null);			
		}else if(!hasPlayedOnce()){
			g.drawImage(destroyAnimation.getImage(), x - 56, y - 42, null);		
		}
	}
	
}
