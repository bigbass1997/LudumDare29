package tm.info.bigbass1997.ld29.entities.species;

public abstract class Species {
	
	public static final int ALGAE = 0;
	
	public String name;
	public int type;
	
	public float speed;
	public float width, height;
	
	public Species(String name, int type, float speed, float width, float height){
		this.name = name;
		this.type = type;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
}