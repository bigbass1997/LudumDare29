package tm.info.bigbass1997.ld29.entities.species;

import tm.info.bigbass1997.ld29.GraphicsMain;
import tm.info.bigbass1997.ld29.managers.GameStateManager;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Polygon;

public class Organism {
	
	public Species species;
	public float x, y;
	public TextureRegion texture;
	public Sprite sprite;
	
	public GameStateManager gsm;
	
	public boolean remove;
	
	public boolean moveRight; // Decides if organism should move right across the screen, if false it moves left.
	
	public Polygon hitbox;
	
	public Organism(TextureRegion texture, Species species, float x, float y, boolean moveRight, GameStateManager gsm) {
		this.species = species;
		this.x = x;
		this.y = y;
		this.texture = texture;
		this.moveRight = moveRight;
		this.gsm = gsm;
		
		hitbox = new Polygon(new float[]{x, y, x + species.width, y, x + species.width, y + species.height, x, y + species.height});
		
		sprite = new Sprite(texture);
		
		remove = false;
	}
	
	public void update(float delta){
		if(moveRight){
			x += species.speed * delta;
		}else{
			x -= species.speed * delta;
		}
		sprite.setPosition(x, y - texture.getRegionHeight() + species.height);
		hitbox.setVertices(new float[]{x, y, x + species.width, y, x + species.width, y + species.height, x, y + species.height});
	}
	
	public void draw(){
		if(!remove){
			GraphicsMain.batch.begin();
			sprite.draw(GraphicsMain.batch);
			GraphicsMain.batch.end();

			gsm.dm.Polygon(hitbox.getVertices(), 0xFF0000FF, ShapeType.Line);
		}
	}
	
	public void dispose(){
		
	}
}
