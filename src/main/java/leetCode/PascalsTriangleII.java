package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

翻译: 给定一个k值  , 求杨辉三角第k行结果

你可以用o(k)的额外空间来解决这个问题吗?

 *
 */
public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		return recursionSolution(rowIndex);
	}

	/**
	 * cannot pass oj
	 * @param rowIndex
	 * @return
	 */
	private List<Integer> recursionSolution(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			result.add(recursion(rowIndex + 1, i + 1));
		}
		return result;
	}

	private int recursion(int row, int col) {
		if (col == 1 || col == row) {
			return 1;
		}
		return recursion(row - 1, col - 1) + recursion(row - 1, col);
	}

	/**
	 * 解决方案 : 构造完整杨辉三角 , 然后找到某一行输出数据  不满足题目使用o(k)的额外空间
	 * @param rowIndex
	 * @return
	 */
	@SuppressWarnings(value = "all")
	private List<Integer> mySolution(int rowIndex) {

		if (rowIndex < 0) {
			return new ArrayList<Integer>();
		}
		List<List<Integer>> pascalsTriangle = getPascalsTriangle(rowIndex + 1);
		return pascalsTriangle.get(rowIndex);

	}

	private List<List<Integer>> getPascalsTriangle(int rowIndex) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		// 头行
		list.add(1);
		result.add(list);
		List<Integer> next = null;
		for (int i = 2; i <= rowIndex; i++) {
			// 从第二行开始遍历
			next = new ArrayList<Integer>();
			next.add(1);
			for (int j = 0; j < list.size() - 1; j++) {
				// 第二行 由上一行的j+j+1的总和
				next.add(list.get(j) + list.get(j + 1));
			}
			next.add(1);
			result.add(next);
			list = next;
		}
		return result;

	}
}
