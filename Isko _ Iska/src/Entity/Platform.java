package Entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Platform extends GameObject{
	
	public Platform(int x, int y, String s) {
		super(x, y);
		try {
			image = ImageIO.read(getClass().getResourceAsStream(String.format("/Background/%s", s)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
	}

	public void update() {}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, x, y, null);

	}
	
}
