package com.epam.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.epam.io.exception.ArgumentMismatchException;

class StringFinderHelper {
	public static void runApplication(String[] args) {
		StringFinder.validateInput(args);
		String filePath = args[0].trim();
		String keyword = args[1].trim();
		StringFinder stringFinder = new StringFinder(filePath, keyword);
		stringFinder.matchKeywordAndPrintLine();
	}
}
public class StringFinder {
    private String filePath;
    private String keyword;
	
    StringFinder(String filePath, String keyword){
    	this.filePath = filePath;
    	this.keyword = keyword;
    }
	public static void validateInput(String[] args) {
		if(args.length != 2) {
			throw new ArgumentMismatchException("There must be two input params");
		}
	}
	public String matchKeywordAndPrintLine() {
		FileReader inputStream = null;
		BufferedReader bufferedReader = null;
		String line = null;
		try {
			inputStream = new FileReader("src/main/resources/sample.txt");
			bufferedReader = new BufferedReader(inputStream);
			while((line = bufferedReader.readLine()) != null) {
				if(line.contains(keyword)) {
					System.out.println(line);
				}
			}
			
		} catch (IOException e) {
          System.out.println(e.getMessage());  
		} 
		return line;
	}
	public static void main(String[] args) {
		StringFinderHelper.runApplication(args);
	}

}
