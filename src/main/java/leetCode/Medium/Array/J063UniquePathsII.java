package leetCode.Medium.Array;

/**
 * Created by yupeng on 16/4/6.
 */
public class J063UniquePathsII {

    /**
     * Follow up for "Unique Paths":
     * <p/>
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * <p/>
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * <p/>
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * <p/>
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * The total number of unique paths is 2.
     * <p/>
     * Note: m and n will be at most 100.
     * <p/>
     * Subscribe to see which companies asked this question
     * <p/>
     * 1表示障碍 , 0表示可选路径
     * <p/>
     * 思路先进行初始化 第一行 第一列 , 遇到障碍后面不进行初始化 , 然后进行动态规划处理 , 第i行第j列的值为 它上方与它左方的数字之和 , 如果是障碍位置则为0
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return mySolution(obstacleGrid);
    }

    private int mySolution(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        //初始化数据
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            grid[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            grid[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        J063UniquePathsII j063UniquePathsII = new J063UniquePathsII();
        int[][] obstacleGrid = new int[4][4];
        obstacleGrid[0] = new int[]{0, 1, 0, 0};
        obstacleGrid[1] = new int[]{1, 1, 1, 0};
        obstacleGrid[2] = new int[]{0, 1, 0, 0};
        obstacleGrid[3] = new int[]{0, 0, 0, 0};
        int i = j063UniquePathsII.mySolution(obstacleGrid);
        System.out.println(i);
    }
}
