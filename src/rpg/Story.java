package rpg;
/**
 * 
 * Classe qui permet d'afficher les parties de l'histoire
 *
 */
public class Story {

	public static void printIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("STORY");
		GameLogic.printSeparator(30);
		System.out.println("You are a villager who's family was kidnapped by an unknown man...");
		System.out.println("By becoming one of those gifted people, it's time to get back your family!");
		GameLogic.anythingToContinue();
		
	}
	
	public static void printEnd() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("END");
		GameLogic.printSeparator(30);
		System.out.println("Congratulations" + GameLogic.player.name);
		System.out.println("By becoming one of those gifted people, it's time to get back your family!");
		GameLogic.anythingToContinue();
		
	}
}
