package lintcode.binarySearch;

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
public class WoodCut {

	public int woodCut(int[] L, int k) {
		int sum = 0;
		for (int i = 0; i < L.length; i++) {
			sum += L[i];
		}

		int target = sum / k;

		while (true) {
			int g = 0;
			for (int i = 0; i < L.length; i++) {
				g += L[i] / target;
			}
			if (g >= k)
				return target;
			else {
				target--;
				if (target < k)
					return 0;
			}

		}

	}

	public static void main(String[] args) {
		WoodCut w = new WoodCut();

	}
}
