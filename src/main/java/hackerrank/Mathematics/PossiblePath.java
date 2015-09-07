package hackerrank.Mathematics;

import java.util.Scanner;

public class PossiblePath {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t;
		int a;
		int b;
		int x;
		int y;
		t = in.nextInt();
		for (int i = 0; i < t; i++) {
			a = in.nextInt();
			b = in.nextInt();
			x = in.nextInt();
			y = in.nextInt();
			if (gcd(a, b) == gcd(x, y)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	static int gcd(int a, int b) {
		int c;
		while (b != 0) {
			c = b;
			b = a % b;
			a = c;
		}
		return a;
	}

	/**
	 * 求最大公约数的过程
	 * @param a
	 * @param b
	 * @return
	 */
	static int getMax(int a, int b) {
		while (a != 0 && b != 0) {

			if (a < 0 && b < 0) {
				if (a < b) {
					a = a - b;
				} else {
					b = b - a;
				}
			} else if (a > 0 && b < 0) {
				a = a + b;
			} else if (a < 0 && b > 0) {
				b = a + b;
			} else {
				if (a > b) {
					a = a - b;
				} else {
					b = b - a;
				}
			}

		}
		return Math.max(a, b);
	}
}
