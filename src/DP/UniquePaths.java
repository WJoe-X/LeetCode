package DP;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @auther: WJoe
 * @Description: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 * @Date : 19:10 2018/8/10
 */
public class UniquePaths {


    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1)
            return 0;
       int [][] ints  =new int[m][n];
        for (int i = 0; i <m ; i++) {
            ints[i][0]=1;
        }
        for (int i = 0; i <n ; i++) {
            ints[0][i]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                ints[i][j] = ints[i-1][j]+ints[i][j-1];
            }
        }
        return ints[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(2,100));
    }
}
