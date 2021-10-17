package rpg;
/**
 * Classe représentant un arc
 * @author kanou
 *
 */
public class Bow extends Weapon {
	
	private static final String name = "Bow";
	private static final double damage = 200;
	private static final double monsterDamageMultiplicator = 1.2;
	private static final double obstacleDamageMultiplicator = 1.5;
	
	
	
	public Bow() {
		super(name,damage,monsterDamageMultiplicator,obstacleDamageMultiplicator);
	}
	
	public Bow(double damage) {
		super(name,damage,monsterDamageMultiplicator,obstacleDamageMultiplicator);
	}

	@Override
	protected String Ascii_art() {
		return "   (\r\n"
				+ "    \\\r\n"
				+ "     )\r\n"
				+ "##-------->\n"
				+ "     )\r\n"
				+ "    /\r\n"
				+ "   (";
	}
}