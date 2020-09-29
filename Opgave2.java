package Hjemmeopgave2;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Opgave2 {
	
	static String[] illegal = {" ",".",",","!","?","(",")","/"};
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Takes the input from the user
		String inLine = takeInput();
		
		
		//Splits the input-string into a list of separated characters.
		//A list is used in this case, as a list is easier to manipulate
		//in the cleaning-method eliminateIllegals().
		List<String> separated = splitLine(inLine);
		
		
		//Cleans the separated line of illegal characters, and
		//turns every element into lower case letters
		List<String> cleanLine = eliminateIllegals(separated);
		
		
		//Takes the input from cleanLine creates 2 strings:
		//first string is all of the elements of cleanLine in one string,
		//second string is the first string reversed.
		String[] twoLines = createReversedStrings(cleanLine);
		
		
		//Checks if the two strings from twoLines are equal
		Boolean isPalindrome = checkIfPalindrome(twoLines);
		
		
		if(isPalindrome) {
			System.out.println("'" + inLine + "'" + " is a palindrome!");
		}
		else {
			System.out.println("'" + inLine + "'" + " is not a palindrome!");
		}
	}
	
	

	public static String takeInput() {
		System.out.println("Enter line to check: "); 
		
		return scanner.nextLine();
	}
	

	public static List<String> splitLine(String line) {
		List<String> output = new ArrayList<String>();
		
		for(int i=0; i<line.length(); i++) {
			//Adds one letter at a time to the list
			output.add(i, line.substring(i,i+1));
		} 
		return output;
	}
	
	
	public static List<String> eliminateIllegals(List<String> list) {
		
		//Checks every element for illegal content
		for(int i=0; i<list.size(); i++) {
			
			for(int j=0; j<illegal.length; j++) {
				
				if(list.get(i).equals(illegal[j])) {
					list.remove(i);
					
					//If an element is removed, the next element will
					//take its index, so we need to redo the i-value
					i--;
				}
			}
		}
		
		//Changes every element to lower case letters
		for(int i=0; i<list.size(); i++) {
			list.set(i, list.get(i).toLowerCase());
		}
		
		return list;
	}
	
	
	public static String[] createReversedStrings(List<String> list) {
		
		//Initialize two empty strings
		String[] output = {"",""};
		
		for(int i=0; i<list.size(); i++) {
			//First one starts from beginning
			output[0] += list.get(i);
			
			//Second one start from the end
			output[1] += list.get(list.size()-i-1);
		}
		
		return output;
	}

	
	public static Boolean checkIfPalindrome(String[] lines) {
		return lines[0].equals(lines[1]) ? true : false;
	}
}

