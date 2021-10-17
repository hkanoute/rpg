package rpg;

import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;
/**
 * Map qui va gerer les intéractions entre la map et le joueur
 * @author kanou
 *
 */
public class Map extends JFrame implements KeyListener {
	
	private static int width = 900;
	private  static int height = 900;
		
	private static int nbEnemies = 16;
	public static ArrayList<Destructible> enemies = new ArrayList<Destructible>();
	public static ArrayList <MapAction> enemiesPos = new ArrayList <MapAction>();
	
	public static MapDrawing mapDrawing = new MapDrawing();
	public static MapAction playerPos = new MapAction(GameLogic.player);
	
	/**
	 * Constructeur qui créer les ennemies à la création de la map 
	 */
	public Map() {
		
		setTitle("Map");
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
		
		for (int i=0; i<nbEnemies/2; i++) { 			
			Monster currMonster = new Monster();
			enemies.add(currMonster);
			enemiesPos.add(new MapAction(currMonster));
			
			Obstacle currObstacle = new Obstacle();
			enemies.add(currObstacle);
			enemiesPos.add(new MapAction(currObstacle));			
		}
		
		add(mapDrawing);
				
	}
	/**
	 * permet d'afficher la map
	 */
	public void showMap() {
		setVisible(true);		
	}
	
	/**
	 * Méthode qui permet à l'utisateur de se déplacer sur la map et de verifier s'il a gagné ou croisé un destructible
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		MapAction.randomEnemyPosition();
		
		if (checkIfEnemy()==false) {
			switch (e.getKeyCode()) {
				case 38:
					playerPos.changePosition("up");
					break;
				case 39:
					playerPos.changePosition("right");
					break;
				case 40:
					playerPos.changePosition("down");
					break;
				case 37:
					playerPos.changePosition("left");
					break;
			}
		}
		
		checkIfWin();
		mapDrawing.repaint();
		
		try {
			checkIfBattle();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	}
	/**
	 * Si le joueur est en haut a droite il a gagné la partie
	 */
	public void checkIfWin() {
		if (playerPos.getX()==0 && playerPos.getY()==800) {
			GameLogic.printHeading("You won ! with " + GameLogic.player.honor + " Honors !");
			System.exit(0);
		}
	}
	
	/**
	 * Si la positon du joueur est celui d'un ennemie sont équivallent alors le joueur aura le choix de combattre ou fuir
	 * @throws InterruptedException
	 */
	public void checkIfBattle() throws InterruptedException {
		for (int i=0; i<enemies.size(); i++) { 
			if (enemiesPos.get(i).getX() == playerPos.getY() && enemiesPos.get(i).getY() == playerPos.getY()) {	
				removeKeyListener(this);
				Destructible currEnemy = enemies.get(i);
				System.out.println("You met a(n) "+currEnemy.getName()+" !");
				boolean exit = false;
				System.out.println("(1) => fight");
				System.out.println("(2) => flee");
				int input = GameLogic.readInt("->", 2);
				do {
					
					
					if (input == 2) {
						exit = true;
						GameLogic.printHeading("You escaped ! , you do not earn Honor !");
						GameLogic.printHeading("You can now moove on the map");
						addKeyListener(this);			
						break;
					}
					else {
						
						GameLogic.printHeading("The fight is in progress..");
						Thread.sleep(3000);
						BattleHandler battle = new BattleHandler(currEnemy);
						battle.start();
						battle.checkResult();
						//If the enemy is dead then continue the game
						if (currEnemy.isDead()) {
							addKeyListener(this);
						}
						break;
					}
				} while (!exit);				
					
				}	
				
			}
		}
	/**
	 * Permet de verifier si le joueur a croisé un destructible
	 * @return
	 */
	private boolean checkIfEnemy() {
		for (int i=0; i<enemies.size(); i++) { 
			if (enemiesPos.get(i).getX() != playerPos.getY() || enemiesPos.get(i).getY() != playerPos.getY()) {	
				return false;		
			}
		}
		return true;
	}
			
	@Override
	public void keyReleased(KeyEvent e) {		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		
	}
	
}