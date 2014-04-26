package tm.info.bigbass1997.ld29.managers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import tm.info.bigbass1997.ld29.states.GameState;
import tm.info.bigbass1997.ld29.states.MenuState;
import tm.info.bigbass1997.ld29.states.PlayState;

public class GameStateManager {
	
	private GameState gameState;
	
	public int currentState;
	public final int MENUSTATE = 0;
	public final int PLAYSTATE = 1;
	
	private GameState menuState;
	private GameState playState;
	
	public ShapeRenderer sr;
	public FontManager fm;
	public DrawManager dm;
	
	public GameStateManager(){
		sr = new ShapeRenderer();
		fm = new FontManager();
		dm = new DrawManager(sr);
		
		menuState = new MenuState(this);
		playState = new PlayState(this);
		
		setState(PLAYSTATE);
	}
	
	public void update(float delta){
		gameState.update(delta);
	}
	
	public void draw(){
		gameState.draw(sr);
	}
	
	public void setState(int state){
		switch(state){
		case MENUSTATE:
			gameState = menuState;
			currentState = state;
			break;
		case PLAYSTATE:
			gameState = playState;
			currentState = state;
			break;
		default:
			System.out.println("INPUTTED STATE NOT VALID!");
			break;
		}
	}
	
	public int getCurrentState(){ return currentState;}
	public GameState getGameState(){ return gameState;}
}