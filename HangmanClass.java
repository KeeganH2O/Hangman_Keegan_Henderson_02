import java.util.Scanner;
import java.io.*;

/** 
 * 
 * @author Keegan Henderson
 * @version 2.0 with javadocs
 * 
 * This class is the meat of the program with various methods and including the game loop
 */
public class HangmanClass {
	Scanner input = new Scanner(System.in);
	Dictionary Dict = new Dictionary();
	private int wins,losses;
	private String currentWord;


	private int Lives = 5;
	
	HangmanClass(){
	}//end constructor
	
	/**
	 * loadWL loads the win loss integer values into the program
	 */
	public void loadWL() {
		try {
			File WinLoss = new File("WinLoss.txt");
			Scanner reader = new Scanner(WinLoss);
			
			wins = reader.nextInt();
			losses = reader.nextInt();
			
			reader.close();
		}//ends try
		
		catch(FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
			
		}//ends catch	
		
	}//end loadWL method
	
	
	/**
	 * writeWL writes the win loss to the WinLoss.txt 
	 * @throws IOException
	 */
	public void writeWL()throws IOException{ 
		try {
			File WinLoss = new File("WinLoss.txt");
			Writer wr = new FileWriter(WinLoss);
			
			wr.write(wins + "\n");
			wr.write(losses + "\n");
			
			wr.close();
		}//ends try
		catch(FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}//ends catch 	
	}//end writeWL method
	
	/**
	 * playGame method writes the game loop implementing the methods to play HANGMAN!
	 */
	public void playGame(){
		Lives = 5;
		Dictionary Dict = new Dictionary();
		Dict.readFile("WordFile.txt");
		currentWord = Dict.chooseWord();
		//System.out.println(currentWord);  //this is the cheat code :)
		
		char[] undercoverWord = currentWord.toCharArray();
		char[] answerArray = currentWord.toCharArray();
		char guess;
				
		for(int i = 0; i < currentWord.length(); i++) {
			undercoverWord[i] = '#';
		}
		
		System.out.println("Would you like to play a game??? Y/N");
		String userInput = input.nextLine();
		guess = userInput.charAt(0);
		
		if(userInput.equals("N")) {
			System.out.println("Why not?");
		}
		
		if(userInput.equals("Y")) {
			System.out.println("You have "+Lives+" incorrect guesses left.");
			System.out.println(undercoverWord);

			
			while(String.valueOf(undercoverWord).equals(currentWord) == false && Lives > 0) {
				System.out.println("What is your guess?");
				userInput = input.nextLine();
				guess = userInput.charAt(0);
				boolean right = false;

				for(int i = 0; i < currentWord.length();i++) {
					if(answerArray[i] == guess){
						undercoverWord[i] = guess;
						right = true;
					}//if loop
				
				}//for loop end	
				
				
				if(right) {
					System.out.println("You have "+Lives+" incorrect guesses left.");
				}
				if(!right){
					Lives--;
					System.out.println("You have "+Lives+" incorrect guesses left.");
				}
				System.out.println(undercoverWord);
			
			}//while loop end
					
		} //running game loop "yes" end
		
		if(String.valueOf(undercoverWord).equals(currentWord)) {
			System.out.println("YOU WON!");
			wins = wins + 1;
		}
		else if(Lives < 1) {
			System.out.println("YOU LOST!");
			losses = losses + 1;
		}		
		
			System.out.println("You had "+wins+" wins and "+ losses + " losses");
			System.out.println("Good Game!");
			
	}//ends play game method
	
	
}	//end class body
