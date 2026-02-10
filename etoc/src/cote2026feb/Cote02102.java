package cote2026feb;

import java.util.*;
public class Cote02102 {

    class Solution {

        public int[][] memo;

        public int dp(int i , int j){

            if (i == 0 || j == 0) return 1;

            if (memo[i][j] == -1){
                memo[i][j] = dp(i-1, j) + dp(i, j-1);
            }
            return memo[i][j];
        }


        public int uniquePaths(int m, int n) {

            // 로봇이 시작점 (0,0) 에서 (m-1, n-1) 까지 도달할 수 있는
            // unique 한 경로의 개수

            memo = new int[m][n];

            for (int i = 0; i < m; i++){
                Arrays.fill(memo[i] , -1);
            }

            return dp(m-1, n-1);

        }
    }
}
