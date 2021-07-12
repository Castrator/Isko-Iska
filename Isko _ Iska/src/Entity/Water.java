package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Water extends GameObject{
	
	private Animation animation;
	private String color;
	
	public Water(int x, int y, String s) {
		super(x, y);
		animation = new Animation();
		BufferedImage frame;
		BufferedImage[] bi = new BufferedImage[4];
		if(s.equals("blueshort") || s.equals("bluelong")) {
			color = "blue";
		}else if(s.equals("orangeshort") || s.equals("orangelong")) {
			color = "orange";
		}else {
			color = "violet";
		}
		for(int i = 0; i < 4; i++) {
			try {
				frame = ImageIO.read(getClass().getResourceAsStream(String.format("/Background/Water/%s%d.png", s, i)));
				bi[i] = frame;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		animation.setFrames(bi);
		animation.setDelay(100);
		width = animation.getImage().getWidth();
		height = animation.getImage().getHeight();
	}
	
	public String getColor() {
		return color;
	}

	public void update() {
		animation.update();
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(animation.getImage(), x, y, null);

	}
	
}
