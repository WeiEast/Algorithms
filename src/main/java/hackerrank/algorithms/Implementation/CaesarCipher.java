package hackerrank.algorithms.Implementation;

import java.util.Scanner;

/**
 * Problem Statement

	Julius Caesar protected his confidential information from his enemies by encrypting it. Caesar rotated every letter in the string by a fixed number K. This made the string unreadable by the enemy. You are given a string S and the number K. Encrypt the string and print the encrypted string.
	
	For example: 
	If the string is middle-Outz and K=2, the encoded string is okffng-Qwvb. Note that only the letters are encrypted while symbols like - are untouched. 
	'm' becomes 'o' when letters are rotated twice, 
	'i' becomes 'k', 
	'-' remains the same because only letters are encoded, 
	'z' becomes 'b' when rotated twice.
	
	Input Format
	
	Input consists of an integer N equal to the length of the string, followed by the string S and an integer K.
	
	Constraints 
	1≤N≤100 
	0≤K≤100 
	S is a valid ASCII string and doesn't contain any spaces.
	
	Output Format
	
	For each test case, print the encoded string.
	
	Sample Input
	
	11
	middle-Outz
	2
	Sample Output
	
	okffng-Qwvb
	Explanation
	
	As explained in statement.
	
	https://www.hackerrank.com/challenges/caesar-cipher-1
 *
 */
public class CaesarCipher {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		StringBuffer str = new StringBuffer();
		str.append(in.next());
		int K = in.nextInt();
		System.out.println(Solve(N, str.toString(), K));
	}

	private static String Solve(int N, String s, int K) {
		if (K >= 26) {
			K %= 26;
		}
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < N; i++) {
			char c = s.charAt(i);
			if (K - ('z' - c) > 0 && c >= 'a' && c <= 'z') {
				int t = K - ('z' - c);
				char d = 'a';
				for (int j = 0; j < t - 1; j++) {
					d++;
				}
				res.append(d);

			} else if (K - ('Z' - c) > 0 && c >= 'A' && c <= 'Z') {
				int t = K - ('Z' - c);
				char d = 'A';
				for (int j = 0; j < t - 1; j++) {
					d++;
				}
				res.append(d);
			} else {
				if ((c >= 'A' && c <= 'Z') || (c <= 'z' && c >= 'a')) {
					for (int j = 0; j < K; j++) {
						c++;
					}
				}
				res.append(c);
			}

		}
		return res.toString();

	}

}
