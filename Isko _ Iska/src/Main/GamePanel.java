package Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

import javax.swing.JPanel;

import GameState.GameStateManager;
 


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener{

//	public static void main(String[] args) {
		
		//Init
		public static final int WIDTH = 900;
		public static final int HEIGHT = 700;
		
		// game thread
		private Thread thread;
		private boolean running;
		private int FPS = 10;
		private long targetTime = 1000 / FPS;
		
		
		//display
		private BufferedImage image;
		private Graphics2D g;
		
		//game static manager
		private GameStateManager gsm;
		
		public GamePanel() {
			super();
			setPreferredSize(new Dimension(WIDTH, HEIGHT));
			setFocusable(true);
			requestFocus();
		}

	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	public void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		
		gsm = new GameStateManager();
	}
	
	public void run() {
		
		init();
		
		long start;
		long elapsed;
		long wait;
		
		
		while(running) {
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			wait = (targetTime - elapsed) / 1000000;
			
			try {
				Thread.sleep(Math.abs(wait));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		gsm.update();
	}
	
	public void draw() {
		gsm.draw(g);
		
	}
	
	public void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image,  0, 0, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {
		gsm.keyPressed(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key) {
		gsm.keyReleased(key.getKeyCode());
	}
	
	public void mouseClicked(MouseEvent key) {
		gsm.mouseClicked(key.getXOnScreen(), key.getYOnScreen());
	}
	public void mouseEntered(MouseEvent key) {}
	public void mouseExited(MouseEvent key) {}
	public void mousePressed(MouseEvent key) {}
	public void mouseReleased(MouseEvent key) {}
}
