package tm.info.bigbass1997.ld29.managers;

import tm.info.bigbass1997.ld29.GraphicsMain;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DrawManager {
	
	private SpriteBatch batch;
	private ShapeRenderer sr;
	
	public DrawManager(ShapeRenderer sr){
		this.sr = sr;
		batch = GraphicsMain.batch;
	}
	
	public void Rect(float x, float y, float width, float height, int color, ShapeType type){
		sr.setColor(new Color(color));
		sr.begin(type);
		sr.rect(x, y, width, height);
		sr.end();
	}
	
	public void Polygon(float[] vertices, int color, ShapeType type){
		sr.setColor(new Color(color));
		sr.begin(type);
		sr.polygon(vertices);
		sr.end();
	}
	
	public void String(String s, float x, float y, BitmapFont font, int color){
		font.setColor(Color.WHITE); //Resets color
		font.setColor(new Color(color));
		
		batch.begin();
		font.draw(batch, s, x, y);
		batch.end();
	}
}
