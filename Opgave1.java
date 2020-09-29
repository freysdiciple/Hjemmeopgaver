package Hjemmeopgave2;
import java.util.Scanner;

public class Opgave1 {
	
	//Numbers and their numeral partners are defined
	static int[] numbers = {1000,500,100,50,10,5,1};
	static String[] numerals = {"M","D","C","L","X","V","I"};
	
	static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		//Take in number from user
		int inNumber = takeInput();
		
		//Convert the input
		String outNumeral = convert(inNumber);
		
		//Print the numerals
		System.out.println(inNumber + " = " + outNumeral);
	}
	
	//Returns how many times a number 'scale' goes into 'num'
	public static int howManyTimes(int num, int scale) {
		int outVal=0;
		int inVal=num;
		
		while(inVal - scale >= 0) {
			inVal -= scale;
			outVal++;
		}
		return outVal;
	}
	
	//Returns the integer from the console
	public static int takeInput() {
		System.out.print("Enter positive integer to convert:");
		
		int input = scanner.nextInt();
		
		return input;
	}
	
	//Return roman numeral as a string, from an integer input value 
	public static String convert(int input) {
		
		//Initialize the output string
		String outNum="";
		
		//Goes systematically through every possible roman numeral,
		//starting with M = 1000, and then moving down
		for(int i=0; i<numbers.length;i++) {
			int num = howManyTimes(input, numbers[i]);
			
			//Reduces input to match
			input -= num * numbers[i];
			
			//We then add the numeral values to the output.
			//Exception: if num equals 4, we do a special syntax, f.x:
			//we dont write 4 as IIII but as IV,
			//and this syntax is not handled here
			if(num != 4) {
				for(int j=0; j<num; j++) {
					outNum += numerals[i];
				}
			}
			//This else-method handles the special syntax
			else {
				outNum += (numerals[i] + numerals[i-1]);
			}
		}
		
		return outNum;
		
	}
}
