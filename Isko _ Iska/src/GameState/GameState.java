package GameState;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public abstract void init(int state);
	public abstract void update();
	public abstract void draw(java.awt.Graphics2D g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	public abstract void mouseClicked(int x, int y);
	
}
