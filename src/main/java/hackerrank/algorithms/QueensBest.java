package hackerrank.algorithms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * N皇后 ， 筛选法
 *
 */
public class QueensBest {
	int N;

	public static void main(String[] args) {
		QueensBest q = new QueensBest();
		q.trysolution(11);
	}

	long currentTimeMillis;
	List<String> list;

	private void trysolution(int n) {
		N = n;
		N = 1;
		int[] grid = new int[n + 1];
		currentTimeMillis = System.currentTimeMillis();
		for (int i = 11; i <= 19; i++) {

			list = new ArrayList<String>();
			queen(1, grid);
			write(list);

		}

	}

	private void write(List<String> list) {
		try {
			FileUtils.writeLines(new File("C:/upload/" + N + ".txt"), list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String array(int[] grid) {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i < grid.length; i++) {
			str.append(grid[i] + " ");
		}
		return str.toString();
	}

	private void print(int[] grid) {
		for (int i = 1; i < grid.length; i++) {
			System.out.print(grid[i] + " ");
		}
		System.out.println();
	}

	private boolean canNext(int index, int[] grid) {
		for (int i = 1; i < index; i++) {
			if (grid[i] == grid[index])
				return false;
			if (grid[index] - grid[i] == index - i || grid[i] - grid[index] == index - i) {
				return false;
			}

		}
		for (int i = 1; i < index; i++) {
			int x = grid[index] - grid[i];
			int y = index - i;
			for (int j = i + 1; j < index; j++) {
				int m = grid[index] - grid[j];
				int q = index - j;
				if (m * y == x * q) {
					return false;
				}
			}

		}
		return true;
	}

	private void queen(int index, int[] grid) {
		if (index > N) {
			list.add(array(grid));
			return;
		}
		for (int i = 1; i <= N; i++) {
			grid[index] = i;
			if (canNext(index, grid)) {
				queen(index + 1, grid);
			}
		}
	}

}
