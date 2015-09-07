package hackerrank.algorithms;

import java.util.HashMap;
import java.util.Map;

public class QueensRevised {

	int N;
	// 代表第m行第n列的值 , key为行 , value为列
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		QueensRevised q = new QueensRevised();
		q.solution(11);
	}

	private void solution(int n) {
		N = n;
		for (int i = 1; i <= n; i++) {
			map.put(1, i);
			queen(2, 1);
			if (map.size() == N) {
				break;
			} else {
				map.clear();
			}
		}

		System.out.println(map);
	}

	private boolean canNext(int m, int n) {
		map.remove(m);
		if (map.containsValue(n)) {
			map.put(m, n);
			return false;
		}
		map.put(m, n);
		int x = n - map.get(m - 1);
		int y = 1;
		// 斜率
		if (Math.abs(x) == Math.abs(y))
			return false;

		for (int i = 1; i < m; i++) {
			// 横轴
			x = n - map.get(m - i);
			y = i;
			for (int j = i + 1; j < m && j > i; j++) {
				int p = n - map.get(m - j);
				int q = j;
				if (x * q == p * y) {
					return false;
				}
			}

		}
		return true;

	}

	private void queen(int index, int pos) {
		if (index == N) {
			return;
		}
		if (pos == N) {
			return;
		}
		map.put(index, pos);
		if (canNext(index, pos)) {
			queen(++index, 1);
		} else {
			map.remove(index);
			queen(index, pos + 1);
		}
		System.out.println(map);

	}
}
