package hackerrank.ArtificalIntelligence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
	Problem Statement
	
	N Puzzle is a sliding blocks game that takes place on a k * k grid with ((k * k) - 1) tiles each numbered from 1 to N. Your task is to reposition the tiles to their proper order.
	
	Input Format
	
	The first line of the input contains an integer k, the size of the square grid. k * k lines follow each line containing an integer I on the tile starting from the top left to bottom right. The empty cell is represented by the number 0.
	
	N = (k * k) -1 
	0 <= I <= N
	
	Constraints
	
	3 <= k <= 5
	
	Output Format
	
	The first line contains an integer, M, the number of moves your algorithm has taken to solve the N-Puzzle. M lines follow. Each line indicating the movement of the empty cell (0).
	
	A grid is considered solved if it is of the following configuration. *
 */
public class NPuzzle {

	int[][] grid;

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		NPuzzle n = new NPuzzle();
		int count = 3;
		String s = "0 3 8";
		String q = "4 1 7";
		String p = "2 6 5";
		List<String> lists = new ArrayList<String>();
		lists.add(s);
		lists.add(p);
		lists.add(q);
		n.solution(count, lists);
	}

	private void solution(int n, List<String> list) {
		grid = new int[n][n];
		for (int i = 0; i < list.size(); i++) {
			String[] split = list.get(i).split(" ");
			for (int j = 0; j < split.length; j++) {
				grid[i][j] = Integer.valueOf(split[j]);
			}
		}
		System.out.println(Arrays.deepToString(grid));
	}

	private void mysolution() {
		// grid[n];
	}
}
