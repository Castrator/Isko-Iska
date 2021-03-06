package Entity;

import java.awt.event.KeyEvent;

public class Iska extends Player{
	
	public Iska(int x, int y) {
		super(x, y, "Iska");
	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_LEFT) {
			if(!jumping) {
				running = true;
			}else {
				running = false;
			}
			idle = false;
			if(k == KeyEvent.VK_LEFT) {
				facing = LEFT;
				ax = -ACCELERATION;
			}
			if(k == KeyEvent.VK_RIGHT) {
				facing = RIGHT;
				ax = ACCELERATION;
			}
		}
		if(k == KeyEvent.VK_UP && !jumping) {
			vy = -MAX_SPEEDY;
			jumping = true;
		}
	}
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_LEFT) {
			ax = 0;
		}
	}
}
