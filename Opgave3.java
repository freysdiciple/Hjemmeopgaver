package Hjemmeopgave2;

public class Opgave3 {
	
	static double needleLength = 1;
	static int nOfReps = 1000000;

	public static void main(String[] args) {
		
		int nOfCrosses = train(nOfReps);
		System.out.println((double) nOfReps/ (double) nOfCrosses);
		

	}
	
	public static int train(int repetitions) {
		int cases=0;
		
		for(int i=0; i<repetitions; i++) {
			double needleMiddle = 2*Math.random();
			double needleAngle = Math.PI*Math.random();
			
			double needleEnd1 = needleMiddle + Math.sin(needleAngle) * needleLength/2;
			double needleEnd2 = needleMiddle - Math.sin(needleAngle) * needleLength/2;
			
			Boolean crossed = (needleEnd1 > 2 || needleEnd2 < 0) ? true : false;
			if(crossed) {cases++;}
		}
		return cases;
	}

}
