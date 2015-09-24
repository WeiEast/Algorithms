package lintcode.America.Array;

import java.util.Arrays;

/**
 * 给出一个无序的正数数组，找出其中没有出现的最小正整数。

	您在真实的面试中是否遇到过这个题？ Yes
	样例
	如果给出 [1,2,0], return 3 如果给出 [3,4,-1,1], return 2
	
	挑战
	只允许时间复杂度O(n)的算法，并且只能使用常数级别的空间。
	http://www.lintcode.com/zh-cn/problem/first-missing-positive/
 *
 */
public class FirstMissingPositive {
	/**
	 * @param A
	 * @return
	 */
	public int firstMissingPositive(int[] A) {
		return uglySolution(A);
	}

	/**
	 * 时间复杂度nlogn+n 空间复杂度常熟级别 不符合题目 O(n)
	 * @param A
	 * @return
	 */
	private int uglySolution(int[] A) {
		Arrays.sort(A);
		int pre = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && pre >= 0 && A[i] - pre > 1) {
				break;
			}
			if (A[i] > 0) {
				pre = A[i];
			}
		}
		return pre + 1;
	}

	public static void main(String[] args) {
		FirstMissingPositive f = new FirstMissingPositive();
		int[] A = new int[] { -1 };
		System.out.println(f.firstMissingPositive(A));
	}
}
