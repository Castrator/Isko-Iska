package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Barrier extends GameObject{
	
	private Animation hideAnimation;
	private BufferedImage image;
	private Button button1;
	private Button button2;
	private int xpos;
	private int ypos;
	private int xhide;
	private int yhide;
	private boolean hide;
	
	public Barrier(int x, int y, Button button) {
		this(x, y, button, null);
	}
	
	public Barrier(int x, int y, Button button1, Button button2) {
		super(x, y);
		this.xpos = x;
		this.ypos = y;
		this.xhide = 1000;
		this.yhide = 1000;
		this.button1 = button1;
		this.button2 = button2;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Background/barrier.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		hideAnimation = new Animation();
		BufferedImage frame;
		BufferedImage[] bi = new BufferedImage[3];
		for(int i = 0; i < 3; i++) {
			try {
				frame = ImageIO.read(getClass().getResourceAsStream(String.format("/Sprites/Booklet/destroy%d.png", i)));
				bi[i] = frame;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		hideAnimation.setFrames(bi);
		hideAnimation.setDelay(300);
	}

	public void update() {
		if(button1.pressed() || (button2 != null && button2.pressed())) {
			hide = true;
			hideAnimation.update();
		}else {
			hide = false;
		}
	}
	
	public void draw(Graphics2D g) {
		if(!hide) {
			x = xpos;
			y = ypos;
			g.drawImage(image, x, y, null);
			hideAnimation.setPlayedOnce(false);
			hideAnimation.setFrame(0);
		}else {
			x = xhide;
			y = yhide;
			if(!hideAnimation.hasPlayedOnce()) {
				g.drawImage(hideAnimation.getImage(), xpos - 50, ypos - 30, null);
			}
		}
	}
}
