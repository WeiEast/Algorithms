package hackerrank.Mathematics;

import java.util.Scanner;

public class EvenOddQuery {

	static int[] A;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t;
		t = in.nextInt();
		int a;
		int cout;
		int x;
		int y;
		A = new int[t];
		for (int j = 0; j < A.length; j++) {
			a = in.nextInt();
			A[j] = a;
		}
		cout = in.nextInt();
		for (int z = 0; z < cout; z++) {
			x = in.nextInt();
			y = in.nextInt();
			if (A[x - 1] % 2 != 0) {
				System.out.println("Odd");
			} else {
				if (x == y)
					System.out.println("Even");
				else {
					if (A[x] == 0)
						System.out.println("Odd");
					else
						System.out.println("Even");

				}
			}
		}
	}

	static double find(int x, int y) {
		double ans;
		if (x > y)
			return 1;
		ans = Math.pow(A[x - 1], find(x + 1, y));
		return ans;
	}
}
