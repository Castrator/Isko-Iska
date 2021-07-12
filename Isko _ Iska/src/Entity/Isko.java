package Entity;

import java.awt.event.KeyEvent;

public class Isko extends Player{
	
	public Isko(int x, int y) {
		super(x, y, "Isko");
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_D || k == KeyEvent.VK_A) {
			if(!jumping) {
				running = true;
			}else {
				running = false;
			}
			idle = false;
			if(k == KeyEvent.VK_A) {
				facing = LEFT;
				ax = -ACCELERATION;
			}
			if(k == KeyEvent.VK_D) {
				facing = RIGHT;
				ax = ACCELERATION;
			}
		}
		if(k == KeyEvent.VK_W && !jumping) {
			vy = -MAX_SPEEDY;
			jumping = true;
		}
	}
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_D || k == KeyEvent.VK_A) {
			ax = 0;
		}
	}
}
