package tm.info.bigbass1997.ld29.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import tm.info.bigbass1997.ld29.entities.species.Algae;
import tm.info.bigbass1997.ld29.entities.species.Species;
import tm.info.bigbass1997.ld29.managers.GameStateManager;

public class Player extends GameObject {
	
	public Species species;
	
	public Player(GameStateManager gsm) {
		super(gsm);
		
		x = 100;
		y = 100;
		width = 64;
		height = 64;
		
		speed = 0.0f;
		
		setSpecies(new Algae());
	}

	@Override
	public void update(float delta) {
		Input input = Gdx.input;
		if(input.isKeyPressed(Keys.LEFT) || input.isKeyPressed(Keys.A)){
			dx = -speed;
		}else if(input.isKeyPressed(Keys.RIGHT) || input.isKeyPressed(Keys.D)){
			dx = speed;
		}else{
			dx = 0.0f;
		}
		
		if(input.isKeyPressed(Keys.UP) || input.isKeyPressed(Keys.W)){
			dy = speed;
		}else if(input.isKeyPressed(Keys.DOWN) || input.isKeyPressed(Keys.S)){
			dy = -speed;
		}else{
			dy = 0.0f;
		}
		
		x += dx * delta;
		y += dy * delta;
	}

	@Override
	public void draw() {
		gsm.dm.Rect(x, y, width, height, 0x00FF00, ShapeType.Filled);
	}
	
	public void setSpecies(Species species){
		this.species = species;
		speed = species.speed;
		width = species.width;
		height = species.height;
	}
}
