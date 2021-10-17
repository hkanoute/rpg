package rpg;

/**
 * Classe permettant de créer des monstres
 * @author kanou
 *
 */
public class Monster extends Destructible {
	

	public Monster() {
		super(400,"Monster",60);
	}

	@Override
	public void hit_me(double damage) {
		super.life -= damage;
		
	}
	

}
