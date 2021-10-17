package rpg;
/**
 * Classe représentant un baton magique
 * @author kanou
 *
 */
public class Wand extends Weapon {
		private static final String name = "Wand";
		private static final double damage = 200;
		private static final double monsterDamageMultiplicator = 1.2;
		private static final double obstacleDamageMultiplicator = 1.5;
		
		
		
		public Wand() {
			super(name,damage,monsterDamageMultiplicator,obstacleDamageMultiplicator);
		}
		
		public Wand(double damage) {
			super(name,damage,monsterDamageMultiplicator,obstacleDamageMultiplicator);
		}

		@Override
		protected String Ascii_art() {
			return "             *\r\n"
					+ "       *   *\r\n"
					+ "     *    \\* / *\r\n"
					+ "       * --.:. *\r\n"
					+ "      *   * :\\ -\r\n"
					+ "        .*  | \\\r\n"
					+ "       * *     \\\r\n"
					+ "     .  *       \\";
		}
}


