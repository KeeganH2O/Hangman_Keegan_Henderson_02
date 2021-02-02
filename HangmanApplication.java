import java.io.*;
import java.util.Scanner;
/**
 * 
 * @author Keegan Henderson
 * @version 2.0 with javadocs
 *
 *this is the main method and utilises the methods within HangmanClass to play the game.
 */
public class HangmanApplication {

	public static void main(String[] args) throws IOException{
		HangmanClass Hangman = new HangmanClass();
		Scanner input = new Scanner(System.in);
		boolean playAgain = true;
		String again = ""; 
		
		Hangman.loadWL();
		
		while(playAgain) {
			Hangman.playGame();
			System.out.println("Play Again? or quit? Y/N");
			again = input.nextLine();
			if(again.equals("Y")){
				playAgain = true;
			}
			else if(again.equals("N")){
				playAgain = false;
				System.out.println("YOU HAVE COMPELTED THE GAME!");
			}
			
		}
		
		Hangman.writeWL();

	}//end main

}//end class
