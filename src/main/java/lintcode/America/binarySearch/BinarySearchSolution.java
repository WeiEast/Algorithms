package lintcode.America.binarySearch;

import java.util.Arrays;

import lombok.extern.log4j.Log4j;

/**
 * 二分查找
 *
 */
@Log4j
public class BinarySearchSolution {
	public int searchInsert(int[] A, int target) {
		int i = 0;
		int j = A.length;
		int mid = (j - i) / 2 + i;

		while (i < j && i < mid) {
			if (A[mid] > target) {
				j = mid;
			} else if (A[mid] == target) {
				break;
			} else {
				i = mid;
			}
			mid = (j - i) / 2 + i;
		}
		return i >= mid && mid != 0 ? i + 1 : mid;
	}

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

	public int woodCut(int[] L, int k) {
		int max = 0;
		for (int i = 0; i < L.length; i++) {
			max = Math.max(max, L[i]);
		}

		// find the largest length that can cut more than k pieces of wood.
		int start = 1, end = max;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (count(L, mid) >= k) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (count(L, end) >= k) {
			return end;
		}
		if (count(L, start) >= k) {
			return start;
		}
		return 0;
	}

	private int count(int[] L, int length) {
		int sum = 0;
		for (int i = 0; i < L.length; i++) {
			sum += L[i] / length;
		}
		return sum;
	}

	public int findFirstBadVersion(int n) {

		int i = 1;
		int j = n;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (VersionControl.isBadVersion(mid)) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}

		}
		return i;

	}

	static class VersionControl {
		public static boolean isBadVersion(int k) {
			if (k >= 4)
				return true;
			return false;
		};
	}

	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	
		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		
		You are given a target value to search. If found in the array return its index, otherwise return -1.
		
		You may assume no duplicate exists in the array.
		
		Have you met this question in a real interview? Yes
		Example
		For [4, 5, 1, 2, 3] and target=1, return 2.
		
		For [4, 5, 1, 2, 3] and target=0, return -1.
		
		Challenge
		O(logN) time
	 * @param A
	 * @param target
	 * @return
	 */
	public int search(int[] A, int target) {
		int i = 0;
		int j = A.length - 1;

		while (i <= j) {

			int mid = (i + j) / 2;
			// 如果左边是正序
			if (A[mid] > A[i]) {
				if (target < A[i] && target < A[mid]) {
					i = mid + 1;
				} else if (A[mid] == target) {
					return mid;
				} else if (target > A[mid]) {
					i = mid + 1;
				} else {
					j = mid - 1;
				}
			} else {
				if (A[mid] < target && target > A[j]) {
					j = mid - 1;
				} else if (A[mid] == target) {
					return mid;
				} else if (target < A[mid]) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}
			}

		}
		return -1;
	}

	public int[] searchRange(int[] A, int target) {

		int[] res = new int[2];

		int i = 0;
		int j = A.length - 1;

		while (i <= j) {
			int mid = (i + j) / 2;

			if (target < A[mid]) {
				j = mid - 1;
			} else if (target > A[mid]) {
				i = mid + 1;
			} else {
				break;
			}

		}
		if (i > j) {
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		int m = (i + j) / 2 - 1;
		int q = m + 2;

		while (m >= 0 && A[m] == target) {
			m--;
		}

		while (q < A.length && A[q] == target) {
			q++;
		}

		res[0] = m + 1;
		res[1] = q - 1;

		return res;
	}

	public static void main(String[] args) {
		BinarySearchSolution b = new BinarySearchSolution();
		// log.info(b.findFirstBadVersion(5));
		// log.info(b.search(new int[] { 0, 1, 2, -10, -9, -8, -7, -6, -5, -4,
		// -3, -2, -1 }, -9));
		log.info(Arrays.toString(b.searchRange(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 5)));
	}

}
