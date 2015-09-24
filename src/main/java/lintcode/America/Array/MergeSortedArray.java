package lintcode.America.Array;

/**
 * 合并两个排序的整数数组A和B变成一个新的数组。

您在真实的面试中是否遇到过这个题？ Yes
样例
给出A = [1, 2, 3, empty, empty] B = [4,5]

合并之后A将变成[1,2,3,4,5]

注意
你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
 *
 */
public class MergeSortedArray {
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		mySolution(A, m, B, n);
	}

	private void mySolution(int[] a, int m, int[] b, int n) {
		while (m > 0 && n > 0) {
			if (b[n - 1] > a[m - 1]) {
				a[m + n - 1] = b[n - 1];
				n--;
			} else {
				a[m + n - 1] = a[m - 1];
				m--;
			}

		}
		while (n > 0) {
			a[n - 1] = b[n - 1];
			n--;
		}

	}

	public static void main(String[] args) {
		MergeSortedArray mergeSortedArray = new MergeSortedArray();
		int[] A = new int[5];
		A[0] = 1;
		A[1] = 6;
		A[2] = 8;
		mergeSortedArray.mergeSortedArray(A, 3, new int[] { 4, 5 }, 2);
		System.out.println(1);
	}
}
