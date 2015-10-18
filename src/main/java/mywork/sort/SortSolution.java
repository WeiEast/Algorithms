package mywork.sort;

import java.util.Arrays;

public class SortSolution {
	/**
	 * 选择排序
	 * @param nums
	 */
	public static void sortChoose(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (nums[i] > nums[j]) {
					swap(nums, i, j);
				}
			}
		}
	}

	/**
	 * 冒泡排序
	 * @param nums
	 */
	public static void sortBuddle(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
				}
			}
		}
	}

	/**
	 * 插入排序
	 * 写一个函数 , 一个已经从小到大排序的数组中 , 插入一个元素 , 插入之后 , 该数组还是排序的
	 * @param nums
	 */
	public static void insertSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int j;
			int key = nums[i];
			for (j = i - 1; j >= 0 && key < nums[j]; j--) {
				nums[j + 1] = nums[j];
			}
			nums[j + 1] = key;
		}
	}

	// 数组a 已经从小到大排序了
	public static int[] insertValue(int[] a, int value) {
		a = Arrays.copyOf(a, a.length + 1);
		int i;
		for (i = a.length - 2; i >= 0; i--) {
			if (a[i] < value) {
				break;
			} else {
				a[i + 1] = a[i];
			}

		}
		a[i + 1] = value;
		return a;
	}

	/**
	 * 实现快速排序
	 * @param a
	 * @return
	 */
	public static int[] quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
		return a;
	}

	private static void quickSort(int[] a, int left, int right) {
		int i = left;
		int j = right;
		if (left > right)
			return;
		int ele = a[left];
		while (i != j) {
			while (i < j && a[j] >= ele) {
				j--;
			}
			while (i < j && a[i] <= ele) {
				i++;
			}
			swap(a, i, j);
		}
		swap(a, left, i);
		quickSort(a, left, i - 1);
		quickSort(a, i + 1, right);
	}

	/**
	 * 归并排序
	 * @param a
	 * @param left
	 * @param right
	 */
	public static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			merge(a, left, mid, right);
		}

	}

	private static void merge(int[] a, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= right) {
			temp[k++] = a[j++];
		}
		System.arraycopy(temp, 0, a, left, temp.length);
	}

	public static void swap(int[] nums, int i, int j) {
		System.out.println("i" + i + "j" + j);
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args) {
		int[] a = { 10, 14, 2, 9, 8, 32 };
		mergeSort(a, 0, a.length - 1);
		// int[] insertValue = insertValue(a, 4);
		System.out.println(Arrays.toString(a));
	}
}
