package tm.info.bigbass1997.ld29.states;

import tm.info.bigbass1997.ld29.entities.species.Species;
import tm.info.bigbass1997.ld29.managers.GameStateManager;

public class PlayState extends GameState {

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		for(int i = 0; i < 20; i++){
			gsm.om.deployOrganism(Species.ALGAE, 0, i * 26);
		}
	}

	@Override
	public void update(float delta) {
		gsm.player.update(delta);
		gsm.om.update(delta);
	}

	@Override
	public void draw() {
		gsm.player.draw();
		gsm.om.draw();
	}

	@Override
	public void dispose() {
		
	}

}
