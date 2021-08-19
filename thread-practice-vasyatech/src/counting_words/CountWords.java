package counting_words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountWords {
	
	public static String getWordsNumber(File file) throws IOException{
		int wordsNumber = 0;
		try {
		      String[] words = null;
		      FileReader fileReader = new FileReader(file);
		      BufferedReader bufferedReader = new BufferedReader(fileReader); 
		      String line;
		      while((line = bufferedReader.readLine())!=null)    
		      {
		         words = line.split(" ");  
		         wordsNumber += words.length;   
		      }
		      fileReader.close();
		      bufferedReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		    }
		return String.format("%s: %2d", file.getName(), wordsNumber) + System.lineSeparator();
	}
}
