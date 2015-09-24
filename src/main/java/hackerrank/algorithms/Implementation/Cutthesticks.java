package hackerrank.algorithms.Implementation;

import java.util.Scanner;

public class Cutthesticks {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] grid = new int[N];
		for (int i = 0; i < N; i++) {
			grid[i] = in.nextInt();
		}

		int size = grid.length;
		System.out.println(size);
		while (size > 0) {
			int countZero = countZero(grid);
			if (countZero > 0) {
				if (size != countZero) {
					size = countZero;
					System.out.println(size);
				}
				for (int i = 0; i < grid.length; i++) {
					grid[i] = grid[i] - 1;
				}

			} else {
				break;
			}

		}

	}

	static int countZero(int[] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {

			if (grid[i] > 0) {
				count++;
			}
		}
		return count;
	}

}
