package hackerrank.Day30;

import java.util.Scanner;

/**
 * Input Format

	Three numbers, (M, T, and X), each on separate lines:
	
	M will be a double representing the original price of the meal.
	
	T will be a integer representing the percentage that the customer wants to tip based off of the original price of the meal.
	
	X will be an integer representing the tax percentage that the customer has to pay based off of the original price of the meal.
	
	Output Format
	
	A string stating...
	
	The final price of the meal is $-.
	where the final price of the meal is substituted for the dash. The price should be rounded to the nearest integer (dollar) - the code for rounding has already been added in the editor if you are coding in Java.
	
	Sample Input
	
	12.00
	20
	8
	Sample Output
	
	The final price of the meal is $15.
	Explanation
	
	M=12, T=20, X=8 
	tip=(20×12)/100=2.4 
	tax=(8×12)/100=0.96 
	final price=12+2.4+0.96=15.36 
	Officially, the price of the meal is $15.36, but rounded to the nearest dollar (integer), the meal is $15.
 *
 */
public class Arithmetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double M = sc.nextDouble(); // original meal price
		int T = sc.nextInt(); // tip percentage
		int X = sc.nextInt(); // tax percentage
		double tip = (M * T) / 100;
		double tax = (X * M) / 100;
		int price = (int) Math.round(tip + tax + M);
		System.out.println("The final price of the meal is $" + price + ".");
	}
}
