package rpg;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/**
 * 
 * Classe perm�ttant de repr�senter la carte,le joueur et les ennemi 
 * le joueur => Carr� Bleu 
 * les bstacles => carr� noir 
 * les monstres => carr� vert
 *
 */

public class MapDrawing extends JPanel {
	
	public MapDrawing() {
		setBackground(Color.LIGHT_GRAY);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<Map.enemies.size(); i++) {
			
			if (Map.enemies.get(i) instanceof Monster) {
				g.setColor(Color.GREEN);
				g.fillRect(Map.enemiesPos.get(i).getY(), Map.enemiesPos.get(i).getX(),10,10);
			}
			
			else if (Map.enemies.get(i) instanceof Obstacle) {
				g.setColor(Color.BLACK);
				g.fillRect(Map.enemiesPos.get(i).getY(), Map.enemiesPos.get(i).getX(),10,10);
			}
		}
		
		g.setColor(Color.BLUE);
		g.fillRect(Map.playerPos.getY(), Map.playerPos.getX(), 10, 10);
		
	}
}