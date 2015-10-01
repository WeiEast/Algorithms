package lintcode.America.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 中等 三数之和

	19% 通过
	给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
	
	您在真实的面试中是否遇到过这个题？ Yes
	样例
	如S = {-1 0 1 2 -1 -4}, 你需要返回的三元组集合的是：
	
	(-1, 0, 1)
	
	(-1, -1, 2)
	
	注意
	在三元组(a, b, c)，要求a <= b <= c。
	
	结果不能包含重复的三元组。
	
	http://www.lintcode.com/zh-cn/problem/3-sum/
 *
 */
public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		return mySolution(numbers);
	}

	private ArrayList<ArrayList<Integer>> mySolution(int[] numbers) {
		if (numbers == null || numbers.length < 3)
			return null;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(numbers);

		for (int k = 0; k <= numbers.length - 3; k++) {
			int top = numbers[k];
			int i = k + 1;
			int j = numbers.length - 1;
			while (i < j) {
				if (top + numbers[i] + numbers[j] > 0) {
					j--;
				} else if (top + numbers[i] + numbers[j] < 0) {
					i++;
				} else {
					ArrayList<Integer> mid = new ArrayList<Integer>();
					mid.add(top);
					mid.add(numbers[i]);
					mid.add(numbers[j]);
					if (!list.contains(mid))
						list.add(mid);
					i++;
					j--;
				}
			}

		}
		return list;
	}

	public static void main(String[] args) {
		ThreeSum t = new ThreeSum();
		System.out.println(t.threeSum(new int[] { -2, -3, 5, -1, -4, 5, -11, 7, 1, 2, 3, 4, -7, -1, -2, -3, -4, -5 }));
	}
}
