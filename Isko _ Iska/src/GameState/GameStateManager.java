package GameState;

import java.util.ArrayList;

public class GameStateManager {
	
	private GameState[] gameStates;
	private int currentState;

	public static int MENUSTATE = 0;
	public static int LEVELSTATE = 1;
	
	public GameStateManager() {
		gameStates = new GameState[2];
		gameStates[MENUSTATE] = new MenuState(this);
		gameStates[LEVELSTATE] = new LevelState(this, 1);
	}
	
	public void setState(int index, int state) {
		currentState = index;
		if(index == LEVELSTATE) {
			gameStates[index] = new LevelState(this, state);
		}else if(index == MENUSTATE) {
			gameStates[index] = new MenuState(this);
		}
	}
	
	public void update() {
		gameStates[currentState].update();
	}
	
	public void draw(java.awt.Graphics2D g) {
		gameStates[currentState].draw(g);
	}
	
	public void keyPressed(int k) {
		gameStates[currentState].keyPressed(k);		
	}
	
	public void keyReleased(int k) {
		gameStates[currentState].keyReleased(k);
	}
	
	public void mouseClicked(int x, int y) {
		gameStates[currentState].mouseClicked(x, y);
	}
}
