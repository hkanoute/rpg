package rpg;
/**
 * Classe qui gère les déplacement des ennemies et du joueur
 * @author kanou
 *
 */
public class MapAction {
	
		private int currX, currY;
		
		public MapAction(Player player) {
				this.currX = 800;
				this.currY = 0;
		}
			
		
		
		public MapAction(Monster currMonster) {
			this.currX=(int)(Math.random()*8)*100;
			this.currY=(int)(Math.random()*8)*100;
		}



		public MapAction(Obstacle currObstacle) {
			this.currX=(int)(Math.random()*8)*100;
			this.currY=(int)(Math.random()*8)*100;
		}



		public void changePosition(String direction) {
			
			if (direction=="up" && 0<this.currX) {
				this.currX-=100;
			}
			
			else if (direction=="down" && this.currX<800) {
				this.currX+=100;
			}
			
			else if (direction=="left" && 0<this.currY) {
				this.currY-=100;
			}
			
			else if (direction=="right" && this.currY<800) {
				this.currY+=100;
			}
		}
		
		
		public static void randomEnemyPosition() {
			for (int i=0; i<Map.enemies.size(); i++) { 
				Map.enemiesPos.get(i).currX=(int)(Math.random()*8)*100;
				Map.enemiesPos.get(i).currY=(int)(Math.random()*8)*100;
			}
		}
		
		public int getX() {
			return this.currX;
		}
		
		public int getY() {
			return this.currY;
		}
			
}


