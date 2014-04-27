package tm.info.bigbass1997.ld29.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Polygon;

import tm.info.bigbass1997.ld29.GraphicsMain;
import tm.info.bigbass1997.ld29.entities.species.Algae;
import tm.info.bigbass1997.ld29.entities.species.Species;
import tm.info.bigbass1997.ld29.managers.GameStateManager;

public class Player extends GameObject {
	
	public Species species;
	
	private TextureRegion texture;
	private Sprite sprite;
	
	public Polygon hitbox;
	
	public Player(GameStateManager gsm) {
		super(gsm, 100, 100, 64, 64);
		
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
		
		if(x > GraphicsMain.sWidth - width) x = GraphicsMain.sWidth - width;
		else if(x < 0) x = 0;
		
		if(y > GraphicsMain.sHeight - height) y = GraphicsMain.sHeight - height;
		else if(y < 0) y = 0;
		
		sprite.setPosition(x, y - sprite.getHeight() + height);
		
		hitbox.setVertices(new float[]{x, y, x + width, y, x + width, y + height, x, y + height});
		
		if(remove) dispose();
	}

	@Override
	public void draw() {
		if(!remove){
			GraphicsMain.batch.begin();
			sprite.draw(GraphicsMain.batch);
			GraphicsMain.batch.end();
			
			gsm.dm.Polygon(hitbox.getVertices(), 0x00FFFFFF, ShapeType.Line);
		}
	}
	
	public void setSpecies(Species species){
		this.species = species;
		speed = species.speed;
		width = species.width;
		height = species.height;
		
		hitbox = new Polygon(new float[]{x, y, x + width, y, x + width, y + height, x, y + height});
		
		texture = gsm.om.regions.get(species.type);
		sprite = new Sprite(texture);
	}
	
	public void kill(){
		System.out.println("YOU HAVE BEEN KILLED");
	}
	
	public void dispose(){
		texture.getTexture().dispose();
		sprite.getTexture().dispose();
	}
}
