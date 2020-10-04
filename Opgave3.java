package Hjemmeopgave2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Opgave3 {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Gets user input
		int nReps = getInput();
			
		//Saves the number of times the needle crosses a line in a variable
		int nOfCrosses = needleThrows(nReps);
			
		//Prints out the estimated value of PI
		System.out.println(nReps + " / " + nOfCrosses + " = " + (double)nReps/nOfCrosses);
		
	}
	
	public static int getInput() {
		
		int reps=0;
		System.out.print("Enter number of Iterations: ");
		
		//Throws an error if a non-integer is recieved as input
		try {
			reps = scanner.nextInt();
		}
		catch(InputMismatchException ime) {
			inputError();
			reps = getInput();
		}
		
		//Throws an error if the received integer is zero or negative
		if(reps <= 0) {
			inputError();
			reps = getInput();
		}
		return reps;
	}
	
	public static int needleThrows(int repetitions) {
		int cases=0;
		
		for(int i=0; i<repetitions; i++) {
			//Determines a new midpoint and angle for the needle for every throw
			double needleMiddle = 2*Math.random();
			double needleAngle = Math.PI*Math.random();
			
			//Calculates the ends of the needles
			double needleEnd1 = needleMiddle + Math.sin(needleAngle)/2;
			double needleEnd2 = needleMiddle - Math.sin(needleAngle)/2;
			
			//Checks if needle crossed a line
			Boolean crossed = (needleEnd1 > 2 || needleEnd2 < 0) ? true : false;
			if(crossed){cases++;}
		}
		return cases;
	}
	
	public static void inputError() {
		//Error message
		System.out.println("\n======================================");
		System.out.println("ERROR: PLEASE ENTER A POSITIVE INTEGER");
		System.out.println("======================================\n");
		
		//Clears the next line
		scanner.nextLine();
	}
}
