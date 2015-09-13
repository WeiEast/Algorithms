package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Problem Statement

	You are given an array of integers of size N. You need to print the sum of the elements of the array.
	
	Input Format 
	The first line of the input consists of an integer N. The next line contains N space-separated integers describing the array.
	
	Constraints 
	1≤N≤1000 
	0≤A[i]≤1000
	
	Output Format 
	Output a single value equal to the sum of the elements of the array.
	
	Sample Input
	
	6
	1 2 3 4 10 11
	Sample Output
	
	31
	Explanation 
	1+2+3+4+10+11=31
 *
 */
public class SimpleArraySum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t;
		t = in.nextInt();
		int sum = 0;
		for (int i = 0; i < t; i++) {
			sum += in.nextInt();
		}
		System.out.println(sum);

	}

}
