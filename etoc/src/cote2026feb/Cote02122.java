package cote2026feb;

public class Cote02122 {

    class Solution {
        public int maximalSquare(char[][] matrix) {

            int rows = matrix.length;
            int cols = matrix[0].length;

            int[][] dp = new int[rows + 1][cols + 1];
            // dp[i][j] : (i,j) 를 오른쪽 꼭짓점으로 할 때, 정사각형의 최대 길이

            int maxSize = 0;

            for (int row = 1; row <= rows; row++){
                for (int col = 1; col <= cols; col++){

                    if (matrix[row -1][col - 1] == '1'){
                        dp[row][col] = Math.min(dp[row][col - 1] ,
                                Math.min(dp[row -1][col - 1] , dp[row -1][col])) + 1;

                        maxSize = Math.max(maxSize, dp[row][col]);
                    }
                }
            }

            return maxSize * maxSize;
        }
    }
}
