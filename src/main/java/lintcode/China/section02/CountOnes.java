package lintcode.China.section02;

/**
 * 计算在一个 32 位的整数的二进制表式中有多少个 1.

	您在真实的面试中是否遇到过这个题？ Yes
	样例
	给定 32 (100000)，返回 1
	
	给定 5 (101)，返回 2
	
	给定 1023 (111111111)，返回 9
 *
 */
public class CountOnes {
	public int countOnes(int num) {
		int result = 0;
		while (num != 0) {
			num &= (num - 1);
			result++;
		}
		return result;
	}

	public static void main(String[] args) {
		CountOnes c = new CountOnes();
		System.out.println(c.countOnes(1023));
	}
}
