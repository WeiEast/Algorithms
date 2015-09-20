package hackerrank.algorithms.Implementation;

import java.util.Scanner;

/**
 * Problem Statement

	You are given an integer N. Find the digits in this number that exactly divide N (division that leaves 0 as remainder) and display their count. For N=24, there are 2 digits (2 & 4). Both of these digits exactly divide 24. So our answer is 2.
	
	Note
	
	If the same number is repeated twice at different positions, it should be counted twice, e.g., For N=122, 2 divides 122 exactly and occurs at ones' and tens' position. So for this case, our answer is 3.
	Division by 0 is undefined.
	Input Format
	
	The first line contains T (the number of test cases), followed by T lines (each containing an integer N).
	
	Constraints 
	1≤T≤15 
	0<N<1010
	Output Format
	
	For each test case, display the count of digits in N that exactly divide N in a separate line.
	
	Sample Input
	
	2
	12
	1012
	Sample Output
	
	2
	3
	Explanation
	
	2 digits in the number 12 divide it exactly. The first digit, 1, divides it exactly in twelve parts, and the second digit, 2 divides 12 equally in six parts.
	
	1 divides 1012 exactly (and it occurs twice), and 2 also divides it exactly. Division by 0 is undefined, therefore it will not be counted.
	
	This challenge was part of Pragyan 12.
 *
 */
public class FindDigits {
	private static int getNum(int n) {
		int k = 0;
		int t = n;
		while (n != 0) {
			int ret = n % 10;
			if (ret != 0 && t % ret == 0) {
				k++;
			}
			n /= 10;
		}
		return k;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println(getNum(in.nextInt()));
		}
	}
}
