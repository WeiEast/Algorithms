package lintcode.America.binarySearch;

import java.util.Arrays;

import lombok.extern.log4j.Log4j;

/**
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。

您在真实的面试中是否遇到过这个题？ Yes
样例
有3根木头[232, 124, 456], k=7, 最大长度为114.

注意
木头长度的单位是厘米。原木的长度都是正整数，我们要求切割得到的小段木头的长度也要求是整数。无法切出要求至少 k 段的,则返回 0 即可。

挑战
O(n log Len), Len为 n 段原木中最大的长度
 *
 */
@Log4j
public class WoodCut {

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

	public static void main(String[] args) {
		WoodCut w = new WoodCut();
		log.info(w.woodCut(new int[] { 232, 124, 456 }, 7));

	}
}
