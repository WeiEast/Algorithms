package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 *Problem Statement

	You are given a square matrix of size N×N. Calculate the absolute difference of the sums across the two main diagonals.
	
	Input Format
	
	The first line contains a single integer N. The next N lines contain N integers (each) describing the matrix.
	
	Constraints 
	1≤N≤100 
	−100≤A[i]≤100
	Output Format
	
	Output a single integer equal to the absolute difference in the sums across the diagonals.
	
	Sample Input
	
	3
	11 2 4
	4 5 6
	10 8 -12
	Sample Output
	
	15
	Explanation
	
	The first diagonal of the matrix is:
	
	11
	    5
	        -12
	Sum across the first diagonal = 11+5-12= 4
	
	The second diagonal of the matrix is:
	
	        4
	    5
	10
	Sum across the second diagonal = 4+5+10 = 19 
	Difference: |4-19| =15
	https://www.hackerrank.com/challenges/diagonal-difference
 *
 */
public class DiagonalDifference {
	private static int getAbsoluteDiff(int[][] grid) {
		int x = 0;
		for (int i = 0; i < grid.length; i++) {
			x += grid[i][i];
		}
		for (int i = grid.length - 1; i >= 0; i--) {
			x -= grid[i][grid.length - 1 - i];
		}
		return x < 0 ? -x : x;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int grid[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		System.out.println(getAbsoluteDiff(grid));

	}
}
