package rpg;
/**
 * Classe representant une hache
 * @author kanou
 *
 */
public class Axe extends Weapon {
	
	private static final String name = "Axe";
	private static final double damage = 200;
	private static final double monsterDamageMultiplicator = 1.2;
	private static final double obstacleDamageMultiplicator = 1.5;
	
	
	
	public Axe() {
		super(name,damage,monsterDamageMultiplicator,obstacleDamageMultiplicator);
	}
	public Axe(double damage ) {
		super(name,damage,monsterDamageMultiplicator,obstacleDamageMultiplicator);
	}
	
	public String Ascii_art() {
		return "  ,:\\      /:.\r\n"
				+ " //  \\_()_/  \\\\\r\n"
				+ "||   |    |   ||\r\n"
				+ "||   |    |   ||\r\n"
				+ "||   |____|   ||\r\n"
				+ " \\\\  / || \\  //\r\n"
				+ "  `:/  ||  \\;'\r\n"
				+ "       ||\r\n"
				+ "       ||\r\n"
				+ "       XX\r\n"
				+ "       XX\r\n"
				+ "       XX\r\n"
				+ "       XX\r\n"
				+ "       OO\r\n"
				+ "       `'";
	}
}