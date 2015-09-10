package hackerrank.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * N皇后加难型 ， 非递归算法
 *
 */
public class QueensUgly {
	int N;

	public static void main(String[] args) {
		QueensUgly q = new QueensUgly();
		q.solution(25);
	}

	long currentTimeMillis;

	private void solution(int n) {
		N = n;
		int[] grid = new int[n + 1];
		grid[1] = 1;
		int index = 1;

		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (int i = 1; i <= N; i++) {
			map.put(i, new HashSet<Integer>());
		}
		currentTimeMillis = System.currentTimeMillis();
		for (int i = 1; i <= N; i++) {
			grid[index] = i;
			if (map.containsKey(index) && map.get(index).contains(i)) {
				if (i == N) {
					clear(index, map);
					index--;
					i = 0;
				}
				continue;
			}

			if (canNext(index, grid)) {
				Set<Integer> set = map.get(index);
				set.add(i);
				map.put(index, set);
				index++;
				if (index > N) {
					break;
				}
				i = 0;
				continue;
			}
			if (i == N) {
				clear(index, map);
				index--;
				i = 0;

			}

		}

		System.out.println(System.currentTimeMillis() - currentTimeMillis);
		print(grid);
	}

	private void clear(int index, Map<Integer, Set<Integer>> map) {
		for (int i = index; i <= N; i++) {
			if (map.containsKey(index))
				map.get(index).clear();
		}
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

}
