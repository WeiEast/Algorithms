package leetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


翻译 : 写出一段程序 , 判断给出的数字是否为ugly number 

ugly number定义为 , 因式分解中只能包含2,3,5的正数 , 当然1 是一个特别的ugly number , 例如6 , 8 就是ugly number 而14不是 因为14因数分解为7*2 7不包含在2,3,5中
 *
 */
public class UglyNumber {
	/**
	 * @param num
	 * @return whether ugly number
	 */
	public boolean isUgly(int num) {
		return bestSolution(num);
	}

	/**
	 * @param num
	 * @return
	 */
	private boolean bestSolution(int num) {
		if (num <= 0)
			return false;
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		return num == 1;
	}

	/**
	 * @param num
	 * @return
	 */
	private boolean badSolution(int num) {
		if (num <= 0)
			return false;
		if (num == 1)
			return true;
		Set<Integer> factor = getFactor(num);
		Iterator<Integer> iterator = factor.iterator();
		System.out.println(factor);
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			if (next != 2 && next != 3 && next != 5) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 因数分解
	 * @param num
	 * @return
	 */
	private Set<Integer> getFactor(int num) {
		Set<Integer> result = new HashSet<Integer>();
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				result.add(i);
				num /= i;
			}
		}
		result.add(num);
		return result;
	}

}
