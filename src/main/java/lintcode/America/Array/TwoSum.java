package lintcode.America.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * twoSum
 * 
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数target。

	你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是1到n，不是以0开头。
	
	您在真实的面试中是否遇到过这个题？ Yes
	样例
	numbers=[2, 7, 11, 15],  target=9
	
	return [1, 2]
	
	注意
	你可以假设只有一组答案。
 * 
 *	http://www.lintcode.com/zh-cn/problem/2-sum/#
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				res[0] = map.get(numbers[i]);
				res[1] = i + 1;
			} else {
				map.put(target - numbers[i], i + 1);
			}
		}
		return res;
	}
}
