package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Problem Statement

	Your teacher has given you the task to draw the structure of a staircase. Being an expert programmer, you decided to make a program for the same. You are given the height of the staircase. You need to print a staircase as shown in the example.
	
	Input Format
	
	You are given an integer N depicting the height of the staircase.
	
	Constraints 
	1≤N≤100
	Output Format
	
	Draw a staircase of height N in the format given below.
	
	For example:
	
	     #
	    ##
	   ###
	  ####
	 #####
	######
	Staircase of height 6, note that last line has 0 spaces before it.
	
	Sample Input
	
	6
	Sample Output
	
	     #
	    ##
	   ###
	  ####
	 #####
	######
 *
 */
public class Staircase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = t - i - 1; j < t; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
