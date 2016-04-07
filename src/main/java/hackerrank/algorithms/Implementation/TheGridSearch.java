package hackerrank.algorithms.Implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-grid-search
 *
 */
public class TheGridSearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int R = in.nextInt();
			int C = in.nextInt();
			String G[] = new String[R];
			for (int G_i = 0; G_i < R; G_i++) {
				G[G_i] = in.next();
			}
			int r = in.nextInt();
			int c = in.nextInt();
			String P[] = new String[r];
			for (int P_i = 0; P_i < r; P_i++) {
				P[P_i] = in.next();
			}
			System.out.println(valid(G, P));
		}
	}

	private static String valid(String[] g, String[] p) {
		int count = 0;
		int indexOf = -1;
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < p.length && i < g.length; j++) {
				if (indexOf >= 0) {
					String substring = g[i].substring(indexOf, p[j].length());
					if (substring.equals(p[j])) {
						i++;
						count++;
					} else {
						count = 0;
						indexOf = -1;
						j = -1;
					}
				} else {
					int index = g[i].indexOf(p[j]);
					i++;
					if (index >= 0) {
						count++;
						indexOf = index;
					} else {
						j = -1;
						count = 0;
						indexOf = -1;
					}
				}

			}
			if (count == p.length) {
				break;
			}

		}
		if (count == p.length) {
			return "YES";
		}
		return "NO";

	}
}
