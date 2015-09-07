package hackerrank.ArtificalIntelligence;

import java.util.Scanner;

public class Botsavesprincess {
	static void displayPathtoPrincess(int n, String[] grid) {
		int x = (n - 1) / 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				char c = grid[i].charAt(j);
				if (i != x && j != x) {
					if (c != '-' && c != 'm') {
						while (i != x && j != x) {
							if (i > x) {
								System.out.println("DOWN");
								i--;
							} else if (i == x) {

							} else {
								i++;
								System.out.println("UP");
							}
							if (j > x) {
								j--;
								System.out.println("RIGHT");
							} else if (j == x) {

							} else {
								System.out.println("LEFT");
								j++;
							}
						}
						return;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m;
		m = in.nextInt();
		String grid[] = new String[m];
		for (int i = 0; i < m; i++) {
			grid[i] = in.next();
		}

		displayPathtoPrincess(m, grid);
	}
}
