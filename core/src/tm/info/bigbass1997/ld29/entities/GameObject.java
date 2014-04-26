package tm.info.bigbass1997.ld29.entities;

import tm.info.bigbass1997.ld29.managers.GameStateManager;

public abstract class GameObject {
	
	public float x, y;
	public float dx, dy;
	
	public float speed;
	
	public float width, height;
	
	public GameStateManager gsm;

	public GameObject(GameStateManager gsm){
		this(gsm, 0, 0, 0, 0);
	}
	
	public GameObject(GameStateManager gsm, float x, float y, float width, float height){
		this.gsm = gsm;
	}
	
	public abstract void update(float delta);
	public abstract void draw();
}
