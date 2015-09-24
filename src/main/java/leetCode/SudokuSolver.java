package leetCode;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import lombok.extern.java.Log;
import utils.TreeNode;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


 *
 */
@Log
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		int N = board.length;
		dfs(board, N, 0);
		System.out.println(1);

	}

	private void dfs(char[][] board, int N, int h) {
		if (h > N) {
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (board[h][i - 1] != '.') {
				continue;
			}
			board[h][i - 1] = String.valueOf(i).charAt(0);
			if (validSudoku(board)) {
				dfs(board, N, h + 1);
			}
		}

	}

	private boolean validSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				char c = board[i][j];
				if (c != '.') {
					for (int m = 0; m < board.length; m++) {
						char d = board[m][j];
						char f = board[i][m];
						if ((c == d && m != i) || (c == f && m != j)) {
							return false;
						}

					}

				}

			}

		}

		int sqrt = (int) Math.sqrt(board.length);
		for (int m = 0; m < board.length; m += sqrt) {
			for (int r = 0; r < board.length; r += sqrt) {
				for (int i = m; i < m + sqrt; i++) {
					for (int j = r; j < r + sqrt; j++) {
						char c = board[i][j];
						if (c != '.') {
							for (int q = m; q < m + sqrt; q++) {
								for (int p = r; p < r + sqrt; p++) {
									char d = board[q][p];
									if (c == d && q != i) {
										return false;
									}

								}

							}
						}

					}
				}
			}

		}
		return true;

	}

	public static void main(String[] args) {
		SudokuSolver s = new SudokuSolver();
		String[] strs = new String[] { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
				"...8.3.2.", "........6", "...2759.." };
		char[][] board = new char[9][9];
		for (int i = 0; i < strs.length; i++) {
			board[i] = strs[i].toCharArray();
		}
		s.solveSudoku(board);
	}
}
