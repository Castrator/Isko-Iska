package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Button extends GameObject{
	
	private BufferedImage image1;
	private BufferedImage image2;
	public boolean pressed;
	
	public Button(int x, int y) {
		super(x, y);
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/Background/button0.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/Background/button1.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		width = image1.getWidth();
		height = image1.getHeight();
	}
	
	public boolean pressed() {
		return pressed;
	}

	public void update() {

	}

	
	public void draw(Graphics2D g) {
		if(pressed) {
			g.drawImage(image2, x, y, null);			
		}else {
			g.drawImage(image1, x, y, null);			
		}
	}
}
