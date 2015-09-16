package hackerrank.algorithms.warmup;

import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

/**
 * Problem Statement

	You're given an array containing integer values. You need to print the fraction of count of positive numbers, negative numbers and zeroes to the total numbers. Print the value of the fractions correct to 3 decimal places.
	
	Input Format
	
	First line contains N, which is the size of the array. 
	Next line contains N integers A1,A2,A3,⋯,AN, separated by space.
	
	Constraints 
	1≤N≤100 
	−100≤Ai≤100
	Output Format
	
	Output three values on different lines equal to the fraction of count of positive numbers, negative numbers and zeroes to the total numbers respectively correct to 3 decimal places.
	
	Sample Input
	
	6
	-4 3 -9 0 4 1          
	Sample Output
	
	0.500
	0.333
	0.167
	Explanation
	
	There are 3 positive numbers, 2 negative numbers and 1 zero in the array. 
	Fraction of the positive numbers, negative numbers and zeroes are 36=0.500, 26=0.333 and 16=0.167 respectively.
	
	Note This challenge introduces precision problems. You can even print output to 4 decimal places and above but only the difference at 3rd decimal digit is noted. That is the reason you'll notice testcases have much higher precision (more decimal places) than required. 
	Answers with absolute error upto 10−4 will be accepted.
 *
 */
public class PlusMinus {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int positive = 0;
		int negative = 0;
		int zero = 0;
		int result = 0;
		for (int i = 0; i < t; i++) {
			result = in.nextInt();
			if (result > 0) {
				positive++;
			} else if (result == 0) {
				zero++;
			} else {
				negative++;
			}
		}

		double x = (double) positive / (double) t;
		double y = (double) negative / (double) t;
		double z = (double) zero / (double) t;
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
}
