package DP;

/**
 * @auther: WJoe
 * @Description: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * @Date : 19:42 2018/8/10
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] ints = new int[rows][columns];
        for (int i = 0; i <rows ; i++) {
            if (obstacleGrid[i][0]==1) {
                for (int j = i; j < rows; j++) {
                    ints[j][0] = 0;
                }
                break;
            }
            else ints[i][0]=1;
        }
        for (int i = 0; i <columns ; i++) {
            if (obstacleGrid[0][i]==1) {
                for (int j = i; j < columns; j++) {
                    ints[0][j] = 0;
                }
                break;
            }
            else ints[0][i]=1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] == 1)
                    ints[i][j] = 0;
                else ints[i][j] = ints[i - 1][j] + ints[i][j - 1];
            }


        }
        return ints[rows-1][columns-1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{{1,0}}));
    }
}
