package hackerrank.ArtificalIntelligence;

import java.util.Scanner;

public class BotCleanLarge {
	/**
	 * bad solution
	 * @param posr
	 * @param posc
	 * @param dimh
	 * @param dimw
	 * @param board
	 */
	static void next_move(int posr, int posc, int dimh, int dimw, String[] board) {
		int shortpath = dimh + dimw - 1;
		int x = 0;
		int y = 0;
		for (int i = 0; i < dimh; i++) {
			for (int j = 0; j < dimw; j++) {
				char key = board[i].charAt(j);
				if (key == 'd') {
					if (Math.abs(posr - i) + Math.abs(posc - j) < shortpath) {
						x = i;
						y = j;
						shortpath = Math.abs(posr - i) + Math.abs(posc - j);
					}
				}
			}
		}
		if (!(posr == x)) {
			if (posr < x) {
				System.out.println("DOWN");
				posr++;
			} else if (posr == x) {

			} else {
				System.out.println("UP");
				posr--;
			}

		} else if (!(posc == y)) {
			if (posc < y) {
				System.out.println("RIGHT");
				posc++;
			} else if (posc == y) {

			} else {
				System.out.println("LEFT");
				posc--;
			}

		} else {
			System.out.println("CLEAN");
		}
		return;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] pos = new int[2];
		int[] dim = new int[2];
		for (int i = 0; i < 2; i++)
			pos[i] = in.nextInt();
		for (int i = 0; i < 2; i++)
			dim[i] = in.nextInt();
		String board[] = new String[dim[0]];
		for (int i = 0; i < dim[0]; i++)
			board[i] = in.next();
		next_move(pos[0], pos[1], dim[0], dim[1], board);
	}
}
