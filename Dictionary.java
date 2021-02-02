import java.util.Scanner;
import java.io.*;
import java.util.Random;

/**
 * 
 * @author Keegan Henderson
 * @version 2.0 with javadocs
 *
 *This class Dictionary reads a file called "WordFile.txt" and converts that to a Array of Strings to be able to choose at random as the word to guess.
 */
public class Dictionary{
Random Generator = new Random();

private String[] wordList = new String[200];
private int ranNum = Generator.nextInt(200);

/**
 * readFile method reads a 200 line long list of strings and converts to array of strings
 * 
 */
	public void readFile(String fileName) {
		//
		try { 
			File Dict = new File(fileName);
			Scanner Reader = new Scanner(Dict);
			
			for(int i = 0;i < 200; i++) {
				wordList[i] = Reader.nextLine();
				//System.out.println(wordList[i]);
			}
		Reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}//ends catch
	}//ends readFile method
	
/**
 * chooseWord method chooses a word from the newly made list and returns it.
 * 
 */
	public String chooseWord(){
		return wordList[ranNum];
	}//ends chooseWord method
	
	
}//ends class