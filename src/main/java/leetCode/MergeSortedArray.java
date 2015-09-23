package leetCode;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

	Note:
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		mergeSort(nums1, nums2, new int[m + n], m, n, 0, 0);
	}

	public void mergeSort(int[] nums1, int[] nums2, int[] nums3, int m, int n, int left, int right) {
		int leftpos = left;
		while (left != m && right != n) {
			if (nums1[left] < nums2[right]) {
				nums3[leftpos++] = nums1[left++];
			} else {
				nums3[leftpos++] = nums2[right++];
			}
		}
		while (left != m) {
			nums3[leftpos++] = nums1[left++];
		}
		while (right != n) {
			nums3[leftpos++] = nums2[right++];
		}
		for (int i = 0; i < m + n; i++) {
			nums1[i] = nums3[i];
		}
	}

	public static void main(String[] args) {
		MergeSortedArray merge = new MergeSortedArray();
		int[] nums1 = new int[6];
		nums1[0] = 1;
		int[] nums2 = new int[] { 2, 3, 8, 9, 16 };
		merge.merge(nums1, 1, nums2, 5);
		System.out.println(Arrays.toString(nums1));
	}
}
