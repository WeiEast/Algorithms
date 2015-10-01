package lintcode.America.Array;

/**
 * 中等 数组划分

	25% 通过
	给出一个整数数组nums和一个整数k。划分数组（即移动数组nums中的元素），使得：
	
	所有小于k的元素移到左边
	所有大于等于k的元素移到右边
	返回数组划分的位置，即数组中第一个位置i，满足nums[i]大于等于k。
	
	您在真实的面试中是否遇到过这个题？ Yes
	样例
	给出数组nums=[3,2,2,1]和 k=2，返回 1
	
	注意
	你应该真正的划分数组nums，而不仅仅只是计算比k小的整数数，如果数组nums中的所有元素都比k小，则返回nums.length。
	
	挑战
	要求在原地使用O(n)的时间复杂度来划分数组
	
	http://www.lintcode.com/zh-cn/problem/partition-array/
 *
 */
public class PartitionArray {
	public int partitionArray(int[] nums, int k) {
		return mySolution(nums, k);
	}

	private int mySolution(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		for (int i = 0, j = nums.length - 1; i < j; i++, --j) {
			for (; i < j && nums[i] < k; i++)
				;
			for (; i < j && nums[j] >= k; j--)
				;
			if (i < j)
				swap(nums, i, j);
		}
		for (int m = 0; m < nums.length; m++) {
			if (k <= nums[m])
				return m;
		}
		return nums.length;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	public static void main(String[] args) {
		PartitionArray p = new PartitionArray();
		System.out.println(p.partitionArray(new int[] { 1, 2, 3, 3, 2, 3 }, 2));
	}
}
