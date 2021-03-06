package Entity;

import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class GameObject {

	protected BufferedImage image;
	public int width;
	public int height;
	protected int cwidth;
	protected int cheight;
	protected int cdiff;
	public int x;
	public int y;
	protected double vx;
	protected double vy;
	protected double maxSpeed;
	protected double ax;
	protected double ay;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		this.vx = 0;
		this.vy = 0;
		this.ax = 0;
		this.ay = 0;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
	
	public Rectangle getCollisionRect() {
		return new Rectangle((x + (width - cwidth)/2), (y + (height - cheight)/2), cwidth, cheight);
	}
	
	public abstract void update();
	public abstract void draw(Graphics2D g);

}
