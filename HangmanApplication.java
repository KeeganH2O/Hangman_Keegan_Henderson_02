import java.io.*;
import java.util.Scanner;

public class HangmanApplication {

	public static void main(String[] args) throws IOException{
		HangmanClass Hangman = new HangmanClass();
		Scanner input = new Scanner(System.in);
		boolean playAgain = true;
		String again; 
		
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
			input.close();
		}
		
		Hangman.writeWL();

	}//end main

}//end class
