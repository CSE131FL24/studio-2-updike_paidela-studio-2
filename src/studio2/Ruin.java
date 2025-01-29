package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter starting money amount: ");
		double startAmount = in.nextDouble();
		
		System.out.println("Enter the win probability that you win a single play: ");
		double winChance = in.nextDouble();
		
		System.out.println("Enter the amount of money you would be satisfied with and leave: ");
		double winLimit = in.nextDouble();
		
		System.out.println("Enter the number of total simulations: ");
		int totalSimulations = in.nextInt();
		
		//boolean success = winLimit==startAmount;
		//if I win or loose
		if (totalSimulations == 0) {
			System.out.println("Ruin :(");
		}
		double expectedRuin= 0;
		double alpha= (1- winChance)/winChance;
		if (winChance==0.5) {
			 expectedRuin= 1- (startAmount/winLimit);
		}
		else {
			expectedRuin= (Math.pow(alpha, startAmount)- Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
	
		}
		
		System.out.println("Expected Ruin Rate =" + expectedRuin);
		
		
		
		int totalSimulationsCheck = totalSimulations;
		boolean result = (Math.random()*101) < (winChance*100);
		double count = 0.0;
		
		while (totalSimulations>0) {
			if (result==true) {
				startAmount++;
				
			}else {
				startAmount--;
				count++;
				
			}
			if (startAmount>=winLimit) {
				System.out.println("Successful gamble!");
				totalSimulations = -1;
				
			} else {
			totalSimulations--;
		}
			
			

		
		

	}
		System.out.println ("Ruin rate from simulation: " + count/totalSimulationsCheck);

}
}
