package rpg;
/**
 * Classe abstraite permettant de définir différent types d'armes
 * @author kanou
 *
 */
public abstract class Weapon {
	
	protected String name;
	protected double damage;
	private double monsterDamageMultiplicator;
	private double obstacleDamageMultiplicator;
	
	public Weapon (String name, double damage, double monsterDamageMultiplicator, double obstacleDamageMultiplicator) {
		this.name=name;
		this.damage = damage;
		this.monsterDamageMultiplicator = monsterDamageMultiplicator;
		this.obstacleDamageMultiplicator = obstacleDamageMultiplicator;
	}

	public String getName() {
		return this.name;
	}
	
	/**
	 * ppermet de définir l'ascii art de l'arme
	 * @return
	 */
	abstract protected String Ascii_art();
	
	public String getAscii() {
		return this.Ascii_art();
	}
	/**
	 * permet à l'arme d'infliger des dégâts 
	 * @param enemy
	 */
	public void attackEnemy(Destructible enemy) {
		if (enemy instanceof Monster) {
			enemy.hit_me(enemy.damage*this.monsterDamageMultiplicator);
		}
		else if (enemy instanceof Obstacle) {
			enemy.hit_me(enemy.damage*this.obstacleDamageMultiplicator);
		}
	}
}
