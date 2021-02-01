import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Dictionary{
Random Generator = new Random();

private String[] wordList = new String[200];
private int ranNum = Generator.nextInt(200);


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
	

	public String chooseWord(){
		return wordList[ranNum];
	}//ends chooseWord method
	
	
}//ends class