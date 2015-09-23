package hackerrank.algorithms.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceLane {
	static int[] grid;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int T = in.nextInt();
		grid = new int[N];
		for (int i = 0; i < N; i++) {
			grid[i] = in.nextInt();
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < T; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int kmin = 3;
			for (int k = m; k <= n; k++) {
				kmin = Math.min(grid[k], kmin);
			}
			list.add(kmin);

		}
		for (Integer integer : list) {
			System.out.println(integer);
		}

	}
}
