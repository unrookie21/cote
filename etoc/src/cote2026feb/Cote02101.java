package cote2026feb;

import java.util.*;
public class Cote02101 {

    class Solution {

        public int[] memo;
        public int[] cost;


        public int minCostClimbingStairs(int[] cost) {
            this.cost = cost;
            this.memo = new int[cost.length + 1];
            Arrays.fill(memo, -1);
            return dp(cost.length);


        }

        public int dp(int i){
            if (i == 0 || i == 1){
                return 0;
            }

            if (memo[i] == -1){
                memo[i] = Math.min(dp(i -1) + cost[i-1] , dp(i-2) + cost[i -2]);
            }

            return memo[i];
        }

    }
}
