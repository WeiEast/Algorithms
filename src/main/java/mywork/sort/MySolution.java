package mywork.sort;

import java.util.Arrays;

public class MySolution {

	private static void sortBuddle(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
				}
			}
		}
	}

	private static void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}

	private static void quickSort(int[] nums, int left, int right) {
		int i = left;
		int j = right;
		if (i > j)
			return;
		int flag = nums[left];
		while (i != j) {
			while (i < j && nums[j] >= flag) {
				j--;
			}
			while (i < j && nums[i] <= flag) {
				i++;
			}
			swap(nums, i, j);

		}
		swap(nums, left, i);
		quickSort(nums, left, i - 1);
		quickSort(nums, i + 1, right);
	}

	private static void mergeSort(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);

	}

	private static void mergeSort(int[] nums, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(nums, left, mid);
			mergeSort(nums, mid + 1, right);
			mergeSort(nums, left, mid, right);
		}

	}

	private static void mergeSort(int[] nums, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int pos = 0;
		while (i <= mid && j <= right) {
			if (nums[i] < nums[j]) {
				temp[pos++] = nums[i++];
			} else {
				temp[pos++] = nums[j++];
			}
		}
		while (i <= mid) {
			temp[pos++] = nums[i++];
		}
		while (j <= right) {
			temp[pos++] = nums[j++];
		}
		System.arraycopy(temp, 0, nums, left, temp.length);

	}

	private static void insertSort(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			int value = nums[i];
			int j;
			for (j = i - 1; j >= 0 && nums[j] > value; j--) {
				nums[j + 1] = nums[j];
			}
			nums[j + 1] = value;

		}

	}

	private static void chooseSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					swap(nums, i, j);
				}
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void print(int[] nums) {
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 1, 5, 67, 87, 4, 123, 1, 56 };
		int[] nums2 = nums.clone();
		int[] nums3 = nums.clone();
		int[] nums4 = nums.clone();
		int[] nums5 = nums.clone();
		sortBuddle(nums);
		quickSort(nums2);
		mergeSort(nums3);
		chooseSort(nums4);
		insertSort(nums5);
		print(nums);
		print(nums2);
		print(nums3);
		print(nums4);
		print(nums5);
	}

}
