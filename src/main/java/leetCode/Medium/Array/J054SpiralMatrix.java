package leetCode.Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p/>
 * For example,
 * Given the following matrix:
 * <p/>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class J054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        return solution(matrix);
    }

    private List<Integer> solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        int hex = matrix.length - 1;
        int vir = matrix[0].length - 1;
        int left = 0;
        while (hex - left >= 0 && vir - left >= 0) {
            printArr(left, left, hex, vir, matrix, result);
            hex--;
            left++;
            vir--;
        }
        return result;

    }


    /**
     * 转圈加
     *
     * @param i
     * @param j
     * @param p
     * @param q
     * @param matrix
     * @param list
     */
    private static void printArr(int i, int j, int p, int q, int[][] matrix, List<Integer> list) {

        for (int m = j; m <= q; m++) {
            list.add(matrix[i][m]);
        }

        for (int m = i + 1; m <= p; m++) {
            list.add(matrix[m][q]);
        }

        for (int m = q - 1; m >= j && i != p; m--) {
            list.add(matrix[p][m]);
        }

        for (int m = p - 1; m > i && j != q; m--) {
            list.add(matrix[m][i]);
        }


    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};
        J054SpiralMatrix j054SpiralMatrix = new J054SpiralMatrix();
        List<Integer> solution = j054SpiralMatrix.solution(matrix);
        System.out.println(solution);


    }

}
