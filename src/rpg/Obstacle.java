package rpg;
/**
 * Classe perméttant de créer des obstacles
 * @author kanou
 *
 */
public class Obstacle extends Destructible{
	
	
	public Obstacle() {
		super(400,"Obstacle",60);
	}

	@Override
	public void hit_me(double damage) {
		super.life -= damage;
		
	}

}


