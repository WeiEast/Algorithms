package hackerrank.Strings;

import java.util.Scanner;

/**
 * Problem Statement

	You are given two strings, A and B. Find if there is a substring that appears in both A and B.
	
	Input Format
	
	Several test cases will be given to you in a single file. The first line of the input will contain a single integer T, the number of test cases.
	
	Then there will be T descriptions of the test cases. Each description contains two lines. The first line contains the string A and the second line contains the string B.
	
	Output Format
	
	For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.
	
	Constraints
	
	All the strings contain only lowercase Latin letters.
	1<=T<=10
	1<=|A|,|B|<=105
	Sample Input
	
	2
	hello
	world
	hi
	world
	Sample Output
	
	YES
	NO
	Explanation
	
	For the 1st test case, the letter o is common between both strings, hence the answer YES. (Furthermore, the letter l is also common, but you only need to find one common substring.) 
	For the 2nd test case, hi and world do not have a common substring, hence the answer NO.
 *
 */
public class TwoStrings {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			boolean flag = true;
			String testA = in.next();
			String testB = in.next();
			for (int j = 0; j < testA.length(); j++) {
				if (testB.indexOf(testA.charAt(j)) > -1) {
					System.out.println("YES");
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("NO");
			}
		}

	}
}
