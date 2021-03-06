package tm.info.bigbass1997.ld29.states;

import tm.info.bigbass1997.ld29.managers.GameStateManager;

public abstract class GameState {
	
	public GameStateManager gsm;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
		init();
	}
	
	public abstract void init();
	public abstract void update(float delta);
	public abstract void draw();
	public abstract void dispose();
}
