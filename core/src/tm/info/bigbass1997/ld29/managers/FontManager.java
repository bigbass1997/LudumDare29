package tm.info.bigbass1997.ld29.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FontManager {
	
	public BitmapFont fs16 = new BitmapFont(Gdx.files.internal("fonts/The-First-FontStruction_16px.fnt"), false);
	public BitmapFont fs32 = new BitmapFont(Gdx.files.internal("fonts/The-First-FontStruction_32px.fnt"), false);
	public BitmapFont fs48 = new BitmapFont(Gdx.files.internal("fonts/The-First-FontStruction_48px.fnt"), false);
	public BitmapFont fs72 = new BitmapFont(Gdx.files.internal("fonts/The-First-FontStruction_72px.fnt"), false);
	
	public FontManager(){
		
	}
}
