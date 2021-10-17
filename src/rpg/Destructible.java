package rpg;

/**
 * Classe abstraite qui permet de définir les ennemies de l'utisateurs 
 * @author kanou
 *
 */
public abstract class Destructible {
	
	protected int life;
	protected String name;
	protected int damage;
	
	public Destructible(int life, String name, int damage) {
		this.life = life;
		this.name = name;
		this.damage = damage;
	}

	public abstract void hit_me(double damage);
	
	/**
	 * permet au ennemies d'attaquer le joueurs
	 */
	protected void attackPlayer() {
		GameLogic.player.hit_me(damage);		
	}
	
	/**
	 * permet de verifier si le destruble est mort 
	 * @return
	 */
	public boolean isDead() {
		if (this.life <= 0) return true;
		return false;
	}
	
	public int getLife() {
		return life;
	}

	public String getName() {
		return name;
	}
}
