package lintcode.America.Array;

import java.util.Arrays;

/**
 * 给一个包含n个整数的数组S, 找到和与给定整数target最接近的三元组，返回这三个数的和。

	您在真实的面试中是否遇到过这个题？ Yes
	样例
	例如S = [-1, 2, 1, -4] and target = 1.  和最接近1的三元组是 -1 + 2 + 1 = 2.
	
	注意
	只需要返回三元组之和，无需返回三元组本身
	
	http://www.lintcode.com/zh-cn/problem/3-sum-closest/
	
	
	思路先对原数组进行排序 , 然后使用双指针的方法, 排序后的数组为:-4 -1 1 2  先选定第一个数字-4  然后i指针指向-1 j指针指向2 -4-1=5 指针i+j = 1 距离5 为4下一步i向后1 1+2 = 3 距离为2 再选定-1
	
 *
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] numbers, int target) {
		return mySolution(numbers, target);
	}

	private int mySolution(int[] numbers, int target) {
		if (numbers == null || numbers.length < 3)
			return 0;
		Arrays.sort(numbers);
		int result = 0;
		int res = 0;
		result = Math.abs(target - (numbers[0] + numbers[1] + numbers[numbers.length - 1]));
		res = numbers[0] + numbers[1] + numbers[numbers.length - 1];
		for (int k = 0; k <= numbers.length - 3; k++) {
			int top = numbers[k];
			int i = k + 1;
			int j = numbers.length - 1;
			while (i < j) {
				if (Math.abs(target - (top + numbers[i] + numbers[j])) < result) {
					result = Math.abs(target - (top + numbers[i] + numbers[j]));
					res = top + numbers[i] + numbers[j];
				}
				if (top + numbers[i] + numbers[j] > target) {
					j--;
				} else {
					i++;
				}
			}

		}
		return res;

	}

	public static void main(String[] args) {
		ThreeSumClosest t = new ThreeSumClosest();
		System.out.println(t.threeSumClosest(new int[] { 2, 7, 11, 15 }, 3));
	}
}
