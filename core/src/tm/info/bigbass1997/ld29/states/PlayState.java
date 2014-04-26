package tm.info.bigbass1997.ld29.states;

import tm.info.bigbass1997.ld29.managers.GameStateManager;

public class PlayState extends GameState {

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void update(float delta) {
		gsm.player.update(delta);
	}

	@Override
	public void draw() {
		gsm.player.draw();
	}

	@Override
	public void dispose() {
		
	}

}
