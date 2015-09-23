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
		while (size > 0) {
			size = swap(grid, size);
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				grid[i] = grid[i] - 1;
			}

		}

	}

	static int swap(int[] grid, int size) {
		int end = size;
		for (int i = 0, j = end - 1; i < j; i++, j--) {
			for (; i < j && grid[i] != 0; ++i)
				;
			for (; j > i && grid[j] == 0; --j)
				;
			if (i < j) {
				size = j;
				int temp = grid[i];
				grid[i] = grid[j];
				grid[j] = temp;
			}

		}
		if (size == 1 && grid[0] == 0) {
			size = 0;
		}
		return size;
	}
}
