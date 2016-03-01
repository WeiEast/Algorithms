package leetCode.Medium.Array;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


N^2时间复杂度
 *
 */
public class J062UniquePaths {
	public int uniquePaths(int m, int n) {
		return solution(m, n);
	}

	private int solution(int m, int n) {
		int[][] grid = new int[m + 1][n + 1];
		//初始化数据
		for (int i = 1; i <= m; i++) {
			grid[i][1] = 1;
		}
		for (int i = 1; i <= n; i++) {
			grid[1][i] = 1;
		}
		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
			}
		}

		return grid[m][n];
	}

	public static void main(String[] args) {
		J062UniquePaths j062UniquePaths = new J062UniquePaths();
		System.out.println(j062UniquePaths.uniquePaths(1, 1));
	}
}
