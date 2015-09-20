package leetCode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	
	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	
	Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
	Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
	
	https://leetcode.com/problems/move-zeroes/
	
 *
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		mySolution(nums);
	}

	private void mySolution(int[] nums) {
		if (nums == null)
			return;
		for (int i = 0; i < nums.length; i++) {
			// 当前值
			int current = nums[i];
			if (current == 0) {
				for (int j = i + 1; j < nums.length; j++) {
					if (current != nums[j]) {
						nums[i] = nums[j];
						nums[j] = current;
						break;
					}
					if (j == nums.length - 1)
						i = nums.length;
				}
			}
		}

	}

}
