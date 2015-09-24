package lintcode.America.Array;

/**
 * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。

	不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
	
	您在真实的面试中是否遇到过这个题？ Yes
	样例
	给出数组A =[1,1,2]，你的函数应该返回长度2，此时A=[1,2]。
	
	http://www.lintcode.com/zh-cn/problem/remove-duplicates-from-sorted-array/
	
 *
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		return bestSolution(nums);
	}

	private int bestSolution(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int count = 1;
		for (int i = 1; i < len; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}

	private int mySolution(int[] nums) {
		if (nums == null)
			return 0;
		int result = nums.length;
		for (int i = 1; i < result; i++) {
			int j = i;
			for (; j < result && nums[i - 1] == nums[j]; j++) {

			}
			;
			result -= j - i;
			System.arraycopy(nums, j, nums, i, nums.length - j);
		}
		return result;

	}

	public static void main(String[] args) {
		RemoveDuplicates r = new RemoveDuplicates();
		System.out.println(r.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5 }));
	}

}
