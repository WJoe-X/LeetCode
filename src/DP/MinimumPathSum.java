package DP;

/**
 * @auther: WJoe
 * @Description:
 * @Date : 20:07 2018/8/10
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rows= grid.length;
        int columns = grid[0].length;
        int [][] result = new int[rows][columns];
        result[0][0] = grid[0][0];
        for (int i = 1; i <rows ; i++) {
            result[i][0] = result[i-1][0] +grid[i][0];
        }
        for (int i = 1; i <columns ; i++) {
            result[0][i] = result[0][i-1] +grid[0][i];
        }
        for (int i = 1; i <rows ; i++) {
            for (int j = 1; j <columns ; j++) {
                result[i][j] =Math.min(result[i-1][j],result[i][j-1])+grid[i][j];
            }
        }
        return result[rows-1][columns-1];
    }
}
