package lintcode.America.binarySearch;

import lombok.extern.log4j.Log4j;

/**
 *写出一个高效的算法来搜索 m × n矩阵中的值。

这个矩阵具有以下特性：

每行中的整数从左到右是排序的。
每行的第一个数大于上一行的最后一个整数。
您在真实的面试中是否遇到过这个题？ Yes
样例
考虑下列矩阵：

[
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
给出 target = 3，返回 true

挑战
O(log(n) + log(m)) 时间复杂度
 */
@Log4j
public class SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;
		int i = 0;
		while (i < matrix.length && matrix[i][matrix[i].length - 1] < target)
			i++;
		if (i >= matrix.length)
			return false;
		int left = 0;
		int right = matrix[i].length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (matrix[i][mid] > target)
				right = mid - 1;
			else if (matrix[i][mid] == target)
				return true;
			else
				left = mid + 1;
		}
		return false;

	}

	public static void main(String[] args) {
		SearchMatrix s = new SearchMatrix();
		int[][] a = new int[3][4];
		a[0] = new int[] { 1, 3, 5, 7 };
		a[1] = new int[] { 10, 11, 16, 20 };
		a[2] = new int[] { 23, 30, 34, 50 };
		log.info(s.searchMatrix(a, 7));
	}

}
