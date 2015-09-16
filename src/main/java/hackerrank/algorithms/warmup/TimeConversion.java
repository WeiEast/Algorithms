package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * 
 * Problem Statement

	You are given time in AM/PM format. Convert this into a 24 hour format.
	
	Note Midnight is 12:00:00AM or 00:00:00 and 12 Noon is 12:00:00PM.
	
	Input Format
	
	Input consists of time in the AM/PM format i.e. hh:mm:ssAM or hh:mm:ssPM 
	where 
	01≤hh≤12 
	00≤mm≤59 
	00≤ss≤59
	
	Output Format
	
	You need to print the time in 24 hour format i.e. hh:mm:ss 
	where 
	00≤hh≤23 
	00≤mm≤59 
	00≤ss≤59
	
	Sample Input
	
	07:05:45PM
	Sample Output
	
	19:05:45
 *
 */
public class TimeConversion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		if (s.equals("12:00:00AM") || s.equals("12:00:00PM")) {
			System.out.println("00:00:00");
			return;
		}
		if (s.charAt(8) == 'A') {
			if (Integer.valueOf(s.substring(0, 2)) == 12) {
				System.out.println("00" + s.substring(2, s.length() - 2));
				return;
			}
			System.out.println(s.substring(0, s.length() - 2));
		} else {
			if (Integer.valueOf(s.substring(0, 2)) == 12) {
				System.out.println(s.substring(0, s.length() - 2));
				return;
			}
			System.out.println((Integer.valueOf(s.substring(0, 2)) + 12) + s.substring(2, s.length() - 2));
		}
	}
}
