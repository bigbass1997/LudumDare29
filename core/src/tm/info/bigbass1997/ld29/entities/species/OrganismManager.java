package tm.info.bigbass1997.ld29.entities.species;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;

import tm.info.bigbass1997.ld29.managers.GameStateManager;

public class OrganismManager {
	
	private Texture spritesheet;
	public ArrayList<TextureRegion> regions;
	
	public GameStateManager gsm;
	
	public ArrayList<Organism> organisms;
	public static final int MAX_FISH = 100; //So that fish dont overrun the ocean
	
	public OrganismManager(GameStateManager gsm){
		this.gsm = gsm;
		
		spritesheet = new Texture(Gdx.files.internal("images/fishsheet.png"));
		regions = new ArrayList<TextureRegion>();
		
		int AREA = 128;
		for(int r = 0; r < 4; r++){
			for(int c = 0; c < 4; c++){
				regions.add(new TextureRegion(spritesheet, (c * AREA), (r * AREA), AREA, AREA));
			}
		}
		
		organisms = new ArrayList<Organism>(MAX_FISH);
	}
	
	public void deployOrganism(int type, float x, float y){
		if(type == Species.ALGAE) organisms.add(new Organism(regions.get(Species.ALGAE), new Algae(), x, y, true, gsm));
	}
	
	public void update(float delta){
		for(int i = 0; i < organisms.size(); i++){
			Organism organism = organisms.get(i);
			organism.update(delta);
			
			if(Intersector.overlapConvexPolygons(organism.hitbox, gsm.player.hitbox)){
				if(organism.species.type <= gsm.player.species.type){
					organism.remove = true;
				}else{
					gsm.player.kill();
				}
			}
			
			if(organism.remove){
				organism.dispose();
				organisms.remove(i);
			}
		}
	}
	
	public void draw(){
		for(int i = 0; i < organisms.size(); i++){
			organisms.get(i).draw();
		}
	}
}
